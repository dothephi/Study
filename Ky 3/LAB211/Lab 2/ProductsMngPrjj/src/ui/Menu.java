/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import tool.MyTool;

public class Menu extends Vector<String> {

    List<String> list = new ArrayList<String>();

    ;
   
    public Menu() {
        super();
    }

    public Menu(String[] items) {
        super();
        for (String item : items) {
            this.add(item);
        }
    }

//    public int getChoice(){
//        int result=0;
//        System.out.println("____________________________");
//        System.out.print("Select 1 ... 7: ");
//        Scanner sc = new Scanner(System.in);
//        result = Integer.parseInt(sc.nextLine()); // get user choice
//        return result;
//    }
    public int getChoice(String title) {
        System.out.println("\n---------------------------------------");
        System.out.println(title);
        System.out.println("---------------------------------------");
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + "- " + this.get(i));
        }
        System.out.println("Others - Quit.");
        System.out.print("Choose 1 ... " + this.size() + ": ");
//        Scanner sc = new Scanner(System.in);
//        int input = Integer.parseInt(MyTool.sc.nextLine());
        return Integer.parseInt(MyTool.sc.nextLine());
    }

    public String getChoice2(String title) {
//        System.out.println("\n---------------------------------------");
        System.out.println("");
        System.out.println("   " + title);
//        System.out.println("---------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("   5." + (i + 1) + "- " + list.get(i));
        }
        System.out.print("   Choose 5.1 or 5.2: ");
//        Scanner sc = new Scanner(System.in);
        return MyTool.sc.nextLine().trim().toUpperCase();
    }
}
