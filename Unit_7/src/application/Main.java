package application;
	

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;


public class Main extends Application {
	
	private VBox layout;
	
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
    	
        primaryStage.setTitle("Uopeople Student Management System");
        
        // Create welcome label
        Label welcomeLb = new Label("Welcome to UoPeople Student Management System!");
        welcomeLb.getStyleClass().add("welcomelb");
        
        // Create a grid pane for the welcome label
        GridPane welcomePane = new GridPane();
        welcomePane.add(welcomeLb, 5, 10);
        
        // Create a menu bar
        MenuBar menuBar = new MenuBar();
		menuBar.getStyleClass().add("menuBar");
        // Create menu
        Menu studentMenu = new Menu("Student Management");
        Menu courseMenu = new Menu("Course Management");
        Menu gradeMenu = new Menu("Grade Management");
        

        // Create menu items for studentMenu
        MenuItem addStudentItem = new MenuItem("Add Student");
        MenuItem updateStudentItem = new MenuItem("Update Student");
        MenuItem viewDetailsItem = new MenuItem("View Student Details");
        addStudentItem.getStyleClass().add("menuItem");
        updateStudentItem.getStyleClass().add("menuItem");
        viewDetailsItem.getStyleClass().add("menuItem");
        
        // Create menu items for courseMenu
        MenuItem enrollStudentItem = new MenuItem("Enroll student");
       
        // Create menu items for gradeMenu
        MenuItem assignGradeItem = new MenuItem("Assign Grade");
        

        // Set actions for each button
        addStudentItem.setOnAction(e -> showAddStudentForm());
        updateStudentItem.setOnAction(e -> showUpdateStudentForm());
        viewDetailsItem.setOnAction(e -> showStudentDetails());
        enrollStudentItem.setOnAction(e -> showAvailableCourses());
        assignGradeItem.setOnAction(e -> showStudentList());
        
        
        
        // Add items to studentMenu
        studentMenu.getItems().addAll(addStudentItem, updateStudentItem, viewDetailsItem);
        
        // Add items to courseMenu
        courseMenu.getItems().add(enrollStudentItem);
        
        gradeMenu.getItems().add(assignGradeItem);
        
        // Add the menu to the menu bar
        menuBar.getMenus().addAll(studentMenu, courseMenu, gradeMenu);
        
        // Create a vertical layout (VBox) to arrange menu and other content
        layout = new VBox();
        
        layout.getChildren().addAll(welcomePane, menuBar);
        layout.setPadding(new Insets(10)); // 10 pixels padding
        
        // Create a scene with the layout
        Scene scene = new Scene(layout, 500, 300);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
        // Set the scene to the stage
        primaryStage.setScene(scene);
        
