import java.util.Scanner;

/**
 * A program that ask simple quiz to the user about the world.
 * After the user answer all the questions, the final
 * score based on the number of correct answers will be displayed.
 */

public class Quiz {
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner( System.in );  // Create the Scanner.
		
		int score = 0;  	// The initial score of user
		String answer;  	// The answer of question
		
		System.out.println("Welcome to the quiz game!!"); 
		
		// To make a loop until the user types a single character.
		boolean check = false; 
		
		// Question 1
		while (!check) {
		
			// Print the question 1
			System.out.println("1. What is the capital of France? ");  
			System.out.println("(A) Berlin");
			System.out.println("(B) London");
			System.out.println("(C) Paris");
			System.out.println("(D) Berlin");
			
			answer = scanner.nextLine();   	// Receive the user's input.
			
			// Check the answer if it is correct.
			// If not, print the error message and request the input again.
			if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B") || 
					answer.equalsIgnoreCase("C") || answer.equalsIgnoreCase("D")) {
				
				// Use if-else statements to check if the answer is correct.
				if (answer.toUpperCase().equals("C")) {
					score++;		// Update the score.
					System.out.println("You are correct!");
				} else {
					System.out.println("You're wrong. The correct answer is (C) Paris.");
				}
				
				check = true;		// If the answer is correct, change the boolean to break the loop.
				System.out.println("Your current score: " + score + "/5");
				
			} else {
				System.out.println("Invalid input. Please enter a single letter (A, B, C, or D).");		
									// Print error message.		
			}
		}
		
		check = false;		// Change the boolean to ask the question 2.
		
		// Question 2
		while (!check) {
				
			// Print the question 2
			System.out.println("2. Which is the largest ocean in the world? ");  
			System.out.println("(A) Pacific Ocean");
			System.out.println("(B) Atlantic Ocean");
			System.out.println("(C) Indian Ocean");
			System.out.println("(D) Arctic Ocean");
					
			answer = scanner.nextLine();   	// Receive the user's input
			
			// Check the answer if it is correct.
			// If not, print the error message and request the input again.
			if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B") || 
					answer.equalsIgnoreCase("C") || answer.equalsIgnoreCase("D")) {
				
				// Use if-else statements to check if the answer is correct.
				if (answer.toUpperCase().equals("A")) {
					score++;		// Update score.
					System.out.println("You are correct!");
				} else {
					System.out.println("You're wrong. The correct answer is (A) Pacific Ocean.");
				}
				
				check = true;       // If the answer is correct, change the boolean to break the loop.
				System.out.println("Your current score: " + score + "/5");
				
			} else {
				System.out.println("Invalid input. Please enter a single letter (A, B, C, or D).");
									// Print error message.
			}
		}

		check = false;		// Change the boolean to ask question 3.
		
		// Question 3
		while (!check) {
				
			// Print the question 3
			System.out.println("3. Which is the largest desert in the world? ");  
			System.out.println("(A) Sahara Desert");
			System.out.println("(B) Antarctic Desert");
			System.out.println("(C) Gobi Desert");
			System.out.println("(D) Australian Desert");
					
			answer = scanner.nextLine();   	// Receive the user's input
			
			// Check the answer if it is correct.
			// If not, print the error message and request the input again.
			if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B") || 
					answer.equalsIgnoreCase("C") || answer.equalsIgnoreCase("D")) {
				
				// Use if-else statements to check if the answer is correct.
				if (answer.toUpperCase().equals("B")) {
					score++;		// Update score.
					System.out.println("You are correct!");
				} else {
					System.out.println("You're wrong. The correct answer is (B) Antarctic Desert.");
				}
				
				check = true;
				System.out.println("Your current score: " + score + "/5");
							
			} else {
				System.out.println("Invalid input. Please enter a single letter (A, B, C, or D).");
								// Print error message.
			}
		}
		
		check = false;		// Change the boolean to ask question 4.
		
		// Question 4
		while (!check) {
				
			// Print the question 4
			System.out.println("4. Which is the longest river in the world? ");  
			System.out.println("(A) Nile River");
			System.out.println("(B) Amazon River");
			System.out.println("(C) Yangtze River");
			System.out.println("(D) Mississippi River");
					
			answer = scanner.nextLine();   	// Receive the user's input
			
			// Check the answer if it is correct.
			// If not, print the error message and request the input again.
			if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B") || 
					answer.equalsIgnoreCase("C") || answer.equalsIgnoreCase("D")) {	
				
				// Use if-else statements to check if the answer is correct.
				if (answer.toUpperCase().equals("A")) {
					score++;
					System.out.println("You are correct!");
				} else {
					System.out.println("You're wrong. The correct answer is (A) Nile River.");
				}
				check = true;		// If the answer is correct, change the boolean to break the loop.
				System.out.println("Your current score: " + score + "/5");
										
			} else {
				System.out.println("Invalid input. Please enter a single letter (A, B, C, or D).");
									// Print error message.
			}			
		}
		
		check = false;		// Change the boolean to ask question 5.
		
		// Question 5
		while (!check) {
				
			// Print the question 5
			System.out.println("5. Which is the tallest mountain in the world? ");  
			System.out.println("(A) K2");
			System.out.println("(B) Kangchenjunga");
			System.out.println("(C) Mount Everest");
			System.out.println("(D) Lhotse");
					
			answer = scanner.nextLine();		// Receive the user's input
			
			// Check the answer if it is correct.
			// If not, print the error message and request the input again.
			if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B") || 
					answer.equalsIgnoreCase("C") || answer.equalsIgnoreCase("D")) {	
				
				// Use if-else statements to check if the answer is correct.
				if (answer.toUpperCase().equals("C")) {
					score++;		// Update score.
					System.out.println("You are correct!");
				} else {
					System.out.println("You're wrong. The correct answer is (C) Mount Everest.");
				}
				
				check = true;		// If the answer is correct, change the boolean to break the loop.
				System.out.println("Your current score: " + score + "/5");
										
			} else {
				System.out.println("Invalid input. Please enter a single letter (A, B, C, or D).");
									// Print error message.
			}
		}
	
		double finalScore = score / 5.0;		// User's final score.
		// Format the float result as a percentage using String.format
		String finalScorePercent = String.format("%.2f%%", finalScore * 100);
		System.out.println("Your final score: " + finalScorePercent);
		scanner.close();	// Close the scanner.
	}
}
