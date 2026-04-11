package FirstJavaProgram;

public class Books {
    
    private String title;
    private String author;
    private static int booksCreated = 0;
    
    public Books(String title, String author) {
        this.title = title;
        this.author = author;
        booksCreated++;
    }
    
    public static void numberOfBooks() {
        System.out.println(booksCreated);
    }

    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
}