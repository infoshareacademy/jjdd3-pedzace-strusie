package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "CATEGORY_PROMOTED")
public class CategoryPromoted {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CategoryPromoted() {
    }

    public CategoryPromoted(User user, String category, LocalDateTime date) {
        this.category = category;
        this.date = date;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CategoryPromoted{");
        sb.append("id=").append(id);
        sb.append(", category='").append(category).append('\'');
        sb.append(", date=").append(date);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
