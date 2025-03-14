package src.oopsLab2;

import java.util.UUID;

public abstract class User {
    private String userId;
    private String name;
    private String contactInfo;

    public static int totalUsers = 0;

    public int getTotalUsers() {
        return totalUsers;
    }

    // abstract class can have constructors
    /*public User() {
        userId = generateUniqueId();
    }*/

    public User(String name, String contactInfo) {
        this.userId = generateUniqueId();
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public User(User sourceUser) {
        this.userId = generateUniqueId();
        this.name = sourceUser.name;
        this.contactInfo = sourceUser.contactInfo;
    }

    protected final String generateUniqueId() {
        totalUsers++;
        return "User_" + totalUsers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    protected abstract void displayDashboard();
    protected abstract boolean canBorrowBooks();
    protected abstract void returnBook();
}
