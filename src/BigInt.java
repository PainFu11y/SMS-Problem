public class BigInt {
    private static final int MAX_SIZE = 10; // Maximum number of digits
    private static final int BASE = 100000000;
    private static final String OUTPUT_FORMAT = "%08d";

    private int amount;   // Number of digits used
    private int[] digits; // Storing the digits of a number

    public BigInt() {
        amount = 1;
        digits = new int[MAX_SIZE];
    }

    public BigInt(int n) {
        this();
        digits[0] = n;
    }


    public BigInt add(BigInt other) {
        BigInt result = new BigInt();
        result.amount = Math.max(this.amount, other.amount);
        int carry = 0;

        for (int i = 0; i < result.amount || carry > 0; i++) {
            if (i >= result.digits.length) break;
            result.digits[i] = this.getDigit(i) + other.getDigit(i) + carry;
            if (result.digits[i] >= BASE) {
                result.digits[i] -= BASE;
                carry = 1;
            } else {
                carry = 0;
            }
        }

        if (result.getDigit(result.amount) > 0) {
            result.amount++;
        }

        return result;
    }

    public void output() {
        System.out.print(digits[amount - 1]);
        for (int i = amount - 2; i >= 0; i--) {
            System.out.printf(OUTPUT_FORMAT, digits[i]);
        }
        System.out.println();
    }

    private int getDigit(int index) {
        return (index < digits.length) ? digits[index] : 0;
    }
}