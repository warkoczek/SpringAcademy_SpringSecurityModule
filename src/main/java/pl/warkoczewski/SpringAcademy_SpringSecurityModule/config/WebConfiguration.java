package pl.warkoczewski.SpringAcademy_SpringSecurityModule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //admins
        registry.addViewController("/admin/admin").setViewName("/admin/admin");
        registry.addViewController("/admin/adminHead").setViewName("/admin/adminHead");
    }
}
