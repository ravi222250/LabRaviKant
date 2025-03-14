package src.oopsLab2;

public class TextBook extends Book {

    private int edition;
    private String subject;
    public TextBook(String isbn, String title, String author, int edition, String subject) {
        super(isbn, title, author, BookType.TEXTBOOK);
        this.edition = edition;
        this.subject = subject;
    }

    @Override
    protected void displayBookDetails() {
        System.out.println("Textbook details:");
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Subject: " + subject);
        System.out.println("Edition: " + edition);
        System.out.println("Type: " + getType());
    }
}
