/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author PhiDT
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.StringTokenizer;
import model.PRODUCT;

import tool.MyTool;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Product implements ProductDao {

    private ArrayList<PRODUCT> list = new ArrayList();
    private ArrayList<PRODUCT> listDataFile = new ArrayList();
    private int count = 0;

    
    public void addDataFromFileToList() {
        listDataFile.clear();
        try {
            try (FileReader fr = new FileReader("Products.txt"); BufferedReader bf = new BufferedReader(fr)) {
                String details;
                while ((details = bf.readLine()) != null) {
                    StringTokenizer stk = new StringTokenizer(details, ",");
                    String ID = stk.nextToken();
                    String name = stk.nextToken();
                    double price = Double.parseDouble(stk.nextToken());
                    int quantity = Integer.parseInt(stk.nextToken());
                    String status = stk.nextToken();
                    listDataFile.add(new PRODUCT(ID, name, price, quantity, status));
                }
            }
        } catch (Exception e) {
            System.out.println("Read data from Product.txt fail");
        }

    }

    @Override
    public void readDataFromFile() {
        try {
            try (FileReader fr = new FileReader("Products.txt")) {
                BufferedReader bf = new BufferedReader(fr);
                String details;
                while ((details = bf.readLine()) != null) {
                    StringTokenizer stk = new StringTokenizer(details, ",");
                    String ID = stk.nextToken();
                    String name = stk.nextToken();
                    double price = Double.parseDouble(stk.nextToken());
                    int quantity = Integer.parseInt(stk.nextToken());
                    String status = stk.nextToken();
                    list.add(new PRODUCT(ID, name, price, quantity, status));
                    count++;
                }
                bf.close();
            }
        } catch (Exception e) {
            System.out.println("Read data from Product.txt fail");
        }
    }

    @Override
    public void createAProduct() {
        String productID, productName, status;
        int index;
        do {
            productID = MyTool.regexString("  -Enter ID Product(S/sxxx): ", "Wrong format.Input again", "^[S|s]\\d{3}$");
            index = checkID(productID);
            if (index >= 0) {
                System.out.println("Product ID has been already.");
            }
        } while (index >= 0);
        boolean checkName;
        do {
            checkName = false;
            productName = MyTool.getString("  -Enter Name Product: ", "Not blank or empty.");
            if (productName.length() < 2) {
                System.out.println("Product's name more than two characters.");
            }
            checkName = checkExistName(productName);
            if (checkName == true) {
                System.out.println("Product's name has been alredy in list.Input again!");
            }
        } while (productName.length() < 2 || checkName == true);
        double price = MyTool.getADouble("  -Enter Price Product[0..10000]: ", "Just from 0 to 10000", 0, 10000);
        int quantity = MyTool.getAnInteger("  -Enter Quantity Product: ", "Just from 0 to 1000", 0, 1000);
        String Status = MyTool.getStringForm("  -Enter status (Y: Avaiable or N: Not-Avaiable): ", "Status is not empty", "^[y|n|Y|N&&[a-zA-Z]]$", "Wrong Status format (Y or N only)");
        if (Status.equalsIgnoreCase("Y")) {
            Status = "Available";
        } else {
            Status = "Not Available";
        }
        list.add(new PRODUCT(productID, productName, price, quantity, Status));
        System.out.println("The Product's added..");
    }

    public boolean checkExistName(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public int checkID(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void checkExitProduct() {
        addDataFromFileToList();
        boolean check = false;
        String find = MyTool.getString("  -Enter Name Product To Search: ", "Not blank or empty.");
        for (int i = 0; i < listDataFile.size(); i++) {
            if (listDataFile.get(i).getName().toLowerCase().contains(find.toLowerCase())) {
                check = true;
            }
        }
        if (check == true) {
            System.out.println("Exit Product");
        } else {
            System.out.println("No Product Found!");
        }

    }

    @Override
    public void searchProduct() {
        ArrayList<PRODUCT> listSP = new ArrayList();
        boolean flag = false;
        String name = MyTool.getString("  -Enter Name Product: ", "Not blank or empty.");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                listSP.add(list.get(i));
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println(" no any Product.");
            return;
        }
        Collections.sort(listSP, (o1, o2) -> {
            return o1.getName().compareToIgnoreCase(o2.getName());
        });
        System.out.println("+----------+--------------------+----------+----------+---------------+");
        System.out.println("|    ID    |        NAME        |   PRICE  | QUANTITY |     STATUS    |");
        System.out.println("+----------+--------------------+----------+----------+---------------+");
        for (int i = 0; i < listSP.size(); i++) {
            listSP.get(i).showInfor();
        }
        System.out.println("+----------+--------------------+----------+----------+---------------+");
    }

    @Override
    public void updateProduct() {
        int choice = MyTool.getAnInteger(" Enter your choice (1.Update Product  OR  2.Delete Product) : ", "Just 1 or 2.", 1, 2);
        if (choice == 1) {
            String productID = MyTool.regexString("  -Enter ID Product(S/sxxx): ", "Wrong format.Input again", "^[S|s]\\d{3}$");
            int index = checkID(productID);
            if (index >= 0) {
                boolean check, checkName;
                String newName;
                do {
                    check = true;
                    checkName = false;
                    newName = MyTool.updateString("  -Enter New Name Product: ", list.get(index).getName());
                    if (!newName.isEmpty() && newName.length() < 2) {
                        System.out.println("Product's Name more than 2 characters.");
                        check = false;
                    }
                } while (check == false || checkName == true);
                double newPrice = MyTool.updateADouble("  -Enter New Price Product: ", 0, 10000, list.get(index).getUnitPrice());
                int newQuantity = MyTool.updateAnInteger("  -Enter New Quantity Product: ", 0, 1000, list.get(index).getQuantity());
              
                String updateStatus =  MyTool.updateString("  -Enter status (Y: Avaiable or N: Not-Avaiable): ",list.get(index).getStatus());
                 
                list.get(index).setName(newName);
                list.get(index).setUnitPrice(newPrice);
                list.get(index).setQuantity(newQuantity);
                list.get(index).setStatus(updateStatus);
                System.out.println("The Product's information has been updated..Successfully.");
            } else {
                System.out.println("Product name does not exist.");
            }
        } else {
            String productID = MyTool.getString("  -Enter ID Product: ", "Not blank or empty.");
            int index = checkID(productID);
            if (index >= 0) {
                list.remove(index);
                System.out.println("The product's information has been deleted..Successfully.");
            } else {
                System.out.println("Product name does not exist.");
            }
        }
    }

    @Override
    public void saveToFile() {
        try {
            File f = new File("Products.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < list.size(); i++) {
                pw.println(list.get(i).toString());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Write data to Product.TXT fail");
        }
        System.out.println("Save to file Successfully.");
    }

    @Override
    public void printListNewProduct() {
        if (list.isEmpty()) {
            System.out.println("List empty.Nothing to print.");
        } else {
            if (count == list.size()) {
                System.out.println("EMPTY LIST");
                return;
            }
            System.out.println("HERE IS INFORMATION OF LIST NEW PRODUCT:");
            System.out.println("+----------+--------------------+----------+----------+---------------+");
            System.out.println("|    ID    |        NAME        |   PRICE  | QUANTITY |     STATUS    |");
            System.out.println("+----------+--------------------+----------+----------+---------------+");
            for (int i = count; i < list.size(); i++) {
                list.get(i).showInfor();
            }
            System.out.println("+----------+--------------------+----------+----------+---------------+");
        }
    }

    @Override
    public void printAllProductFromFile() {
        addDataFromFileToList();
        if (listDataFile.isEmpty()) {
            System.out.println("List empty!!!");
        } else {
            Collections.sort(listDataFile, Comparator.comparingDouble(listDataFile -> ((PRODUCT) listDataFile).getQuantity()).reversed().thenComparingDouble(listDataFile -> ((PRODUCT) listDataFile).getUnitPrice()));
             System.out.println("HERE IS INFORMATION OF LIST PRODUCT FROM FILE:");
            System.out.println("+----------+--------------------+----------+----------+---------------+");
            System.out.println("|    ID    |        NAME        |   PRICE  | QUANTITY |     STATUS    |");
            System.out.println("+----------+--------------------+----------+----------+---------------+");
            for (int i = 0; i < listDataFile.size(); i++) {
                listDataFile.get(i).showInfor();
            }
            System.out.println("+----------+--------------------+----------+----------+---------------+");
        }
    }

}
