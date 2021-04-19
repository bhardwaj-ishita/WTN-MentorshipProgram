package com.company;

import java.util.*;

//Find the Union and Intersection of the two sorted arrays.

public class UnionOfArrays {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[m];
			for(int i = 0; i<n; i++) {
			    a[i] = sc.nextInt();
			}
			for(int i = 0; i<m; i++) {
			    b[i] = sc.nextInt();
			}
			System.out.println(doUnion(a,n,b,m));
			System.out.println(doIntersection(a,n,b,m));
		}
    }

    public static int doUnion(int[] a, int n, int[] b, int m) {
        int output = 0;
        int j = 0;
        while(j < n && j < m && a[j] == b[j]) {
            output++;
            j++;
        }

        return n + m - output;
    }

    public static int doIntersection(int[] a, int n, int[] b, int m) {
        int output = 0;
        int j = 0;
        while(j < n && j < m && a[j] == b[j]) {
            output++;
            j++;
        }

        return output;
    }

}
