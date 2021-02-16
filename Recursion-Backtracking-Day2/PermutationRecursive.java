public class PermutationRecursive {
    static void printPermutations(String remString, String result) {
        if (remString.length() == 0) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < remString.length(); i++) {
            char chosenChar = remString.charAt(i);
            String remLeft = remString.substring(0, i);
            String remRight = remString.substring(i + 1);

            printPermutations(remLeft + remRight, result + chosenChar);
        }

    }

    public static void main(String[] args) {
        printPermutations("abcd", "");
    }
}