        // Show the stage
        primaryStage.show();
        
    }
    
    private void showStudentList() {
		
    	// Create a new stage
    	Stage gradeStage = new Stage();
    	gradeStage.initModality(Modality.APPLICATION_MODAL);
    	
    	gradeStage.setTitle("Assign Grade");
    	// Display student list
    	ListView<Student> studentList = new ListView<>();
    	// Add data to the ListView
        ObservableList<Student> students = FXCollections.observableArrayList();
        
        // Get the details for all id
        for (int id: StudentManagement.studentId) {
        	
        	// Add the name to listView
        	students.add(StudentManagement.studentMap.get(Integer.toString(id)));
        	studentList.setItems(students);
        }
    	
        studentList.getSelectionModel().selectedItemProperty().addListener((obserV, oldV, newV) -> {
        	
        	// Read the student
        	if (newV != null) {
        		
        		// Create form elements
                GridPane formLayout = new GridPane();
                formLayout.setHgap(10);
                formLayout.setVgap(10);
                formLayout.setPadding(new Insets(20, 20, 20, 20));
        		
        		// Create a table view
            	TableView<Course> coursesTable = new TableView<>();
            	
            	// Create columns
            	TableColumn<Course, String> nameColumn = new TableColumn<>("Name");
            	nameColumn.setCellValueFactory(data -> data.getValue().nameProperty());
            	nameColumn.setPrefWidth(350);
                
                TableColumn<Course, Integer> gradeColumn = new TableColumn<>("CurrentGrade");
            	gradeColumn.setCellValueFactory(data -> data.getValue().gradeProperty().asObject());
            	gradeColumn.setPrefWidth(100);
            	
            	// Add column to the table
            	coursesTable.getColumns().add(nameColumn);
            	coursesTable.getColumns().add(gradeColumn);
            	
            	// Add data to the TableView
                ObservableList<Course> courses = FXCollections.observableArrayList();
                for (Course course: newV.getEnrolledCourses()) {
                	courses.add(course);
                }
                coursesTable.setItems(courses);
                coursesTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
                
                coursesTable.getStyleClass().add("root");
                coursesTable.setEditable(true);
                
                coursesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                	if (newValue != null) {
                		
                		// Get old data
                		Course course = coursesTable.getSelectionModel().getSelectedItem();
                		
                		int oldGrade = course.getGrade();
                		
                		// Display new form
                		Label nameLabel = new Label("Course:");
            	        TextField nameField = new TextField(String.valueOf(course.getName()));

            	        Label gradeLabel = new Label("Grade:");
            	        TextField gradeField = new TextField(String.valueOf(course.getGrade()));
            	        
            			Button updateButton = new Button("Update Grade");
            			updateButton.setOnAction(e -> {
            				// Get entered values and update the student in the system
            	            String newGrade = gradeField.getText();
            				
            				try {
            					int grade = newGrade.isEmpty() ? oldGrade : Integer.parseInt(newGrade);
            					
            					// Update the student in the system
            	                CourseManagement.assignGrade(newV, course, grade);
            	                
            	                // Show success alert
            	                showAlert(Alert.AlertType.INFORMATION, "Success", "Grade Updated", "The grade is successfully updated.");
            	                
            	                // Close the form
            	                gradeStage.close();
            					
            				}
            				catch (NumberFormatException err) {
            	            	showAlert(Alert.AlertType.ERROR, "Error", "Invalid Input", "Please enter a grade.");
            	            }
            				
            			});
            			
            			// Add the new elements to the form layout
            	        formLayout.add(nameLabel, 0, 2);
            	        formLayout.add(nameField, 1, 2);
            	        formLayout.add(gradeLabel, 0, 3);
            	        formLayout.add(gradeField, 1, 3);
            	        formLayout.add(updateButton, 1, 4);
            	        
            	        // Set scene to the stage
            	        Scene formScene = new Scene(formLayout, 500, 300);
            	        formScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            	        gradeStage.setTitle("Update grade");
            	        gradeStage.setScene(formScene);
            	    	
                	}
                	
                });
                
                // Create the scene
                Scene tableScene = new Scene(coursesTable, 500, 300);
                tableScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                // Set the stage properties
                gradeStage.setTitle("Select a course");
                gradeStage.setScene(tableScene);
                
                gradeStage.show();
                
        	}
        });
        
        studentList.setCellFactory(new Callback<ListView<Student>, ListCell<Student>>() {
            @Override
            public ListCell<Student> call(ListView<Student> param) {
                return new ListCell<Student>() {
                    @Override
                    protected void updateItem(Student item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty || item == null || item.getName() == null) {
                            setText(null);
                        } else {
                            setText(item.getName());
                        }
                    }
                };
            }
        });
        
        // Create a layout for the table
        VBox listLayout = new VBox();
        listLayout.getChildren().add(studentList);

        // Create scene and set it to the stage
        Scene listScene = new Scene(listLayout, 500, 300);
        listScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        gradeStage.setScene(listScene);
        gradeStage.setTitle("Select a student");

        gradeStage.show();
    	
	}
    

	private void showAvailableCourses() {
    	
    	// Create a new stage
    	Stage enrollStage = new Stage();
    	enrollStage.initModality(Modality.APPLICATION_MODAL);
    	
    	
    	enrollStage.setTitle("Enroll Course");
    	
    	// Create a table view
    	TableView<Course> coursesTable = new TableView<>();
    	
    	// Create columns
    	TableColumn<Course, Integer> codeColumn = new TableColumn<>("Code");
    	codeColumn.setCellValueFactory(data -> data.getValue().codeProperty().asObject());
    	codeColumn.setPrefWidth(100);
    	
    	TableColumn<Course, String> nameColumn = new TableColumn<>("Name");
    	nameColumn.setCellValueFactory(data -> data.getValue().nameProperty());
    	nameColumn.setPrefWidth(350);
    	
    	TableColumn<Course, Integer> studentColumn = new TableColumn<>("Student");
    	studentColumn.setCellValueFactory(data -> data.getValue().studentProperty().asObject());
    	studentColumn.setPrefWidth(50);
    	
    	// Add columns to the table
    	coursesTable.getColumns().add(codeColumn);
    	coursesTable.getColumns().add(nameColumn);
    	coursesTable.getColumns().add(studentColumn);
    	
    	coursesTable.getStyleClass().add("root");
    	
    	// Add data to the TableView
        ObservableList<Course> courses = FXCollections.observableArrayList(
                new Course(101, "Introduction to Computer Science"),
                new Course(201, "Calculus I"),
                new Course(102, "English Composition"),
                new Course(103, "Programming I"),
                new Course(202, "English Composition II")
        );
        
       
        
        coursesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
            	
            	// Display student list
            	ListView<Student> studentList = new ListView<>();
            	// Add data to 0the ListView
                ObservableList<Student> students = FXCollections.observableArrayList();
                
                // Get the details for all id
                for (int id: StudentManagement.studentId) {
                	
                	// Add the name to listView
                	students.add(StudentManagement.studentMap.get(Integer.toString(id)));
                	studentList.setItems(students);
                }
            	
                studentList.getSelectionModel().selectedItemProperty().addListener((obserV, oldV, newV) -> {
                	
                	// Enroll the student and show the alert message
                	if (newV != null) {
                        // Handle course selection, e.g., display enrolled students
                        CourseManagement.enrollStudent(newV, newValue);
                       
                        // Show success alert
                        showAlert(Alert.AlertType.INFORMATION, "Success", "Enrolled Course", newV.getName()+ " is successfully enrolled the "+newValue.getName()+ " .");
                        
                        // Close the form
                        enrollStage.close();
                	}
                });
                
                studentList.setCellFactory(new Callback<ListView<Student>, ListCell<Student>>() {
                    @Override
                    public ListCell<Student> call(ListView<Student> param) {
                        return new ListCell<Student>() {
                            @Override
                            protected void updateItem(Student item, boolean empty) {
                                super.updateItem(item, empty);

                                if (empty || item == null || item.getName() == null) {
                                    setText(null);
                                } else {
                                    setText(item.getName());
                                }
                            }
                        };
                    }
                });

                // Create a layout for the table
                VBox listLayout = new VBox();
                listLayout.getChildren().add(studentList);

                // Create scene and set it to the stage
                Scene listScene = new Scene(listLayout, 500, 300);
                listScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                enrollStage.setScene(listScene);
                enrollStage.setTitle("Select a student");

                enrollStage.show();
            	
            }
        });

        coursesTable.setItems(courses);
        coursesTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        // Create the scene
        Scene scene = new Scene(coursesTable, 500, 300);

        // Set the stage properties
        enrollStage.setTitle("Select a course");
        enrollStage.setScene(scene);

        // Show the stage
        enrollStage.show();
    	
    }
    
    private void showStudentDetails() {
    	
    	// Create a new stage for the form
        Stage tableStage = new Stage();
        tableStage.initModality(Modality.APPLICATION_MODAL);
        
        tableStage.setTitle("Student Details");
    	
        // Create a table view
        TableView<Student> table = new TableView<>();
        
        // Create ID Column
        TableColumn<Student, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        
        // Create Name Column
        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(data -> data.getValue().nameProperty());
        
        // Create Age Column
        TableColumn<Student, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(data -> data.getValue().ageProperty().asObject());
        
        // Create ID Column
        TableColumn<Student, String> gradeColumn = new TableColumn<>("Grade");
        gradeColumn.setCellValueFactory(data -> data.getValue().gradeProperty());
        
        
        // Add the columns
        table.getColumns().add(idColumn);
        table.getColumns().add(nameColumn);
        table.getColumns().add(ageColumn);
        table.getColumns().add(gradeColumn);
        
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        
        ArrayList<Object> studentDetails;
        // Get the details for all id
        for (int id: StudentManagement.studentId) {
        	studentDetails = StudentManagement.getStudentDetails(id);
        	
        	// Get the info
        	String name = (String) studentDetails.get(1);
        	int age = (int) studentDetails.get(2);
        	String grade = (String) studentDetails.get(3);
        	
        	// Update the table items
        	table.getItems().add(new Student(id, name, age, grade));
        }
    
       
        // Create a layout for the table
        VBox tableLayout = new VBox();
        tableLayout.getChildren().add(table);

        // Create scene and set it to the stage
        Scene tableScene = new Scene(tableLayout, 500, 300);
        tableScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        tableStage.setScene(tableScene);

        tableStage.show();
        
    }
    
	private void showUpdateStudentForm() {
    	// Create a new stage for the form
        Stage formStage = new Stage();
        
        formStage.initModality(Modality.APPLICATION_MODAL);
        formStage.setTitle("Update Student");

        // Create form elements
        GridPane formLayout = new GridPane();
        formLayout.setHgap(10);
        formLayout.setVgap(10);
        formLayout.setPadding(new Insets(20, 20, 20, 20));
    	
        Label idLabel = new Label("Student ID:");
        TextField idField = new TextField();
        
        Button selectBtn = new Button("Select");
        selectBtn.setOnAction(e -> {
        	// Get the id of the student
        	String idString = idField.getText();

        	// Check if id is a valid input
        	try {
        		int oldId = Integer.parseInt(idString);
        		
        		// Check if the student exist in the system
        		ArrayList<Object> studentDetails = StudentManagement.getStudentDetails(oldId);
        		if (studentDetails != null) {
        			
        			String oldName = (String) studentDetails.get(1);
        			int oldAge = (int) studentDetails.get(2);
        			String oldGrade = (String) studentDetails.get(3);
        			
        			// Show the rest of the form to update the Student
       
        			Label nameLabel = new Label("Name:");
        	        TextField nameField = new TextField((oldName) );

        	        Label ageLabel = new Label("Age:");
        	        TextField ageField = new TextField(String.valueOf(oldAge));

        	        Label gradeLabel = new Label("Grade:");
        	        TextField gradeField = new TextField(String.valueOf(oldGrade));
        	        
        			Button updateButton = new Button("Update Student");
        	        updateButton.setOnAction(evt -> {
        	            // Get entered values and update the student in the system
        	        	String newId = idField.getText();
        	            String newName = nameField.getText();
        	            String newAge = ageField.getText();
        	            String newGrade = gradeField.getText();
        	            
        	            // Check if age and grade are valid input
        	            try {
        	            	int id = newId.isEmpty() ? oldId : Integer.parseInt(newId);
        	            	String name = newName.isEmpty() ? oldName : newName;
        	                int age = newAge.isEmpty() ? oldAge : Integer.parseInt(newAge);
        	                String grade = newAge.isEmpty() ? oldGrade : newGrade;
        	                
        	                // Update the student in the system
        	                StudentManagement.updateStudent(id, name, age, grade);
        	                
        	                // Show success alert
        	                showAlert(Alert.AlertType.INFORMATION, "Success", "Student Updated", "The student is successfully updated.");
        	                
        	                // Close the form
        	                formStage.close();        	                
        	                
        	            } catch (NumberFormatException err) {
        	            	showAlert(Alert.AlertType.ERROR, "Error", "Invalid Input", "Please enter a valid age and grade.");
        	            }
        	            
        	        });
        	        
        	        // Add the new elements to the form layout
        	        formLayout.add(nameLabel, 0, 2);
        	        formLayout.add(nameField, 1, 2);
        	        formLayout.add(ageLabel, 0, 3);
        	        formLayout.add(ageField, 1, 3);
        	        formLayout.add(gradeLabel, 0, 4);
        	        formLayout.add(gradeField, 1, 4);
        	        formLayout.add(updateButton, 1, 5);
        	        formLayout.getChildren().remove(selectBtn);

        		}
        		else { 
        			showAlert(Alert.AlertType.ERROR, "Error", "ID Not Found", "Student with ID " + oldId + " does not exist.");
        		}
        			
        	}
        	catch (NumberFormatException err) {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid Input", "Please enter a valid ID.");
            }
        	
        	
        });
        
        // Add elements to the form layout
        formLayout.add(idLabel, 0, 0);
        formLayout.add(idField, 1, 0);
		formLayout.add(selectBtn, 1, 1);
        
 
        // Set scene to the stage
        Scene formScene = new Scene(formLayout, 450, 300);
        formScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        formStage.setScene(formScene);
    	
        // Show the form
        formStage.showAndWait();
	}
    
	private void showAddStudentForm() {
        // Create a new stage for the form
        Stage formStage = new Stage();
        formStage.initModality(Modality.APPLICATION_MODAL);
        formStage.setTitle("Add Student");

        // Create form elements
        GridPane formLayout = new GridPane();
        formLayout.setHgap(10);
        formLayout.setVgap(10);
        formLayout.setPadding(new Insets(20, 20, 20, 20));

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label idLabel = new Label("ID:");
        TextField idField = new TextField();
        
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();

        Button addButton = new Button("Add Student");
        addButton.setOnAction(e -> {
            // Get entered values and add the student to the system
            String name = nameField.getText();
            String idString = idField.getText();
            String ageString = ageField.getText();
            
            try {
                int id = Integer.parseInt(idString);
                int age = Integer.parseInt(ageString);

                // Add the student to the system
                StudentManagement.addStudent(id, name, age, null);

                // Show success alert
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student Added", "The student is successfully added.");

                // Close the form
                formStage.close();
            } catch (NumberFormatException ex) {
                // Show error alert for invalid input
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid Input", "Please enter valid ID and Age.");
            }
        });

        // Add elements to the form layout
        formLayout.add(nameLabel, 0, 0);
        formLayout.add(nameField, 1, 0);
        formLayout.add(idLabel, 0, 1);
        formLayout.add(idField, 1, 1);
        formLayout.add(ageLabel, 0, 2);
        formLayout.add(ageField, 1, 2);
        formLayout.add(addButton, 1, 3);
        

        // Create scene and set it to the stage
        Scene formScene = new Scene(formLayout, 450, 300);
        formScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        formStage.setScene(formScene);

        // Show the form
        formStage.showAndWait();
    }

	private void showAlert(Alert.AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    
}
