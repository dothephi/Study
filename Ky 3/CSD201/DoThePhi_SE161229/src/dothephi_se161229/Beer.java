/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dothephi_se161229;

/**
 *
 * @author MSI
 */
public class Beer {
    String id;
    String name;
    String productionPlace;
    int unitPrice;

    public Beer(String id, String name, String productionPlace, int unitPrice) {
        this.id = id;
        this.name = name;
        this.productionPlace = productionPlace;
        this.unitPrice = unitPrice;
    }

    public String toString() {
    return "ID: " + id + ", Name: " + name + ", Production Place: " + productionPlace + ", Unit Price: " + unitPrice;
}

}
