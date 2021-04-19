package com.company;

import java.util.Arrays;
import java.util.Scanner;

//Move all the negative elements to one side of the array

public class NegPosSort {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0; i<n; i++) {
			    a[i] = sc.nextInt();
			}
			System.out.println(Arrays.toString(bruteForce(a,n)));
			System.out.println(Arrays.toString(twoPointerWay(a,n)));
		}
    }

    public static int[] bruteForce(int[] a, int n) {
        int j = 0;
        for(int i = 0  ; i < n ; i++) {
            int store;
            if(a[i] < 0) {
                //OPTIMIZATION: if i = j then there is no use to swipe or shift or rearrange the number as it is already in place
                if(i !=j) {
                    store = a[j];
                    a[j++] = a[i];
                    a[i] = store;
                }
            }
        }
        return a;
    }

    public static int[] twoPointerWay(int[] a, int n) {
        int right = n - 1;
        int left = 0;
        while(left <= right) {
            if(a[left] >= 0 && a[right] >= 0)
                left++;
            else if(a[left] < 0 && a[right] >= 0) {
                int store = a[left];
                a[left] = a[right];
                a[right] = store;
                left++;
                right--;
            }
            else if(a[left] < 0 && a[right] < 0)
                right--;
            else {
                int store = a[left];
                a[left] = a[right];
                a[right] = store;
                left++;
                right--;
            }
        }
        return a;
    }
}
