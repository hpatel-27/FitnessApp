/**
 * 
 */
package hpatel.calendar;

import java.util.ArrayList;

/**
 * @author Harsh Patel
 *
 */
public class Year {
	
	private int year;
		
	private ArrayList<Months> months;
	// hello
	public Year(int year) {
		setYear(year);
		months = new ArrayList<Months>( 12 );
	}
	
	/* Setter for the year field, cannot be changed once made */
	private void setYear( int day ) {
		this.year = day;
	}
	
	/** Gets the year value for the object */
	public int getYear() {
		return this.year;
	}
	
	public Months addMonth( String name ) {
		Months m = new Months( name );
		months.add( m );
		
		return m;
	}
	
	public Day addDay( int month, int day, double weight ) {
		Day d = months.get(month).addDay( day, weight );
		
		return d;
	}
	public Months getMonth( int month ) {
		if ( month < 0 || month > 12 ) {
			return null;
		}
		
		// return the month that we want to get
		return months.get(month);
	}
	
	public Day getDay(int month, int day) {
		
		return getMonth( month ).getDay(day);

	}
}
