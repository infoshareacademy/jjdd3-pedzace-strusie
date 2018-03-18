package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

//@Entity
//@Table(name = "CATEGORY_PROMOTED")
public class CategoryPromoted {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "id_category_fk")
    @NotNull
    private Long id_category_fk;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @Column(name = "time")
    @NotNull
    private LocalTime time;

//    @ManyToMany(mappedBy = "categoriesPromoted")
    private List<User> user;

    public CategoryPromoted() {
    }

    public CategoryPromoted(Long id_category_fk, LocalDate date, LocalTime time, List<User> user) {
        this.id_category_fk = id_category_fk;
        this.date = date;
        this.time = time;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_category_fk() {
        return id_category_fk;
    }

    public void setId_category_fk(Long id_category_fk) {
        this.id_category_fk = id_category_fk;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CategoryPromoted{");
        sb.append("id=").append(id);
        sb.append(", id_category_fk=").append(id_category_fk);
        sb.append(", date=").append(date);
        sb.append(", time=").append(time);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
