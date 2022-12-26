package D_2022_01_03;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,1,5,6,20,10,7,11,15,9};
        quickSort(arr);
    }

    public static void quickSort(int[] arr) {
        quickSort(arr,0,arr.length-1);
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    private static void quickSort(int[] arr,int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = start;
        int left = start + 1;
        int right = end;

        while(left <= right) {
            while(left<=end && arr[left] <= arr[pivot])
                left++;
            while(right > start && arr[right] >= arr[pivot]) {
                right--;
            }
            if(left > right) {
                swap(arr,right,pivot);
            }
            else {
                swap(arr,left,right);
            }
            quickSort(arr,start,right-1);
            quickSort(arr,right+1,end);
        }
    }

    private static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
