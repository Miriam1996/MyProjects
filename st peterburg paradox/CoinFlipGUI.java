/**
 * @author Miriam Schnoll
 */
import java.awt.*;
import javax.swing.JFrame;

public class CoinFlipGUI extends JFrame {
	static Container myContentPane;
	//text area for the GUI
	TextArea money = new TextArea();

	public CoinFlipGUI(String Title, int height, int width) {
		setTitle(Title);
		setSize(height, width);
		setLocation(200, 200);// x, y);
		myContentPane = getContentPane();
		myContentPane.add(money);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	/**
	 * print out number of game played
	 * @param n is the number of games
	 * puts winnings per n games on GUI
	 * @param winnings is the winnings
	 */

	public void addWinnings(int n, double winnings) {
		money.append("game " + n + " played: " + "$" + Math.floor(winnings*100)/100);
		money.append("\n");
	}

}
