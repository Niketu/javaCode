package ProblemSolving.Ch_6_ArraysAndString;

/**
 * Created by ndave on 8/13/16.
 */
public class MyQuickSort {
    private static int [] sampleArray = {24,2,45,20,56,75,2,56,99,53,12};
    public static void main(String args[]) {
        MyQuickSort sorter = new MyQuickSort();
        sorter.quickSort(0, sampleArray.length - 1);
        for(int i : sampleArray) {
            System.out.println(i);
        }
    }
    public  void quickSort(int startIndex, int endIndex) {
        int j = startIndex;
        int k = endIndex;
        int pivot = sampleArray[startIndex + (endIndex - startIndex)/2];
        while (j <= k) {

            while(sampleArray[j] < pivot) {
                j++;
            }
            while(sampleArray[k] > pivot) {
                k--;
            }
            if(j<=k) {
                exchangeValues(j,k);
                j++;
                k--;
            }

        }
        if(startIndex<k){
            quickSort(startIndex, k);

        }
        if(j<endIndex) {
            quickSort(j, endIndex);
        }

    }
    private void exchangeValues(int j, int k) {
        int temp = sampleArray[j];
        sampleArray[j]=sampleArray[k];
        sampleArray[k]=temp;
    }

}
