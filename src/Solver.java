import java.util.*;

public class Solver {
    private static final int[] Len = {
            0, 0, 3, 3, 3, 3, 3, 4, 3, 4
    };

    public static void solve(int n, String init) {
        List<Integer> str = Parser.parseStr(init);

        // Create a 2D list of BigInt
        List<List<BigInt>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<BigInt> row = new ArrayList<>();
            for (int j = 0; j < str.size(); j++) {
                row.add(new BigInt(0));
            }
            dp.add(row);
        }

        // Initialize the first state
        dp.get(0).set(0, new BigInt(1));

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < str.size(); j++) {
                dp.get(i).set(j, dp.get(i - 1).get(j - 1));
                int len = Len[str.get(j)];
                for (int k = 1; k < len; k++) {
                    if (j - k - 1 >= 0 && str.get(j).equals(str.get(j - k))) {
                        BigInt sum = dp.get(i).get(j).add(dp.get(i - 1).get(j - k - 1));
                        dp.get(i).set(j, sum);
                    } else {
                        break;
                    }
                }
            }
        }

        dp.get(n).get(str.size() - 1).output();
    }
}
