public class Book {
    // vars
    private String bookName;
    private String bookAuthor;
    private int bookYear;
    private double bookPrice;


    // set up a constructor
    public Book(String bookName, String bookAuthor, int bookYear, double bookPrice) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.bookPrice = bookPrice;
    }

    // get book NAME
    public String getBookName() {
        return bookName;
    }

    // set book NAME
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    // get AUTHOR
    public String getBookAuthor() {
        return bookAuthor;
    }

    // set AUTHOR
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    // get publishing YEAR
    public int getBookYear() {
        return bookYear;
    }

    // set publishing YEAR
    public void setBookYear(int bookYear) {
        if (bookYear >= 1450) {
            this.bookYear = bookYear;
        } else {
            System.out.println("Error: Publishing year is impossible.");
        }
    }


    // get publishing PRICE
    public double getBookPrice() {
        return bookPrice;
    }

    // set publishing PRICE
    public void setBookPrice(double bookPrice) {
        if (bookPrice >= 0) {
            this.bookPrice = bookPrice;
        } else {
            System.out.println("Error: Price cannot be less than zero.");
        }
    }

    public static void main(String[] args) {
        // use the logic above to create three categorized books: BESTSELLER, OLDEST BOOK,
        // MOST POPULAR, and PRICE
        Book bestseller = new Book("Brave New World", "Aldous Huxley", 1932, 19.99);
        Book firstMovableTypePrint = new Book("The Gutenberg Bible", "Several authors", 1450, 450000.00);
        Book mostPopular = new Book("Gone Girl", "Gillian Flynn", 2012, 8.99);

        // set a new bestseller
        bestseller.setBookName("The Hunger Games");
        bestseller.setBookAuthor("Suzanne Collins");
        bestseller.setBookYear(2008);
        bestseller.setBookPrice(10.99);

        // set a new most popular
        mostPopular.setBookName("Dungeon Crawler Carl");
        mostPopular.setBookAuthor("Matt Dinniman");
        mostPopular.setBookYear(2024);
        mostPopular.setBookPrice(6.99);


        //print results
        System.out.println("_________ * BESTSELLER * _________");
        System.out.println("Name:           " + bestseller.getBookName());
        System.out.println("Author:         " + bestseller.getBookAuthor());
        System.out.println("Year Published: " + bestseller.getBookYear());
        System.out.println("Price:           $") + bestseller.getBookPrice());
        System.out.println("__________________________________");
        System.out.println("_ * OLDEST BOOK IN COLLECTION * __");
        System.out.println("Name:           " + firstMovableTypePrint.getBookName());
        System.out.println("Author:         " + firstMovableTypePrint.getBookAuthor());
        System.out.println("Year Published: " + firstMovableTypePrint.getBookYear());
        System.out.println("Price:           $") + firstMovableTypePrint.getBookPrice());
        System.out.println("__________________________________");
        System.out.println("________ * MOST POPULAR * ________");
        System.out.println("Name:           " + mostPopular.getBookName());
        System.out.println("Author:         " + mostPopular.getBookAuthor());
        System.out.println("Year Published: " + mostPopular.getBookYear());
        System.out.println("Price:           $") + mostPopular.getBookPrice());
        System.out.println("__________________________________");
    }

}
