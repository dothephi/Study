/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.ProductDao;
import dao.Product;

public class ProductManager {

    public static void main(String[] args) {
        String[] options = {
            "Print",
            "Create a Product.",
            "Check exits Product.",
            "Search Product information by Name.",
            "Update Product.",
            "Save Product to file.",
            "Print list Product from the file."
        };
        Menu mnu = new Menu(options);
        int choice = 0;
        ProductDao x = new Product();
        x.readDataFromFile();
        
        do {

            choice = mnu.getChoice("WELCOME TO PRODUCT MANAGER");
            System.out.println("------------------------------");
            switch (choice) {
                case 1:
                    x.printListNewProduct();
                    break;
                case 2:
                    x.createAProduct();
                    break;
                case 3:
                    x.checkExitProduct();
                    break;
                case 4:
                    x.searchProduct();
                    break;
                case 5:
                    x.updateProduct();
                    break;
                case 6:
                    x.saveToFile();
                    break;
                case 7:
                    x.printAllProductFromFile();
                    break;
            }
        } while (choice >0 && choice <8);
        System.out.println("Quit program completed!");
}
}
