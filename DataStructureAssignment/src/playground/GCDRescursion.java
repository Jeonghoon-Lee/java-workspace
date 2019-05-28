package playground;

public class GCDRescursion {
    public static int gcd(int m, int n) {
        return m % n == 0 ? n : gcd(n , m % n);
    }

    public static void main(String[] args) {
        System.out.format("(%d, %d) -> %d\n", 10, 20, gcd(30, 45));
    }
}
