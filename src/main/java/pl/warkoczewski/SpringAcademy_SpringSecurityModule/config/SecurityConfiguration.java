package pl.warkoczewski.SpringAcademy_SpringSecurityModule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final DataSource dataSource;

    public SecurityConfiguration(UserDetailsService userDetailsService, DataSource dataSource) {
        this.userDetailsService = userDetailsService;
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/home/home", "/login/sign_in").permitAll()
        .antMatchers("/search/search").authenticated()
        .antMatchers("/admin/admin") .hasAnyRole("ADMIN", "ADMIN_HEAD")
        //.antMatchers("/admin/admin") .hasRole("ADMIN_HEAD")
        .antMatchers("/admin/adminHead") .hasRole("ADMIN_HEAD")
        .and()
        .formLogin().loginPage("/login/sign_in")
                .defaultSuccessUrl("/search/search")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
        .and()
        .logout()
                .logoutUrl("/logout")
        .and()
        .exceptionHandling().accessDeniedPage("/admin/accessDenied")
        .and().rememberMe().tokenRepository(persistentTokenRepository());

    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        final JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }


}
