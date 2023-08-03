import java.util.ArrayList;
import java.util.Scanner;

public class Multiply {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			String[] l1 = scan.nextLine().split(" ");
			String[] l2 = scan.nextLine().split(" ");
			ArrayList<Integer> errors = new ArrayList<Integer>();
			for (int j = 0; j < l1.length; j++) {
				if(Double.parseDouble(l1[i]) >= .6 && Double.parseDouble(l1[i]) <= .85 && Double.parseDouble(l2[i]) >= .6 && Double.parseDouble(l2[i]) <= .85){
					errors.add(j);
				}
			}
			if(errors.isEmpty()){
				System.out.println("No multipaction events detected.");
			}else if(errors.size() == 1){
				System.out.println("A multipaction event was detected at time index " + errors.get(0) + ".");
			} else{
				System.out.print(errors.size() + "multipaction events were detected at time indices: ");
				System.out.print(errors.get(0));
				for (int j = 1; j < errors.size(); j++) {
					System.out.print(" " + errors.get(j));
				}
				System.out.print(".\n");
			}

		}
	}
}
