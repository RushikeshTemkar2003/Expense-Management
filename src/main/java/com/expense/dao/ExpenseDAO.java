package com.expense.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.expense.model.Expense;

public class ExpenseDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/expensedb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "cdac";

    private static final String INSERT_EXPENSE_SQL = "INSERT INTO expenses (expense_id, title, amount, expense_date, category) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_EXPENSES = "SELECT * FROM expenses ORDER BY expense_date DESC";
    private static final String DELETE_EXPENSE_SQL = "DELETE FROM expenses WHERE expense_id = ?";
    private static final String SELECT_EXPENSE_BY_ID = "SELECT * FROM expenses WHERE expense_id = ?";
    private static final String UPDATE_EXPENSE_SQL = "UPDATE expenses SET title = ?, amount = ?, expense_date = ?, category = ? WHERE expense_id = ?";

    // JDBC Connection
    protected Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }

    // Insert Expense
    public void insertExpense(Expense expense) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EXPENSE_SQL)) {
            preparedStatement.setString(1, expense.getExpenseId());
            preparedStatement.setString(2, expense.getTitle());
            preparedStatement.setDouble(3, expense.getAmount());
            preparedStatement.setDate(4, expense.getExpenseDate());
            preparedStatement.setString(5, expense.getCategory());
            preparedStatement.executeUpdate();
        }
    }

    // Select All Expenses
    public List<Expense> selectAllExpenses() throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EXPENSES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Expense expense = new Expense();
                expense.setId(rs.getInt("id"));
                expense.setExpenseId(rs.getString("expense_id"));
                expense.setTitle(rs.getString("title"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setExpenseDate(rs.getDate("expense_date"));
                expense.setCategory(rs.getString("category"));
                expenses.add(expense);
            }
        }
        return expenses;
    }

    // Delete Expense
    public boolean deleteExpense(String expenseId) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_EXPENSE_SQL)) {
            statement.setString(1, expenseId);
            return statement.executeUpdate() > 0;
        }
    }

    // Select Expense by ID
    public Expense selectExpense(String expenseId) throws SQLException {
        Expense expense = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EXPENSE_BY_ID)) {
            preparedStatement.setString(1, expenseId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                expense = new Expense();
                expense.setId(rs.getInt("id"));
                expense.setExpenseId(rs.getString("expense_id"));
                expense.setTitle(rs.getString("title"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setExpenseDate(rs.getDate("expense_date"));
                expense.setCategory(rs.getString("category"));
            }
        }
        return expense;
    }

    // Update Expense
    public boolean updateExpense(Expense expense) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_EXPENSE_SQL)) {
            statement.setString(1, expense.getTitle());
            statement.setDouble(2, expense.getAmount());
            statement.setDate(3, expense.getExpenseDate());
            statement.setString(4, expense.getCategory());
            statement.setString(5, expense.getExpenseId());
            return statement.executeUpdate() > 0;
        }
    }
}
