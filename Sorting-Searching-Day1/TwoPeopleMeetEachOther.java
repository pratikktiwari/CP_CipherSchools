// Linear Time, Constant space
public class TwoPeopleMeetEachOther {
    static boolean checkIfMeet(int x1, int x2, int v1, int v2) {
        /*
         * if x1 started after x2 and his speed is greater ,or if x2 started ater x1 and
         * his speed is greater then they will never meet
         */
        if (x1 > x2 && v1 > v2)
            return false;
        if (x2 > x1 && v2 > v1)
            return false;

        /*
         * To check if they ever meet, we need to check if their distance at some point
         * becomes equal
         */
        int X = x1 > x2 ? x1 : x2;
        int Y = x1 > x2 ? x2 : x1;

        int U = x1 > x2 ? v1 : v2;
        int V = x1 > x2 ? v2 : v1;

        while (X >= Y) {
            if (X == Y)
                return true;
            X += U;
            Y += V;
        }
        return false;
    }

    public static void main(String[] args) {
        int x1 = 3, x2 = 2;
        int v1 = 2, v2 = 3;

        System.out.println(checkIfMeet(x1, x2, v1, v2));
    }
}