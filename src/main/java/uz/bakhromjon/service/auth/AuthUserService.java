package uz.bakhromjon.service.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.bakhromjon.dto.user.UserCreateDto;
import uz.bakhromjon.entity.role.Role;
import uz.bakhromjon.entity.user.AuthUser;
import uz.bakhromjon.exceptions.UserNotFoundException;
import uz.bakhromjon.mapper.UserMapper;
import uz.bakhromjon.repository.RoleRepository;
import uz.bakhromjon.repository.UserRepository;
import uz.bakhromjon.service.BaseAbstractService;
import uz.bakhromjon.settings.PermissionSettings;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Properties;

/**
 * @author Bakhromjon Sat, 9:13 AM 2/19/2022
 */
@Service
public class AuthUserService extends BaseAbstractService<UserRepository, UserMapper> {
    private Long OTP;
    private LocalDateTime expiry;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public AuthUserService(UserRepository repository, UserMapper mapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        super(repository, mapper);
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public Long registration(UserCreateDto userCreateDto) {
        AuthUser authUser = mapper.fromCreateDto(userCreateDto);
        authUser.setPassword(new BCryptPasswordEncoder(8).encode(authUser.getPassword()));
        // TODO: 2/19/2022 Add Some Checks
        repository.save(authUser);
        Role user = PermissionSettings.user;
        user.setAuthUser(authUser);
        roleRepository.save(user);

        return authUser.getId();
    }


    public void logout(Long id) {
        boolean deleted = repository.delete(id);
        if (!deleted) {
            throw new UserNotFoundException("User not found " + id);
        }
    }

    // TODO: 2/20/2022 add send otp
    public void sendEmail(String to) {
        String from = "xbakhromjon@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, "kolhcntytwkrkwiw");

            }
        });

        // Used to debug SMTP issues
        session.setDebug(false);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is OTP code");

            // Now set the actual message
            OTP = Math.round(Math.random() * 9000 + 1000);
            message.setText("" + OTP);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
            expiry = LocalDateTime.now().plus(2, ChronoUnit.MINUTES);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    public boolean verify(Long otp) {
        return otp.equals(OTP) && LocalDateTime.now().isBefore(expiry);
    }
}

