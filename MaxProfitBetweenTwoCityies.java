package dp_questions;


public class MaxProfitBetweenTwoCityies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a1 = { 23,  9,  100,  37 };
		int[] a2 = { 89,  45 ,12 , 44 };
		int max=0;
		
		
		if(a1.length==0) {
			max=0;
		} 
		else if(a1.length==1) {
			max= Math.max(a1[0], a2[0]);
		}
		// add when traveling day we cannot take profit
//		else if(a1.length==2) {
//			max= Math.max(a1[0]+a1[1], a2[0]+a2[1]);
//		}
		System.out.println(max);
		max= findMaxRevenue(a1,a2);
		
		System.out.println(max);

	}

	private static int findMaxRevenue(int[] a1, int[] a2) {
		
		int[][] dp= new int[2][a1.length];
		dp[0][0]= a1[0];
		dp[1][0] = a2[0];

		// when traveling from one city to other has some cost associated, also we can take profit of travel day
		// cost 1-2 : cost12
		// cost 2-1 : cost21
		int cost12= 34;
		int cost21 = 77;
		
		for(int i=1; i< a1.length; i++) {
			dp[0][i] = a1[i] + Math.max(dp[0][i-1], dp[1][i-1] - cost21 );
			dp[1][i] = a2[i] + Math.max(dp[1][i-1], dp[0][i-1] -cost12);		
		}

		// when travel day we cannot take revenue, just no profit at the dsy we are travelling to different city
		// dp[0][1]= a1[0]+a1[1];
		// dp[1][1] = a2[0]+ a2[1];
		
		// for(int i=2; i< a1.length; i++) {
		// 	dp[0][i] = a1[i] + Math.max(dp[0][i-1], dp[1][i-2] );
		// 	dp[1][i] = a2[i] + Math.max(dp[1][i-1], dp[0][i-2] );		
		// }				
		return Math.max(dp[0][a1.length-1], dp[1][a2.length-1]);
	}

}
