package src.oopsLab2;

public class Member extends User {

    private int borrowedBooksCount;
    private static final int MAX_BORROW_LIMIT = 5;

    /*public Member() {
        super();
        this.borrowedBooksCount = 0;
    }*/

    public Member(String name, String contactInfo) {
        super(name, contactInfo);
        this.borrowedBooksCount = 0;
    }

    public void setBorrowedBooksCount(int borrowedBooksCount) {
        this.borrowedBooksCount = borrowedBooksCount;
    }

    public int getBorrowedBooksCount() {
        return borrowedBooksCount;
    }

    @Override
    protected void displayDashboard() {
        System.out.println("Member Dashboard:");
        System.out.println("Name: " + getName());
        System.out.println("Contact Info: " + getContactInfo());
        System.out.println("Number of books borrowed " + this.borrowedBooksCount);
    }

    @Override
    protected boolean canBorrowBooks() {
        return borrowedBooksCount < MAX_BORROW_LIMIT;
    }

    @Override
    protected  void returnBook() {
        borrowedBooksCount--;
    }
}
