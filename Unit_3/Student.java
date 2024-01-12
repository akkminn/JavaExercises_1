public class Student {
    // Private instance variables
    private String name;
    private int age;
    private int grade;

    // Setter methods to set the student's information
    public void setName(String name) { // Set student's name
        this.name = name;
    }

    public void setAge(int age) { // Set student's age
        this.age = age;
    }

    public void setGrade(int grade) { // Set student's grade
        this.grade = grade;
    }

    // Getter methods to retrieve the student's information
    public String getName() { // Get student's name
        return name; 
    }

    public int getAge() { // Get student's age
        return age;
    }

    public int getGrade() { // Get student's grade
        return grade;
    }
}