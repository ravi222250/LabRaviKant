package src.oopsLab2;

public class Librarian extends User {

    private String employeeNumber;

    public Librarian(String name, String contactInfo, String employeeNumber) {
        super(name, contactInfo);
        this.employeeNumber = employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    @Override
    protected void displayDashboard() {
        System.out.println("Librarian Dashboard");
        System.out.println("Name: " + getName());
        System.out.println("Contact Info: " + getContactInfo());
        System.out.println("Employee Number: " + employeeNumber);
    }

    @Override
    protected boolean canBorrowBooks() {
        return true;
    }

    @Override
    protected void returnBook() {
        // we are not tracking the borrowed books count by the librarians
        System.out.println("Librarian returned a book");
    }

    void addNewBook(Book book) {
        System.out.println("New book added");
    }
    void removeBook(Book book) {
        System.out.println("Book removed");
    }

}
