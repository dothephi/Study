/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author MSI
 */
public class MyList {
    Node head,tail;
    MyList(){
        head=tail=null;
    }
    
    boolean isEmpty(){
    return(head==null);
    }

    void clear(){
    head=tail=null;
    }
    
    void add(int x){
        if(isEmpty())
            head=tail=new Node(x,null);
        else{
            Node q =new Node(x,null);
            tail.next=q;
            tail=q;
        }
    }
    
    void traverse(){
        Node p=head;
        while(p!=null){
            System.out.println(" " + p.info);
            p=p.next;
        }
        System.out.println();
    }
   // Node search(int x){
        
    //}
    //void dele(int x){
        
    //}
}