package uz.bakhromjon.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
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
        securedEnabled = true
)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserDetailService applicationUserDetailService;

    public SpringSecurityConfig(PasswordEncoder passwordEncoder, ApplicationUserDetailService applicationUserDetailService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserDetailService = applicationUserDetailService;
    }

    private final String[] WHITE_LIST = new String[]{"/home/", "/", "/about/", "/contact/", "/auth/register/"};

    @Value(value = "${remember.me.token.key}")
    private String rememberMeTokenKey;

    @Value(value = "${remember.me.token.expiry}")
    private int rememberMeTokenExpiry;

    private int rememberMeTokenExpiryInSeconds;

    @PostConstruct
    public void init() {
        this.rememberMeTokenExpiryInSeconds = (int) TimeUnit.DAYS.toSeconds(rememberMeTokenExpiry);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer
                                .maximumSessions(1)
                                .maxSessionsPreventsLogin(false)
                )
                .authorizeRequests(expressionInterceptUrlRegistry ->
                        expressionInterceptUrlRegistry
                                .antMatchers(HttpMethod.GET, WHITE_LIST)
                                .permitAll()
                                .antMatchers(HttpMethod.POST, "/auth/register/")
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
                                .successHandler(successHandler()))
                .rememberMe(httpSecurityRememberMeConfigurer ->
                        httpSecurityRememberMeConfigurer
                                .tokenValiditySeconds(rememberMeTokenExpiryInSeconds)
                                .alwaysRemember(false)
                                .key(rememberMeTokenKey)
                                .rememberMeParameter("remember-me"))
                .logout(httpSecurityLogoutConfigurer ->
                        httpSecurityLogoutConfigurer
                                .logoutUrl("/auth/logout/")
                                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout/  ", "POST"))
                                .clearAuthentication(true)
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSION", "remember-me")
                                .logoutSuccessUrl("/auth/login/"));
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

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler successHandler() {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("/user/profile/");
        return successHandler;
    }

}
