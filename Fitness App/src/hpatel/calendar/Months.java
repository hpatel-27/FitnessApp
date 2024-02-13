/**
 * 
 */
package hpatel.calendar;

import java.util.ArrayList;

/**
 * @author Harsh Patel
 *
 */
public class Months {
	
//	public static final Months January = 1;
//	private static Months single;
	
	private int month;
	
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
		this.name = month;
		
		switch (month) {
		
		case "January":
			this.month = 1;
			days = new ArrayList<Days>(31);
			break;
		case "February":
			this.month = 2;
			days = new ArrayList<Days>(28);
			break;
		case "March":
			this.month = 3;
			days = new ArrayList<Days>(31);
			break;	
		case "April":
			this.month = 4;
			days = new ArrayList<Days>(30);
			break;
		case "May":
			this.month = 5;
			days = new ArrayList<Days>(30);
			break;
		case "June":
			this.month = 6;
			days = new ArrayList<Days>(31);
			break;
		case "July":
			this.month = 7;
			days = new ArrayList<Days>(31);
			break;
		case "August":
			this.month = 8;
			days = new ArrayList<Days>(31);
			break;
		case "September":
			this.month = 9;
			days = new ArrayList<Days>(30);
			break;
		case "October":
			this.month = 10;
			days = new ArrayList<Days>(31);
			break;
		case "November":
			this.month = 11;
			days = new ArrayList<Days>(30);
			break;
		case "December":
			this.month = 12;
			days = new ArrayList<Days>(31);
			break;
		default:
			break;
		}
	}
	
	public int getMonth() {
		return this.month;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public Days getDay(int day) {
		if ( day < 0 || day > 31 ) {
			return null;
		}
		
		return days.get(day);
	}
	
	public Days addDay(int day, double weight) {
		Days d = new Days( day, weight );
		days.add(d);
		return d;
	}
	
}
