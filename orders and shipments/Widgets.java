/**
 * Project 1 
 * @author Miriam Schnoll
 * class of widgets hold
 * amount of widgets and cost
 *
 */
public class Widgets extends Object {
	private double cost;
	private int amount;
	public Widgets(int a, double c){
		if (c<0 || a<0)
			throw new IllegalArgumentException("invalid cost or amount ordered");
		cost =c;
		amount =a;
	}
	/**
	 * it gets the cost of a widget
	 * @return
	 */
	public double getCost (){
		return cost;
	}
	/**
	 * it gets the amount of widgets
	 * 
	 * @return
	 */
	public int getAmount(){
		return amount;
	}
	public void setCost(double c){
		if (c<0)
			throw new IllegalArgumentException("invalid cost");
		cost =c;
		
	}
	public void setAmount(int a){
		if(a<0)
			throw new IllegalArgumentException("invalid amount");
		amount =a;
	}

}
