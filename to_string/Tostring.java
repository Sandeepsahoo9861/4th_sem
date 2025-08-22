//Write a program to create an Image class with attributes imageWidth, imageHeight, 
//and colorCode. Add the required constructor, set methods, get methods, and toString 
//method. Create the object of the image class using the default and parameterized 
//constructor and print the details of the object.



package to_string;

 class Box {
    int width, height;
    
    Box(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public String toString() {
        return "Box [Width=" + width + ", Height=" + height + "]";
    }
}

public class Tostring {  // Main class with proper naming
    public static void main(String[] args) {
        Box myBox = new Box(10, 20);
        System.out.println(myBox);  // Calls myBox.toString() automatically
    }
}

// we print myBox, Java automatically calls toString() and gives a meaningful description.
//Since myBox is an object, Java automatically calls myBox.toString().
// It returns "Box [Width=10, Height=20] to System.out.println()

