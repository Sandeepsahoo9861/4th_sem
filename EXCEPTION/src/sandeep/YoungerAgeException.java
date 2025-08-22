package sandeep;
import java.util.*;
public class YoungerAgeException extends RuntimeException {
YoungerAgeException(String msg ){
	super(msg);
}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your age");
		try {
		int age=sc.nextInt();
		if (age<18) {
			throw new YoungerAgeException("You are not eligble for the vote");
		         //Throw keyword actually used for userdefined exception,we manually throws message
		}
		
		else {
			System.out.println("you can eligible for the vote");
		}
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("hello6");//this print statement is used to know that
		                      // if the exception is handled then only this print statement
		                        // will execute,it can be handled through try and catch 

	}

}
