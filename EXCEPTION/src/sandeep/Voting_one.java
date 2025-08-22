
package sandeep;

//Custom exception class
class UnderAgeException extends RuntimeException { // Using RuntimeException makes it unchecked

 // Default constructor
 UnderAgeException() {
     super("You are underage, my dear");
 }

 // Parameterized constructor
 UnderAgeException(String message) {
     super(message);
 }
}

//Main class
public class Voting_one {

 public static void main(String[] args) {
     int age = 16; 

     try {
         if (age < 18) {
             // Creating and throwing custom exception
             throw new UnderAgeException("You cannot vote as age is below 18");
         } else {
             System.out.println("You can vote");
         }
     } catch (UnderAgeException e) {
         // Handling the custom exception
         System.out.println(e); // prints the exception message
         System.out.println("Exception has been handled"); // line 25
     }
 }
}
