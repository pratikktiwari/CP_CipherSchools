import java.util.Arrays;

public class MinimumPlatform {
    static int minimumPlatform(int arrival[], int dept[]) {
        Arrays.sort(arrival);
        Arrays.sort(dept);

        int minPlatform = 1, currPlatform = 1;
        int i = 1, j = 0;
        // i => pointer for arrival array
        // j => pointer for deptarture array

        while (i < arrival.length && j < arrival.length) {
            if (arrival[i] > dept[j]) {
                // train 11:00 | dept 10:50
                currPlatform -= 1; // add departure => -1 since train departs
                j++;
            } else {
                currPlatform += 1; // add arrival
                i++;
            }
            minPlatform = Math.max(minPlatform, currPlatform);
        }
        return minPlatform;
    }

    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

        int minPlatforms = minimumPlatform(arr, dep);
        System.out.println("Max platforms required: " + minPlatforms);
    }
}
