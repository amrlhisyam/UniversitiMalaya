
package soalan2;


public class a {
    public static void main(String[] args) {
        Book myBook = new Book("Sang Kancil", "Amirul Hisyam", 1998);
        myBook.getAuthor();
        myBook.getTitle();
        myBook.getyearPublished();
    }
}

class Book{
    private String author;
    private String title;
    private int yearPublished;
    
    public Book(String title, String author, int yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }
    
    public void getTitle(){
        System.out.println(title);
    }
    public void getAuthor(){
        System.out.println(author);
    }
    public void getyearPublished(){
        System.out.println(yearPublished);
    }
}
