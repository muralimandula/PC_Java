/**
 * 
 */

public class OrderedList extends AbstractList {
    /*
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     * 
     * The method returns void (nothing)
     */
    public void add(int item) {
        //Inserts the specified element at the end of the list.
        // TODO
        // Your code goes here....
    }
    public void resize() {
        list = java.util.Arrays.copyOf(list, 2 * capacity);
        capacity = capacity * 2; // I missed this earlier
    }
    public int rank(int item) {
        int lo = 0, hi = size-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2;
            if      (item < list[hi]) hi = mid - 1; 
            else if (item > list[lo]) lo = mid + 1; 
            else return mid; 
        } 
        return lo;
    }

    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {

            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        AbstractList lst = new OrderedList();
        lst.add(1, 1);
    }
    
}