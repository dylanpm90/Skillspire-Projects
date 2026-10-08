public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("1984", "Penguin Books", 1948);
        System.out.println( b1.title + ", " +
                            b1.publisher + ", " +
                            b1.yearPublished + ".");
    }
}
