/**
 * 
 */
package hpatel.calendar;

//import java.util.ArrayList;

/**
 * Represents a day of the month, holding the day number and the morning weight for that day.
 * Also, allows for access to the day and weight, but cannot change that value after it was created
 * 
 * @author Harsh Patel
 *
 */
public class Days {

	/* A day of the month */
	private int day;
	
	/* Recorded weight for this day */
	private double weight;
	
	// TODO: Make the exercise functionality in the future
	/** The list of exercise done for the day */
//	private ArrayList<Exercise> exercises;
	
	public Days(int day, double weight) {
		setDay(day);
		setWeight(weight);
	}
	
	/* Setter for the weight field, cannot be changed once made */
	public void setWeight(double weight) {
		if ( weight < 0 ) {
			throw new IllegalArgumentException("Error day input given!");
		}
		if ( weight < 150.0 ) {
			throw new IllegalArgumentException("Bruh...");
		}
		
		this.weight = weight;
	}
	
	/* Setter for the day field, cannot be changed once made */
	public void setDay(int day) {
		if ( day < 0 ) {
			throw new IllegalArgumentException("Error day input given!");
		}
		this.day = day;
	}
	
	/** Gets the day value for the object */
	public int getDay() {
		return this.day;
	}
	
	/** Gets the morning weight of the day */
	public double getWeight() {
		return this.weight;
	}
}
