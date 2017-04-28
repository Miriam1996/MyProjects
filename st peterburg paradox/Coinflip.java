/**
 * @author Miriam Schnoll
 */
import java.util.Random;

public class Coinflip {
	/**
	 * pass in integer from a random function generating a 1 or 0
	 * 
	 * @param side
	 *            - either a 1 or 0
	 * @return whether it's heads or tails
	 */
	public static String Flip() {
		/*
		 * use the math random function to output 0 or 1 
		 * 1 is heads and 0 is tails
		 */
		int side = (0 + (int)(Math.random() * ((1 - 0) + 1)));
		if (side == 1)
			return "Heads";
		else
			return "Tails";
	}
	
	public static void main(String args[]) {
		CoinFlipGUI GUI = new CoinFlipGUI("Coin flip", 750, 500);
		String h = "";
		//money made per all games played
		int total=0;
		//play the game 100,000
		for (int i = 1; i <= 100000; i++) {
			int winnings=0;
			while (h != "heads") {
				 h= Flip();
				if (h.equals("Tails")) {
					if (winnings == 0)
						winnings = 2;
					else
						winnings *= 2;
					total += winnings;
				} else {
					//coin got heads end of game
					/*
					 * if winnings is 0
					 * then set it to 2  
					 * otherwise to multiply by 2
					 */
					if (winnings == 0)
						winnings = 2;
					else
						winnings *= 2;
					total += winnings;
					break;
				}
				//outcome and winning for that toss
				System.out.println(h);
				System.out.println(winnings);
				
			}
			//adds average outcome of n games on to GUI
			GUI.addWinnings(i,(double)total/i);
		
		}
	}
}
