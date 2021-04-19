package com.company;

import java.util.Arrays;
import java.util.Scanner;

//Write a program to cyclically rotate an array by one.

public class CyclicRotation {
	public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0; i<n; i++) {
			    a[i] = sc.nextInt();
			}
			System.out.println(Arrays.toString(bruteForce(a,n)));
		}
    }

    //BRUTE FORCE: A loop; it will iterate and exchange the last index adjacently until it's at index 0
    public static int[] bruteForce(int[] a, int n) {
        int store = a[n - 1];
        int i = n - 1;
        while(i >= 1) {
            a[i] = a[i - 1];
            i--;
        }
        a[0] = store;
        return a;
    }


    //ERROR IN GFG: possible lossy conversion from long to int
    /*
    You cannot create an array with more than 2^31-1 entries, so you should use an int value
    when you do so (the compiler is simply warning you that the size will be truncated
    from long to int). 1000000000 is small enough to fit into int, so you basically have
    no reason to use long y in order to store this value in the first place.

    According to your description, the array itself is designated to store int values, so it
    doesn't need to be an array of long values.
     */

    /*
    public void rotate(long arr[], long n)
    {
        int store = (int) arr[(int)n - 1];
        int i = (int) n - 1;
        while(i >= 1) {
            arr[i] = arr[i - 1];
            i--;
        }
        arr[i] = store;
    }
     */
}
