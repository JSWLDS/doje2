package C_2022_12_26;

import java.util.Arrays;

public class InsertionSort {

    static void inserSort(int [] arr) {
        for(int i=1; i<arr.length; i++){
            int idx = i;
            int tmp = arr[i] ;

            while((idx > 0 ) && (arr[idx-1] > tmp)) {
                arr[idx] = arr[idx-1];
                idx--;
            }
            arr[idx] = tmp;
        }

    }
    public static void main(String[] args) {
        int [] arr = {3, 1, 2, 6, 7, 5, 4};
        inserSort(arr);
//        for(int i=0; i<arr.length; i++){
//            System.out.println(arr[i]);
//        }
        System.out.println(Arrays.toString(arr));
    }
}
