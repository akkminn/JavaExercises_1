public class Course {
    
    // Private instance variables for course's code, name, maximum capacity
    private int code;
    private String name;
    private int MAX_CAPACITY = 32;
    private int grade = 0;
    private int student = 0;
    
    /**
     * Static variable for to keep track of the total number of enrolled students 
     * across all instances of the Course class.
     */
    static int totalStudent = 0;

    // Constructor for course name and code.
    public Course(int code, String name) {
        this.code = code;
        this.name = name;
    }

    // Setter methods
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setStudentNumber(int num) {
        this.student = num;
    }

    // Getter methods
    public int getCode() { // Get course's code
        return code;
    }

    public String getName() { // Get course's name
        return name;
    }

    public int getGrade() { // Get the course's grade
        return grade;
    }

    public int getMaxCapacity() { // Get the course's maximum capacity
        return MAX_CAPACITY;
    }

    public int getStudentNumber() {
        return student;
    }

    // A static method to retrieve the total number of enrolled students
    public static void numberOfEnrolledStudents() {
        System.out.println("The number of enrolled student of this course is " + totalStudent);
    }
}
