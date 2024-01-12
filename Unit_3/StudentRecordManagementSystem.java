import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class StudentRecordManagementSystem {

    // Create a dash-line
    public static void printDashes() {
        for (int i = 0; i < 50; i++) {
                System.out.print("-");
            }
        System.out.println();
    }

    // Main program
    public static void main(String[] args) {

        // Open Scanner
        Scanner scanner = new Scanner(System.in);
        // Create a menu list
        String[] menuList = {"Add a new student", "Update student's information", "View student's details", "View the total student", "Exit the program"};

        // Create User interface with menu-driven program
        System.out.println("Welcome from the Student Record Management System");
        
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

            if (choice.equals("1")) { // If the user choose to add a new student
                
                String studentName;
                int studentID = 0;      // Initialize student's ID, age
                int studentAge = 0;     // grade with default values to ask
                int studentGrade = 0;   // repeatedly until user types correct input
                
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

                // Ask for the student's name
                System.out.println("What's the name of the student?");
                studentName = scanner.nextLine();

                // Ask for the student's age
                do { // Ask repeatedly until the user type integer
                    System.out.println("How old is the student? ");
                    String userInput = scanner.nextLine();
                    try {    
                        studentAge = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input! The student's age must be an integer.");
                    }
                } while (studentAge == 0);

                // Ask for the student's grade
                do { // Ask repeatedly until the user type integer
                    System.out.println("What's the current grade of the student?");
                    String userInput = scanner.nextLine();
                    try {    
                        studentGrade = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input! The student's grade must be an integer.");
                    }
                } while (studentGrade == 0);

                // If all the requirements are fulfilled, add the student to the list
                StudentManagement.addStudent(studentID, studentName, studentAge, studentGrade);
                isRepeat = true;

            }

            else if (choice.equals("2")) { // If user chose to update the student
                String newName;
                int studentID = 0;   // Initialize student's ID, age
                int newAge = -1;     // grade with default values to ask
                int newGrade = -1;   // repeatedly until user types correct input
                
                // Ask for the student's ID
                do { // Ask repeatedly until the user type integer
                    System.out.println("What's the ID of the student that you want to update?");
                    System.out.println("Note: Type '0' to keep the existing information.");
                    String userInput = scanner.nextLine();

                    try {    
                        studentID = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input! The student's ID must be an integer.");
                    }
                    
                } while (studentID == 0);

                
                // Ask for the student's new name
                System.out.println("What is the new name of the student? ");
                newName = scanner.nextLine();

                // Ask for the student's new age
                do { // Ask repeatedly until the user type integer
                    System.out.println("How old is the student, now? ");
                    String userInput = scanner.nextLine();                        
                    try {    
                        newAge = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input! The student's age must be an integer.");
                    }
                } while (newAge == -1);
                // Ask for the student's new grade
                do { // Ask repeatedly until the user type integer
                    System.out.println("What's the new grade of the student?");
                    String userInput = scanner.nextLine();
                    try {    
                        newGrade = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input! The student's grade must be an integer.");
                    }
                } while (newGrade == -1);

                // If all the requirements are fulfilled, update the student informations
                StudentManagement.updateStudent(studentID, newName, newAge, newGrade);
                isRepeat = true;
            }

            else if (choice.equals("3")) { // If user chose to find the student's details

                int studentID = 0;  // Inatialize student's age with a default value
                ArrayList<Object> studentDetails;
                // Ask for the student's ID
                do { // Ask repeatedly until the user type integer
                    System.out.println("What's the ID of the student that you want to know?");
                    String userInput = scanner.nextLine();

                    try {    
                        studentID = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input! The student's ID must be an integer.");
                    }
                    
                } while (studentID == 0);

                // If all the requirements are fulfilled, show the student's information
                studentDetails = StudentManagement.getStudentDetails(studentID);

                if (!(studentDetails == null)) {
                    System.out.printf("Student's ID: %d" ,studentID);
                    System.out.println();
                    System.out.printf("Student's name: %s", studentDetails.get(0));
                    System.out.println();
                    System.out.printf("Student's age: %s", studentDetails.get(1));
                    System.out.println();
                    System.out.printf("Student's grade: %d", studentDetails.get(2));
                    System.out.println();
                    printDashes();
                }
            }
            else if (choice.equals("4")){
                System.out.printf("Total student in the list: %d", StudentManagement.TOTAL_STUDENT);
                System.out.println();
                isRepeat = true;
                printDashes();
            }
            else if (choice.equals("5")) { // If user chose to exit the program
                System.out.println("Thanks for using our system.");
                printDashes();
                isRepeat = false;
            }

            else { // If user types wrong input other than menu options
                System.err.println("Invalid input! the input must in range of 1 to 4.");
                isRepeat = true;
            }
            
        }
        scanner.close();
    }

}