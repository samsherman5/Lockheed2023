import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ships {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < iterations; i++) {
			int things = Integer.parseInt(scan.nextLine());
			ArrayList<String> classifies = new ArrayList<String>();
			ArrayList<Double> health = new ArrayList<Double>();
			for(int j = 0; j < things; j++){
				String [] thing = scan.nextLine().split(" ");
				classifies.add(thing[0]);
				health.add(Double.parseDouble(thing[1]));
			}
			System.out.println("" + solve(classifies, health));
		}
	}
	public static int solve(ArrayList<String> classifies, ArrayList<Double> health){
		double sum = 0.0;
		double divider = 0;
		for(int i = 0; i < classifies.size(); i++){
			if(classifies.get(i).equals("LOW")){
				sum += health.get(i);
				divider++;
			}
			if(classifies.get(i).equals("MEDIUM")){
				sum += health.get(i)*2;
				divider+=2;
			}
			if(classifies.get(i).equals("HIGH")){
				sum += health.get(i)*3;
				divider+=3;
			}
		}
		double avg = sum/divider;
		avg = round(avg);
		int total = (int)(avg*10);
		return total;
	}

	public static double round(double number) {
		double powerOfTen = 10;//change this for precision (10: 1 place)
		double exp = number * powerOfTen;
		double remainder = Math.abs(exp) - Math.floor(Math.abs(exp));
		if (remainder >= 0.5) {
			if (exp > 0.0) {
				exp += 1.0;
			} else {
				exp -= 1.0;
			}
		}
		return ((int)exp)/powerOfTen;
	}
}
