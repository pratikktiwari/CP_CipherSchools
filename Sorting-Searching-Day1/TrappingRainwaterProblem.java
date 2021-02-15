public class TrappingRainwaterProblem {
    static int trappingRainwater(int arr[]) {
        int size = arr.length;
        int lmax = arr[0];
        int[] rmax = new int[size];
        rmax[size - 1] = arr[size - 1];

        for (int j = size - 2; j >= 0; j--) {
            rmax[j] = Math.max(rmax[j + 1], arr[j]);
        }
        int countWater = 0;
        for (int i = 0; i < size; i++) {
            lmax = Math.max(lmax, arr[i]);
            countWater += (Math.min(lmax, rmax[i]) - arr[i]);
        }

        return countWater;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int res = trappingRainwater(arr);
        System.out.println("Water trapped: " + res);
    }
}
