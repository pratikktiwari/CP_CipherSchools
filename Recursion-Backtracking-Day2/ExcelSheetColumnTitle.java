public class ExcelSheetColumnTitle {
    static String res = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static String colTitle(int n) {
        if (n >= 1 && n <= 26) {
            return Character.toString((char) (64 + n));
        }
        String res = "";

        if (n % 26 != 0) {
            res += colTitle(n / 26);
            res += colTitle(n % 26);
        } else {
            res += colTitle((n / 26) - 1);
            res += 'Z';
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(colTitle(2));
        System.out.println(colTitle(27));
        System.out.println(colTitle(701));
    }
}
