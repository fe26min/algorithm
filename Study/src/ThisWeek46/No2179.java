package ThisWeek46;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No2179 {
	static int N;
	static ArrayList<String> inputs;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int a = 0;
		int b = 0;
		int max = 0;
		
		for(int i=0; i<N-1; i++) {
			String st1 = inputs.get(i);
			
			for(int j=i+1; j<N; j++) {
				String st2 = inputs.get(j);
				int count = 0;
				for(int k=0; k<st2.length() && k<st1.length(); k++) {
					if(st1.charAt(k)!=st2.charAt(k))
						break;
					count++;
				}
				if(max<count) {
					max = count;
					a = i;
					b = j;
				}
			}
		}
		System.out.println(inputs.get(a));
		System.out.println(inputs.get(b));
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inputs = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			inputs.add(s);
		}
		br.close();		
	}
}
