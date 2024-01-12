import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		// Specify the path to employee dataSet text file
        String filePath = "C:\\Users\\Dell\\Documents\\GitHub\\cs_1102_programming_1\\Unit_8\\Employee.txt";

        // Read the dataSet and store it in a list of Employee objects
        List<Employee> employees = readDataset(filePath);

        // Print the details of each employee
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Define a Function to extract the concatenated string of name and department
        Function<Employee, String> nameDeptConcatenator = employee ->
                employee.getName() + " - " + employee.getDepartment();

        // Use streams to apply the function to each employee and collect the results
        List<String> nameDeptStrings = employees.stream()
                .map(nameDeptConcatenator)
                .collect(Collectors.toList());

        // Print the results
        nameDeptStrings.forEach(System.out::println);
        
        // Calculate the average salary of all employees
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0); // Default to 0.0 if there are no employees

        System.out.println("Average Salary of All Employees: " + averageSalary);

        // Generalize the program with a filter function based on age
        int ageThreshold = 30;
        Predicate<Employee> ageFilter = employee -> employee.getAge() > ageThreshold;

        // Apply the filter and then calculate the average salary
        double averageSalaryAboveThreshold = employees.stream()
                .filter(ageFilter)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0); // Default to 0.0 if there are no employees above the threshold

        System.out.println("Average Salary of Employees Above " + ageThreshold + " Years: " + averageSalaryAboveThreshold);
	}
	
	
	private static List<Employee> readDataset(String filePath) {
		
		// Create a list for the employees
		List<Employee> employees = new ArrayList<>();

        try {
            // Read all lines from the file
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);

            // Parse each line and create Employee objects
            for (String line : lines) {
                String[] parts = line.split(","); // Assuming dataSet is in CSV format
                String name = parts[0].trim();
                int age = Integer.parseInt(parts[1].trim());
                String department = parts[2].trim();
                double salary = Double.parseDouble(parts[3].trim());

                // Create an Employee object and add it to the list
                Employee employee = new Employee(name, age, department, salary);
                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
		
	}

}
