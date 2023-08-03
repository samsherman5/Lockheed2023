import java.util.Scanner;

public class BottomLine {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			String[] lineSplit = scan.nextLine().split(" ");
			int cassowary = Integer.parseInt(lineSplit[0]);
			int lead = Integer.parseInt(lineSplit[1]);
			if(cassowary>lead){
				System.out.println("Cassowary Craft sold " + (cassowary-lead) + " more aircraft");
			} else if(lead>cassowary){
				System.out.println("Lead Balloons Ltd sold " + (lead-cassowary) + " more aircraft");
			} else {
				System.out.println("Cassowary Craft and Lead Balloons Ltd sold the same number of aircraft");
			}
		}
	}
}
