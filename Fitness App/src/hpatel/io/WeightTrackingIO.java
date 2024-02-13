package hpatel.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import hpatel.calendar.Days;
import hpatel.calendar.Months;
import hpatel.calendar.Years;

/**
 * @author Harsh Patel
 *
 */
public class WeightTrackingIO {

	/**
	 * IO constructor
	 */
	public WeightTrackingIO() {
		//Empty constructor
	}
	
	private static void processYear( Scanner scan, Years y ) {
		// we have already read the year,
		// next line should have the month name ONLY
		if ( scan.hasNextLine() ) {
			String line = scan.nextLine();
			
			switch (line) {
			
			case "January":
				break;
			case "February":
				break;
			case "March":
				break;	
			case "April":
				break;
			case "May":
				break;
			case "June":
				break;
			case "July":
				break;
			case "August":
				break;
			case "September":
				break;
			case "October":
				break;
			case "November":
				break;
			case "December":
				break;
			default:
				System.err.println( "File Reading Error!" );
				throw new IllegalArgumentException();
			}
		}
		
		
	}
	
	
	/**
	 * The data is pre-sorted for me
	 */
	public static ArrayList<Months> readFile(String filename) {
		
		try {
			Scanner fileReader = new Scanner(new FileInputStream(filename));
			ArrayList<Years> y = new ArrayList<Years>();
			
			while ( fileReader.hasNextLine() ) {
				
				
				// read the year line and then process the info for the year
				String line = fileReader.nextLine();
				String sub = line.substring(0, 4);
				
				// if the line we read gives the year
				if ( sub.equals( "Year" ) ) {
					// account for the space between the word and the value and read the year
					String rest = line.substring(5);
					int num = Integer.parseInt(rest);
					
					// create the year with the given value
					Years n = new Years( num );
					
					// create months for this year (originally empty, unless there is data for any of the days
					n.addMonth("January");
					n.addMonth("February");
					n.addMonth("March");
					n.addMonth("April");
					n.addMonth("June");
					n.addMonth("July");
					n.addMonth("August");
					n.addMonth("September");
					n.addMonth("October");
					n.addMonth("November");
					n.addMonth("Decemeber");
					
					processYear( fileReader, n );
					
					
					
					y.add(n);
					
					
					
				}
			}
			String fileRep = "";
			// for each day
			while (fileReader.hasNextLine()) {
				fileRep = fileReader.nextLine() + "\n";
				readLine(fileRep);
			}
			fileReader.close();

		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		
		return null;
	}
	
	private static Months readLine( String line ) {
		Scanner in = new Scanner( line );
		
		// we will have the month string, day num, year num, and then the weight
		String monthString = in.next();
		int day = in.nextInt();
		int year = in.nextInt();
		double weight = in.nextDouble();
		
		Years y = new Years(year);
		Days d = new Days(day, weight);
		
				
		Months m = new Months(monthString);
		return m;
	}

}
