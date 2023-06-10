package Sweep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2170 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node2170[] arr = new Node2170[N];
		int result = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			arr[i] = new Node2170(s, e);
		}
		
		Arrays.sort(arr);
		
		int min = arr[0].s;
		int max = arr[0].e;
		
		int len = max - min;
		
		for(int i=1; i<N; i++) {
			if(min <= arr[i].s && arr[i].e <= max)
				continue;
			else if(arr[i].s < max)
				len += arr[i].e - max;
			else {
				len += arr[i].e - arr[i].s;
			}
			min = arr[i].s;
			max = arr[i].e;
		}
		System.out.println(len);
		br.close();
	}
}
class Node2170 implements Comparable<Node2170>{
	int s, e;
	
	public Node2170(int s, int e) {
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Node2170 o) {
		if(this.s == o.s)
			return this.e - o.e;
		return this.s - o.s;
	}
}