
/**
 * Project 1 
 * @author Miriam Schnoll
 */

import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class Project1Main {
	// write separate text files for costumer
	/**
	 * this method fills the orders
	 * 
	 * @param currentorder
	 *            is the widget holding the order
	 * @param ship
	 *            is the stack of inventory
	 * @param order
	 *            is the queue being passed in if the stack is empty then the
	 *            queue will be refilled
	 * @return an object array containing the stack and queue
	 */
	public static Object[] fillorders(Widgets currentorder, Stack ship, Queue order) {
		// price that widget is sold off for
		int amountfilled = 0;
		int amount = currentorder.getAmount();
		int original_amount = currentorder.getAmount();
		// store top widget from stack in inventory

		Widgets inventory = ship.pop();

		// get price from inventory for book keeping
		double inventory_price = inventory.getCost();
		// get amount at that cost for book keeping
		int inventory_amount = inventory.getAmount();
		// as long as there is an order amount to fill
		while (amount != 0) {
			/*
			 * if no more shippments put remaining amount of order on back order
			 * on current price
			 */
			if (inventory_amount > amount) {
				amountfilled = original_amount;
				// inventory is pushed back on stack with remaining amount
				inventory.setAmount(inventory_amount - amount);
				ship.push(inventory);
				// print out book keeping and receipt
				book_keeping(amount, inventory_price);
				amount = 0;
				break;

			}
			/*
			 * there's more in the order to fill besides the amount of the very
			 * top of the stack of shipments
			 */
			else {
				amountfilled += inventory_amount;
				amount -= inventory_amount;
				currentorder.setAmount(amount);
				book_keeping(inventory_amount, inventory_price);
				/*
				 * more in order to fill but inventory is empty put widget in
				 * new queue called replace and move everything from old queue
				 * into new queue set order to replace
				 */
				if (ship.isEmpty()) {

					Queue replace = new Queue();
					replace.EnQ(currentorder);
					while (!order.isEmpty()) {
						replace.EnQ(order.DeQ());
						order = replace;
						break;
					}
				}
				/*
				 * there's more inventory pop the stack and continue to fill the
				 * order get new inventory top cost for book keeping get new
				 * inventory amount needed to fill the order
				 */
				else {
					inventory = ship.pop();
					amount = currentorder.getAmount();
					inventory_price = inventory.getCost();

					inventory_amount = inventory.getAmount();

				}
			}
		}
		costumer_receipt(amountfilled, currentorder.getCost());
		// put stack and queue into object array
		Object array[] = new Object[2];
		array[0] = order;
		array[1] = ship;
		return array;
	}

	/**
	 * this method prints a costumer receipt
	 * 
	 * @param amount
	 *            amount of widgets the costumer wants
	 * @param cost
	 *            the cost of the widgets
	 */

	public static void costumer_receipt(int amount, double cost) {
		double price = cost * amount;
		System.out.println("Costumer receipt:");
		System.out.print(amount + " @ $");
		//makes only 2 decimals
		System.out.printf("%.2f", cost);
		System.out.print(" = $");
		System.out.printf("%.2f", price);
		System.out.println("\n");
	}

	/**
	 * this method prints out the book keeping the actual amount the widgets
	 * cost
	 * 
	 * @param amount
	 *            of widgets
	 * @param cost
	 *            of widgets
	 */
	public static void book_keeping(int amount, double cost) {
		// total price
		double price = cost * amount;
		System.out.println("actual cost:");
		System.out.print(amount + " @ $");
		System.out.printf("%.2f", cost);
		System.out.print(" = $");
		System.out.printf("%.2f", price);
		System.out.println("\n");
	}

	public static void main(String args[]) throws FileNotFoundException {
		// read in file
		// file that is read from
		try{
		File inputFile = new File("transactions.txt");
		Scanner in = new Scanner(inputFile);
		/*
		 * The Stack shipments hold the shipments of widgets The Queue orders
		 * hold the back orders of widgets
		 */
		Stack shipments = new Stack();
		Queue orders = new Queue();
		Widgets ship;
		// array holds line split up
		String[] splited;
		double currentCost = 0.0;
		while (in.hasNextLine()) {
			// gets line in file
			String line = in.nextLine();
			splited = line.split(" ");
			// R receives shipments
			// push on stack
			if (line.charAt(0) == 'R') {
				// how each line being split by spaces
				ship = new Widgets(Integer.parseInt(splited[1]), Double.parseDouble(splited[2]));
				// cost for widgets sold off gets updated when new shipments
				// come in
				currentCost = Double.parseDouble(splited[2]) * 1.40;
				// add shipments to stack
				shipments.push(ship);
				// are there back orders to fill
				while (!orders.isEmpty() && !shipments.isEmpty()) {
					// put top order into widgets
					Widgets currentorder = orders.DeQ();
					Object array[] = fillorders(currentorder, shipments, orders);
					orders = (Queue) array[0];
					shipments = (Stack) array[1];
				}
			} else {
				// line is split using splitter
				int amountordered = Integer.parseInt(splited[1]);
				// fill the order coming in into a widget
				Widgets currentorder = new Widgets(amountordered, currentCost);
				/*
				 * if the stack of shipments isn't empty then fill orders
				 * otherwise put the order in the queue
				 */
				if (!shipments.isEmpty()) {
					Object array[] = fillorders(currentorder, shipments, orders);
					orders = (Queue) array[0];
					shipments = (Stack) array[1];
				} else
					orders.EnQ(currentorder);

			}

		}
		// close file

		in.close();
		}
		
		catch (FileNotFoundException fnfe){
			System.out.print("file not found");
		}
		
	}
}