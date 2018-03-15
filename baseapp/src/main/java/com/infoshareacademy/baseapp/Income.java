package com.infoshareacademy.baseapp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "INCOMES")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @Column(name = "income")
    @NotNull
    private double income;

    public Income() {
    }

    public Income(LocalDate date, double income) {
        this.date = date;
        this.income = income;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Income{");
        sb.append("id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", income=").append(income).append(UserRepository.getCurrency());
        sb.append('}');
        return sb.toString();
    }
}
