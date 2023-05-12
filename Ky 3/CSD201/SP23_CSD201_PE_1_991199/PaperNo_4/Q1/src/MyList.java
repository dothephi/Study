import java.util.*;
import java.io.*;

public class MyList {
    Node head, tail;
    int size;

    // Default constructor
    MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while(p != null) {
            f.writeBytes(p.getInfo() + " "); // write data in node p to the file f
            p = p.next;
        }
        
        f.writeBytes("\r\n");
    }
    
    /**
     * Do NOT modify this method
     * Load 3 lines of data from file: 
     *      line k (for owner), 
     *      line k+1 (for price), and
     *      line k+2 (for color)
     * 
     * @param k the k-th line where data is started to be loaded
     */
    void loadData(int k) {
        String [] a = Lib.readLineToStrArray("data.txt", k);
        double [] b = Lib.readLineToDoubleArray("data.txt", k+1);
        int [] c = Lib.readLineToIntArray("data.txt", k+2);
        
        int n = a.length;
        for(int i = 0; i < n; i++) 
            // insert the new Node(a[i], b[i], c[i]) into the list
            addFirst(a[i],b[i],c[i]);
    }
   
    /**
     * Do NOT modify this method
     * This is a helper method for Questions 1.1; 1.2; 1.3; and 1.4
     * @throws Exception 
     */
    void helpFunction(int questionNo) throws Exception {
        clear();
        loadData(questionNo * 4 - 3);
        
        String fname = "f" + Integer.toString(questionNo) + ".txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        
        if (questionNo == 2){
            updateNode();
            ftraverse(f);
        }
        
        if (questionNo == 3){
            removeLast();
            ftraverse(f);
        }
          
        if (questionNo == 4){
            reverse();
            ftraverse(f);
        }
        
        f.close();
    }
   
    void f1() throws Exception {
        helpFunction(1);
    }
    
    void f2() throws Exception {
        helpFunction(2);
    }
    
    void f3() throws Exception {
        helpFunction(3);    
    }
    
    void f4() throws Exception {
        helpFunction(4);
    }
    /**
     * Luy y: 1. SV KHONG su dung tieng Viet co dau trong bai lam de tranh Error khi run chuong trinh.
     *        2. Neu khong tuan thu se nhan diem 0 (khong).
     * Question 1.1: implement the 'addFirst' method that inserts
     * a new Node into the list's head if the price is less than 100.0
     * Note: increase the list's size by 1 if you insert successfully
     * The output of this method will be written into the file 'f1.txt'. 
     * Therefore, you should open this file to inspect your code output.
     * Example: with the data given in the file 'data.txt', 
     *          then the content of 'f1.txt' after insertion should be  
     *          (F, 40.4, -7) (D, 2.5, 4) (C, 6.2, 5) (B, 5.3, 3) (A, 9.8, 8) (H, 10.0, 22)
     * @param xName the name of the input Bike
     * @param xPrice the price of the input Bike
     * @param xColor the color of the input Bike
     */
    void addFirst(String xName, double xPrice, int xColor) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        
         Node p = new Node(xName, xPrice, xColor);
        if(isEmpty()) {head = tail = p;}
        else {p.next = head; head = p;}
               
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }
 
    /**
     * Question 1.2: visit every node in the list and do following tasks
     *      1. if Bike's price < 20.5 then update color = color + 1
     *      2. if 20.5 <= Bike's price <= 40.5 then update color = color + 2
     *      3. if Bike's price > 40.5 then update color = color + 3
     * The output of this method will be written into the file 'f2.txt'. 
     * Therefore you should open this file to see/test your code output.
     * Example: with in data given, the content of 'f2.txt' should be:
     *      (F, 46.4, -7) (D, 52.5, 4) (C, 6.2, 5) (B, 35.3, 3) (A, 29.8, 8) (H, 10.0, 22) 
     *      (F, 46.4, -4) (D, 52.5, 7) (C, 6.2, 6) (B, 35.3, 5) (A, 29.8, 10) (H, 10.0, 23)     
     * Note: You should use methods getPrice(), getColor(), and setColor(int) 
     * in the class Bike rather than directly accessing the private attributes 'color', and 'price'
     */
    void updateNode(){
        //------ Start your code here---------------------------------------------------------

        
        
        //------ End your code here-----------------------------------------------------------
    }
    
    /**
    * Question 1.3: Remove the last node of the list
    * The output of this method will be written into the file 'f3.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: with the data given, the linked list before and after removeLast is:
    * (F, 46.5, -7) (D, 52.5, 4) (C, 6.5, 5) (B, 35.0, 3) (A, 29.0, 8) (H, 10.0, 22) 
    * (F, 46.5, -7) (D, 52.5, 4) (C, 6.5, 5) (B, 35.0, 3) (A, 29.0, 8)
    */   
    void removeLast(){
        /**
         * 1. if you have your own idea for this Question, just follow it
         * 2. if you do NOT have any idea, you may follow the hint
         * You should code ONLY in Case 1 or Case 2 below
         */
        
        // Case 1. If you have an idea, then just follow it
        //------ Start your code here-------------------------------------------------------

        Node p=head;
        if(p==null) return;
        //if head in not null and next of head is null, delete the head
        if(p.next == null) {
            p = null;
        } else { //else, traverse to the second last element of the list
            Node temp = new Node();
            temp = p;
            while(temp.next.next != null)
                temp = temp.next;
            //change the next of the second last node to null and 
            //delete the last node
            Node lastNode = temp.next;
            temp.next = null; 
            lastNode = null;
        }
        
        //------ End your code here---------------------------------------------------------

        
        // Case 2. if you do NOT have any idea, you may follow the hint below
        // uncomment the following block code and 
        // fill in the '...' with your appropriate code
        
//        //------ Start your code here-------------------------------------------------------
// 
//        // The list is empty
//        if (isEmpty())
//            return ;
//        
//        // The list has only one node
//        if (this.size == 1) {
//            head = tail = ...;
//            this.size...;
//            return ;
//        }
//        
//        // The number of nodes is >= 2
//        // Find the second last node (the node before tail node)
//        Node current = head;
//        //Loop through the list untill reaching the second last node 
//        while(current.next != ...) {  
//            current = current....;
//        }
//        
//        // The second last node becomes new tail of the list  
//        tail = ...;  
//        tail.next = ...;  
//        
//        // Descrease list's size by 1
//        this.size...;
//                
//        //------ End your code here---------------------------------------------------------
        
    } // end removeLast()
    
    /**
    * Question 1.4: Reverse the order of all nodes in the linked list 
    * The output of this method will be written into the file 'f4.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: with data given in the file "data.txt",
    *           the linked list before and after reversing is: 
    *       (K, 7.0, 9) (J, 11.0, 12) (F, 14.0, 6) (C, 1.0, 2)
    *       (C, 1.0, 2) (F, 14.0, 6) (J, 11.0, 12) (K, 7.0, 9)   
    */
    void reverse(){
        
        //------ Start your code here-------------------------------------------------------

        
        
        //------ End your code here---------------------------------------------------------
    }
    
} // end MyList

