package application;

import java.util.ArrayList;


public class CourseManagement {

    public static ArrayList<Course> coursesList = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();

    /*
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
            
            newCourse.student++; // Increment the total student
            System.out.println("The course " + code + " " + name + " is successfully added.");
        }
        
    }

    /*
     * The enrollStudent method accepts a Student object and a Course object
     * and it enrolls the student in the course
     */
    public static void enrollStudent(Student student, Course course) {
        if (course.student > course.getMaxCapacity()) {
            System.out.println("There is no more available spot in " + course.getCode() + " " + course.getName());
        } 
        else {
            student.enrollCourse(course);
            System.out.println("Successfully enrolled " + course.getCode() + " " + course.getName());
            studentList.add(student);
            course.student++;
        }
        
    }

    /*
     * The assignGrade method accepts a Student object, a Course object, 
     * and a grade and it assigns the grade to the student for that course
     */
    public static void assignGrade(Student student, Course course, int grade) {
        student.assignGrade(course, grade);
    }
    
    /*
     * The calculateOverallGrade method accept a Student object and 
     * calculate the overall course grade for that student based 
     * on the grades assigned to them.
     */

    // Create a dash-line
    public static void printDashes() {
        for (int i = 0; i < 50; i++) {
                System.out.print("-");
            }
        System.out.println();
    }
}

