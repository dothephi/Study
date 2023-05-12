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
public class Node {
    int info;
    Node next;
    Node() {}
    Node(int x, Node p){
        info=x; next=p;
    }
}
