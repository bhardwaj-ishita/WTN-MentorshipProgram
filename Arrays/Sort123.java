package com.company;

import java.util.Arrays;
import java.util.Scanner;

//Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algo

public class Sort123 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0; i<n; i++ ) {
			    a[i] = sc.nextInt();
			}
			System.out.print(Arrays.toString(sort012(a, n)));
		}
    }

    //time complexity = O(n)
    //space complexity = O(1)

    //COUNT NUMBER OF 0s, 1s and 2s: and don't store them in an array
    public static int[] sort012(int[] a, int n)
    {
        int zero = 0;
        int one = 0;
        for(int i = 0; i < n ; i++) {
            if(a[i] == 0)
                zero++;
            else if(a[i] == 1)
                one++;
        }

        int j = 0;
        for(;j<zero; j++)
            a[j] = 0;
        for(;j < zero+one;j++)
            a[j] = 1;
        for(;j < n;j++)
            a[j] = 2;
        return a;
    }

    //DUTCH NATIONAL FLAG ALGORITHM
    public static void dutchAlgo(int[] a, int n) {
        //in above method we considered only the 0s and 1s and we filled 2s by default
        //here we'll take care of the 0s and 2s and fill the 1s by default

        int low;
        int high;

    }
}
