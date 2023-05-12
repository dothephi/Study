/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dothephi_se161229;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author MSI
 */
public class BeerManagement {
    static Queue<Beer> beerQueue = new LinkedList<Beer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Beer Management System");
            System.out.println("1. Add Beer");
            System.out.println("2. Update Beer Unit Price");
            System.out.println("3. Save to File");
            System.out.println("4. Print All Beers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addBeer(scanner);
                    break;
                case 2:
                    updateBeerUnitPrice(scanner);
                    break;
                case 3:
                    saveToFile();
                    break;
                case 4:
                    printAllBeers();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    public static void addBeer(Scanner scanner) {
        System.out.println("Enter Beer Details:");
        System.out.print("ID (starting with Bxx): ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Production Place (Tay Ninh, Tay Tang, Tay Du Ky): ");
        String productionPlace = scanner.nextLine();
        System.out.print("Unit Price (<= 25000): ");
        int unitPrice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Check if ID already exists in the queue
        boolean isDuplicateId = false;
        for (Beer beer : beerQueue) {
            if (beer.id.equals(id)) {
                isDuplicateId = true;
                break;
            }
        }

        if (isDuplicateId) {
            System.out.println("Error: ID already exists in the queue.");
        } else if (unitPrice > 25000) {
            System.out.println("Error: Unit Price cannot exceed 25000.");
        } else {
            Beer beer = new Beer(id, name, productionPlace, unitPrice);
            beerQueue.add(beer);
            System.out.println("Beer added to the queue successfully.");
        }
    }

    public static void updateBeerUnitPrice(Scanner scanner) {
        System.out.print("Enter Production Place to update unit price (Tay Tang): ");
        String productionPlace = scanner.nextLine();
        System.out.print("Enter unit price increment: ");
        int increment = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        int updatedCount = 0;

        for (Beer beer : beerQueue) {
            if (beer.productionPlace.equals(productionPlace)) {
                beer.unitPrice += increment;
                updatedCount++;}
        }
        if (updatedCount > 0) {
        System.out.println("Unit price updated for " + updatedCount + " beers.");
    } else {
        System.out.println("No beers found with the specified production place.");
    }
}

public static void saveToFile() {
    try {
        FileWriter fw = new FileWriter("Beer.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (Beer beer : beerQueue) {
            bw.write(beer.id + "," + beer.name + "," + beer.productionPlace + "," + beer.unitPrice);
            bw.newLine();
        }

        bw.close();
        fw.close();
        System.out.println("Data saved to Beer.txt file successfully.");
    } catch (IOException e) {
        System.out.println("Error saving data to file: " + e.getMessage());
    }
}

public static void printAllBeers() {
    System.out.println("All Imported Beers:");
    if (beerQueue.isEmpty()) {
        System.out.println("No beers found.");
    } else {
        for (Beer beer : beerQueue) {
            System.out.println(beer.toString());
        }
    }
}
    
}