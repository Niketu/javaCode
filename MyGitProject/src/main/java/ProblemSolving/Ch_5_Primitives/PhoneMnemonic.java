package ProblemSolving.Ch_5_Primitives;

/**
 * Created by hmahant on 7/17/16.
 */
public class PhoneMnemonic {
    private static final String[] keyPad = {
      "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO","PQRS", "TUV", "WXYZ"
    };

    public static void phoneMnemonic(String num) {
        char[] result = new char[num.length()];
        phoneMnemonicHelper(result, 0, num);
    }

    public static void phoneMnemonicHelper(char[] result, int nxtInd, String num) {
        if (nxtInd == num.length()) {
            // All digits are processed so we output answer.
            System.out.println(result);
        } else {
            // Try all corresponding characters for this digit.
            for (char c : keyPad[num.charAt(nxtInd) - '0'].toCharArray()) {
                result[nxtInd] = c;
                phoneMnemonicHelper(result, nxtInd + 1, num);
            }
        }
    }

    public static void main(String... args) {
        String singleMnemonic = "786";

        phoneMnemonic(singleMnemonic);
    }
}
