import java.util.ArrayList;

public class Student {
    
    // Private instance variables for student's name, ID, enrolled courses, grades
    private String name;
    private int ID;
    private ArrayList<Course> Courses;
    private String grade; // Overall grade for each student

    // Constructor for student name and ID
    public Student (String name, int ID) {
        this.ID = ID;
        this.name = name;
        this.Courses = new ArrayList<>();
    }


    // Setter methods
    public void setName(String name) { // Set the student's name
        this.name = name;
    }

    public void setID(int ID) { // Set the student's ID
        this.ID = ID;
    }

    public void setGrade(String grade) { // Set student's overall grade
        this.grade = grade;
    }


    /**
     * A method to enroll students in courses that takes
     * a Course object as a parameter and add the course 
     * to the student's enrolled courses.
     */
    public void enrollCourse(Course courseName) {
    
        boolean courseExist = false; // Check if the course exit in Courses
        for (Course course : Courses) { 
        
            if (course.getCode() == courseName.getCode()) {
                // The course with the specified name exists in the ArrayList
                System.out.println("The student " + this.getName() + " is already enrolled " +courseName.getCode()+ " " + courseName.getName() + ".");
                courseExist = true;
            }
        }
        if (!courseExist) { // If the course doesn't exist in Courses
            // Create a new Course object
            Course newCourse = new Course(courseName.getCode(), courseName.getName());
            // Add code name and grade (null at first) to Courses
            Courses.add(newCourse);
        }       
    }

    /**
     * A method to assign grades to students that take a Course object
     * and a grade for the student as parameters and update 
     * the student's grade for that course. 
     */
    public void assignGrade(Course courseName, int grade) {
        // Check if the course exist course in Courses
        for (Course course : Courses) {
            
            if (course.getCode() == courseName.getCode()) {
                // Set the grade at index 1.
                course.setGrade(grade);
                
            }
        }
        
    }
       
    // Getter methods
    public String getName() { // Get student's name
        return name;
    }

    public int getID() { // Get the student's ID
        return ID;
    }

    public String getGrade() { // Get student's overall grade
        return grade;
    }

    public ArrayList<Course> getEnrolledCourses() { // Get enrolled courses
        return Courses;
    }

}
