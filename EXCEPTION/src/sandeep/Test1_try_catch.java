package sandeep;

public class Test1_try_catch {
	public void divide() {//divide method will not be able to handle the exception then,it will send 
		                 //to main method method (who has called him) if main method unable to
		                  // handle ,JVM  will send to default exception
		int a=100, b=0,c;//
		c=a /b;         //
		System.out.println(c);//
		}
		
		
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1_try_catch t=new Test1_try_catch();
		try {//we can handle it through main method
		t.divide();
		}
		catch(ArithmeticException e) {
			System.out.println("you cannot divided by zero");
		}
		System.out.println("hi this Sandeep");

	}

}
