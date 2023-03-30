package ThisWeek34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class No1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		LinkedList<Character> list = new LinkedList<>();
		for(char c : line.toCharArray()) {
			list.add(c);
		}
		
		int M = Integer.parseInt(br.readLine());
	
		ListIterator<Character> cursor = list.listIterator();
		while(cursor.hasNext())
			cursor.next();
	
		for(int i=0; i<M; i++) {
			String cmd = br.readLine();
			
			switch(cmd.charAt(0)) {
			case 'L':
				if(cursor.hasPrevious())
					cursor.previous();
				break;
			case 'D':
				if(cursor.hasNext())
					cursor.next();
				break;
			case 'B':
				if(cursor.hasPrevious()) {
					cursor.previous();
					cursor.remove();
				}
				break;
			case 'P':
				cursor.add(cmd.charAt(2));
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char c : list) {
			sb.append(c);
		}
		System.out.println(sb);
		br.close();
	}
}
