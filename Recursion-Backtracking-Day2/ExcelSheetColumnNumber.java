public class ExcelSheetColumnNumber {
    static int getNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + ((int) s.charAt(i) - 64);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = getNumber("AB");
        System.out.println(res);
    }
}
