/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MSI
 */
public class StudentManager {
    private Node root; // Root of the BST

    // Node class for BST
    private static class Node {
        private Student student;
        private Node left;
        private Node right;

        public Node(Student student) {
            this.student = student;
            left = null;
            right = null;
        }
    }

    // Constructor
    public StudentManager() {
        root = null;
    }

    // Method to add a student to the BST
    public void addStudent(Student student) {
        root = addStudentRec(root, student);
    }

    // Helper method to recursively add a student to the BST
    private Node addStudentRec(Node root, Student student) {
        if (root == null) {
            root = new Node(student);
            return root;
        }

        // Compare the student ID to determine the insertion point
        if (student.compareTo(root.student) < 0) {
            root.left = addStudentRec(root.left, student);
        } else if (student.compareTo(root.student) > 0) {
            root.right = addStudentRec(root.right, student);
        }

        return root;
    }

    // Method to remove a student from the BST based on stdID
    public void removeStudent(String stdID) {
        root = removeStudentRec(root, stdID);
    }

    // Helper method to recursively remove a student from the BST
    private Node removeStudentRec(Node root, String stdID) {
        if (root == null) {
            return root;
        }

        // Compare the student ID to find the student to be removed
        int compareResult = stdID.compareTo(root.student.getStdID());
    if (compareResult < 0) {
        root.left = removeStudentRec(root.left, stdID);
    } else if (compareResult > 0) {
        root.right = removeStudentRec(root.right, stdID);
    } else {
        // Found the student to be removed

        // Case 1: Node with only one child or no child
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        // Case 2: Node with two children
        // Get the inorder successor (smallest in the right subtree)
        root.student = minValue(root.right);

        // Delete the inorder successor
        root.right = removeStudentRec(root.right, root.student.getStdID());
    }

    return root;
}

// Helper method to find the inorder successor (smallest in the BST)
private Student minValue(Node root) {
    Student minValue = root.student;
    while (root.left != null) {
        minValue = root.left.student;
        root = root.left;
    }
    return minValue;
}

// Method to correct a student's GPA based on stdID
public void correctGpa(String stdID, double newGpa) {
    correctGpaRec(root, stdID, newGpa);
}

// Helper method to recursively correct a student's GPA based on stdID
private void correctGpaRec(Node root, String stdID, double newGpa) {
    if (root == null) {
        return;
    }

    // Compare the student ID to find the student
    int compareResult = stdID.compareTo(root.student.getStdID());
    if (compareResult < 0) {
        correctGpaRec(root.left, stdID, newGpa);
    } else if (compareResult > 0) {
        correctGpaRec(root.right, stdID, newGpa);
    } else {
        // Found the student, update the GPA
        root.student.setGpa(newGpa);
    }
}

// Method to update a student's phone number based on stdID
public void updatePhoneNumber(String stdID, String newPhoneNumber) {
    updatePhoneNumberRec(root, stdID, newPhoneNumber);
}

// Helper method to recursively update a student's phone number based on stdID
private void updatePhoneNumberRec(Node root, String stdID, String newPhoneNumber) {
    if (root == null) {
        return;
    }

    // Compare the student ID to find the student
    int compareResult = stdID.compareTo(root.student.getStdID());
    if (compareResult < 0) {
        updatePhoneNumberRec(root.left, stdID, newPhoneNumber);
    } else if (compareResult > 0) {
        updatePhoneNumberRec(root.right, stdID, newPhoneNumber);
    } else {
        // Found the student, update the phone number
        root.student.setPhoneNumber(newPhoneNumber);
    }
}

// Method to print the entire list of students entered
public void printStudentList() {
    printStudentListRec(root);
}

// Helper method to recursively print the entire list of students entered
private void printStudentListRec(Node root) {
    if (root != null) {
        printStudentListRec(root.left);
        System.out.println(root.student.toString());
        printStudentListRec(root.right);
    }
}
}
