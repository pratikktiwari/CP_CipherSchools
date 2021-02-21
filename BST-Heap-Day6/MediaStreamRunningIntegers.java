import java.util.*;

class MediaStreamRunningIntegers {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return -1 * a.compareTo(b);
            }
        });
        PriorityQueue<Integer> highers = new PriorityQueue<>();

        for (int i = 0; i < nums1.length; i++) {
            int number = nums1[i];
            addToPQ(number, lowers, highers);

            rebalancePQ(lowers, highers);
        }
        for (int i = 0; i < nums2.length; i++) {
            int number = nums2[i];
            addToPQ(number, lowers, highers);

            rebalancePQ(lowers, highers);
        }

        return median(lowers, highers);

    }

    static void addToPQ(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() == 0 || number < lowers.peek()) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

    static void rebalancePQ(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {

        PriorityQueue<Integer> biggerPQ = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerPQ = lowers.size() > highers.size() ? highers : lowers;

        if (biggerPQ.size() - smallerPQ.size() >= 2) {
            smallerPQ.add(biggerPQ.poll());
        }
    }

    static double median(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {

        PriorityQueue<Integer> biggerPQ = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerPQ = lowers.size() > highers.size() ? highers : lowers;

        if (biggerPQ.size() == smallerPQ.size()) {
            return (((double) biggerPQ.peek() + smallerPQ.peek())) / 2;
        } else {
            return (double) biggerPQ.peek();
        }
    }

    public static void main(String[] args) {

    }
}