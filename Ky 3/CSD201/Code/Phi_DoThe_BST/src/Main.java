
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MSI
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner
        (System.in);
        boolean running = true;
        while (running) {
        System.out.println("-------------------------------");
        System.out.println("        Students Manager");
        System.out.println("-------------------------------");
        System.out.println("        Enter your choice:");
        System.out.println("1. Add a student information");
        System.out.println("2. Remove a student");
        System.out.println("3. Change student's GPA");
        System.out.println("4. Update student phone number");
        System.out.println("5. Print entire student list");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                System.out.println("Enter student ID:");
                String stdID = scanner.nextLine();
                System.out.println("Enter student name:");
                String name = scanner.nextLine();
                System.out.println("Enter student year of birth:");
                int yearOfBirth = scanner.nextInt();
                System.out.println("Enter student GPA:");
                double gpa = scanner.nextDouble();
                System.out.println("Enter student phone number:");
                String phoneNumber = scanner.next();
                Student newStudent = new Student(stdID, name, yearOfBirth, gpa, phoneNumber);
                studentManager.addStudent(newStudent);
                System.out.println("Student added successfully.");
                break;
            case 2:
                System.out.println("Enter student ID to remove:");
                String removeStdID = scanner.next();
                studentManager.removeStudent(removeStdID);
                System.out.println("Student removed successfully.");
                break;
            case 3:
                System.out.println("Enter student ID to correct GPA:");
                String correctStdID = scanner.next();
                System.out.println("Enter new GPA:");
                double newGpa = scanner.nextDouble();
                studentManager.correctGpa(correctStdID, newGpa);
                System.out.println("Student GPA corrected successfully.");
                break;
            case 4:
                System.out.println("Enter student ID to update phone number:");
                String updateStdID = scanner.next();
                System.out.println("Enter new phone number:");
                String newPhoneNumber = scanner.next();
                studentManager.updatePhoneNumber(updateStdID, newPhoneNumber);
                System.out.println("Student phone number updated successfully.");
                break;
            case 5:
                System.out.println("Printing entire student list:");
                studentManager.printStudentList();
                break;
            case 6:
                System.out.println("Exiting...");
                running = false;
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                break;
        }
    }
    scanner.close();
    }
}
    
