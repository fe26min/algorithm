package Ch001_CodingTestPrac.Basic.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj6588 {
	static boolean[] isPrime;
	static ArrayList<Integer> primeList;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		eratos();
		sb = new StringBuilder();
		while(true) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0)
				break;
			func(num);
		}
		System.out.println(sb);
		br.close();
	}
	
	private static void func(int num) {
		for(int i : primeList) {
			if(i > num/2) {
				sb.append("Goldbach's conjecture is wrong.\n");
			}
				
			if(isPrime[num - i]) {
				sb.append(num + " = " + i + " + " + (num-i) + "\n"); 
				return;
			}
		}
	}

	private static void eratos() {
		primeList = new ArrayList<>();
		isPrime = new boolean[1000001];
		boolean[] visit = new boolean[1000001];
		for(int i=2; i<1000001; i++) {
			if(visit[i])
				continue;
			if(!isPrime[i]) {
				isPrime[i] = true;
				primeList.add(i);
				for(int j=i; j<1000001; j+=i) {
					visit[j] = true;
				}
			}
		}
	}
}
