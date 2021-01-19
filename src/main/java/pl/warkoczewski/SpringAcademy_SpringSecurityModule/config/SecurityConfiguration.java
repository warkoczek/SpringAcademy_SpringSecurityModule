package pl.warkoczewski.SpringAcademy_SpringSecurityModule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    public SecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/home/home").permitAll()
        .antMatchers("/search/search").hasAnyRole("USER", "ADMIN", "ADMIN_HEAD")
        .antMatchers("/admin/admin") .hasAnyRole("ADMIN", "ADMIN_HEAD")
                .antMatchers("/admin/adminHead") .hasRole("ADMIN_HEAD")
        .and()
        .formLogin().loginPage("/login/sign_in")
                .defaultSuccessUrl("/home/home")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
        .and()
        .logout()
                .logoutUrl("/logout");

    }
}
