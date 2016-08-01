package ProblemSolving.Ch_12_HashTable;

/**
 * Created by hmahant on 7/21/16.
 */
public class StringHash {
    public static int stringHash(String str) {
        int kMult = 997;
        int val = 0;
        int modulus = 1 << 16;
        for (char c : str.toCharArray()) {
            val = (val * kMult + c) % modulus;
        }
        return val;
    }
}
