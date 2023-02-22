package ThisWeek27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class No21942 {
	static int N, LMin, F;
	static String L;
	
	static HashMap<String, String> hs;
	static HashMap<String, Long> lateFee;
	
	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = st.nextToken();
		F=  Integer.parseInt(st.nextToken());
		
		int lDDD = Integer.parseInt(L.substring(0, 3));
		int lhh = Integer.parseInt(L.substring(4, 6));
		int lmm = Integer.parseInt(L.substring(7, L.length()));
		
		LMin = (24 * lDDD + lhh) * 60 + lmm;
		
		hs = new HashMap<>();
		lateFee = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String date = st.nextToken();
			String time = st.nextToken();
			String item = st.nextToken();
			String user = st.nextToken();
			
			String id = item + "_" + user;
			
			if(hs.containsKey(id)) {
				String prev = hs.get(id);
				String now = date + " " + time;
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				long prevMin = f.parse(prev).getTime();
				long nowMin = f.parse(now).getTime();
				
				long diff = ((nowMin - prevMin) / (1000 * 60));
				if(diff > LMin) {
					lateFee.put(user, lateFee.getOrDefault(user, 0L) + (diff-LMin) * F);
				}
				hs.remove(id);
			} else {
				hs.put(id, date + " " + time);
			}
		}
		
		List<String> list = new ArrayList<>(lateFee.keySet());
		list.sort((s1, s2) -> s1.compareTo(s2));
		if(list.size() <= 0) {
			System.out.println(-1);
		} else {
			StringBuilder sb = new StringBuilder();
			for(String key : list) {
				sb.append(key + " " + lateFee.get(key)).append("\n");
			}
			System.out.println(sb);
		}
		
		br.close();
	}
}
