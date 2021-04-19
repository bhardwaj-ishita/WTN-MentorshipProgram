package com.company;

import java.util.Arrays;
import java.util.Scanner;

//find duplicate in an array of N+1 Integers
/*
Proving that at least one duplicate must exist in nums is simple application of
the PIGEONHOLE PRINCIPLE. Here, each number in nums is a "pigeon" and each distinct
number that can appear in nums is a "pigeonhole". Because there are n+1n+1 numbers and
n distinct possible numbers, the pigeonhole principle implies that at least one of the
numbers is duplicated.
 */

public class DuplicateNumber {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0; i<n; i++) {
			    a[i] = sc.nextInt();
			}
			System.out.println(bruteForce(a));
			System.out.println(sortingWay(a));
		}
    }

    //BRUTE FORCE:
    //time complexity O(n^2)
    //space complexity O(1)
    //without modifying the input array
    public static int bruteForce(int[] nums) {
        int store = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    store = nums[j];
                    break;
                }
            }
        }
        return store;
    }

    //SORT FIRST AND THEN WHEN THEY GET ADJACENT IT'LL BE EASY TO GET THEM IN ONE LOOP
    //time complexity O(nlogn)
    //space complexity O(1)/O(n)
    //if modifying the input array is allowed
    public static int sortingWay(int[] nums) {
        Arrays.sort(nums);
        int store = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == nums[i+1]) {
                store = nums[i];
                break;
            }
        }
        return store;
    }



}
