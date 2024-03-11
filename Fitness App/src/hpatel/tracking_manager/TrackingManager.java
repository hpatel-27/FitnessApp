/**
 *
 */
package hpatel.tracking_manager;

import java.util.ArrayList;
import java.util.Scanner;

import hpatel.calendar.Years;
import hpatel.io.WeightTrackingIO;

/**
 * @author Harsh Patel
 *
 */
public class TrackingManager {

    /** Single static instance of a TrackingManager */
    private static TrackingManager manager;

    public ArrayList<Years>        years;

    /** Constructs a TrackingManager */
    private TrackingManager () {
        years = new ArrayList<Years>( 5 );
    }

    /**
     * Gets an instance of a RequirementsManager
     *
     * @return singleton The single instance of the RequirementsManager that
     *         should be active
     */
    public static TrackingManager getInstance () {
        if ( manager == null ) {
            manager = new TrackingManager();
        }
        return manager;
    }

    /**
     * Sets the singleton to null
     */
    protected void resetManager () {
        manager = null;
    }

    public ArrayList<Years> getYears () {
        return manager.years;
    }

    // Test function to test the operations on the calendar classes
    private void updateInputs () {
        Years y = new Years( 2023 );
        Years y2 = new Years( 2024 );

        ArrayList<Years> ys = manager.getYears();

        y.addDay( 1, 0, 160 );
        y.addDay( 1, 1, 159 );
        y.addDay( 1, 2, 180 );
        y.addDay( 2, 3, 160 );
        y.addDay( 2, 4, 160 );
        y.addDay( 4, 5, 175 );
        y.addDay( 3, 6, 160 );
        y.addDay( 5, 7, 155 );
        y.addDay( 2, 8, 164 );
        y.addDay( 6, 9, 163 );
        y.addDay( 10, 10, 162 );
        y.addDay( 12, 11, 163 );
        y.addDay( 2, 12, 165 );

        ys.add( y );
        ys.add( y2 );

    }

    /**
     * @param args
     */
    public static void main ( String[] args ) {

        getInstance();

        manager.updateInputs();

        // read in the current file for our data
        Scanner input = new Scanner( System.in );

        System.out.print( "cmd> " );

        String line = input.nextLine();

        System.out.println( "Line " + line );
        // allow the user to quit the program, otherwise keep talking to them
        while ( !line.equals( "quit" ) ) {
            // continue forever haahahahhahahahaha
            System.out.println( "User input: " + line );

            System.out.print( "cmd> " );

            line = input.nextLine();
        }

        // Print out default info before we leave, such as the latest day's
        // information for them

        ArrayList<Years> output = manager.getYears();
        //
        // System.out.println( "Number of years in the list : " + output.size()
        // );
        //
        // System.out.println();
        // Years year = output.get( 0 );
        // System.out.println( "Year " + year.getYear() );
        //
        // for ( int i = 0; i < year.getMonths().size(); i++ ) {
        // Months m = year.getMonth( i + 1 );
        // System.out.println( "Month " + m.getName() );
        // for ( int j = 0; j < m.getDays().size(); j++ ) {
        // Days d = m.getDay( j + 1 );
        // System.out.println( "Day " + ( d.getDay() ) + " Weight " +
        // d.getWeight() );
        // }
        // }
        input.close();

        WeightTrackingIO.readFile( "Bulk.csv" );
    }

}
