package pl.warkoczewski.SpringAcademy_SpringSecurityModule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;
@Entity
@Table(name = "persistent_logins")
public class PersistentRememberMeToken {
    @Id
    @Column
    private String series;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private Date lastUsed;
}
