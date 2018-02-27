/* A few useful items are provided to you. You must write the rest. */
import java.util.Scanner;

public class TollRoadDatabase {
    /**Name of file*/
    private String eventFileName;
    /**
     * For printing floating point values in dollar/cents format. Example:
     * System.out.println( String.format( DOLLAR_FORMAT, 10.5 );  // $10.50
     */
    private static final String DOLLAR_FORMAT = "$%5.2f";
    private static final String SPEED_FORMAT = "%5.1f MpH";

    /**
     * Universal new line
     */
    private static final String NL = System.lineSeparator();

    /**
     * Conversion constant from minutes to hours
     */
    public static final double MINUTES_PER_HOUR = 60.0;

    /**
     * This toll road's speed limit, in miles per hour
     */
    public static final double SPEED_LIMIT = 65.0;

    /**
     * TollRoadDatabase Constructor
     */
    public TollRoadDatabase(String eventFileName){
        this.eventFileName = eventFileName;
        Scanner scan = new Scanner(eventFileName);

    }

    /**
     * Used to enter items into the database
     */
    private void enterEvent(String tag, int exit, int time){

    }

    /**
     * Print out the number of completed trips
     */
    public void summaryReport(){

    }

    /**
     * Print out a report listing vehicles on the road in order based on tag
     */
    public void onRoadReport(){

    }

    /**
     * Print out a billing report for vehicles that completed trips
     */
    public void printBills(){

    }

    /**
     * Creates a new bill
     */
    private double bill(String tag){
        return 5;
    }

    /**
     * List cars going over the speed limit
     */
    public void speederReport(){

    }

    /**
     * Prints the summary for a single customer, specified by tag
     */
    public void printCustSummary(String tag){

    }

    /**
     * Prints all toll records with a specific exit as their on or off point,
     * with completed records listed first
     */
    public void printExitActivity(int exit){

    }


}
