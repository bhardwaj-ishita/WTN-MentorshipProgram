package com.company;

//import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.min;

public class MinJumps {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0; i<n; i++) {
			    a[i] = sc.nextInt();
			}
			System.out.println(Jumps(a,n));
		}
    }

    public static int minJumps(int[] a, int n){
        Integer[] dp = new Integer[n+1];
        dp[n] = 0;
        for(int i = n-1; i >= 0; i--) {
            if(a[i] > 0) {
                int min = Integer.MAX_VALUE;//as we are considering min value we'll have to put the max possible value so no complexities occur
                for(int j = 1; j <= a[i]; j++) {
                    if(dp[j+i] != null) {
                        min = min(min,dp[i+j] + 1);
                    }
                }

                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }

        return dp[0];
    }


    /*
    base cases:
    1) dp[destination] = 0; there are no steps to be taken
    2) i + j < n; at 9th step we have max 5 jump allowed to make but the destination is 10; hence step no. +
    3) dp[i] != null;
    4) arr[i] != 0;
     */
    public static int Jumps(int[] arr, int n) {
        Integer[] dp = new Integer[n+1];
        dp[n] = 0;//base case 1
        for(int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j <= arr[i] && i+j < n + 1; j++) {
                if(arr[i] != 0 && dp[i] != null) {
                    //i + j < n
                    min = min(min, dp[i + j] + 1);
                }
                dp[i] = min;
            }

        }
        return dp[0];
    }
}
