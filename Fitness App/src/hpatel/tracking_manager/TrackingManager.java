/**
 * 
 */
package hpatel.tracking_manager;

import java.util.ArrayList;
import java.util.Scanner;

import hpatel.calendar.Year;



/**
 * @author Harsh Patel
 *
 */
public class TrackingManager {

	/** Single static instance of a TrackingManager */
	private static TrackingManager manager;
	
	public ArrayList<Year> years;
	
	/** Constructs a TrackingManager */
	private TrackingManager() {
		years = new ArrayList<Year>(5);
	}
	
	/**
	 * Gets an instance of a RequirementsManager 
	 * @return singleton The single instance of the RequirementsManager that should be active
	 */
	public static TrackingManager getInstance() {
		if (manager == null) {
			manager = new TrackingManager();
		}
		return manager;
	}
	
	/**
	 * Sets the singleton to null 
	 */
	protected void resetManager() {
		manager = null;
	}
	
	public void updateInputs() {
		Year y = new Year( 2023 );
		years.add(y);
		y.addMonth("January");
		y.addMonth("February");
		y.addMonth("March");
		y.addMonth("April");
		y.addMonth("May");
		y.addMonth("June");
		y.addMonth("July");
		y.addMonth("August");
		y.addMonth("September");
		y.addMonth("October");
		y.addMonth("November");
		y.addMonth("December");

		
		y.getMonth(0).addDay(0, 160);
		y.getMonth(0).addDay(1, 159);
		y.getMonth(0).addDay(2, 180);
		y.getMonth(0).addDay(3, 160);
		y.getMonth(0).addDay(4, 160);
		y.getMonth(0).addDay(5, 175);
		y.getMonth(0).addDay(6, 160);
		y.getMonth(0).addDay(7, 155);
		y.getMonth(0).addDay(8, 164);
		y.getMonth(0).addDay(9, 163);
		y.getMonth(0).addDay(10, 162);
		y.getMonth(0).addDay(11, 163);
		y.getMonth(0).addDay(12, 165);

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println( "HELLO THERE STRANGER" );
		
		getInstance();

		manager.updateInputs();
		
		// read in the current file for our data
		Scanner input = new Scanner(System.in);
		
		
		System.out.print( "cmd> " );
		
		String line = input.nextLine();
		
		
		// allow the user to quit the program, otherwise keep talking to them
		while ( !line.equals("quit") ) {
			// continue forever haahahahhahahahaha
			System.out.println( "User input: " + line);
			
			System.out.print( "cmd> " );

			line = input.nextLine();
		}
		
		// Print out default info before we leave, such as the latest day's information for them
		System.out.println( "Year " + manager.years.get(0).getYear() );
		System.out.println( "Month " + manager.years.get(0).getMonth(0).getName() );
		System.out.println( "Day " + manager.years.get(0).getMonth(0).getDay(0).getDay());
		System.out.println( "Day " + manager.years.get(0).getMonth(0).getDay(0).getWeight());

		System.out.println( "Day " + manager.years.get(0).getMonth(0).getDay(1).getDay());
		System.out.println( "Day " + manager.years.get(0).getMonth(0).getDay(1).getWeight());

		System.out.println( "Day " + manager.years.get(0).getMonth(0).getDay(2).getDay());
		System.out.println( "Day " + manager.years.get(0).getMonth(0).getDay(2).getWeight());

		System.out.println( "Day " + manager.years.get(0).getMonth(0).getDay(3).getDay());
		System.out.println( "Day " + manager.years.get(0).getMonth(0).getDay(3).getWeight());

		
		input.close();
	}

}
