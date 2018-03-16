package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "EXPENSES")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @Column(name = "category", length = 32)
    @NotNull
    private String category;

    @Column(name = "expense")
    @NotNull
    private double expense;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Expense() {
    }

    public Expense(LocalDate date, String category, double expense) {
        this.date = date;
        this.category = category;
        this.expense = expense;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Expense{");
        sb.append("id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", category='").append(category).append('\'');
        sb.append(", expense=").append(expense);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
