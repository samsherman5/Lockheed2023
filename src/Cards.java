import java.util.ArrayList;
import java.util.Scanner;

public class Cards {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int iterations = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<iterations; i++){
			String [] p1card = scan.nextLine().split(" ");
			String [] p2card = scan.nextLine().split(" ");
			System.out.println(solve(p1card, p2card));
		}
	}

	public static String solve(String [] p1cards, String [] p2cards) {

		ArrayList<String> p1actCards = new ArrayList<>();
		ArrayList<String> p2actCards = new ArrayList<>();

		for (String thing : p1cards) {
			String[] temp = thing.split("_");
			p1actCards.add(temp[0]);
		}
		for (String thing : p2cards) {
			String[] temp = thing.split("_");
			p2actCards.add(temp[0]);
		}

		int p1sum = 0;
		int p2sum = 0;

		for (String key : p1actCards) {
			if (key.equals("ACE")) {
				int porentialSum = 0;
				for (int k = 0; k < p1actCards.size(); k++) {
					if (!p1actCards.get(k).equals("ACE")) {

						if(p1actCards.get(k).equals("JACK") || p1actCards.get(k).equals("QUEEN") || p1actCards.get(k).equals("KING")) {
							porentialSum += 10;
						}else {


							porentialSum += Integer.parseInt(p1actCards.get(k));
						}
					}
				}
				if (porentialSum + 11 > 21) {
					p1sum += 1;
				} else {
					p1sum += 11;
				}
			} else {
				if(key.equals("JACK") || key.equals("QUEEN") || key.equals("KING")) {
					p1sum += 10;
				}else {


					p1sum += Integer.parseInt(key);
				}
			}
		}

		for (String key : p2actCards) {
			if (key.equals("ACE")) {
				int porentialSum = 0;
				for (int k = 0; k < p2actCards.size(); k++) {
					if (!p2actCards.get(k).equals("ACE")) {
						if(p2actCards.get(k).equals("JACK") || p2actCards.get(k).equals("QUEEN") || p2actCards.get(k).equals("KING")) {
							porentialSum += 10;
						}else {


							porentialSum += Integer.parseInt(p2actCards.get(k));
						}
					}
				}
				if (porentialSum + 11 > 21) {
					p2sum += 1;
				} else {
					p2sum += 11;
				}
			} else {
				if(key.equals("JACK") || key.equals("QUEEN") || key.equals("KING")) {
					p2sum += 10;
				}else {


					p2sum += Integer.parseInt(key);
				}
			}
		}
		if(p1sum == 21 &&  p2sum == 21 ) {
			return "Player Score: " + p1sum + " Dealer Score: " + p2sum + " Tie!";
		}
		else if( p1sum > 21){
			return "Player Score: " + p1sum + " Dealer Score: " + p2sum + " Dealer Wins!";
		}

		else if( p1sum < 21 && p2sum < 21){
			if(p1sum == p2sum){
				return "Player Score: " + p1sum + " Dealer Score: " + p2sum + " Tie!";
			}
			else if(p1sum > p2sum){
				return "Player Score: " + p1sum + " Dealer Score: " + p2sum + " Player Wins!";
			} else {
				return "Player Score: " + p1sum + " Dealer Score: " + p2sum + " Dealer Wins!";

			}
		}

		else if( p1sum <= 21 && p2sum > 21){
			return "Player Score: " + p1sum + " Dealer Score: " + p2sum + " Player Wins!";
		}

			else if(p2sum == 21 || p1sum ==21){
			if(p1sum == 21){
				return "Player Score: " + p1sum + " Dealer Score: " + p2sum + " Player Wins!";
			} else {
				return "Player Score: " + p1sum + " Dealer Score: " + p2sum + " Dealer Wins!";
			}
		}



		return "";
	}
}
