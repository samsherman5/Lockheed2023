import java.util.*;

public class ModemMania {
	static class Pair implements Comparable<Pair>{
		String address;
		int n;
		String [] subnets;
		public Pair(String address, int n) {
			this.address = address;
			this.n = n;
			subnets = address.split(".");
		}
		@Override
		public int compareTo(Pair other) {
			if (this.subnets[0].equals(other.subnets[0])) {
				if (this.subnets[1].equals(other.subnets[0])) {
					if (this.subnets[2].equals(other.subnets[0])) {
						return Integer.parseInt(this.subnets[3]) - Integer.parseInt(other.subnets[3]);
					} else {
						return Integer.parseInt(this.subnets[2]) - Integer.parseInt(other.subnets[2]);
					}
				} else {
					return Integer.parseInt(this.subnets[1]) - Integer.parseInt(other.subnets[1]);
				}
			}
			else {
				return Integer.parseInt(this.subnets[0]) - Integer.parseInt(other.subnets[0]);
			}
		}
		@Override
		public String toString() {
			return address + " " + n;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = Integer.parseInt(scan.nextLine());
		Map<String, Integer> map = new HashMap<>();
		int pairs = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < pairs; i++) {
			String[] line = scan.nextLine().split(" ");
			if (map.containsKey(line[0])) {
				map.put(line[0], map.get(line[0]) + 1);
			} else {
				map.put(line[0], 1);
			}
			//map.put(line[0], Integer.parseInt(line[1]));
		}
		ArrayList<Pair> list = new ArrayList<>();
		for (String key : map.keySet()) {
			list.add(new Pair(key, map.get(key)));
		}
		Collections.sort(list);
		for (Pair pair : list) {
			System.out.println(pair.address + " " + pair.n);
		}
	}
}
