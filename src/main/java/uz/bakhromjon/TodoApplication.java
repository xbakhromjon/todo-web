package uz.bakhromjon;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.bakhromjon.entity.user.AuthUser;
import uz.bakhromjon.repository.UserRepository;

import java.util.Arrays;

@SpringBootApplication
public class TodoApplication {
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public TodoApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        AuthUser user1 = new AuthUser();
//        user1.setUsername("user1");
//        user1.setPassword(passwordEncoder.encode("user1"));
//
//        AuthUser user2 = new AuthUser();
//        user2.setUsername("user2");
//        user2.setPassword(passwordEncoder.encode("user2"));
//
//        userRepository.saveAll(Arrays.asList(user1, user2));
//    }
}
