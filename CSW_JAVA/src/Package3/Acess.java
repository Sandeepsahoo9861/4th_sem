// we can able to access the data member of  different package class member of other package class,data members  are public and to access in  
//different package we have to use import Package_2.B or import Package_2.*

package Package3; // Correct package declaration

import Package_2.B; // Import class B from package_2

public class Acess {
    public static void main(String[] args) {
        B obj = new B(); // Create an object of class B
        System.out.println(obj.a); // Access and print the public field 'a'
    }
}
