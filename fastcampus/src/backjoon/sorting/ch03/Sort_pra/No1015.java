package backjoon.sorting.ch03.Sort_pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1015 {
	// 정렬 기준을 배열로 줌
	
	static int N;
	static Point1015[] arr;
	static int P[];
	
	public static void main(String[] args) throws IOException {
		input();
		
		for(int i : P) {
			System.out.print(i + " ");
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new Point1015[N];
		P = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)
			arr[i] = new Point1015(Integer.parseInt(st.nextToken()), i);
		
		Arrays.sort(arr);
		for(int i=0; i<N; i++) {
			P[arr[i].idx] = i;
		}
		br.close();
	}
	
	
}

class Point1015 implements Comparable<Point1015>{
	int v, idx;
	
	public Point1015(int v, int idx) {
		this.v = v;
		this.idx = idx;
	}
	
	@Override
	public int compareTo(Point1015 o) {
		if(v==o.v) return idx-o.idx;
		return v-o.v;
	}
}