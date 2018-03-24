package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USERS_ACTIVE_CATEGORY")
public class UserActiveCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public UserActiveCategory() {
    }

    public UserActiveCategory(User user) {
        this.user = user;
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
}
