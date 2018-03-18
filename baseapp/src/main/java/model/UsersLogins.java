package model;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
//@Table(name = "USERS_LOGINS")
public class UsersLogins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "login_time")
    private LocalDateTime loginTime;

    public UsersLogins() {
    }

    public UsersLogins(User user, LocalDateTime loginTime) {
        this.user = user;
        this.loginTime = loginTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }
}
