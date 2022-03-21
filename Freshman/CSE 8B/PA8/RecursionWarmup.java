import java.util.ArrayList;

public class RecursionWarmup {
    public static String binaryString(int n) {
        if (n == 1) {
            return "1";
        } else if (n == 0) {
            return "0";
        } else {
            return binaryString(n / 2) + String.valueOf(n % 2);
        }
    }

    public static boolean isSubSetSum(ArrayList<Integer> set, int targetNumber) {
        
    }

    public static void main(String[] args) {
        System.out.println(binaryString(33));
    }
}
