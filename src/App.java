import java.util.Arrays;

public class App<T extends Comparable<T>> {


    //sorts an array from largest to smallest through merge sort 
    //parameter array: the array to be sorted
    public static <T extends Comparable<T>> void mergeSort(T[] arr){
        //returns if length of array is 1 or less
        if(arr.length <=1){
            return;
        }
        //splits array down the middle into two parts
        int mid = arr.length/2;
        T[] left = Arrays.copyOfRange(arr, 0, mid);
        T[] right = Arrays.copyOfRange(arr, mid, arr.length);
        
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    //merges two parts of an array back into the original array in smallest
    //to largest order
    //parameter array: the full array to be merged into
    //parameter left, right: the left and right parts of the array that are being compared
    public static <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right){
        int i = 0, j = 0, k = 0;
        //compares and swaps array elements until the end of either left or right array is reached
        while(i < left.length && j < right.length){
            if(left[i].compareTo(right[j]) <=0){
                array[k++] = left[i++];
            }else{
                array[k++] = right[j++];
            }
        }
        //fills in the rest of the left array
        while(i < left.length){
            array[k++] = left[i++];
        }
        //fills in the rest of the right array
        while(j < right.length){
            array[k++] = right[j++];
        }
    }

    //Uses bubble sorting to sort a generic comparable array from the smallest to largest element
    //parameter array: the array to be sorted
    public static <T extends Comparable<T>> void bubbleSort(T[] arr){
        int n = arr.length;
        boolean swapped;
        //outside loop: number of passes
        for(int i = 0; i<n-1; i++){
            swapped = false;
            //inside loop: comparing elements in the array
            for(int j = 0; j< n-i-1; j++){
                swapped = true;
                //swaps elements if the first is larger than the second
                if(arr[j].compareTo(arr[j+1])>0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            //if array is sorted before passing array full amount of times
            //breaks out of the loop as it is already fully sorted
            if(!swapped){
                break;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Integer arr1[] = {5, 9, 1034, 58, 3975, 823, 54, 7, 2, 2};
        Double arr2[] = {.44, 34.43, 234.0, 5.6, 5.7, 29.444444, 100.4};
        String arr3[] = {"1", "code", "Apple", "sixty-five", "342.3", "Oakland University"};

        //Ingeter array sorting
        System.out.println("Integer Array:");
        System.out.println(Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("Sorted:");
        System.out.println(Arrays.toString(arr1));

        //Double array sorting
        System.out.println("Double array:");
        System.out.println(Arrays.toString(arr2));
        mergeSort(arr2);
        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(arr2));

        //String array sorting
        System.out.println("String Array:");
        System.out.println(Arrays.toString(arr3));
        mergeSort(arr3);
        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(arr3));
    }
}
