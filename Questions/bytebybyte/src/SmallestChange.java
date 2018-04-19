

/*
 * Q: Making Change; Given an input x, write a function to
 * determine the minimum number of coins required to make
 * that exact amount of change
 * 
 * ref: https://www.youtube.com/watch?v=qH7fVuYlOOc
 */

public class SmallestChange {
	
	/*
	 * use recursive way, we assume that there is
	 * American coin system. N(2^n)
	 * 1, 5, 10, 25
	 * N(2^n)인 이유는 32/1, 32/2처럼 계속 트리를 만들어가야 하기 때문
	 */
	
	static int[] coins = {25, 10, 5, 1};
	public static int change(int x, int[] coins){
		if (x == 0) return 0;
		
		int min = x;
		for (int coin : coins) {
			if (x - coin >= 0 ) {
				int c = change(x - coin, coins);
				if (min > c + 1) min = c + 1;
			}
		}

		return min;
	}
	
	/*
	 * use dynamic programming. N(n^2)
	 * in java, we can do this by using 'overloading'
	 */
	
	public static int change_d(int x, int[] coins){
		int[] cache = new int[x];
		for (int i = 1; i < x; i++) {cache[i] = -1;}
		return change_d(x, coins, cache);
	}
	
	public static int change_d(int x, int[] coins, int[] cache){
		if (x == 0) return 0;
		
		int min = x;
		for (int coin : coins) {
			if (x - coin >= 0 ) {
				int c;
				if (cache[x - coin] >= 0) c = cache[x - coin];
				else {
						c = change_d(x - coin, coins, cache);
						cache[x - coin] = c;
				}
				if (min > c + 1) min = c + 1;
			}
		}
		return min;
	}
	
	
	
	public static void main(String args[]){
		System.out.println(change(40, coins));
		System.out.println(change_d(40, coins));
	}
}
