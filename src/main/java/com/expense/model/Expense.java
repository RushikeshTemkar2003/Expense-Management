package com.expense.model;

import java.sql.Date;

public class Expense {
    private int id;
    private String expenseId;
    private String title;
    private double amount;
    private Date expenseDate;
    private String category;

    // Constructors
    public Expense() {}
    
    public Expense(String expenseId, String title, double amount, Date expenseDate, String category) {
        this.expenseId = expenseId;
        this.title = title;
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.category = category;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getExpenseId() { return expenseId; }
    public void setExpenseId(String expenseId) { this.expenseId = expenseId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Date getExpenseDate() { return expenseDate; }
    public void setExpenseDate(Date expenseDate) { this.expenseDate = expenseDate; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
