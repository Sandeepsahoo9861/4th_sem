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
    } // This line calls the parent methods (getTitle(), getAuthor())becase Magazine extends LibraryResources
    //no need of object
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
    }
}

public class Q7_one {
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





//LibraryResource dvd = new DVD("The Matrix", "Wachowski Brothers", 136);
//What is the benefit of using LibraryResource?
//Benefit: It allows you to store and use Books, Magazines, DVDs — all in one common way.
//
//Aapke paas alag-alag cheezein hain:

//
//Book
//Magazine
//DVD
//
//Normally, ye sab alag-alag type ke hote hain.
//
//
//Bookjava b = new Book(...);
//DVD d = new DVD(...);
//Magazine m = new Magazine(...);
//Ab agar aapko sabki details print karni ho, toh teen baar likhna padega:
//
//
//b.displayDetails();
//d.displayDetails();
//m.displayDetails();
//😓 Bohot baar repeat karna padta hai.
//
//✅ Ab aata hai LibraryResource ka magic:
//
//
//LibraryResource item1 = new Book(...);
//LibraryResource item2 = new DVD(...);
//LibraryResource item3 = new Magazine(...);
//Ab sabko ek hi type (LibraryResource) mein store karo:
//	
//	LibraryResource[] items = { item1, item2, item3 };
//
//	for (LibraryResource item : items) {
//	    item.displayDetails(); // Har ek ka correct version chalega 🎯
//	}
//	 Bas ek loop, aur kaam ho gaya.
//	


//Concept	                                      Kya karta hai?	                       Kya super se link hai?
//LibraryResource as parent (extends)	        Inheritance establish karta hai             	✅ Haan
//LibraryResource as reference type       	Polymorphism enable karta hai	                  ❌ Nahi
//super(title, author)	                  Parent constructor call karta hai         	  ✅ Haan, directly linked

//although  DVD extends LibraryResource but we cant acess  title, author becase they are private 
//so we super (title, author);
//Jab super(title, author) likha, us waqt:
//
//"Java" chala gaya LibraryResource ke title mein
//
//"John" chala gaya LibraryResource ke author mein
//
//➡ Inside the parent constructor:
//
//
//this.title = title;   // this.title = "Java"
//this.author = author; // this.author = "John "
//......................



//🧠 Tera Sawal:
//Agar LibraryResource ka object ban hi nahi raha, to fir title aur author store kaha honge?
//		Store Book ke object mein hi hote hain.
//		Par fields LibraryResource ke hote hain.
//
//		Toh jab tu Book ka object banata hai,
//		us object mein parent class (LibraryResource) ka part bhi hota hai.
//		
//		LibraryResource ek aangan hai jisme title, author ke liye jagah bani hai.
//
//		Book us aangan ke upar apna ghar banata hai (pageCount wala room).
//
//		Jab Book ka ghar banta hai, toh aangan (LibraryResource) apne aap ban jata hai automatically.
//
//		Chahe tu aangan ka seedha use na kare, par ghar ke neeche base toh wahi hai — wahi title/author store karta hai.
//

//🧠 Memory Structure (Diagrammatic View):
//
//📦 Book Object
// ┌────────────────────────────┐
// │ LibraryResource part       │
// │ ─ title  = "Java Programming" │
// │ ─ author = "John Doe"         │
// ├────────────────────────────┤
// │ Book part                  │
// │ ─ pageCount = 500          │
// └────────────────────────────┘
//
//📦 Magazine Object
// ┌────────────────────────────┐
// │ LibraryResource part       │
// │ ─ title  = "Nat Geo"          │
// │ ─ author = "Various Authors"  │
// ├────────────────────────────┤
// │ Magazine part              │
// │ ─ issueDate = "Feb 2024"   │
// └────────────────────────────┘
//
//📦 DVD Object
// ┌────────────────────────────┐
// │ LibraryResource part       │
// │ ─ title  = "The Matrix"       │
// │ ─ author = "Wachowski"        │
// ├────────────────────────────┤
// │ DVD part                   │
// │ ─ duration = 136           │
// └────────────────────────────┘
//🔍 Summary:
//if we take the example of DVD object,through super key word we are passing the title ans author to 
//parent LibraryREsource,jab humko jarurat hoga get mthod se le ayenge parent class and although LIbraryResouse
//does not have it own object
//Har object ka ek part LibraryResource se inherited hai (title, author).
//
//Dusra part uski apni class ka data hai (pageCount, issueDate, duration).
//
//Object banne ke baad sab kuch ek hi object mein store hota hai.
//
//Constructor call hota hai:
//Book() → super() → LibraryResource() — yahi title, author set karta hai.

//..................
//
//🧠 Tera Sawal:
//Agar title aur author ko private na banake protected ya public bana dein,
//to kya data waise hi store hote hain?
//Aur kya hum super() use na kar ke bhi unko access kar sakte hain?
//		 Haan! Data memory mein waise hi store honge:
//			 text
//			 Copy
//			 Edit
//			 📦 Book Object
//			  ┌────────────────────────────┐
//			  │ LibraryResource part       │
//			  │ ─ title  = "Java Programming"
//			  │ ─ author = "John Doe"
//			  ├────────────────────────────┤
//			  │ Book part                  │
//			  │ ─ pageCount = 500
//			  └────────────────────────────┘
//			 ➡️ Chahe title, author private ho ya protected ya public,
//			 object structure same hi rehta hai.
//			 Kyuki ye to inheritance se aaya hua part hai, aur memory layout par isse koi farq nahi padta.
//			 Haan! Agar protected ya public hai, to super() ki zarurat nahi:
//				 ➡️ Tere Book object ke andar jo LibraryResource ka part bana hai,
//				 tu uske andar directly haath daal ke title/author ko set bhi kar raha hai, aur use bhi


//...........................

//some extra example
//class Animal {
//    Animal() {
//        System.out.println("Animal constructor");
//    }
//}
//
//class Dog extends Animal {
//    Dog() {
//        System.out.println("Dog constructor");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Dog d = new Dog();
//    }
//}
//
//🐕 Dog Example (Animal)
//Animal ek aangan hai — jisme name aur eat() ka jagah hai.
//Dog us aangan ke upar apna ghar banata hai — jisme bark() aur breed wale rooms hai.
//
//📦 Dog object ka ghar:
//
//
//🏠 Dog ka ghar
// ┌────────────────────┐
// │ Animal ka aangan   │ ← name, eat()
// ├────────────────────┤
// │ Dog ka room        │ ← breed, bark()
// └────────────────────┘
//✅ Jab Dog ka object banta hai, Java pehle Animal ka constructor chalata hai (aangan tayyar).
//Fir Dog apna ghar complete karta hai.
//
//
//
//🎬 DVD Example (LibraryResource)
//LibraryResource ek aangan hai — jisme title aur author ke liye jagah bani hai.
//DVD us aangan ke upar apna ghar banata hai — jisme duration wala ek room hai.
//
//📦 DVD object ka ghar:
//
//
//🏠 DVD ka ghar
// ┌────────────────────────────┐
// │ LibraryResource ka aangan  │ ← title, author
// ├────────────────────────────┤
// │ DVD ka khud ka room        │ ← duration
// └────────────────────────────┘
//✅ Jab DVD ka object banta hai, toh LibraryResource ka constructor pehle chalta hai — aangan ready hota hai.
