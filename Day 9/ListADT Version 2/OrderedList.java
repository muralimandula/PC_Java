class OrderedList extends AbstractList {

    OrderedList() {
        super();
    }

    public void add(final int item) {

        if (size == 0) {
            list[size] = item;
        } else {

            for (int j = 0; j < size; j++) {
                if (item <= list[j]) {
                    insertAt(item, j);
                    break;
                }
            }
        }

        size++;
        if (size == capacity) {
            resize();
        }
    }


    public void insertAt(final int item, final int index) {

        for (int j = size; j > index; j--) {
            list[j] = list[j - 1];
        }
        list[index] = item;
    }

    public void resize() {
        list = java.util.Arrays.copyOf(list, 2 * capacity);
        capacity = capacity * 2;
    }

    public int indexOf(final int item) {
        return binarySearch(list, 0, size, item);
    }

    public int binarySearch(final int[] arr, final int l,
                                     final int r, final int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            }
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
}
