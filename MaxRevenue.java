package dp_questions;


public class MaxRevenue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a1 = { 23,  9,  50,  37 };
		int[] a2 = { 89,  45 ,12 , 44 };
		int max=0;
		
		
		if(a1.length==0) {
			max=0;
		} 
		else if(a1.length==1) {
			max= Math.max(a1[0], a2[0]);
		}
		else if(a1.length==2) {
			max= Math.max(a1[0]+a1[1], a2[0]+a2[1]);
		}
		System.out.println(max);
		max= findMaxRevenue(a1,a2);
		
		System.out.println(max);

	}

	private static int findMaxRevenue(int[] a1, int[] a2) {
		
		int[][] dp= new int[2][a1.length];
		dp[0][0]= a1[0];
		dp[1][0] = a2[0];
		
		dp[0][1]= a1[0]+a1[1];
		dp[1][1] = a2[0]+ a2[1];
		
		for(int i=2; i< a1.length; i++) {
			dp[0][i] = a1[i] + Math.max(dp[0][i-1], dp[1][i-2] );
			dp[1][i] = a2[i] + Math.max(dp[1][i-1], dp[0][i-2] );		
		}
		
		for (int[] arr  : dp) {
			for (int i : arr) {
				System.out.print(i+" ");
			}
			System.out.println();
			
		}
				
		return Math.max(dp[0][a1.length-1], dp[1][a2.length-1]);
	}

}
