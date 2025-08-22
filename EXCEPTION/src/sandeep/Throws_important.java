package sandeep;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
class Reading{
	void readFile() throws FileNotFoundException{
		FileInputStream fis=new FileInputStream("d:/abc.text");
		//This line tries to open the file "d:/abc.text" for reading.
         //But the file does not exist, so Java throws a FileNotFoundException.
	}
}
public class Throws_important{

	public static void main(String[] args) {
		Reading rw=new Reading();
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
//......................
//concept
//in your code, the method call is inside the try block — so Java treats any exception thrown
//inside that method as part of the try block.
//
//
//main()
//├── try {
//│   └── rw.readFile();   <-- This is inside try
//│       └── throws exception (file not found)
//├── catch(FileNotFoundException e)

//Try block = Watchman / Detector 🚨

//Catch block = Exception handler 🧯

//**if a method is called inside a try block, then any exception thrown inside that method is treated as
//happening inside the try block.**


