package uz.bakhromjon.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author Bakhromjon Fri, 9:49 PM 2/18/2022
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserDetailService applicationUserDetailService;

    public SpringSecurityConfig(PasswordEncoder passwordEncoder, ApplicationUserDetailService applicationUserDetailService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserDetailService = applicationUserDetailService;
    }

    private final String[] WHITE_LIST = new String[]{"/home", "/", "/about", "/contact"};

    @Value(value = "${remember.me.key}")
    private String rememberMeKey;

    @Value(value = "${remember.me.expiry}")
    private int rememberMeExpiry;

    private int rememberMeExpirySeconds;

    @PostConstruct
    public void init() throws Exception {
        this.rememberMeExpirySeconds = (int) TimeUnit.DAYS.toSeconds(rememberMeExpiry);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer
                                .maximumSessions(1)
                                .maxSessionsPreventsLogin(false))
                .authorizeRequests(expressionInterceptUrlRegistry ->
                        expressionInterceptUrlRegistry
                                .antMatchers(WHITE_LIST)
                                .permitAll()
                                .anyRequest()
                                .authenticated())
                .formLogin(httpSecurityFormLoginConfigurer ->
                        httpSecurityFormLoginConfigurer
                                .permitAll()
                                .loginPage("/auth/login/")
                                .loginProcessingUrl("/auth/login/")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/home", true))
                .logout(httpSecurityLogoutConfigurer ->
                        httpSecurityLogoutConfigurer
                                .logoutUrl("/auth/logout/")
                                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout/  ", "POST"))
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                                .deleteCookies("JSESSION", "remember-me"))
                .rememberMe(httpSecurityRememberMeConfigurer ->
                        httpSecurityRememberMeConfigurer
                                .rememberMeParameter("remember-me")
                                .tokenValiditySeconds(rememberMeExpirySeconds)
                                .key(rememberMeKey));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }


    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(applicationUserDetailService);
        return daoAuthenticationProvider;
    }

}
