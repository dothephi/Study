/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siu;

/**
 *
 * @author MSI
 */
public class Beer {
    private String id;
    private String name;
    private String place;
    private int price;

    public Beer(String id, String name, String place, int price) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.price = price;
}
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
