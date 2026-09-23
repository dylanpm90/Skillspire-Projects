public class Book {
    private String bookName;
    private int bookYear;

    public Book(String bookName, int bookYear) {
        this.bookName = bookName;
        this.bookYear = bookYear;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        if (bookYear >= 0) {
            this.bookYear = bookYear;
        } else {
            System.out.println("Error: Age cannot be negative.");
        }
    }

    static void main(String[] args) {
        Book bestseller = new Book("Brave New World", 1932);

        bestseller.setBookName("Hunger Games");
        bestseller.setBookYear(2004);

        System.out.println("Name: " + bestseller.getBookName());
        System.out.println("Year: " + bestseller.getBookYear());
    }

}
