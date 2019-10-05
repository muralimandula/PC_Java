abstract class AbstractList implements ListInterface {
    int[] list;
    int size;
    int capacity;

    AbstractList() {
        this.list = new int[10];
        this.size = 0;
        this.capacity = 10;
    }

    // add() must be different for List and OrderedList
    // making it an abstract, without body;
    abstract public void add(int item);

    abstract public void resize();


    // Above are abstract methods


    public String toString() {
        String out = "[";
        for (int i = 0; i < this.size - 1; i++) {
            out += this.list[i] + ",";
        }
        out += this.list[this.size - 1] + "]";
        return out; 
    } 

    public int size() {
        return this.size;
    }

    public int get(final int index) {
        if (index < this.size && index >= 0) {
            return this.list[index];
        }
        return -1;
    }

    // indexOf()
    // similary searching for an item goes different
    // for both list nad ordered List

    abstract public int indexOf(int item);

    // Above is an abstract method


    public boolean contains(final  int item) {
        for (int i = 0; i < this.size; i++) {
            if (this.list[i] == item) {
                return true;
            }
        }
        return false;
    }

    public void remove(final int index) {
        if (index < size) {
            int i = index;
            for (int j = i + 1; j < size; j++) {
                this.list[i] = this.list[j];
                i++;
            }
            this.list[this.size] = 0;
            this.size--;
        }
    }
}
