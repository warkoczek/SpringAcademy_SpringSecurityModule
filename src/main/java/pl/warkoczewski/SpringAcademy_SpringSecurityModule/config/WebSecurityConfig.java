package pl.warkoczewski.SpringAcademy_SpringSecurityModule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;

import static org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter.Directive.*;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private static final ClearSiteDataHeaderWriter.Directive[] SOURCE = {CACHE, COOKIES, STORAGE, EXECUTION_CONTEXTS};

    public WebSecurityConfig(UserDetailsService userDetailsService) {
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
        .and()
        .formLogin().loginPage("/login/sign_in")
                .defaultSuccessUrl("/home/home")
                .permitAll()
        .and()
        .logout()
                .logoutUrl("/home/home")
                .invalidateHttpSession(true)
                .deleteCookies();
                //.addLogoutHandler(new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(SOURCE)));

    }
}
