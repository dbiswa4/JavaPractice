package com.java.code.consensys;

public class MinUniqSum {

	static int minUniqueSum(int[] arr) {
		int n = arr.length;

		int sum = 0;
		int prev = 0;

		if (n >= 1 && n <= 2000) {

			if (arr[0] >= 1 && arr[0] <= 3000) {
				sum = arr[0];
				prev = arr[0];
			} else {
				sum = 0;
				prev = 0;
			}

			for (int i = 1; i < n; i++) {
				int curr = arr[i];

				if (curr >= 1 && curr <= 3000) {
					if (prev >= curr) {
						curr = prev + 1;
					}
					sum += curr;
					prev = curr;
				}

			}

		} else {
			sum = 0;
		}
		return sum;
	}
	
	public static void uniqueSum(){
        //int a[] = {1,2,2,3,5,6,6,6,6 };
		int[] a = {3, 1, 2, 2};
        int n = a.length;
        int sum = a[0];
        int prv=a[0];
        for(int i=1; i<n;i++){
            int cur = a[i];
            if(cur==prv){
                cur = cur+1;
                sum+= cur;
                System.out.print("--"+cur);
            }else{
                if(cur<prv){
                    cur = prv +1;
                }
                sum += cur;
            }
            prv = cur;
        }
        System.out.println("===================== "+sum);
    }

	public static void main(String[] args) {
		//int[] arr = {1, 2 ,3, 4, 5, 1};
		int[] arr = {3, 1, 2, 2};
		System.out.println("sum : " +minUniqueSum(arr));
		uniqueSum();
		

	}

}
