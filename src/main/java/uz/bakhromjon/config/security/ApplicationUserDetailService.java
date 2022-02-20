package uz.bakhromjon.config.security;

import lombok.Getter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.bakhromjon.entity.user.AuthUser;
import uz.bakhromjon.repository.UserRepository;

/**
 * @author Bakhromjon Fri, 10:20 PM 2/18/2022
 */
@Getter
@Service
public class ApplicationUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private Long id;

    public ApplicationUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = userRepository.findAuthUserByUsername(username);
        if (authUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        id = authUser.getId();
        return User.builder()
                .username(authUser.getUsername())
                .password(authUser.getPassword())
                .roles(authUser.getRole().getName())
                .authorities(authUser.getRole().getAuthorities())
                .build();
    }
}
