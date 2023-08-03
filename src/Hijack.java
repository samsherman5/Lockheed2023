import java.util.Scanner;

public class Hijack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = Integer.parseInt(sc.nextLine());
		for (int k = 0; k < testcases; k++) {
			int len = Integer.parseInt(sc.nextLine());
			String s = sc.nextLine();
			String message = "";
			int index = 0;
			while (index < len) {
				int tokenIndex = 0;
				int reversetokenIndex = 0;
				String token = "";
				while (tokenIndex < s.length() - 3) {
					String str = s.substring(tokenIndex, tokenIndex + 3);
					if (s.contains(reverse(str))) {
						token = str;
						reversetokenIndex = s.indexOf(reverse(str));
						break;
					}
				}
				if (message.equals("")) {
					message += removeEscapes(s.substring(tokenIndex + 3, reversetokenIndex), token);
				} else {
					message += removeEscapes(s.substring(tokenIndex + 3, reversetokenIndex) + "\n", token);
				}
			}
			System.out.println(message);
		}
	}

	public static String reverse(String s) {
		String result = "";
		for(int i = s.length() - 1; i >= 0; i--) {
			result += s.charAt(i);
		}
		return result;
	}

	public static String removeEscapes(String str, String token) {
		String [] tokenLetters = token.split("");
		String answer = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == tokenLetters[0].charAt(0) && str.charAt(i + 1) == tokenLetters[1].charAt(0) && str.charAt(i + 2) == tokenLetters[2].charAt(0)) {
				i++ ;
			} else {
				answer += str.charAt(i);
			}
		}
		return answer;
	}
}
