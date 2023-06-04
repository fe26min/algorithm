package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int ti=0; ti<T; ti++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			sb.append(func(x1, y1, r1, x2, y2, r2) + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	private static int func(int x1, int y1, int r1, int x2, int y2, int r2) {
		if(x1 == x2 && y1 == y2 && r1 == r2) {
			return -1;
		}
		int distance = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); 
		
		if(Math.pow(r1 + r2, 2) < distance) {
			return 0;
		}
		
		if(Math.pow(r1 - r2, 2) > distance) {
			return 0;
		}
		
		if(Math.pow(r1- r2, 2) == distance) {
			return 1;
		}
		
		if(Math.pow(r1+r2, 2) == distance) {
			return 1;
		}
		return 2;
	}
}
