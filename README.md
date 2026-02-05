# Expense Management System

A simple web-based expense management application built with Java Servlets and JSP.

## Features

- Add new expenses with details (ID, title, amount, date, category)
- View all expenses in a list
- Edit existing expenses
- Delete expenses
- CRUD operations with database integration

## Technology Stack

- **Backend**: Java Servlets, JSP
- **Frontend**: HTML, JSP
- **Database**: JDBC (database configuration required)
- **Server**: Jakarta EE compatible server (Tomcat, etc.)

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/expense/
│   │       ├── controller/
│   │       │   └── ExpenseController.java    # Main servlet controller
│   │       ├── dao/
│   │       │   └── ExpenseDAO.java           # Database access layer
│   │       └── model/
│   │           └── Expense.java              # Expense model class
│   └── webapp/
│       ├── WEB-INF/
│       │   └── web.xml                       # Web application configuration
│       ├── index.jsp                         # Add/Edit expense form
│       └── viewExpenses.jsp                  # List all expenses
```

## Setup Instructions

1. **Prerequisites**
   - Java 8 or higher
   - Jakarta EE compatible application server (Tomcat 10+)
   - Database (MySQL/PostgreSQL recommended)

2. **Database Setup**
   - Create a database for the application
   - Update database connection details in `ExpenseDAO.java`
   - Create the expenses table with required columns

3. **Deployment**
   - Build the project as a WAR file
   - Deploy to your application server
   - Access the application at `http://localhost:8080/expense-management`

## Usage

- **Add Expense**: Fill out the form on the main page and submit
- **View Expenses**: Click "View Expenses" to see all recorded expenses
- **Edit Expense**: Click edit button next to any expense in the list
- **Delete Expense**: Click delete button to remove an expense

## API Endpoints

- `/` - Main page (add new expense)
- `/new` - Show new expense form
- `/insert` - Add new expense (POST)
- `/list` - View all expenses
- `/edit?expenseId=<id>` - Edit expense form
- `/update` - Update expense (POST)
- `/delete?expenseId=<id>` - Delete expense

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is open source and available under the MIT License.