package backjoon.sorting.ch03.Sort_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No15970 {
	
	static HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
	public static void main(String[] args) throws IOException {
		input();
		
		int sum = 0;
		for(int i: hm.keySet()) {
			ArrayList<Integer> arr = hm.get(i);
			sum += (arr.get(1) - arr.get(0)) + (arr.get(arr.size()-1) - arr.get(arr.size()-2));
			
			for(int j =1; j<arr.size()-1; j++) {
				sum += Math.min(arr.get(j) - arr.get(j-1) , arr.get(j+1) - arr.get(j));
			}
		}
		System.out.println(sum);
		
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			if(!hm.containsKey(Y))
				hm.put(Y, new ArrayList<>());
			hm.get(Y).add(X);
		}
		for(int i : hm.keySet())
			Collections.sort(hm.get(i));
		br.close();
	}
}
