package com.infoshareacademy.webapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CategoryPromoted {
    private Long id;
    private Long id_fk;
    private LocalDate date;
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
        return id_fk;
    }

    public void setId_fk(Long id_fk) {
        this.id_fk = id_fk;
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
        sb.append(", id_fk=").append(id_fk);
        sb.append(", date=").append(date);
        sb.append(", time=").append(time);
        sb.append('}');
        return sb.toString();
    }
}
