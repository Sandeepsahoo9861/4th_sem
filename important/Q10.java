//Design a Java program for university student enrollment, ensuring loose coupling and
 
//high cohesion. Create Student and Course classes, and an Enrollment class that 
//interacts with them through an EnrollmentSystem interface. Implement methods for 
//enrolling and dropping students from courses, and displaying enrollment details. In the 
//MainEnrollApp class, demonstrate functionality by managing student enrollments. 
//Use comments to explain how the design maintains loose coupling (by relying on 
//interfaces) and high cohesion (by keeping related functionalities within appropriate 
//classes).




package important;
import java.util.HashMap;
import java.util.Map;

interface EnrollmentSystem {
    void enrollStudent(Student student, Course course);
    void dropStudent(Student student, Course course);
    void displayEnrollmentDetails();
}

class Student {
    private String studentId, studentName;
    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
    public String getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
}

class Course {
    private String courseId, courseName;
    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }
    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
}

class Enrollment implements EnrollmentSystem {
    private Map<Student, Course> enrollmentMap = new HashMap<>();

    @Override
    public void enrollStudent(Student student, Course course) {
        enrollmentMap.put(student, course);
        System.out.println("Student " + student.getStudentName() + " enrolled in course " + course.getCourseName());
    }

    @Override
    public void dropStudent(Student student, Course course) {
        if (enrollmentMap.containsKey(student) && enrollmentMap.get(student).equals(course)) {
            enrollmentMap.remove(student);
            System.out.println("Student " + student.getStudentName() + " dropped from course " + course.getCourseName());
        } else {
            System.out.println("Student " + student.getStudentName() + " is not enrolled in course " + course.getCourseName());
        }
    }

    @Override
    public void displayEnrollmentDetails() {
        System.out.println("Enrollment Details:");
        for (Map.Entry<Student, Course> entry : enrollmentMap.entrySet()) {
            Student student = entry.getKey();
            Course course = entry.getValue();
            System.out.println("Student ID: " + student.getStudentId() +
                    ", Student Name: " + student.getStudentName() +
                    ", Course ID: " + course.getCourseId() +
                    ", Course Name: " + course.getCourseName());
        }
    }
}

public class Q10 {
    public static void main(String[] args) {
        Student student1 = new Student("1001", "Alice"), student2 = new Student("1002", "Bob");
        Course course1 = new Course("C101", "Java Programming"), course2 = new Course("C102", "Data Structures");
        EnrollmentSystem enrollmentSystem = new Enrollment();

        enrollmentSystem.enrollStudent(student1, course1);
        enrollmentSystem.enrollStudent(student2, course2);
        enrollmentSystem.dropStudent(student2, course2);
        enrollmentSystem.displayEnrollmentDetails();
    }
}
