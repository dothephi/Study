/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingathome;

/**
 *
 * @author MSI
 */
public class Readingathome {

    public class MyDLL {
    private Node head;
    private Node tail;

    private class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    public MyDLL() {
        head = null;
        tail = null;
    }

    public void addFirst(int x) {
        Node newNode = new Node(x);
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }
    }

    public void addLast(int x) {
        Node newNode = new Node(x);
        newNode.prev = tail;

        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;

        if (head == null) {
            head = newNode;
        }
    }

    public void removeFirst() {
        if (head == null) {
            // Empty list, do nothing
            return;
        }

        Node nodeToRemove = head;
        head = head.next;

        if (head == null) {
            // If head becomes null after removal, set tail to null as well
            tail = null;
        } else {
            head.prev = null;
        }

        nodeToRemove = null;
    }

    public void removeLast() {
        if (tail == null) {
            // Empty list, do nothing
            return;
        }

        Node nodeToRemove = tail;
        tail = tail.prev;

        if (tail == null) {
            // If tail becomes null after removal, set head to null as well
            head = null;
        } else {
            tail.next = null;
        }

        nodeToRemove = null;
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
}
