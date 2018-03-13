package com.infoshareacademy.webapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name = "CATEGORY_PROMOTED")
public class CategoryPromoted {

    @Column(name = "id", length = 32)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "id_category_fk", length = 32)
    @NotNull
    private Long id_category_fk;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @Column(name = "time")
    @NotNull
    private LocalTime time;

    public CategoryPromoted() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_fk() {
        return id_category_fk;
    }

    public void setId_fk(Long id_fk) {
        this.id_category_fk = id_fk;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CategoryPromoted{");
        sb.append("id=").append(id);
        sb.append(", id_fk=").append(id_category_fk);
        sb.append(", date=").append(date);
        sb.append(", time=").append(time);
        sb.append('}');
        return sb.toString();
    }
}
