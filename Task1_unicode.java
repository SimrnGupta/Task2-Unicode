

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class LibraryCatalogue{

    static int totalNumOfBooks=5;
    static int currentDay=1;

    static HashMap<String,Book> bookCollection = new HashMap<String,Book>();
    static ArrayList<String> bookList = new ArrayList<>();
    static ArrayList<String> borrowedBooks = new ArrayList<>();

    static public void borrowBook(String title, String owner) {
        Book book = bookCollection.get(title);
        if (book.isCheckedOut)
        {
            System.out.println("Sorry, " + book.title + " is already checked out. It should be back on day " +
                    (book.dayCheckedOut + 7) +".");
        }
        else
        {
            book.setIsCheckedOut(true, currentDay, owner);
            System.out.println("You just checked out " + title + ". It is due on day " +
                    (currentDay + 7) + ". We will charge Rs. 10 per late day!" );
            if(!borrowedBooks.contains(title))
            {
                borrowedBooks.add(title);
            }
            totalNumOfBooks--;
        }
    }

    static public void returnBook(String title) {

        Book book = bookCollection.get(title);
        int daysLate = currentDay - (book.dayCheckedOut + 7);
        if (daysLate > 0) {
            System.out.println("You owe the library Rs." + daysLate*10 +
                    " because your book is "+ daysLate+ " days overdue.");
        } else {
            System.out.println("Book Returned. Thank you");
        }
        book.setIsCheckedOut(false, -1);
        totalNumOfBooks++;
    }

    static public void initialiseBookCollection()
    {
        bookList.add("Bloodline");
        bookCollection.put("Bloodline", new Book("Bloodline") );
        bookList.add("Silent Widow");
        bookCollection.put("Silent Widow", new Book("Silent Widow") );
        bookList.add("Sleeping Murder");
        bookCollection.put("Sleeping Murder", new Book("Sleeping Murder") );
        bookList.add("Death at Nile");
        bookCollection.put("Death at Nile", new Book("Death at Nile") );
        bookList.add("Nothing lasts Forever");
        bookCollection.put("Nothing lasts Forever", new Book("Nothing lasts Forever") );
    }

    static public void addBook(String title)
    {
        bookCollection.put(title, new Book(title));
        bookList.add(title);
        totalNumOfBooks++;
    }



}

 class Book {

    String title;
    boolean isCheckedOut;
    int dayCheckedOut;
    String owner;

    public Book(String bookTitle)
    {
        this.title = bookTitle;
        isCheckedOut = false;
    }

    public void setIsCheckedOut(boolean newIsCheckedOut, int currentDayCheckedOut)
    {
        this.isCheckedOut = newIsCheckedOut;
        dayCheckedOut = currentDayCheckedOut;
    }

    public void setIsCheckedOut(boolean newIsCheckedOut, int currentDayCheckedOut, String owner)
    {
        this.isCheckedOut = newIsCheckedOut;
        dayCheckedOut = currentDayCheckedOut;
        this.owner = owner;
    }


}

class Student {

    String name;
    int numOfBooks;
    int id;

    Student(String name, int id)
    {
        this.name = name;
        this.id = id;
        numOfBooks = 0;
    }
}



class Main {

    public static void main(String[] args) {

        int choice = 0;
        Scanner sc = new Scanner(System.in);

        LibraryCatalogue.initialiseBookCollection();

        String title = "";
        String garbage = "";

        while(choice != 7)
        {
            System.out.println("Today is day "+LibraryCatalogue.currentDay);
            System.out.println("Please select an option");
            System.out.println("1. Add book (Only for library admin)");
            System.out.println("2. Borrow book");
            System.out.println("3. Return book");
            System.out.println("4. Next day!");
            System.out.println("5. Check number of books in the library");
            System.out.println("6. Search for borrowed book (Only for library admin)");
            System.out.println("7. exit");
            System.out.println("Choice: ");
            choice = sc.nextInt();
            garbage = sc.nextLine();
            switch(choice)
            {
                case 1: System.out.println("Please enter password: ");
                        String input = sc.nextLine();
                        if(input.equals("admin123"))
                        {
                            System.out.print("Enter the name of the book: ");
                            title = sc.nextLine();
                            LibraryCatalogue.addBook(title);
                            LibraryCatalogue.totalNumOfBooks++;
                            System.out.println("Book successfully added!");
                        }
                        else
                        {
                            System.out.println("Wrong password!");
                        }
                        break;

                case 2: System.out.println("Enter your name: ");
                        String st = sc.nextLine();
                        System.out.println("Enter your ID: ");
                        int id = sc.nextInt();
                        garbage = sc.nextLine();
                        Student s1 = new Student(st, id);
                        System.out.println("The following is the list of books in the library:");
                        System.out.println(LibraryCatalogue.bookList);
                        System.out.println("Please enter the name of the book you want to borrow:");
                        title = sc.nextLine();
                        if(LibraryCatalogue.bookCollection.containsKey(title))
                        {
                            LibraryCatalogue.borrowBook(title, st);
                        }
                        else
                        {
                            System.out.println("Sorry we dont have this book!");
                        }
                        break;

                case 3: System.out.println("Enter the name of the book you had borrowed: ");
                        title = sc.nextLine();
                        if(LibraryCatalogue.borrowedBooks.contains(title))
                        {
                            LibraryCatalogue.returnBook(title);
                        }
                        else
                        {
                            System.out.println("No such book was borrowed!");
                        }

                case 4: LibraryCatalogue.currentDay++;
                        break;

                case 5: System.out.println("The number of books in the library is " + LibraryCatalogue.totalNumOfBooks);
                        break;

                case 6: System.out.println("Please enter password: ");
                        input = sc.nextLine();
                        if(input.equals("admin123"))
                        {
                            System.out.println("Following is the list of borrowed books:");
                            System.out.println(LibraryCatalogue.borrowedBooks);
                            System.out.println("Enter the name of book you want to check:");
                            title = sc.nextLine();
                            Book book = LibraryCatalogue.bookCollection.get(title);
                            if (LibraryCatalogue.borrowedBooks.contains(title)) {
                                System.out.println(book.title + " is borrowed by " + book.owner + " and should be" +
                                        " back on day " + (book.dayCheckedOut + 7));
                            } else {
                                System.out.println("No such book is borrowed.");
                            }
                        }
                        else
                        {
                            System.out.println("Wrong password!");
                        }
                        break;


                case 7: break;
            }
        }

    }
}