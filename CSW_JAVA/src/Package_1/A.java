//if the class is public we can able to access the data member from the same class
package Package_1;


public class A {
	  int a=78;// if data member is also protected we can able to access it

	public static void main(String[] args) {
		A ob=new A();
		System.out.println(ob.a);
		
	}

}
