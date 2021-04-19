package com.company;

import java.util.Arrays;
import java.util.Scanner;

//Reverse the array

public class ReverseArrayString {
    public static void main(String[] args) {
        try (//input
		Scanner sc = new Scanner(System.in)) {
			int length = sc.nextInt();
			int[] arr = new int[length];
			for (int i = 0; i < length; i++)
			    arr[i] = sc.nextInt();
			System.out.println(Arrays.toString(bruteForce(arr, length)));
			System.out.println(Arrays.toString(iterativeWay(arr, length)));
			System.out.println(Arrays.toString(recursiveWay(arr, 0, length - 1)));
		}
    }

    public static int[] bruteForce(int[] arr, int length) {
        //BRUTE FORCE: making a new array for reversing

        int[] reversedArr = new int[length];
        int i = 0;
        for (int j = length - 1; j >= 0;)
            reversedArr[j--] = arr[i++];

        return reversedArr;
    }

    public static int[] iterativeWay(int[] arr, int length) {
        //ITERATIVE WAY: reversing in the same array
        //O(n)

        int i = length - 1;
        for(int j = 0; j < length/2; j++) {
            int store = arr[j];
            arr[j] = arr[i--];
            arr[i+1] = store;
        }

        return arr;
    }

    public static int[] recursiveWay(int[] arr, int start, int end) {
        //RECURSIVE WAY: use recursion as a loop
        //O(n)
        if(start > end)
            return arr;

        int store = arr[start];
        arr[start] = arr[end];
        arr[end] = store;
        recursiveWay(arr, start + 1, end - 1);
        return arr;
    }

}
