/* A few useful items are provided to you. You must write the rest. */
/**
 * Stores and displays information about trips on a highway
 *
 * @author Jacob Taloricco
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.lang.Math;
import java.util.*;


public class TollRoadDatabase {
    /**Name of file*/
    private String eventFileName;
    /**Stores incomplete trips*/
    private ArrayList<TollRecord> incomplete;
    /**Stores complete trips*/
    private ArrayList<TollRecord> complete;
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
    public TollRoadDatabase(String eventFileName)throws Exception{
        this.eventFileName = eventFileName;
        File file = new File(this.eventFileName);

        incomplete = new ArrayList<TollRecord>();
        complete = new ArrayList<TollRecord>();


        Scanner scan = new Scanner(file);


        while(scan.hasNextLine()){
            String s = scan.nextLine();
            String arr[] = s.split(",");
            enterEvent(Integer.parseInt(arr[0]),arr[1],Integer.parseInt(arr[2]));
        }

        Collections.sort(incomplete);
        Collections.sort(complete);

    }

    /**
     * Used to enter items into the database
     */
    private void enterEvent(int time, String tag, int exit){
        boolean newTrip = true;
        for(int x = 0; x < incomplete.size(); x++){
            if(incomplete.get(x).getTag().equals(tag)){
                incomplete.get(x).setOffExit(exit,time);
                complete.add(incomplete.get(x));
                incomplete.remove(x);
                newTrip = false;
                break;
            }
        }
        if(newTrip==true){
            TollRecord trip = new TollRecord(tag,exit,time);
            incomplete.add(trip);
        }
    }

    /**
     * Print out the number of completed trips
     */
    public void summaryReport(){
        System.out.println(complete.size()+" completed trips"+NL);
    }

    /**
     * Print out a report listing vehicles on the road in order based on tag
     */
    public void onRoadReport(){
        //Sort using compareTo
        System.out.println("On-Road Report"+NL+"===========");
        for(int x = 0; x < incomplete.size(); x++){
            System.out.println(incomplete.get(x).report());
        }
        System.out.println(NL);
    }

    /**
     * Print out a billing report for vehicles that completed trips
     */
    public void printBills(){
        System.out.println("BILLING INFORMATION"+NL+"===========");
        double total = 0;
        for(int x = 0; x < complete.size(); x++){
            total+=bill(complete.get(x).getTag());
        }
        System.out.println("Total: $"+total+NL);
    }

    /**
     * Creates a new bill
     */
    private double bill(String tag){
        double total = 0;
        for(int x = 0; x < complete.size(); x++){
            if(complete.get(x).getTag().equals(tag)){
                System.out.println(complete.get(x).report()+": $"+Math.round(complete.get(x).getFare()*100.0)/100.0);
                total += complete.get(x).getFare();
            }
        }
        return Math.round(total*100.0)/100.0;
    }

    /**
     * List cars going over the speed limit
     */
    public void speederReport(){
        System.out.println("SPEEDER REPORT"+NL+"===========");
        for(int x = 0; x < complete.size(); x++){
            double speed = (((TollSchedule.getLocation(complete.get(x).getOnExit())-TollSchedule.getLocation(complete.get(x).getOffExit()))/(double)(complete.get(x).getOffTime()-complete.get(x).getOnTime()))*60);
            if(speed>65){
                System.out.println("Vehicle "+complete.get(x).getTag()+", starting at time "+complete.get(x).getOnTime()+NL
                +" from "+TollSchedule.getInterchange(complete.get(x).getOnExit())+NL
                +" to "+TollSchedule.getInterchange(complete.get(x).getOffExit())+NL+Math.round(speed*100.0)/100.0+" MpH"+NL);
            }
        }
    }

    /**
     * Prints the summary for a single customer, specified by tag
     */
    public void printCustSummary(String tag){
        double total = bill(tag);
        System.out.println(NL+"Vehicle total due: $"+total);

    }

    /**
     * Prints all toll records with a specific exit as their on or off point,
     * with completed records listed first
     */
    public void printExitActivity(int exit){
        for(int x = 0; x < complete.size(); x++){
            if(complete.get(x).getOffExit()==exit||complete.get(x).getOnExit()==exit){
                System.out.println(complete.get(x).report());
            }
        }
        for(int x = 0; x < incomplete.size(); x++){
            if(incomplete.get(x).getOnExit()==exit){
                System.out.println(incomplete.get(x).report());
            }
        }
    }


}
