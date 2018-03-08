package com.infoshareacademy.baseapp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "EXPENSES")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_expens")
    private Integer id;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @Column(name = "category", length = 32)
    @NotNull
    private String category;

    @Column(name = "expense")
    @NotNull
    private double expense;

    public Expense() {
    }

    public Expense(LocalDate date, String category, double expense) {
        this.date = date;
        this.category = category;
        this.expense = expense;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public double getExpense() {
        return expense;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", expense=" + expense + UserRepository.getCurrency()+
                '}';
    }
}
