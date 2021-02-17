public class ExcelSheetColumnTitle {
    static String res = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static String colTitle(int n) {
        if (n >= 1 && n <= 26) {
            String bans = Character.toString((char) (64 + n));
            return bans;
        }
        String ans = "";

        if (n % 26 != 0) {
            ans += colTitle(n / 26);
            ans += colTitle(n % 26);
        } else {
            ans += colTitle((n / 26) - 1);
            ans += 'Z';
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(colTitle(2));
        System.out.println(colTitle(27));
        System.out.println(colTitle(701));
    }
}
