package ProblemSolving.Ch_5_Primitives;

/**
 * Created by ndave on 8/13/16.
 */

import java.util.Arrays;

public class FindPrimitive{

    public static void main(String [] args) {

        boolean [] primes = new boolean[100];

        Arrays.fill(primes, true);

        primes[0]=primes[1]=false;

        for (int i=0 ; i< primes.length ; i++) {
            if(primes[i]) {
                for(int j=2 ; i*j < primes.length ; j++) {

                    primes[j*i] = false;

                }
            }
        }

        for(int i=0; i<primes.length;i++){
            if(primes[i])
                System.out.println(i);
        }

    }

}