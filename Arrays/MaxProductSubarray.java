package com.company;

import java.util.Scanner;
import static java.lang.Math.max;
import static java.lang.Math.min;

//find maximum product subarray

public class MaxProductSubarray {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0; i<n; i++) {
			    a[i] = sc.nextInt();
			}
			System.out.println(maxProduct1(a,n));
			System.out.println(maxProduct2(a,n));
		}

    }

    /*

    it's not necessary for a (+)*(-) to be min val and never give a max value
    need to keep in mind that a case like this could also come (+)*(-) * (-) = large positive number


    public static long maxProduct(int[] arr, int n) {

        long cpro = arr[0];
        long opro = arr[0];
        for(int i = 1; i < n; i++) {

            //cpro = max(arr[i],arr[i]*arr[i-1]);
            if(arr[i]*cpro > 0)
                cpro *= arr[i];
            else
                cpro = arr[i];

            //opro = max(cpro.opro);
            if(cpro > opro)
                opro = cpro;
        }

        return opro;
    }
     */

    public static long maxProduct1(int[] arr, int n) {
        long maxVal = arr[0];
        long minVal = arr[0];
        long finalVal = arr[0];
        for(int i = 1; i < n; i++) {

            //cpro = max(arr[i],arr[i]*arr[i-1]);
            if(arr[i] > 0) {
                long temp = minVal;
                minVal = maxVal;
                maxVal = temp;
            }

            maxVal = max(arr[i],maxVal*arr[i]);
            minVal = min(arr[i],minVal*arr[i]);
            finalVal = max(maxVal,finalVal);
        }

        return finalVal;
    }

    public static long maxProduct2(int[] arr, int n) {
        long maxVal = arr[0];
        long minVal = arr[0];
        long finalVal = arr[0];
        for(int i = 1; i < n; i++) {

            //cpro = max(arr[i],arr[i]*arr[i-1]);
            if(arr[i] < 0) {
                long temp = minVal;
                minVal = maxVal;
                maxVal = temp;
            }

            if(maxVal*arr[i] > arr[i])
                maxVal = maxVal*arr[i];
            else
                maxVal = arr[i];

            if(minVal*arr[i] < arr[i])
                minVal = minVal*arr[i];
            else
                minVal = arr[i];

            if(finalVal < maxVal)
                finalVal = maxVal;
        }

        return finalVal;
    }
}
