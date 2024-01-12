package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Course {
    
    // Private instance variables for course's code, name, maximum capacity
    private int code;
    private String name;
    private int MAX_CAPACITY = 32;
    
    int student = 0;
    private int grade = 0;
    
    
    /*
     * Static variable for to keep track of the total number of enrolled students 
     * across all instances of the Course class.
     */
    static int totalStudent = 0;

    // Constructor for course name and code.
    public Course(int code, String name) {
        this.code = code;
        this.name = name;
    }
    
    // Constructor for course name and grade
    public Course(String name, int grade) {
    	this.name = name;
    	this.grade = grade;
    }
    
    public void setGrade(int grade) {
    	this.grade = grade;
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

	public IntegerProperty codeProperty() {
		return new SimpleIntegerProperty(code);
	}
	
	public IntegerProperty gradeProperty() {
		return new SimpleIntegerProperty(grade);
	}

	public StringProperty nameProperty() {
		return new SimpleStringProperty(name);
	}

	public IntegerProperty studentProperty() {
		return new SimpleIntegerProperty(student);
	}

}
