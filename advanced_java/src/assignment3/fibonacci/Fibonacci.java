package assignment3.fibonacci;

import java.util.ArrayList;

public class Fibonacci {
    private static ArrayList<Integer> fibNumberList = new ArrayList<>();

    public static int get(int nth) {
        return fibNumber(nth);
    }

    public static int get2(int nth) {
        return fibNumberUsingBuffer(nth);
    }

    private static int fibNumber(int nth) {
        if (nth == 1) return 0;
        if (nth == 2) return 1;

        return fibNumber(nth - 1) + fibNumber(nth - 2);
    }

    private static int fibNumberUsingBuffer(int nth) {
        if (fibNumberList.size() < nth) {
            // generate fibonacci number list
            if (nth == 1) {
                fibNumberList.add(0);
            } else if (nth == 2) {
                fibNumberList.add(1);
            } else {
                fibNumberList.add(fibNumberUsingBuffer(nth - 1) + fibNumberUsingBuffer(nth - 2));
            }
        }
        return fibNumberList.get(nth-1);
    }
}
