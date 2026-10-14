package week5.lab.answers.partA;

// A4 answer. A Book entity with a constructor, this, and two methods
// (LMS Implementation of Real-World Entities, Part 11, exercise 1).
class Book {
    String title;
    String author;
    boolean available = true;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void borrow() {
        if (available) {
            available = false;
            System.out.println("Borrowed: " + title);
        } else {
            System.out.println(title + " is already out");
        }
    }

    void returnBook() {
        available = true;
        System.out.println("Returned: " + title);
    }
}

public class A4Book {
    public static void main(String[] args) {
        Book b = new Book("Clean Code", "Robert Martin");
        System.out.println(b.title + " by " + b.author);
        b.borrow();
        b.borrow();
        b.returnBook();
        b.borrow();
    }
}
