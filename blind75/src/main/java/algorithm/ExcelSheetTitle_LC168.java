package algorithm;

public class ExcelSheetTitle_LC168 {
    public static void main(String[] args) {
        int n = 28;
        String ans = convertToTitle(n);
        System.out.println(ans);
    }

    // added solution
    public static String convertToTitle(int columnNumber) {
        int n = columnNumber;

        StringBuilder result = new StringBuilder();

        while (n > 0) {
            n--;
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
}
