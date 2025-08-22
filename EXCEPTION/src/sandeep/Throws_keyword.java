package sandeep;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
class Read{
	void readFile() throws FileNotFoundException{
		FileInputStream fis=new FileInputStream("d:/abc.text");
		//This line tries to open the file "d:/abc.text" for reading.
         //But the file does not exist, so Java throws a FileNotFoundException.
	}
}
public class Throws_keyword {

	public static void main(String[] args) {
		Read rw=new Read();
		try {
			rw.readFile();
			//readFile() method of rw object is called.
			//This call is wrapped inside try, which means we’re ready to catch any exceptions.
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
		System.out.println("code is working");//this line is working means exception is handled 
	}

}
//Throws method 
//The main aim of the throws method is ,if in a project two members are working ,
//we want the other person to handle that exception according to him we should 
//throws the exception to caller method(inside the main method )he will handle according to him
//throws keyword are used for the checked exception


//............................
//These are the exceptions that extend Exception(checked)
//These are the child class of checked exception
//It means these are checked Exception too
//*IOException
//*FileNotFoundException
//*SQLException
//*ClassNotFoundException
//*InterruptedException
//*ParseException
//🧠 Note: These are called checked because the compiler checks that you must handle or declare them using throws.
//---------------
//These are the exceptions that extend RuntimeException
//These extend from RuntimeException, and the compiler does not force you to handle them.
//*ArithmeticException  
//*NullPointerException  
//*ArrayIndexOutOfBoundsException  
//*IndexOutOfBoundsException  
//*NumberFormatException  
//*IllegalArgumentException  
//🧠 These are unchecked because compiler doesn't check them at compile time — they are runtime errors.


//..................
//🧠 When to use throws?
//We use throws in the method declaration to delegate the responsibility
//of handling the exception to the caller method. This means that the exception 
//is not handled inside the method where it's thrown, but instead, it’s thrown up to the calling method.
//
//
//✅ Here’s how throws works:
//If your method throws an exception (like FileNotFoundException), you declare it
//using throws to inform the caller that this exception might occur.
//The caller then has to handle it either using try-catch or propagate it further.
//

//
//💡 Real-life analogy:
//Imagine you’re in a team, and one person is working on a task (like readFile).
//They realize there's a possible problem (exception), but instead of solving it, 
//they pass it to you with a note saying, "Please handle this" (with throws). 
//Now, you (the caller) must deal with it.