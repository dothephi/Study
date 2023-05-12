
import java.util.Scanner;
/**
 *
 * @author Darki
 */
public class Part3 {
    public static void main(String[] args) {
        String[] list=new String[10];
        for(int i = 0;i<10;i++){
        Scanner sc=new Scanner(System.in);
        System.out.print("Student Name: ");
        list[i]= sc.nextLine().toUpperCase();
        }
        System.out.print("Student Name:");
        System.out.println("\n");
        for(int i = 0;i<list.length;i++){
            System.out.println(i+"."+list[i]);
        }
    }
}
