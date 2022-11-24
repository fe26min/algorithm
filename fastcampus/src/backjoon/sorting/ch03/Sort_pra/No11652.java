package backjoon.sorting.ch03.Sort_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashSet;

public class No11652 {
	
	static int N;
	static HashSet<Point11652> arr;
	
	public static void main(String[] args) throws IOException {
		input();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new HashSet<Point11652>();
		
		for(int i=0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			
			if(arr.contains(num)) {
				arr.add(new Point11652(num, 1));
			}
		}
		
		
		br.close();
	}
}

class Point11652 implements Comparable<Point11652>{
	long num;
	int count;
	
	public Point11652(long num, int count) {
		this.num = num;
		this.count = count;
	}
	
	@Override
	public int compareTo(Point11652 o) {
		if(count == o.count) return num - o.num;
		return o.count - count;
	}
}