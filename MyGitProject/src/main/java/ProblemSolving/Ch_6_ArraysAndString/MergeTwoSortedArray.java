package ProblemSolving.Ch_6_ArraysAndString;

/**
 * Created by ndave on 8/16/16.
 */
public class MergeTwoSortedArray {

    public static void main (String ... args) {
        int [] firstArray = {1,5,7,9};
        int [] secodArray = {2,4,6,7};
        int [][] twoDimentional = { {1,2}, {1,3}};
        int [][] twoDimentional2= new int [3][4];
        int [] [] twoDimentionalNonRectangle = new int [3][];
        twoDimentionalNonRectangle[0] = new int [1];
        twoDimentionalNonRectangle[1] = new int [2];


        int [] mergedArrray = new int [firstArray.length+secodArray.length];
        int i=0,j=0,k=0;
        while(i<firstArray.length && j<secodArray.length) {
            if(firstArray[i]<secodArray[j]) {
                mergedArrray[k]=firstArray[i];
                i++;
                k++;
            }else{
                mergedArrray[k]=secodArray[j];
                j++;
                k++;
            }
        }
        while (i<firstArray.length) {
            mergedArrray[k]= firstArray[i];
            k++;i++;
        }
        while (j<secodArray.length) {
            mergedArrray[k] = secodArray[j];
            k++;
            j++;
        }
        for(int value :mergedArrray) {
            System.out.println(value+" ");
        }
    }

}
