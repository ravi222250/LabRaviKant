package src.oopsLab2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryManagementSystem {

    List<Book> bookInventory;
    List<User> registeredUsers;

    public LibraryManagementSystem() {
        bookInventory = new ArrayList<>();
        registeredUsers = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookInventory.add(book);
    }

    public void registerUser(User user) {
        registeredUsers.add(user);
    }

    public List<Book> searchBooks(String criteria) {
        return bookInventory.stream().filter(book ->
                book.getTitle().equalsIgnoreCase(criteria) || book.getAuthor().equalsIgnoreCase(criteria))
                .collect(Collectors.toList());
    }

    public List<Book> searchBooks(String criteria, BookType type) {
        return searchBooks(criteria).stream()
                .filter(book -> book.getType().equals(type))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();

        TextBook textBook1 = new TextBook("isbn1", "title1", "author1", 1, "subject1");
        TextBook textBook2 = new TextBook("isbn2", "title2", "author2", 2, "subject2");
        system.addBook(textBook1);
        system.addBook(textBook2);

        NovelBook novelBook1 = new NovelBook("isbn1", "title1", "author1", "genre1");
        NovelBook novelBook2 = new NovelBook("isbn2", "title2", "author2", "genre2");
        system.addBook(novelBook1);
        system.addBook(novelBook2);

        Member member1 = new Member("name1", "contact1");
        Member member2 = new Member("name2", "contact2");
        system.registerUser(member1);
        system.registerUser(member2);

        Librarian librarian1 = new Librarian("name1", "contact1", "one");
        Librarian librarian2 = new Librarian("name2", "contact2", "two");
        system.registerUser(librarian1);
        system.registerUser(librarian2);

        if(textBook1.lend(member1)) {
            System.out.println("Successfully lended the book: " + textBook1.getTitle() + " to member: " + member1.getName());
        } else {
            System.out.println("Failed to lend the book: " + textBook1.getTitle() + " to member: " + member1.getName());
        }
    }
}
