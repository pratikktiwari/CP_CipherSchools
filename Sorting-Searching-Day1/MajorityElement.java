import java.util.*;
//Linear Time, Linear Space

public class MajorityElement {
    static boolean findMajorityElement(int arr[]) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int item : arr) {
            if (counter.containsKey(item))
                counter.put(item, counter.get(item) + 1);
            else
                counter.put(item, 1);
        }
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int freq = entry.getValue();
            if (freq > arr.length / 2) {
                System.out.println("Majority is : " + entry.getKey());
                return true;
            }
        }
        System.out.println("No majority element");
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 3, 1, 2 };
        findMajorityElement(arr);
    }
}
