package sandeep;

public class Test {
	public void divide() {
		try {//through try and catch only we can handle the code
		int a=100, b=0,c;
		c=a /b;
		System.out.println(c);
		}
		catch(ArithmeticException e) {
			System.out.println("you cannot divided by zero");
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t=new Test();
		t.divide();
		System.out.println("hi this Sandeep");

	}

}
