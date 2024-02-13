/**
 * 
 */
package hpatel.calendar;

import java.util.ArrayList;

/**
 * @author Harsh Patel
 *
 */
public class Years {
	
	private static final int MAX_MONTHS = 12;
	
	private static final int MIN_MONTHS = 1;

	
	private int year;
		
	
	private ArrayList<Months> months;
	
	
	public Years(int year) {
		setYear(year);
		months = new ArrayList<Months>( MAX_MONTHS );
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
	
	public Days addDay( int month, int day, double weight ) {
		Days d = months.get(month).addDay( day, weight );
		
		return d;
	}
	public Months getMonth( int month ) {
		if ( month < MIN_MONTHS || month > MAX_MONTHS ) {
			return null;
		}
		
		// return the month that we want to get
		return months.get(month);
	}
	
	public Days getDay(int month, int day) {
		
		return getMonth( month ).getDay(day);

	}
}
