package com.company;

import java.util.*;

//The question is to determine a subsequence that contains the minimum number of distinct numbers among all
// possible subsequences of array 'a' which have exactly k length.

public class DistinctNumbers {

    public static void main(String[] args) {
        try (//Input
		Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0; i<n; i++) {
			    a[i] = sc.nextInt();
			}


			//push_back() = addLast()
			//push_front() = addFirst()

			//Answer
			List<Integer> ans = new ArrayList<>();//to store frequencies of distinct numbers
			Arrays.sort(a);
			//to count the frequency of distinct numbers
			int count = 1;
			for(int i = 0; i < n - 1;i++) {
			    if(a[i] == a[i+1]) {
			        count++;
			    } else {
			        ans.add(count);
			        count = 1;
			    }
			}
			ans.add(count);
			Collections.sort(ans);//sorted the arraylist of frequencies of distinct numbers
			Collections.reverse(ans);//descending order of ans

			//adding the frequencies until the sum is equal to or greater than k
			int sum = 0;
			for(int i = 0; i < ans.size(); i++) {
			    sum += ans.get(i);
			    if(sum >= k) {
			        System.out.println(i + 1);
			        break;
			    }
			}
		}


        /*
        List<Integer> ans = new ArrayList<>();//to store frequencies of distinct numbers
        Arrays.sort(a);
        //to count the frequency of distinct numbers
        for(int i = 0; i < n;) {
            int count = 1;
            while(i < n - 1) {
                if(a[i] == a[i+1]) {
                    count++;
                    i++;
                }
                else {
                    i++;
                    break;
                }
            }
            //the point where i = n-1; the loop will go on infinitely as there is no i++ operator out of the while loop. And we only need it once to increment n-1 --> n and break the for loop
            ans.add(count);
        }

        Collections.sort(ans);//sorted the arraylist of frequencies of distinct numbers
        Collections.reverse(ans);//descending order of ans

        //adding the frequencies until the sum is equal to or greater than k
        int sum = 0;
        for(int i = 0; i < ans.size(); i++) {
            sum += ans.get(i);
            if(sum >= k) {
                System.out.println(i + 1);
                break;
            }
        }
         */
    }
}
