/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3;

/**
 *
 * @author baohc
 */
public class Guitar {
    
    private String serialNumber;
    private int Price;
    private String builder;
    private String model;
    private String backWood;
    private String topWood;
    
    public Guitar(){
        serialNumber = null;
        Price = 0;
        builder = null;
        model = null;
        backWood = null;
        topWood = null;
    }
    
    
    public Guitar(String serialNumber, int Price, String builder, String model, String backWood, String topWood) {
        this.serialNumber = serialNumber;
        this.Price = Price;
        this.builder = builder;
        this.model = model;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getPrice() {
        return Price;
    }

    public String getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public String getBackWood() {
        return backWood;
    }

    public String getTopWood() {
        return topWood;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBackWood(String backWood) {
        this.backWood = backWood;
    }

    public void setTopWood(String topWood) {
        this.topWood = topWood;
    }
    
    public void createSound(){
        System.out.println("Serial Number : " + getSerialNumber());
        System.out.println("Price : " + getPrice());
        System.out.println("Builder : " + getBuilder());
        System.out.println("Model : " + getModel());
        System.out.println("Back Wood : " + getBackWood());
        System.out.println("Top Wood : " + getTopWood());
        
    }

}
