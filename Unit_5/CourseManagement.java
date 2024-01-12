import java.util.ArrayList;
import java.util.Scanner;


public class CourseManagement {

    private static ArrayList<Course> coursesList = new ArrayList<>();
    private static ArrayList<Student> studentList = new ArrayList<>();

    /**
     * The addCourse method takes parameters for course information and 
     * create a new Course object. It will add the course to the list of courses.
     */
    public static void addCourse(int code, String name) {
        // Check if the code exist in CoursesList.
        boolean courseExist = false;

        for (Course course: coursesList) {
            if (course.getCode() == code) {
                courseExist = true;
            }
        }
        if (courseExist) {
            System.out.println("The course " + code + " " + name + " is already added.");
        } else {
            // Create a new Course object
            Course newCourse = new Course(code, name);
            coursesList.add(newCourse);
            System.out.println("The course " + code + " " + name + " is successfully added.");
        }
        
    }

    /**
     * The enrollStudent method accepts a Student object and a Course objec
     * and it enrolls the student in the course
     */
    public static void enrollStudent(Student student, Course course) {
        if (course.getStudentNumber() > course.getMaxCapacity()) {
            System.out.println("There is no more available spot in " + course.getCode() + " " + course.getName());
        } 
        else {
            student.enrollCourse(course);
            studentList.add(student);
            course.setStudentNumber(course.getStudentNumber() + 1);
        }
        
    }

    /**
     * The assignGrade method accepts a Student object, a Course object, 
     * and a grade and it assigns the grade to the student for that course
     */
    public static void assignGrade(Student student, Course course, int grade) {
        student.assignGrade(course, grade);
    }
    
    /**
     * The calculateOverallGrade method accept a Student object and 
     * calculate the overall course grade for that student based 
     * on the grades assigned to them.
     */
    public static void calculateOverallGrade(Student student) {

        double sum = 0.0; 
        ArrayList<Course> enrolledCourses = student.getEnrolledCourses();
        for (Course course: enrolledCourses) {
            sum += course.getGrade();
        }
        String result;
        double finalGrade = sum / enrolledCourses.size();
        if (finalGrade > 90) 
            result = "A*";
        else if (finalGrade >= 80) 
            result = "A";
        else if (finalGrade >= 60)
            result = "b";
        else if (finalGrade >= 40)
            result = "C";
        else
            result = "D";

        student.setGrade(result);
        studentList.add(student);

    }

    // Create a dash-line
    public static void printDashes() {
        for (int i = 0; i < 50; i++) {
                System.out.print("-");
            }
        System.out.println();
    }

