import java.util.Scanner;

public class MergeSort {
    static int GlobalfirstNumberSum;

    public static void mergeSort(int start, int end, int[] arr){ 
        //index of start & end  
        
        if (start >= end){
            return ;
        }

        int mid = (start + end) / 2;
        mergeSort(start, mid, arr);
        mergeSort(mid+1, end, arr);//겹치면 안됨!

        // conquer
        merge(start, mid, end, arr);

        GlobalfirstNumberSum += arr[start];
    }

    public static void merge(int start, int mid, int end, int[] arr){
        int[] temp = new int[end-start + 1];
        int i = start;
        int j = mid + 1; //index of start to endindex
        int k = 0; //counting length

        while( i <= mid && j <= end){
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=end){
            temp[k++] = arr[j++];
        }

        //copy
        while(k-- > 0 ){
            arr[start + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = in.nextInt();
        }

        mergeSort(0, arr.length-1, arr);
        System.out.println(GlobalfirstNumberSum);

        in.close();
    }
}
