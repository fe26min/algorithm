package backjoon.fastcampus.ch03.Sort_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class No20291 {
	
	static TreeMap<String, Integer> hm;
	
	public static void main(String[] args) throws IOException {
		input();
		ArrayList<String> arr = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		
		for(String key : hm.keySet()) {
			sb.append(key + " " + hm.get(key)+ "\n");
		}
		
		System.out.println(sb);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		hm = new TreeMap<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			String file[] = line.split("\\.");
			hm.put(file[1], hm.getOrDefault(file[1], 0) + 1);
		}
		br.close();
	}
}
