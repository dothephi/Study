/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PhiDT
 */
public class PRODUCT {
    public static final char SEPARATOR = ',';
    private String ID;
    private String Name;
    private double UnitPrice;
    private int Quantity;
    private String Status;

    public PRODUCT(String ID, String Name, double UnitPrice, int Quantity, String Status) {
        this.ID = ID;
        this.Name = Name;
        this.UnitPrice = UnitPrice;
        this.Quantity = Quantity;
        this.Status = Status;
    }

    public PRODUCT() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return ID +","+Name+","+UnitPrice+","+Quantity+","+Status;
    }

    public void showInfor(){
        System.out.printf("|%-10s|%-20s|%-10f|%-10d|%-15s|\n",ID, Name, UnitPrice, Quantity, Status);
    }
}