    public static void main(String[] args) {

        // Open Scanner
        Scanner scanner = new Scanner(System.in);
        // Create a menu list
        String[] menuList = {"Add a new course", "Enroll student", "Assign grades", "Calculate overall course grades", "Exit the program"};

        // Create User interface with menu-driven program
        System.out.println("Welcome from the Course Enrollment and Grade Management System.");
        
        // Declare variable
        String choice;
        boolean isRepeat = true;
        
        while (isRepeat) {
            // Print the menu

            System.out.println("Press ");
            for(int i = 0; i <= menuList.length-1; i++) {
                System.out.println(Integer.toString(i+1)+ " "+ menuList[i]);
            }
            choice = scanner.nextLine();

            if (choice.equals("1")) { // If the user choose to add a new course

                // Initialize the course code
                int courseCode = 0;
                String courseName;

                // Ask for the course Code
                do { // Ask repeatedly until the user type integer
                    System.out.println("What's the code of the course?");
                    String userInput = scanner.nextLine();  
                    try {    
                        courseCode = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input! The student's ID must be an integer.");
                    }
                } while (courseCode == 0);

                // Ask for the course name
                System.out.println("What's the name of the course?");
                courseName = scanner.nextLine();

                // Add the course
                boolean isCourseExist = false;
                for (Course course: coursesList) {
                    if (course.getCode() == courseCode) {
                        System.out.println("The course with the same code " + courseCode + " is already existed.");
                        isCourseExist = true;
                    }
                }
                if (!isCourseExist)
                    addCourse(courseCode, courseName);
                printDashes();
                isRepeat = true;
            }

            else if (choice.equals("2")) { // If user chose to enroll student

                // Initialize the variables
                int studentID = 0;
                String studentName = null;
                int courseCode = 0;
                boolean isEnroll = false;
                String courseName = null;
                Student existingStudent = null; 

                // Ask for the student's ID
                do { // Ask repeatedly until the user type integer
                    System.out.println("What's the ID of the student?");
                    String userInput = scanner.nextLine();  
                    try {    
                        studentID = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input! The student's ID must be an integer.");
                    }
                } while (studentID == 0);

                // Ask the course code that user want to enroll
                // Ask for the course Code
                do { // Ask repeatedly until the user type integer
                    System.out.println("What's the code of the course?");
                    String userInput = scanner.nextLine();  
                    try {    
                        courseCode = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input! The student's ID must be an integer.");
                    }
                } while (courseCode == 0);

                boolean isStudentExist = false;
                // Check if the student exist in the studentList
                for (Student student: studentList) {
                    if (student.getID() == studentID) {

                        isStudentExist = true;
                        existingStudent = student; 
                        break;
                        
                    }
                }

                if (!isStudentExist) {
                    // Ask for the student's name
                    System.out.println("What's student's name?");
                    studentName = scanner.nextLine();

                    // Create a new student object
                    Student newStudent = new Student(studentName, studentID);
                    existingStudent = newStudent;
                    
                    studentList.add(newStudent);
                        
                }
                
                // Check if the course exist in the list.
                for (Course course: coursesList) {
                    if (course.getCode() == courseCode) {
                            
                        enrollStudent(existingStudent, course);
                        courseName = course.getName();
                        studentName = existingStudent.getName();
                        isEnroll = true;
                    }
                }

                if (isEnroll) 
                    System.out.println("The student " + studentName + " is successfully enrolled " + courseName + ".");
                else 
                    System.out.println("The enrolling process failed. The course doesn't exist in the system.");
                
                printDashes();
                isRepeat = true;
                
            }

            else if (choice.equals("3")) { // If the user chose to assign grade

                // Initialize the variables
                int studentID = 0;
                int courseCode = 0;
                int courseGrade = -1;

                // Ask for the student's ID
                do { // Ask repeatedly until the user type integer
                    System.out.println("What's the ID of the student?");
                    String userInput = scanner.nextLine();  
                    try {    
                        studentID = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input! The student's ID must be an integer.");
                    }
                } while (studentID == 0);

                // Ask the course code that user want to assign grade
                // Ask for the course Code
                do { // Ask repeatedly until the user type integer
                    System.out.println("What's the code of the course?");
                    String userInput = scanner.nextLine();  
                    try {    
                        courseCode = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input! The student's ID must be an integer.");
                    }
                } while (courseCode == 0);
                
                // Ask for the student's grade
                do { // Ask repeatedly until the user type valid integer
                    System.out.println("What's the grade of the student for the course?");
                    String userInput = scanner.nextLine();
                    try {    
                        courseGrade = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input! The student's grade must be a positive integer.");
                    }
                } while (courseGrade == -1);


                // Check if student and course exist 
                boolean isStudentExist = false;
                boolean isCourseExist = false;
                for (Student student: studentList) {
                    if (student.getID() == studentID) {

                        ArrayList<Course> studentEnrolledCourses = student.getEnrolledCourses();
                        for (Course course: studentEnrolledCourses) {
                            if (course.getCode() == courseCode) {
                                assignGrade(student, course, courseGrade);
                                isCourseExist = true;
                            }
                        }
                        isStudentExist = true;
                    }
                }

                if (!isStudentExist) 
                    System.out.println("The student ID " + studentID + " doesn't exist in the system.");
                else if (!isCourseExist)
                    System.out.println("The student ID " + studentID + " haven't enrolled the course code " + courseCode + ".");
               
                printDashes();
                isRepeat = true;

            }

            else if (choice.equals("4")) { // If user chose to calculate overall course grades of a student

                // Initialize the variables
                int studentID = 0;
                Student existingStudent = null;
                // Ask for the student's ID
                do { // Ask repeatedly until the user type integer
                    System.out.println("What's the ID of the student?");
                    String userInput = scanner.nextLine();  
                    try {    
                        studentID = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input! The student's ID must be an integer.");
                    }
                } while (studentID == 0);

                // Check if the student exist in the system
                
                boolean isStudentExist = false;
                for (Student student: studentList) {
                    if (student.getID() == studentID) {
                        existingStudent = student;
                        isStudentExist = true;
                        break;
                    }
                }

                if (!isStudentExist) {
                    System.out.println("The student with ID " + studentID + " doesn't exist in the system.");
                    
                }
                else {
                    calculateOverallGrade(existingStudent);
                    System.out.println("The student " + existingStudent.getName() + " got overall grade " + existingStudent.getGrade() + ".");
                }

                printDashes();
                isRepeat = true;

            }

            else if (choice.equals("5")) { // If user choose to exit the program
                System.out.println("Thanks for using our system.");
                printDashes();
                isRepeat = false;
            }

            else { // For other invalid inputs
                printDashes();
                isRepeat = true;
            }
        }
        
    }
}
