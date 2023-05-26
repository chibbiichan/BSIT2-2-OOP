import java.util.*;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Library Management System\n");
        //library to store and manage books.
        Library library= new Library ();
        boolean exit=false;
        //Keep asking the user for input until they choose the exit.
        while(exit != true){
            System.out.println("1. Add new book");
            System.out.println("2. Remove book");
            System.out.println("3. Display available books");
            System.out.println("4. Borrow books");
            System.out.println("5. Return books");
            System.out.println("6. Exit");
        try {
            int choice = in.nextInt();
            in.nextLine();
            if(choice == 1) {
                System.out.print("Title: ");
                String title = in.nextLine();
                System.out.print("Author: ");
                String author = in.nextLine();
                //Once the new book added the availability of the book automatically set to Available
                String status = "Available";
                library.addBook(title, author, status);
                    System.out.println("A new book successfully added to library.\n");
            }
            else if (choice == 2) {
                System.out.println("Enter book ID you want to remove.");
                int id=in.nextInt();
                if(library.deleteBooks(id)) {
                    System.out.println("The Book successfully removed.\n");
                }else{
                    System.out.println("Can't removed.The book doesn't exist in the library or the book was borrow.\n");
                }
            }
            else if (choice == 3) {
                library.displayBooks();
            }
            else if (choice == 4) {
                System.out.println("Enter book ID you want to borrow.");
                int id = in.nextInt();
                if (library.borrowBooks(id)) {
                    System.out.println("The book successfully borrowed\n");
                }else{
                    System.out.println("The book doesn't exist in the library or it is not available.\n");
                }
            }
            else if (choice == 5) {
                System.out.println("Enter book ID you want to return.");
                int id = in.nextInt();
                if (library.returnBooks(id)) {
                    System.out.println("The book successfully returned.\n");
                }else{
                    System.out.println("The book doesn't exist in the library.\n");
                }
            }
            else if(choice == 6){
                exit=true;
            }
            else{
                System.out.println("Invalid input. Try again.\n");
            }
        }catch(Exception e){
            System.out.println("Invalid input. Please checks input and try again.\n");
            in.nextLine();
        }
        }
        System.out.println("Thank you for using Library Management.");
    }
}
//this class used to represent books.
class Book{
    private String title, author, status;
    private int id;
    // incId use for the id to automatically incremented.
    private static int incId = 1;
    public Book(String title, String author, String status){
        this.id=incId++;
        this.title=title;
        this.author=author;
        this.status=status;
    }
    public int getID(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}
//this class use to manage books in library.
class Library{
    private List<Book> books;
    public Library(){
        books = new ArrayList<>();
    }
    //Add new book.
    public void addBook(String title, String author, String status ){
        Book newBook = new Book(title, author, status);
        books.add(newBook);
    }

    //this method use to delete books. if the book is available it will return true and delete
    // the book, else it returns false and print message.
    public boolean deleteBooks(int id){
        for(Book book : books){
            if(book.getID() == (id) &&(book.getStatus().equalsIgnoreCase("Available"))){
                books.remove(book);
                return true;
            }
        }
        return false;
    }
    //this method use for borrowing the book, if the book status is available it returns
    // true and set status to not available. else it returns false and print message.
    public boolean borrowBooks(int id){
        for(Book book : books){
            if((book.getID() == id)&&(book.getStatus().equalsIgnoreCase("Available"))){
                book.setStatus("Not available");
                return true;
            }
        }
        return false;
    }
    //this method use for returning books. after returning the book the status will change no available.
    // if the user input id doesn't exist in the list it will return false and print message.
    public boolean returnBooks(int id){
        for(Book book : books){
            if(book.getID()==id){
                book.setStatus("Available");
                return true;
            }
        }
        return false;
    }
    //method to display books.
    public void displayBooks(){
        System.out.println("List of Available Books in Library:");
        System.out.printf("|%-3s|%-15s|%-15s|%-10s|%n", "ID", "Title", "Author", "Status");
        System.out.printf("------------------------------------------------%n");

        for (Book book : books){
            System.out.printf("|%-3s|%-15s|%-15s|%-10s|%n",book.getID(), book.getTitle(), book.getAuthor(), book.getStatus());
        }
        System.out.println(" ");
    }
}