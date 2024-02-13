/**
 * 
 */
package hpatel.calendar;

import java.util.ArrayList;

import hpatel.enums.MonthType;

/**
 * @author Harsh Patel
 *
 */
public class Months {
	
//	public static final Months January = 1;
//	private static Months single;
	
	// this is actually day 31, but indexes start at 0
	private static final int MAX_DAY = 30;

	// this is actually day 1, but indexes start at 0
	private static final int MIN_DAY = 0;

	private MonthType month;
	
	private String name; 
	
	private ArrayList<Days> days;
	

	// Set the month int depending on what the string was; 
	public Months(String month) {
		// will set the month field as int and will initialize the days List with the correct number of days
		setMonth(month);
//		// at least 28 days, so we can save some resizing time, without wasting space
//		days = new ArrayList<Day>(31);
	}
	
//	public Months() {
//		this( null );
//	}
//
//	/**
//	 * Gets an instance of a RequirementsManager 
//	 * @return singleton The single instance of the RequirementsManager that should be active
//	 */
//	public static Months getInstance() {
//		if (single == null) {
//			single = new Months();
//		}
//		return single;
//	}
	
//	/**
//	 * Sets the singleton to null 
//	 */
//	protected void resetMonth() {
//		single = null;
//	}

//	public void setYear(Year year) {
//		this.year = year;
//	}


	public void setMonth(String month) {
		
		switch (month) {
		
		case "January":
			this.month = MonthType.JANUARY;
			days = new ArrayList<Days>(31);
			break;
		case "February":
			this.month = MonthType.FEBRUARY;
			days = new ArrayList<Days>(28);
			break;
		case "March":
			this.month = MonthType.MARCH;
			days = new ArrayList<Days>(31);
			break;	
		case "April":
			this.month = MonthType.APRIL;
			days = new ArrayList<Days>(30);
			break;
		case "May":
			this.month = MonthType.MAY;
			days = new ArrayList<Days>(30);
			break;
		case "June":
			this.month = MonthType.JUNE;
			days = new ArrayList<Days>(31);
			break;
		case "July":
			this.month = MonthType.JULY;
			days = new ArrayList<Days>(31);
			break;
		case "August":
			this.month = MonthType.AUGUST;
			days = new ArrayList<Days>(31);
			break;
		case "September":
			this.month = MonthType.SEPTEMBER;
			days = new ArrayList<Days>(30);
			break;
		case "October":
			this.month = MonthType.OCTOBER;
			days = new ArrayList<Days>(31);
			break;
		case "November":
			this.month = MonthType.NOVEMBER;
			days = new ArrayList<Days>(30);
			break;
		case "December":
			this.month = MonthType.DECEMBER;
			days = new ArrayList<Days>(31);
			break;
		default:
			throw new IllegalArgumentException( "No valid month given!");
//			break;
		}
		
		// wait to set the month string until after the switch in case there wasn't a match found for it, 
		// so that we can send it to the IAE
		this.name = month;

	}
	
	// Return the month as the enumerated type
	public MonthType getMonth() {
		return this.month;
		
	}
	
	// Return the month as a string of the month name
	public String getName() {
		return this.name;
	}
	
	// Return the requested day of the month
	public Days getDay(int day) {
		if ( day < MIN_DAY || day > MAX_DAY ) {
			throw new IllegalArgumentException( "Error day input given!" );
		}
		
		return days.get(day);
	}
	
	// Add a day to the month's list and return the day that was created
	public Days addDay(int day, double weight) {
		Days d = new Days( day, weight );
		days.add(d);
		return d;
	}
	
	public Days removeDay( int day ) {
		if ( day < MIN_DAY || day > MAX_DAY ) {
			throw new IllegalArgumentException( "Error day input given!" );
		}
		return days.remove(day);
		
		
	}
}
