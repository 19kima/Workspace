/**
 * COSC 2100 - Project 1
 * Explain briefly the functionality of the class.
 * @author Andrew Kim
 * Instructor Brylow
 * TA-BOT:MAILTO andrew.y.kim@marquette.edu
 */
package project1;
import java.util.*;
import java.io.*;

public class Letter {

	public static void main(String[] args) throws IOException {
		File temp = new File("Sample.txt");
		Scanner input = new Scanner(temp);
		int row = 0;
		int col = 0;
		int stop = 0;
		String message = "";
		if (input.hasNextLine()) {						//Check for empty file
			do {
				String rowCounter = input.nextLine();	
				if(rowCounter.equals("---")) {
					stop = 1;
				} else {
					row++;								//row counter
				}
			}while(stop == 0);
			while (input.hasNextLine()) {				//Record mail message
				message+=input.nextLine() + "\n";
			}
			message+= "---";
			input.close();
			input = new Scanner(temp);
			col = input.nextLine().split(" ").length;	//col counter
			boolean allGood = true;
			for (int i = 1; i < row; i++) {
				if (input.nextLine().split(" ").length != col) {		//check if all the rows have same amount of col
					allGood = false;
				}
			}
			input.close();
			if (allGood == true) {
				input = new Scanner(temp);
				String[][] data = new String[row][col];				//fill arrays
				for (int j = 0; j < row; j++) {
					for(int k = 0; k < col; k++) {
						data[j][k] = input.next();
					}
				}
				input.close();
				String changer = new String(message);
				for(int j = 1; j < row; j++) {
					for (int k = 0; k < col; k++) {
						changer = changer.replaceAll(data[0][k], data[j][k]);	//change message
					}
					System.out.println(changer);
					changer=new String(message);
				}
			}
		}
	}

}