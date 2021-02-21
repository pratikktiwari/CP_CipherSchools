import java.util.*;

class MaxHeap {
    int capacity;
    int arr[];
    int count;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.count = 0;
    }

    public int getParentIndex(int index) {
        if (index <= 0 || index >= this.count)
            return -1;
        return (index - 1) / 2;
    }

    public int getParent(int index) {
        if (index <= 0 || index >= this.count)
            return -1;
        return arr[(index - 1) / 2];
    }

    public int leftChild(int index) {
        int left = 2 * index + 1;
        if (left >= this.count)
            return -1;
        return left;
    }

    public int rightChild(int index) {
        int right = 2 * index + 2;
        if (right >= this.count)
            return -1;
        return right;
    }

    public int getMaximum(int index) {
        if (this.count == 0)
            return -1;
        return this.arr[0];
    }

    public void insertOrg__Backup(int data) {
        if (count == capacity) {
            resizeHeap();
        }
        this.count++;
        int i = this.count - 1;
        while (i > 0 && data > this.arr[(i - 1) / 2]) {
            this.arr[i] = this.arr[(i - 1) / 2];
            i = (i - 1) / 2;
        }
        this.arr[i] = data;
    }

    public void insert(int data) {
        if (count == capacity) {
            resizeHeap();
        }
        this.count++;
        int i = this.count - 1;

        while (i > 0 && data > getParent(i)) {
            arr[i] = getParent(i);
            i = getParentIndex(i);
        }
        this.arr[i] = data;
    }

    public void resizeHeap() {
        if (count < capacity)
            return;
        int old_capacity = capacity;
        capacity = capacity * 2;
        int arr2[] = new int[capacity];
        for (int i = 0; i < old_capacity; i++)
            arr2[i] = arr[i];
        arr = null;
        arr = arr2;
    }

    public void heapify(int i) {
        // not working
        int left = leftChild(i);
        int right = rightChild(i);
        int max = i;
        int temp;

        if (left != -1 && arr[left] > arr[i])
            max = left;
        if (right != -1 && arr[right] > arr[max])
            max = right;

        if (i != max) {
            temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;

            heapify(max);
        }
    }

    public int deleteMax() {
        if (count == 0)
            return -1;
        arr[0] = arr[count - 1];
        count--;
        // heapify
        int i = 0;
        while (i <= count) {
            int left = leftChild(i);
            int right = rightChild(i);

            int max = i;

            if (left != -1 && arr[i] < arr[left])
                max = left;
            if (right != -1 && arr[max] < arr[right])
                max = right;
            if (max != i) {
                int temp = arr[max];
                arr[max] = arr[i];
                arr[i] = temp;

                i = max;
            } else
                break;
        }
        return arr[0];
    }

    public void printHeap() {
        System.out.println();
        for (int i = 0; i < count; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public int kThGreatest(int k) {
        for (int i = 0; i < k; i++) {
            deleteMax();
        }
        return arr[0];
    }

    public void heapSort() {
        // delete max and insert at end
        ArrayList<Integer> al = new ArrayList<>();
        int total = count;
        for (int i = 0; i < total; i++) {
            al.add(deleteMax());
        }
        System.out.println(al);
    }

    public static void main(String[] args) {
        MaxHeap h = new MaxHeap(10);
        h.insert(1);
        h.insert(2);
        h.insert(3);
        h.insert(4);
        h.insert(3);
        h.insert(7);
        h.insert(2);
        h.insert(1);
        h.insert(6);
        h.insert(0);

        h.printHeap();
        // h.deleteMax();

        // System.out.println("Second max element: " + h.kThGreatest(2));
        h.heapSort();
    }
}

public class HeapCrud {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(10);
        heap.insert(2);
        heap.insert(5);
        heap.insert(15);

        heap.heapSort();
    }
}