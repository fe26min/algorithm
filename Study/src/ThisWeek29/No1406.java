package ThisWeek29;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class No1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		int N = Integer.parseInt(br.readLine());

		LinkedList<Character> list = new LinkedList<Character>();
		
		for(char i : line.toCharArray()) {
			list.add(i);
		}
		
		ListIterator<Character> iter = list.listIterator();
		
		while(iter.hasNext()) {
			iter.next();
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			switch(cmd) {
			case 'L':
				if(iter.hasPrevious())
					iter.previous();
				break;
				
			case 'D':
				if(iter.hasNext())
					iter.next();
				break;
				
			case 'B':
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			case 'P':
				char t = st.nextToken().charAt(0);
				iter.add(t);
				break;
			}
		}
		for(Character chr : list) {
			bw.write(chr);
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
