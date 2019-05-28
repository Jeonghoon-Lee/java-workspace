package assignment1;

public class Main {
    /**
     * Return greatest common divisor(GCD) between 2 integers using modular operator
     *
     * @param num1  integer number that is greater than 0
     * @param num2  integer number that is greater than 0
     * @return  greatest common divisor
     */
    public static int getGCD1(int num1, int num2) {
        while (true) {
            if (num1 >= num2) {
                if (num1 % num2 == 0)
                    return num2;
                num1 = num1 % num2;
            } else {
                if (num2 % num1 == 0)
                    return num1;
                num2 = num2 % num1;
            }
        }
    }

    /**
     * Return greatest common divisor(GCD) between 2 integers using subtraction
     *
     * @param num1  integer that is greater than 0
     * @param num2  integer that is greater than 0
     * @return  greatest common divisor
     */
    public static int getGCD2(int num1, int num2) {
        while (true) {
            if (num1 == num2) {
                break;
            } else if (num1 < num2) {
                num2 = num2 - num1;
            } else {
                num1 = num1 - num2;
            }
        }
        return num1;
    }

    /**
     * Convert decimal number to string of hex number
     *
     * @param input     integer that is greater than 0
     * @return  String of hex number
     */
    public static String convertDec2Hex(int input) {
        String hexResult = "";

        while (true) {
            int remainder = input % 16;
            char hexDigit = (char)(remainder < 10 ? '0' + remainder : 'A' + remainder - 10);

            hexResult = hexDigit + hexResult;

            input = input / 16;
            if (input < 1) break;
        }
        return hexResult;
    }

    /**
     * Convert string of hex number to decimal number and return decimal number
     *
     * @param hexStr    String of hex numbers
     * @return  decimal number
     */
    public static int convertHex2Dec(String hexStr) {
        int decimalValue = 0;

        for (int i=0; i < hexStr.length(); i++) {
            int digit = hexStr.charAt(i) <= '9' ? hexStr.charAt(i) - '0' : hexStr.charAt(i) - 'A' + 10;
            decimalValue = decimalValue * 16 + digit;
        }
        return decimalValue;
    }

    /**
     * Check whether input string is palindrome or not,
     * if string is palindrome return true, otherwise false
     *
     * @param strInput String
     * @return  true if string is palindrome, otherwise false
     */
    public static boolean isPalindrome(String strInput) {
        int lowIndex = 0;
        int highIndex = strInput.length() - 1;

        while (true) {
            if (lowIndex >= highIndex) {
                return true;
            }
            if (strInput.charAt(lowIndex) == strInput.charAt(highIndex)){
                lowIndex++;
                highIndex--;
                continue;
            }
            break;
        }
        return false;
    }

    /**
     * Check if a given number is prime number or not
     *
     * @param value     positive integer
     * @return  true if input value is a prime number, otherwise false
     */
    static boolean isPrime(int value) {
        if (value == 1) return false;   // 1 is not prime number
        if (value == 2) return true;    // 2 is prime number

        if (value % 2 == 0) return false;   // all even numbers are not prime number

        // check only for odd number
        int divNum = 3;
        while (divNum <= value / 2) {
            if (value % divNum == 0) {
                return false;
            }
            divNum += 2;
        }
        return true;
    }

    public static void main(String[] args) {
        // GCD Test
        int num1 = 45;
        int num2 = 20;
        System.out.printf("GCD(%d, %d) is %d\n", num1, num2, getGCD1(num1, num2));
//        System.out.printf("GCD(%d, %d) is %d\n", num1, num2, getGCD2(num1, num2));

        // Test: Decimal to Hex, Hex to Decimal
//        int input = 15556;
//        String hexStr = convertDec2Hex(input);
//        System.out.printf("Dec:%d, Hex:%s\n", input, hexStr);
//        System.out.printf("Hex:%s, Dec:%d\n", hexStr, convertHex2Dec(hexStr));

        // Palindrome
//        String inputStr1 = "ABCDEEDCBA";
//        System.out.printf("%s\n", (isPalindrome(inputStr) ? "Palindrome word" : "Not Palindrome word"));
//        inputStr1 = "This is test";
//        System.out.printf("%s\n", (isPalindrome(inputStr) ? "Palindrome word" : "Not Palindrome word"));

        // Prime number
//         int value = 3;
//         System.out.printf("%d, %s\n", value, (isPrime(value) ? "Prime number" : "Not Prime number"));
//         value = 27;
//         System.out.printf("%d, %s\n", value, (isPrime(value) ? "Prime number" : "Not Prime number"));
    }
}
