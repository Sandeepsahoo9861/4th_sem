package FINAL_1;
 class B{
	 int a=8999;
	 String b="Sandeep";
	   int inser() {
		 int L=9000;
		 return L;
	 }
 }
 class E extends B{
	 void display() {
	 System.out.println(a);
	 System.out.println(b);
 }
	 void display1() {
		// B obj = new B();  // Create an instance of B
	      //  System.out.println(obj.inser());  
		  System.out.println(inser());  // No need to create an instance of B as it is inheritance
		}
	 }
 
public class A {

	public static void main(String[] args) {
		
		E ob=new E();
		ob.display();
		ob.display1();

	}

}
