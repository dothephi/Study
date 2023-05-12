
package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PhiDT
 */


public interface ProductDao {
       
       void readDataFromFile();
       void createAProduct();
       void searchProduct() ;
       void updateProduct();
       void saveToFile();
       void printListNewProduct();
       void printAllProductFromFile();
       void checkExitProduct();
       
}
