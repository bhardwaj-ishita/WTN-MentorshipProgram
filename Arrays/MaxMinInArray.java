package com.company;

import java.util.Scanner;

//Find the maximum and minimum element in an array

public class MaxMinInArray {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int length = sc.nextInt();
			int[] arr = new int[length];
			for(int i = 0; i < length; i++)
			    arr[i] = sc.nextInt();

			//BRUTE FORCE: sort and then print indices 0 and length - 1
			/*
			for(int i = 0; i < length; i++) {
			    for(int j = 0; j < length; j++) {
			        if(arr[i] > arr[j]) {
			            int store = arr[i];
			            arr[i] = arr[j];
			            arr[j] = store;
			        }
			    }
			}
			System.out.println(Arrays.toString(arr));
			System.out.println("Max: " + arr[0] + "\n" + "Min: " + arr[length - 1]);
			 */

			//LINEAR SEARCH: assume a no. to be min/max and compare simultaneously to find min and max
			int min = arr[0];
			int max = arr[0];
			for(int i = 1; i < length; i++) {
			    if(min > arr[i])
			        min = arr[i];
			    else if(max < arr[i])
			        max = arr[i];
			}

			System.out.println("Max: " + max + "\n" + "Min: " + min);
		}
    }

}
