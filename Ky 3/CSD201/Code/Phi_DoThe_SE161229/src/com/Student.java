/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author MSI
 */
class Student implements Comparable<Student> {
    private String stdID;
    private String name;
    private int yearOfBirth;
    private double gpa;
    private String phoneNumber;

    // Constructor
    public Student(String stdID, String name, int yearOfBirth, double gpa, String phoneNumber) {
        this.stdID = stdID;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gpa = gpa;
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter methods

    public String getStdID() {
        return stdID;
    }

    public void setStdID(String stdID) {
        this.stdID = stdID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Override compareTo() method to compare students based on stdID
    @Override
    public int compareTo(Student st) {
        return this.stdID.compareTo(st.getStdID());
    }

    // Override toString() method to output student information
    @Override
    public String toString() {
        return "Student ID: " + stdID + ", Name: " + name + ", Year of Birth: " + yearOfBirth +
                ", GPA: " + gpa + ", Phone Number: " + phoneNumber;
    }
}

