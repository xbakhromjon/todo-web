package uz.bakhromjon.config.security;

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
@Service
public class ApplicationUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public ApplicationUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = userRepository.findByUsername(username);
        if (authUser == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return User.builder()
                .username(authUser.getUsername())
                .password(authUser.getPassword())
                .roles(authUser.getRole().getName())
                .authorities(authUser.getRole().getAuthorities())
                .build();
    }
}
