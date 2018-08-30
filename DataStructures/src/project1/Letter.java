package project1;
import java.util.*;
import java.io.*;

public class Letter {

	public static void main(String[] args) throws IOException {
		File temp = new File("Sample.txt");
		Scanner input = new Scanner(temp);
		int row = 0;
		int col = 0;
		int stop1 = 0;
		int stop2 = 0;
		String message = "";
		do {
			String rowCounter = input.nextLine();
			if(rowCounter.equals("---")) {
				stop1 = 1;
			} else {
				row++;
			}
		}while(stop1 == 0);
		do {
			String rowCounter = input.nextLine();
			if(rowCounter.equals("---")) {
				message+=rowCounter;
				stop2 = 1;
			} else {
				message+=rowCounter + "\n";
			}
		}while(stop2 == 0);
		input.close();
		input = new Scanner(temp);
		String[] tags = input.nextLine().split(" ");
		col = tags.length;
		input.close();
		input = new Scanner(temp);
		String[][] data = new String[row][col];
		for (int j = 0; j < row; j++) {
			for(int k = 0; k < col; k++) {
				data[j][k] = input.next();
			}
		}
		input.close();
		String changer = message.substring(0);
		for(int j = 1; j < row; j++) {
			for (int k = 0; k < col; k++) {
				//System.out.println(data[0][k] + ", " + data[j][k]);
				changer = changer.replaceAll(data[0][k], data[j][k]);
			}
			System.out.println(changer);
			changer=message.substring(0);
		}
	}

}
