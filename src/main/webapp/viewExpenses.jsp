<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.expense.model.Expense" %>
<html>
<head>
    <title>View Expenses</title>
</head>
<body>
    <h2>All Expenses</h2>
    <a href="new">Add New Expense</a>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>Expense ID</th>
            <th>Title</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Category</th>
            <th>Actions</th>
        </tr>
        <%
            List<Expense> listExpense = (List<Expense>) request.getAttribute("listExpense");
            for (Expense e : listExpense) {
        %>
        <tr>
            <td><%= e.getExpenseId() %></td>
            <td><%= e.getTitle() %></td>
            <td><%= e.getAmount() %></td>
            <td><%= e.getExpenseDate() %></td>
            <td><%= e.getCategory() %></td>
            <td>
                <a href="edit?expenseId=<%= e.getExpenseId() %>">Edit</a>
                <a href="delete?expenseId=<%= e.getExpenseId() %>" onclick="return confirm('Are you sure?');">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
