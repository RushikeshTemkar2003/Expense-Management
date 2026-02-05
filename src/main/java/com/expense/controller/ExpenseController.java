package com.expense.controller;

import com.expense.dao.ExpenseDAO;
import com.expense.model.Expense;

import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class ExpenseController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ExpenseDAO expenseDAO;

    public void init() {
        expenseDAO = new ExpenseDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertExpense(request, response);
                    break;
                case "/delete":
                    deleteExpense(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateExpense(request, response);
                    break;
                default:
                    listExpenses(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listExpenses(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Expense> listExpense = expenseDAO.selectAllExpenses();
        request.setAttribute("listExpense", listExpense);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewExpenses.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String expenseId = request.getParameter("expenseId");
        Expense existingExpense = expenseDAO.selectExpense(expenseId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("expense", existingExpense);
        dispatcher.forward(request, response);
    }

    private void insertExpense(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String expenseId = request.getParameter("expenseId");
        String title = request.getParameter("title");
        double amount = Double.parseDouble(request.getParameter("amount"));
        Date expenseDate = Date.valueOf(request.getParameter("expenseDate"));
        String category = request.getParameter("category");

        Expense newExpense = new Expense(expenseId, title, amount, expenseDate, category);
        expenseDAO.insertExpense(newExpense);
        response.sendRedirect("list");
    }

    private void updateExpense(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String expenseId = request.getParameter("expenseId");
        String title = request.getParameter("title");
        double amount = Double.parseDouble(request.getParameter("amount"));
        Date expenseDate = Date.valueOf(request.getParameter("expenseDate"));
        String category = request.getParameter("category");

        Expense expense = new Expense(expenseId, title, amount, expenseDate, category);
        expenseDAO.updateExpense(expense);
        response.sendRedirect("list");
    }

    private void deleteExpense(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String expenseId = request.getParameter("expenseId");
        expenseDAO.deleteExpense(expenseId);
        response.sendRedirect("list");
    }
}
