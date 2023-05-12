/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;
import com.Menu;
import java.util.Scanner;
/**
 *
 * @author MSI
 */
public class TestBST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BST<Integer> tree= new BST<Integer>();
        tree.insertBalance(a);
        
        Menu menu = new Menu();
        menu.add("Thêm phần tử");
        menu.add("Xóa phần tử - Delete by Merging");
        menu.add("Xuất cây dạng gióng hang");
        menu.add("Xuất cây - breadth-first");
        menu.add("Xuất cây - Morris Inoder");
        menu.add("Thoát");
        int choice=0; 
        int x;
        Scanner sc = new Scanner(System.in);
        do {
            choice = menu.getUserChoice();
            switch(choice) {
                case 1:
                    System.out.println("Nhập trị cần thêm vào cây:");
                    x = Integer.parseInt(sc.nextLine());
                    tree.insert(x);
                    System.out.println("Tri " + x + " đã được thêm vào cây:");
                    break;
                case 2:
                    System.out.println("Nhập trị cần xóa khỏi cây:");
                    x = Integer.parseInt(sc.nextLine());
                    tree.deleteByMerging(x);
                    break;
                case 3 : tree.print_align();
                    break;
                case 4 : tree.breadthFirst();
                    break;
                case 5 : tree.MorrisInorder();
                    break;
            }
        }
        while (choice > 0 && choice < 6);
    }
    
}
