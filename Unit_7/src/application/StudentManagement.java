package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentManagement {
	
	public static ArrayList<Integer> studentId = new ArrayList<>();

    public static Map<String, Student> studentMap; // Change the value type to Student

    // Static initializer block to initialize the studentMap
    static {
        studentMap = new HashMap<>();
    }
    // Create a dash-line
    public static void printDashes() {
        for (int i = 0; i < 50; i++) {
                System.out.print("-");
            }
        System.out.println();
    }
 
    // Track the total number of students
    public static int TOTAL_STUDENT = 0;

    // Delcare methods
    /*
     * Create a method called addStudent that takes
     * student's ID, name, age and grade and create
     * a new Student object. It will add the student 
     * to the list of students and update the total 
     * number of students.
     */
    public static void addStudent(int ID, String name, int age, String grade) {
       
        String idString = Integer.toString(ID); // Convert double to String for the key
        if (studentMap.containsKey(idString)) {
            System.err.printf("Error! The student ID %d is already taken.\n", ID);
            printDashes();
        }
        else {
            // Create a new Student object
            Student newStudent = new Student(ID, name, age, grade);
           
            studentMap.put(idString, newStudent);
            studentId.add(ID);		// Add the student's ID to arrayList
            CourseManagement.studentList.add(newStudent); 	// Add the new student to the list
            TOTAL_STUDENT += 1;     // Increase the total number of students
            System.out.println(name + " is successfully added to the list.");
            printDashes();
        }
    }

    /*
     * Create a method called updateStudent that 
     * accept a student ID and new information. It 
     * locate the student in the list and update 
     * the student's information accordingly.
     */
    public static void updateStudent(int ID, String newName, int newAge, String newGrade) {
        
        String idString = Integer.toString(ID); // Convert double to String for the key
        if (studentMap.containsKey(idString)) {
        	
            Student studentInfo = studentMap.get(idString);  

            // Update name if new name is provided
            if (!newName.equals("0")) {
                studentInfo.setName(newName);
            }

            // Update age if new age is provided
            if (newAge != 0) {
                studentInfo.setAge(newAge);
            }

            // Update grade if new grade is provided
            studentInfo.setGrade(newGrade);
            

            // Update the studentMap only if any new values were provided
            if (!newName.equals("0") || newAge != 0) {
                studentMap.put(idString, studentInfo);
            }
            System.out.println("The student ID " + idString + " is successfully updated.");
            printDashes();

        }
        else {
            System.err.printf("Error! The student ID %d doesn't exist in the list.\n", ID);
            printDashes();
        }
    }

    /*
     * Create a method called getStudentDetails 
     * that accepts a student ID and return the 
     * details(ArrayList) of the corresponding student
     * 
     */
    public static ArrayList<Object> getStudentDetails(int ID) {
        String idString = Integer.toString(ID); // Convert double to String for the key
        if (studentMap.containsKey(idString)) {

            Student student = studentMap.get(idString);
            // Create a new ArrayList to add student's infos
            ArrayList<Object> studentInfo = new ArrayList<>();
            studentInfo.add(student.getID()); // Get student's name
            studentInfo.add(student.getName());  // Get student's age
            studentInfo.add(student.getAge()); // Get student's grade
            studentInfo.add(student.getGrade()); // Get student's ID
            studentInfo.add(student.getEnrolledCourses());
            return studentInfo;
        }
        else {
            System.err.printf("Error! The student ID %d doesn't exist in the list.\n", ID);
            printDashes();
            return null;
        }
    }

}
