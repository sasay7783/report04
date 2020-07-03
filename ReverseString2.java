package report04;
import java.util.Scanner;

public class ReverseString2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		StringBuffer sb = new StringBuffer();
		sb.append(str);
		
		System.out.println(sb.reverse());

	}

}
