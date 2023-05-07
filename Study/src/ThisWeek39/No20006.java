package ThisWeek39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No20006 {
	static int p, m;
	static ArrayList<Room> rooms;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		p = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		rooms = new ArrayList<>();
		
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();
			
			Player p = new Player(n, l);
			
			boolean isCheck = false;
			for(Room r : rooms) {
				if(r.players.size() >= m)
					continue;
				if(Math.abs(r.players.get(0).l - l) > 10)
					continue;
				isCheck = true;
				r.players.add(p);
				break;
			}
			if(!isCheck) {
				rooms.add(new Room(p));
			}
		}
		br.close();
		
		StringBuilder sb = new StringBuilder();
		
		for(Room r : rooms) {
			if(r.players.size() == m)
				sb.append("Started!\n");
			else
				sb.append("Waiting!\n");
			Collections.sort(r.players);
			for(int i=0; i<r.players.size(); i++) {
				sb.append(r.players.get(i).l + " " + r.players.get(i).n + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}

class Room {
	ArrayList<Player> players;
	public Room(Player p) {
		this.players = new ArrayList();
		players.add(p);
	}
}

class Player implements Comparable<Player> {
	String n;
	int l;
	
	public Player(String n, int l) {
		this.n = n;
		this.l = l;
	}

	@Override
	public int compareTo(Player o) {
		return this.n.compareTo(o.n);
	}
}