package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Student {
    // Private instance variables
    private String name;
    private int age;
    private String grade;
    private int ID;
    private ArrayList<Course> Courses = new ArrayList<>(); // Courses of a student

    public Student(int ID, String name, int age, String grade) {
    	this.ID = ID;
    	this.name = name;
    	this.age = age;
    	this.grade = grade;
    }
    
    public Student(int ID, String name, int age, String grade, ArrayList<Course> enroledCourse) {
    	this.ID = ID;
    	this.name = name;
    	this.age = age;
    	this.grade = grade;
    	this.Courses.addAll(enroledCourse);
	}

	// Setter methods to set the student's information
    public void setName(String name) { // Set student's name
        this.name = name;
    }
    
    public void setCourse(Course course) {
    	this.Courses.add(course);
    }
    
    public void setID(int ID) { // Set student's ID
    	this.ID = ID;
    }

    public void setAge(int age) { // Set student's age
        this.age = age;
    }

    public void setGrade(String grade) { // Set student's grade
        this.grade = grade;
    }

    // Getter methods to retrieve the student's information
    public String getName() { // Get student's name
        return name; 
    }

    public int getAge() { // Get student's age
        return age;
    }

    public String getGrade() { // Get student's grade
        return grade;
    }

	public int getID() { // Get student's ID
		return ID;
	}
	
	public StringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }

    public IntegerProperty idProperty() {
        return new SimpleIntegerProperty(ID);
    }

    public IntegerProperty ageProperty() {
        return new SimpleIntegerProperty(age);
    }

    public StringProperty gradeProperty() {
        return new SimpleStringProperty(grade);
    }
    
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
    
    public void assignGrade(Course courseName, int grade) {
        // Check if the course exist course in Courses
        for (Course course : Courses) {
            
            if (course.getCode() == courseName.getCode()) {
                // Set the grade at index 1.
                course.setGrade(grade);
                
            }
        }
        
    }
    
    public ArrayList<Course> getEnrolledCourses() { // Get enrolled courses
        return Courses;
    }

	
}