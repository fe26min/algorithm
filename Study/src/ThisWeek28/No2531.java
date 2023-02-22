package ThisWeek28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No2531 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr= new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int max = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		map.put(c, 1);
		
		for(int i=0; i<k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		max = Math.max(max, map.size());
		
		for(int i=1; i<N; i++) {
			if(map.get(arr[i-1]) == 1) {
				map.remove(arr[i-1]);
			}
			else {
				map.put(arr[i-1], map.get(arr[i-1]) - 1);
			}
			map.put(arr[(i+k-1) % N], map.getOrDefault(arr[(i+k-1) % N], 0) + 1);
			max = Math.max(max, map.size());
//			System.out.println(i + " " + map.size());
		}
		System.out.println(max);
		
		br.close();
	}
}
