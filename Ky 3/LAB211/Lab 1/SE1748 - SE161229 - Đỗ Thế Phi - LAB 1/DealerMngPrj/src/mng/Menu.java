/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mng;
import java.util.ArrayList;
import tools.MyTool;

/**
 *
 * @author PhiDT
 */
public class Menu extends ArrayList<String> {
    public Menu(){
        super();
    }
    public Menu(String[] items){
        super();
        for (String item: items) this.add(item);
    }
    public void showMenu(){
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i));
        }
    }
    public int getChoice(String title){
        int size = this.size();
        String welcome = "Enter your choice: ";
        String error = "Input again!";
        return MyTool.getAnInteger(welcome, error, 1);
    } 
}
