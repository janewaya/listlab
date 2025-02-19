package edu.grinnell.csc207.listlab;

/**
 * A linked implementation of the list ADT.
 */



public class LinkedList {
    
    private static class Node {
        private int val;
        private Node nextNode;
        
        public Node(int value, Node next){
            this.val = value;
            this.nextNode = next;
        }
    }
    
        private Node head;
        private int size;
        
        public LinkedList(){
            this.head = null;
            this.size = 0;
        }
    
    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        Node newAdd = new Node(value, null);
        if (this.head == null) {
            this.head = newAdd;
        } else {
            Node hold = this.head;
            while (hold.nextNode != null) {
                hold = hold.nextNode;              
            }
            hold.nextNode = newAdd;
        }
        this.size++;
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return this.size;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) {
        Node hold = this.head;
        if (index >= size) {
            return 0;
        }
        for (int i = 0; i < index; i++) {
            hold = hold.nextNode;
        }
        return hold.val;
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
       Node current = this.head;
       int valRemoved = 0;
       if (index < size) {
            for (int n = 0; n < index - 1; n ++) {
                if (current.nextNode != null) {
                    current = current.nextNode;
                }
                valRemoved = current.nextNode.val;
            }
            current.nextNode = current.nextNode.nextNode;     
       }
       return valRemoved;      
    }
}
