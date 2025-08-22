//Custmmize Exception or Userdefined Exception we use throw keyword


package sandeep;
class UnderAgeException extends RuntimeException{//if we use here only exception instead of 
                                 // runtimeException it would fall under checkedException
                                // try to make unchecked exception 
UnderAgeException() {//constructor,if there is no parameter in line 22 it would work
	super("You are underage my dear");//this message passed to parent constructor(RuntimeException
}
UnderAgeException(String message){//this line will for parameterized constructor  as line 22 pass the argument
	//You cannot vote as age is below 18"
	super(message);//super will pass this message to parent constructor(RuntimeXception constructor)
}

public class voting {

	public static void main(String[] args) {
		int age=16;
		try {
		if(age < 18) {
			throw new UnderAgeException("You cannot vote as age is below 18");//if we not use
			 //try and catch, exception will not handle, line no25 will not execute,here throw 
			  //keyword make an object of Underageage exception and send to jvm ,jvm has defult 
			//if throw is not there then jvm will ask to main method are you handling the exception
		//if main method not handling,then jvm will teminate the main method by its defult exception
			// exception and this defult exception will terminate the main method
			// throw keyword is used for succesfull compilation
			
			
		}
		else {
			System.out.print("You can vote");
		}
		}
		catch(UnderAgeException e) {
			System.out.println(e);//super(message) sends the message to the parent RuntimeException class,
			                        // which stores it,When you print the exception object
			                            //     (System.out.println(e)), Java shows the
			                        // class name and the message together
		System.out.println("Exception has been handeled");//line 25
			
	}

}
}}
//super("You are underage my dear"); to call the constructor of the parent class (RuntimeException)
//and pass a message.
//super(message);   throw new UnderAgeException("You cannot vote as age is below 18");

