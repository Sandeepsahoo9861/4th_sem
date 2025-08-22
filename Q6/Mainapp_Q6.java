//Develop a Java-based College Management System to model the relationship between 
//colleges and students. Create a College class with attributes collegeName and 
//collegeLoc, and a Student class with studentId, studentName, and a reference to a 
//College object. Implement a constructor in Student to initialize these attributes and a 
//displayStudentInfo() method to print student and college details. In the MainApp 
//class, instantiate at least two College and Student objects, enroll each student in one of 
//the colleges, and display all details using appropriate methods. 



package Q6;

//College class to represent a college
class College {
 String collegeName;
 String collegeLoc;

 // Constructor to initialize college details
 public College(String collegeName, String collegeLoc) {
     this.collegeName = collegeName;
     this.collegeLoc = collegeLoc;
 }
}

//Student class to represent a student
class Student {
 int studentId;
 String studentName;
 College college; // Reference to College object

 // Constructor to initialize student details
 public Student(int studentId, String studentName, College college) {
     this.studentId = studentId;
     this.studentName = studentName;
     this.college = college;
 }

 // Method to display student and college details
 public void displayStudentInfo() {
     System.out.println("Student ID: " + studentId);
     System.out.println("Student Name: " + studentName);
     System.out.println("College Name: " + college.collegeName);
     System.out.println("College Location: " + college.collegeLoc);
     System.out.println("--------------------------------");
 }
}

//Main application class
public class Mainapp_Q6 {
 public static void main(String[] args) {
     // Creating College objects
     College college1 = new College("SOA", "BBSR");
     College college2 = new College("XYZ Science College", "Mumbai");

     // Creating Student objects and enrolling them in colleges
     Student student1 = new Student(101, "Rahul Sharma", college1);
     Student student2 = new Student(102, "Sandeep Sahoo", college2);

     // Displaying student details
     student1.displayStudentInfo();
     student2.displayStudentInfo();
 }
}


//The new Student(101, "Rahul Sharma", college1); part calls the Student class constructor, 
//creating a new Student object in memory.

//The constructor initializes studentId with 101, studentName with "Rahul Sharma", and college with
//the reference to college1.

//student1 is a reference variable of type Student, which stores the memory address of the newly created 
//Student object.

//This means student1 can be used to access the student's details and methods.
