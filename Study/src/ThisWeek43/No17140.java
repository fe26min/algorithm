package ThisWeek43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class No17140 {
	static int r, c, k, cr, cc;
	static int[][] mat;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		cr = 3;
		cc = 3;
		
		int count = 0;
		while(count <= 100 && mat[r][c] != k) {
			if(cr >= cc)
				funcR();
			else
				funcC();
			count++;
		}
		if(count == 101)
			count = -1;
		System.out.println(count);
	}


	private static void funcC() {
		for(int i=0; i<cc; i++) {
			HashMap<Integer, Integer> hm = new HashMap<>();
			for(int j=0; j<cr; j++) {
				if(mat[j][i]==0) continue;
				hm.put(mat[j][i], hm.getOrDefault(mat[j][i], 0) + 1);
				mat[j][i] = 0;
			}
			
			List<Map.Entry<Integer, Integer>> list = new LinkedList<>(hm.entrySet());
			list.sort(new Comparator<Map.Entry<Integer, Integer>>() {

				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
					if(o1.getValue() == o2.getValue()) {
						return o1.getKey() - o2.getKey();
					}
					return o1.getValue() - o2.getValue();
				}
			});
			
			int count = 0;
			
			for(Entry<Integer, Integer> ent : list) {
				if(count >= 100) break;
				mat[count++][i] = ent.getKey();
				mat[count++][i] = ent.getValue();
			}
			cr = Math.max(cr, count);
		}
	}

	private static void funcR() {
		for(int i=0; i<cr; i++) {
			HashMap<Integer, Integer> hm = new HashMap<>();
			
			for(int j=0; j<cc; j++) {
				if(mat[i][j]==0)
					continue;
				hm.put(mat[i][j], hm.getOrDefault(mat[i][j], 0) + 1);
				mat[i][j] = 0;
			}
			
			ArrayList<Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
			list.sort(new Comparator<Entry<Integer, Integer>>() {

				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
					if(o1.getValue() == o2.getValue())
						return o1.getKey() - o2.getKey();
					return o1.getValue() - o2.getValue();
				}
			});
			
			int count = 0;
			
			for(Entry<Integer, Integer> ent : list) {
				if(count >= 100) break;
				mat[i][count++] = ent.getKey();
				mat[i][count++] = ent.getValue();
			}
			cc = Math.max(cc, count);
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		
		mat = new int[100][100];
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
}
