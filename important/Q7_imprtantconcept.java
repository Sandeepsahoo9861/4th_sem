//Develop a Java program for a library system using encapsulation, abstraction, and    
//inheritance. Create an abstract LibraryResource class with private attributes (title, 
//author), a constructor, getters, setters, and an abstract displayDetails() method. Extend 
//it into Book, Magazine, and DVD classes, each adding a specific attribute 
//(pageCount, issueDate, duration), along with constructors, getters, setters, and 
//overridden displayDetails() methods. In the LibrarySystem class, instantiate various 
//resources and call displayDetails() to display their information. 

package important;

abstract class LibraryResource {
    private String title, author;
    public LibraryResource(String title, String author) { // This is the parent constructor
        this.title = title;
        this.author = author;
    }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public abstract void displayDetails();
}

class Book extends LibraryResource {
    private int pageCount;
    public Book(String title, String author, int pageCount) {
        super(title, author); // Calls the parent constructor
        this.pageCount = pageCount;
    }
    public int getPageCount() { return pageCount; }
    @Override
    public void displayDetails() {
        System.out.println("Book Title: " + getTitle() + "\nAuthor: " + getAuthor() + "\nPage Count: " + getPageCount());
    } // This line calls the parent methods (getTitle(), getAuthor())
}

class Magazine extends LibraryResource {
    private String issueDate;
    public Magazine(String title, String author, String issueDate) {
        super(title, author);
        this.issueDate = issueDate;
    }

    // ❌ Don't do this — wrong way to initialize title and author again (they are private in parent class)
    // this.title = title;
    // this.author = author;
    // this.issueDate = issueDate;

    // ✅ Instead, we reuse the constructor from LibraryResource using super(),
    // and use public getter methods because title and author are private in the parent class.

    public String getIssueDate() { return issueDate; }
    @Override
    public void displayDetails() {
        System.out.println("Magazine Title: " + getTitle() + "\nAuthor: " + getAuthor() + "\nIssue Date: " + getIssueDate());
    } // This line calls the parent methods (getTitle(), getAuthor())
}

class DVD extends LibraryResource {
    private int duration;
    public DVD(String title, String author, int duration) {
        super(title, author);
        this.duration = duration;
    }
    public int getDuration() { return duration; }
    @Override
    public void displayDetails() {
        System.out.println("DVD Title: " + getTitle() + "\nAuthor: " + getAuthor() + "\nDuration: " + getDuration() + " minutes");
    }// no need of object to call getTitle() becase DVD extend duration
}

public class Q7_imprtantconcept  {
    public static void main(String[] args) {
        LibraryResource book = new Book("Java Programming", "John Doe", 500);
        LibraryResource magazine = new Magazine("National Geographic", "Various Authors", "February 2024");
        LibraryResource dvd = new DVD("The Matrix", "Wachowski Brothers", 136);

        System.out.println("Details of the Book:");
        book.displayDetails();
        System.out.println("\nDetails of the Magazine:");
        magazine.displayDetails();
        System.out.println("\nDetails of the DVD:");
        dvd.displayDetails();
    }
}
//....
//When you create a DVD object, it looks like this:
//
//
//DVD object
//├── LibraryResource part (from parent)
//│   ├── private title: "The Matrix"
//│   └── private author: "Wachowski Brothers"
//└── DVD-specific part
//    └── duration: 136
//So the DVD object contains the LibraryResource part inside it — even though you never made a separate object of LibraryResource.
//
//DVD ek ghar hai. Us ghar ke andar ek LibraryResource ka kamra already bana hua hai.
//Jab DVD ghar banta hai, to LibraryResource ka kamra bhi sath mein tayaar ho jata hai —
//aur super(...) us kamre mein title, author daal deta hai.
//Baad mein getTitle() aur getAuthor() se wo cheezein bahar nikalte ho.
//..............
//super keyword ka kam ye v hota hai
//super.displayDetails();
//🎯 Ye kaam karta hai:
//Parent class ke method ko call karna, ya uski variable ko access karna.
//ex-
//class Parent {
//    void show() {
//        System.out.println("Parent show()");
//    }
//}
//
//class Child extends Parent {
//    void show() {
//        System.out.println("Child show()");
//        super.show();  // 👈 Parent class ka show() bhi call hoga
//    }
//}
//Child show()
//Parent show()
//.......
// work of this keyword and super keyword
//Expression	Hindi meaning
//super(title, author);	“Parent ji, ye lo title aur author — aap apne kamre mein rakh lo.”
//this.title = title;	“Main apne hi kamre ke title drawer mein, yeh title saman daal raha hoon.”
//this.author = author;	“Main apne hi kamre ke author drawer mein, yeh author saman daal raha hoon.”
//
//........
//ANOTHER CONCEPT
//LibraryResource book = new Book("Java Programming", "John Doe", 500);
//LibraryResource magazine = new Magazine("National Geographic", "Various Authors", "February 2024");
//LibraryResource dvd = new DVD("The Matrix", "Wachowski Brothers", 136);
//WE ARE USING LibraryResource  BECAUSE 

//LibraryResource[] resources = {
//	    new Book("Java Programming", "John Doe", 500),
//	    new Magazine("National Geographic", "Various Authors", "February 2024"),
//	    new DVD("The Matrix", "Wachowski Brothers", 136)
//	};





//If we use LibraryResource as the common type, we can do this:
//	for (LibraryResource res : resources) {
//	    res.displayDetails();
//	}
//WE CAN PRINT ALL VALUE

//OTHER WISE
//Without LibraryResource, you'd need 3 separate arrays like this:
//
//Book[] books = { ... };
//Magazine[] magazines = { ... };
//DVD[] dvds = { ... };
//Then you'd have to write 3 loops to print them!