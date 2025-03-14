package src.oopsLab2;

public abstract class Book implements Lendable {

    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;

    private BookType type;

    public Book (String isbn, String title, String author, BookType type) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.type = type;
        this.isAvailable = true; // initially the book should be available
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setType (BookType type) {
        this.type = type;
    }

    public BookType getType() {
        return type;
    }

    public boolean lend(User user) {
        if (isAvailable && user.canBorrowBooks()) {
            isAvailable = false;
            return true;
        }
        return false;
    }
    public void returnBook(User user) {
        isAvailable = true;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    protected abstract void displayBookDetails();

}
