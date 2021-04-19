package com.company;

import java.util.Scanner;

import static java.lang.Math.max;

//find Largest sum contiguous Sub-array aka Kadane's Algorithm

public class KadaneAlgo {
    public static void main (String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0; i<n; i++) {
			    a[i] = sc.nextInt();
			}
			System.out.println(bruteForce(a,n));
			System.out.println(bruteForce2(a,n));
			System.out.println(kadanes(a,n));
		}
    }

    //BRUTE FORCE: three loops with O(n^3);
    /*
    loop 1: decides the start of the array from where the sum needs to be calculated
    loop 2: decides the end of the array till where the sum will go on
    loop 3: it is the addition of the numbers
    */
    public static int bruteForce(int[] a, int n) {
        int best = 0;
        for(int start = 0; start < n; start++) {
            for(int end = start; end < n; end++) {
                int sum = 0;
                for(int traverse = start; traverse < end; traverse++) {
                    sum += a[traverse];
                    best = max(best,sum);
                }
            }
        }

        return best;
    }

    //BRUTE FORCE 2: three loops with O(n^2);
    /*
    loop 1: decides the start of the array from where the sum needs to be calculated
    loop 2: decides the end of the array till where the sum will go on && making the sum simultaneously
    */
    public static int bruteForce2(int[] a, int n) {
        int best = 0;
        for(int start = 0; start < n; start++) {
            int sum = 0;
            for(int end = start; end < n; end++) {
                sum += a[end];
                best = max(best,sum);
            }

        }
        return best;
    }


    //KADANE'S ALGORITHM:
    /*
    A train goes on of numbers and they keep adding up as we go forward
    the next number decides if it should join the train and add up to it
    OR start it's own train
    basically see if the number is bigger than all the numbers added up together
     */
    public static int kadanes(int[] a, int n) {
        int osum = a[0];
        int csum = a[0];
        /*
            for(int i = 0; i < n; i++) {
            sum = max(a[i], sum + a[i]);
            best = max(sum, best);
        }
         */

        for(int i = 0; i<n; i++) {
            if(csum > 0) {
                //agar peeche se sum positive aa rha hai toh a[i] decides to join the csum
                csum += a[i];
            }

            else {
                //agar peeche se sum ghate main aa rha hai toh a[i] decides to start to make their own sum
                //jaha ham khade hote hai whi se line shuru ho jati hai
                csum = a[i];
            }

            if(csum > osum) {
                osum = csum;
            }
        }

        return osum;
    }
}
