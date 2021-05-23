/*
    @author: Zimu Jiao
    HW3-CS501
    7.9/7.10/7.20
*/
import java.io.*;
import java.util.Scanner;
class Array{
    // 7.9 Find the largest element: find the largest element in an array of double values using the following header:
    // public static double max(double[] array);
    // Test by 10 elements, and return and output the largest value.

    // 7.10 Find the index of the largest element: return the index of the largest element in an array of integer. If there-
    // is more than one element, return the largest index. Using the following header:
    // public static int indexOfLargestElement(double[] array);
    // Test by 10 elements, return the index and output the index and value.

    // 7.20 Modify the bubble sort method(Programming Exercise 7.18), then sort elements in array in descending.
    // Test by 10 double numbers

    // Use the same 10 number for 3 tests at the beginning, then find the minimum and its index, then sort the array and-
    // print it.

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		System.out.println("\nPlease input 10 number(double):");    // Let user input 10 double number
		double[] list = new double[10];
		for(int i=0;i<10;i++){  // Save them in double[] list
		    list[i] = scan.nextDouble();
		}

        /*  // Print the array
		System.out.println("The array is:");
		for(int i=0;i<list.length;i++){
		    System.out.print(list[i]+" ");
		}
        */

		int index=0;    // Set index, min
        double min=list[0];
        for(int i=0;i<list.length;i++){     // Loop, compare min with current element. If current element is smaller,
            if(min>=list[i]){               // set index as its index and min value as its value.
                min=list[i];
                index=i;
            }
        }
        System.out.println("The smallest number is "+min+"\nAnd its index is "+index);
        // Report min value and its index.

        boolean flag=true;  // Set flag to mark if switch happen
        while(flag){                        // When there is at least one switch, repeat.
            flag=false;                     // Set flag as false.
            for(int i=0;i<list.length-1;i++){
                if(list[i]<=list[i+1]){     // When list-i smaller than list-i+1
                    double temp=list[i];    // Switch them and mark 'flag' turn true.
                    list[i]=list[i+1];
                    list[i+1]=temp;
                    flag=true;
                }
            }
        }
        // Show the array after the bubble sort. It is in descend order.
        System.out.println("After bubble sort, the array is:");
		for(int i=0;i<list.length;i++){
		    System.out.print(list[i]+" ");
        }
    }
    /*
    public static double min(double[] array){
    // Method min() to find the minimum in array
        double min=array[0];
        for(int i=0;i<array.length;i++){
            if(min>=array[i]){
                min=array[i];
            }
        }
        System.out.println("The smallest number is:"+ min);
        return min;
    }

    public static int indexOfSmallestElement(double[] array){
    // Method indexOfSmallestElement to find the index of minimum
        int index=0;
        double min=array[0];
        for(int i=0;i<array.length;i++){
            if(min>=array[i]){
                min=array[i];
                index=i;
            }
        }
        return index;
    }
    */
}