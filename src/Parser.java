import java.util.*;

public class Parser {
    private static final int[] Amount = {
            1, 2, 3,      // ABC
            1, 2, 3,      // DEF
            1, 2, 3,      // GHI
            1, 2, 3,      // JKL
            1, 2, 3,      // MNO
            1, 2, 3, 4,   // PQRS
            1, 2, 3,      // TUV
            1, 2, 3, 4    // WXYZ
    };

    private static final int[] Button = {
            2, 2, 2,      // ABC
            3, 3, 3,      // DEF
            4, 4, 4,      // GHI
            5, 5, 5,      // JKL
            6, 6, 6,      // MNO
            7, 7, 7, 7,   // PQRS
            8, 8, 8,      // TUV
            9, 9, 9, 9    // WXYZ
    };

    public static List<Integer> parseStr(String init) {
        List<Integer> parsed = new ArrayList<>();
        parsed.add(0); // Start signal
        for (char c : init.toCharArray()) {
            int len = Amount[c - 'A'];
            for (int j = 0; j < len; j++) {
                parsed.add(Button[c - 'A']);
            }
        }
        return parsed;
    }
}
