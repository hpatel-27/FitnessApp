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

    private static final int  MAX_MONTHS = 12;

    private static final int  MIN_MONTHS = 1;

    private int               year;

    private ArrayList<Months> months;

    public Years ( int year ) {
        // set the year value
        setYear( year );

        // the 12 months that every year must have
        months = new ArrayList<Months>( MAX_MONTHS );

        // add these 12 months
        addMonth( "January" );
        addMonth( "February" );
        addMonth( "March" );
        addMonth( "April" );
        addMonth( "May" );
        addMonth( "June" );
        addMonth( "July" );
        addMonth( "August" );
        addMonth( "September" );
        addMonth( "October" );
        addMonth( "November" );
        addMonth( "December" );

    }

    /* Setter for the year field, cannot be changed once made */
    private void setYear ( int day ) {
        this.year = day;
    }

    /** Gets the year value for the object */
    public int getYear () {
        return this.year;
    }

    private Months addMonth ( String name ) {
        if ( name == null || name.length() == 0 ) {
            throw new IllegalArgumentException( "Month name not provided! Please provide the name of the month" );
        }

        Months m = new Months( name );
        months.add( m );

        return m;
    }

    public Days addDay ( int month, int day, double weight ) {

        if ( month < MIN_MONTHS || month > MAX_MONTHS ) {
            throw new IllegalArgumentException( "Provided month is out of range!" );
        }

        Days d = months.get( month - 1 ).addDay( day, weight );

        return d;
    }

    public Months getMonth ( int month ) {
        if ( month < MIN_MONTHS || month > MAX_MONTHS ) {
            return null;
        }

        // return the month that we want to get
        return months.get( month - 1 );
    }

    public ArrayList<Months> getMonths () {
        return months;
    }

    public Days getDay ( int month, int day ) {

        return getMonth( month ).getDay( day );

    }
}
