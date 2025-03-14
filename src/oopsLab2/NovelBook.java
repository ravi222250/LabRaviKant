package src.oopsLab2;

public class NovelBook extends Book {

    private String genre;
    public NovelBook(String isbn, String title, String author, String genre) {
        super(isbn, title, author, BookType.NOVELBOOK);
        this.genre = genre;
    }

    @Override
    protected void displayBookDetails() {
        System.out.println("Novelbook details:");
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Genre: " + genre);
        System.out.println("Type: " + getType());
    }
}
