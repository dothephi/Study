/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siu;
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
    private static Queue<Beer> beerQueue = new LinkedList<>();

    public static void main(String[] args) {
        // Add sample beers to the queue
        addBeerToQueue(new Beer("B01", "Beer 1", "Tay Ninh", 20000));
        addBeerToQueue(new Beer("B02", "Beer 2", "Tay Tang", 25000));
        addBeerToQueue(new Beer("B03", "Beer 3", "Tay Du Ky", 22000));
        addBeerToQueue(new Beer("B04", "Beer 4", "Tay Ninh", 24000));

        // Update unit price for beers produced in Tay Tang
        updateBeerPriceByPlace("Tay Tang", 200);

        // Save beer data to file
        saveBeerDataToFile("Beer.txt");

        // Print all imported beers
        printAllImportedBeers();
    }

    // Add a beer to the queue
    public static void addBeerToQueue(Beer beer) {
        if (!isDuplicateId(beer.getId()) && beer.getPrice() <= 25000) {
            beerQueue.add(beer);
        } else {
            System.out.println("Error: Cannot add beer to queue. Invalid ID or unit price.");
        }
    }

    // Update unit price for beers produced in a specific place
    public static void updateBeerPriceByPlace(String place, int priceIncrement) {
        for (Beer beer : beerQueue) {
            if (beer.getPlace().equals(place)) {
                beer.setPrice(beer.getPrice() + priceIncrement);
            }
        }
    }

    // Save beer data to a file
    public static void saveBeerDataToFile(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (Beer beer : beerQueue) {
                writer.write(beer.getId() + "," + beer.getName() + "," + beer.getPlace() + "," + beer.getPrice());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: Failed to save beer data to file.");
        }
    }

    // Print all imported beers
    public static void printAllImportedBeers() {
        System.out.println("All imported beers:");
        for (Beer beer : beerQueue) {
            System.out.println("ID: " + beer.getId() + ", Name: " + beer.getName() + ", Place: " + beer.getPlace() + ", Price: " + beer.getPrice());
        }
    }

    // Check if a beer with the same ID already exists in the queue
    public static boolean isDuplicateId(String id) {
        for (Beer beer : beerQueue) {
            if (beer.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}