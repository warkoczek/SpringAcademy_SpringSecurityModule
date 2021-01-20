package pl.warkoczewski.SpringAcademy_SpringSecurityModule.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

public class EmailConfiguration {
    @Value("smtp.mailtrap.io")
    private String host;
    @Value("2525")
    private String port;
    @Value("8d6b80716007ad")
    private String username;
    @Value("23221479e3f811")
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
