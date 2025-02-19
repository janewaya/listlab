
package edu.grinnell.csc207.listlab;

import java.util.Arrays;
/**
 * An array-based implementation of the list ADT.
 */
public class ArrayList {
    
    private int size; //actual number of the elements in the arr
    private int[] arr; //capacity is the length of the arr
    
    private static final int INITIAL_SIZE = 8;
    /**
     * Construct an ArrayList with default values.
     */
    public ArrayList() {
        this.size = 0;
        this.arr = new int[INITIAL_SIZE];
    }     
            
    private void ensureCapacity() {
        if (this.size == this.arr.length) {
            int[] result = Arrays.copyOf(this.arr, this.arr.length*2);
            this.arr = result;
        }
    }
          
    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        ensureCapacity();
        this.arr[this.size++] = value;
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
        return this.arr[index];
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        int value = this.arr[index];
        for (int i = index; i < (this.size - 1); i++){
            this.arr[i] = this.arr[i + 1];
        }
        this.size--;
        return value;
    }
}
