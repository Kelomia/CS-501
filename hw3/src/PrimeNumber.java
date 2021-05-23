/*
    @author: Zimu Jiao
    HW3-CS501
    5.16/5.20/6.10
*/
import java.io.*;
import java.util.Scanner;
class PrimeNumber {
    // 5.16 find the factors of an integer: read an integer and display all its smallest factors n an increasing order
    // example: 120=> 2,2,2,3,5

    // 5.20 display prime number [2,1200] 8 prime numbers per line each one are separated with one space

    // 6.10 PrimeNumberMethod.java provide the isPrime(int number) method for testing whether a number is prime use -
    // this method to find prime number less than 10,000

    // The method isPrime(int number) provided in Listing 6.7

    // Show only first 50, then populate an array to save the prime number less than 1000.
    // In a loop, ask user to enter a number, check by search the array, and output the factors if it is't prime number

    public static boolean isPrime(int number){
        for(int divisor=2;divisor<=number/2;divisor++){
            if(number%divisor==0){
                return false;
            }
        }
        return true;
    }

    public static boolean BinarySearch(int array[],int left,int right,int target){
        if(left>right){return false;}
        int mid = left + (right-left)/2;
        if(array[mid]>target){
            return BinarySearch(array,left,mid-1,target);
        }
        if(array[mid]<target){
            return BinarySearch(array,mid+1,right,target);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] PrimeList = new int[500];    // The array to save the prime number less than 1000, set size as 500 at first.

        // Part of 5.20
        //-------------------------Modify the listing 5.15-----------------------

        final int number_of_primes=1000;    // The bounder of prime number
        final int number_of_primes_per_line=8;  // The limit of showed number per line

        int count=0;    // To count the number in a line and total
        int number=2;   // Set the beginning number as 2

        System.out.println("The prime number between 2 to 1000 is(the first 50):");
        while(number<=number_of_primes){    // The Condition of loop
            /*
            boolean isPrime=true;

            for(int divisor=2;divisor<=number/2;divisor++){
                if(number%divisor==0){
                    isPrime=false;
                    break;
                }
            }

            if(isPrime){    // When current number is prime number output it and check how many number printed in this line
               // Above part can be done by method isPrime(int i)
            */
            if(isPrime(number)){
                PrimeList[count]=number;
                count++;
                if(count<=50){
                    if(count % number_of_primes_per_line==0){
                        System.out.println(number);
                    } else {
                        System.out.print(number+"\t");
                        //Since the number at the end will be longer than those at beginning, I use \t instead of space to
                        //separate them. And I do so at the part of 6.10, which to find those prime number less than 10000.

                    }
                }
            }
            number++;
        }
        int total=0;
        for(int i=0;i<500;i++){
            if(PrimeList[i]!=0){total++;}   // Get the index of total last prime number in PrimeList.
        }

        //  Part of 5.16
        Scanner scan = new Scanner(System.in);

        while(true){
            boolean jump=false; // Boolean marker 'jump' to decide break this loop or not.
		    System.out.println("\nPlease input a number(int): (Quit by input 0)");    // Ask user to input an int number
		    int num = scan.nextInt();   // Save it as num
            if(num==0){break;}          // If user input 0, quit the while-loop
            if(num>1000){               // Check the input, since the array just save prime number less than 1000.
                System.out.println("The number is out of range, please input a number no more than 1000(type int)");
                jump=true;
            }
            if(!jump){  //  Searching array to find if num in array. Using binary search.
                if(BinarySearch(PrimeList,0,total-1,num)){
                    System.out.println(num+" is prime number");
                    jump=true;  // Set jump as true
                }
            }
            if(!jump){
                // If num is not prime number that it is not in PrimeList, show its factors:
	    	    System.out.println(num+" is not prime number.\nThe factor(s) is:");
		        /*
		        for(int i=2;i<=num;i++){    // The loop to find prime number smaller than 'num' and check if it is a factor.
		            if(isPrime(i)){
		                while(num%i==0){    // When it(i) is a factor(s), output it.
		                    if(num==i){
		                        System.out.print(i);
		                        num=num/i;
		                    } else {
		                        System.out.print(i+",");
		                        num=num/i;
		                    }
		                }
		            }
		        }
		        */
		        for(int i=0;PrimeList[i]<=num;i++){     // Using the idea above to find the factors of num through PrimeList[].
		            while(num%PrimeList[i]==0){
		                if(num==PrimeList[i]){
		                    System.out.print(PrimeList[i]);
		                    num=num/PrimeList[i];
		                } else {
		                    System.out.print(PrimeList[i]+",");
		                    num=num/PrimeList[i];
		                }
		            }
		        }
                System.out.println();
            }
        }
	    /*  Part of 6.10 find the prime number in 10,000
	    count =0;
	    System.out.println("The prime number less than 10000 is:");
	    for(int i=2;i<=10000;i++){  // Using loop to find the prime number less than 10000
	        if(isPrime(i)){ // Codes below I use the part from the Listing-5.15
	            count++;
	            if(count % number_of_primes_per_line==0){
                    System.out.println(i);
                } else {
                    System.out.print(i+"\t");
                }
	        }
	    }
	    */
    }
}