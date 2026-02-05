<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    com.expense.model.Expense expense = (com.expense.model.Expense) request.getAttribute("expense");
    boolean isEdit = expense != null;
%>
<html>
<head>
    <title>Expense Management</title>
</head>
<body>
    <h2><%= isEdit ? "Edit Expense" : "Add New Expense" %></h2>
    <form action="<%= isEdit ? "update" : "insert" %>" method="post">
        <input type="hidden" name="expenseId" value="<%= isEdit ? expense.getExpenseId() : "" %>"/>
        <table>
            <tr>
                <td>Expense ID:</td>
                <td><input type="text" name="expenseId" value="<%= isEdit ? expense.getExpenseId() : "" %>" <%= isEdit ? "readonly" : "" %> required/></td>
            </tr>
            <tr>
                <td>Title:</td>
                <td><input type="text" name="title" value="<%= isEdit ? expense.getTitle() : "" %>" required/></td>
            </tr>
            <tr>
                <td>Amount:</td>
                <td><input type="number" step="0.01" name="amount" value="<%= isEdit ? expense.getAmount() : "" %>" required/></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><input type="date" name="expenseDate" value="<%= isEdit ? expense.getExpenseDate() : "" %>" required/></td>
            </tr>
            <tr>
                <td>Category:</td>
                <td><input type="text" name="category" value="<%= isEdit ? expense.getCategory() : "" %>" required/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit"><%= isEdit ? "Update" : "Add" %></button>
                </td>
            </tr>
        </table>
    </form>
    <a href="list">View Expenses</a>
</body>
</html>
