/* A few useful items are provided to you. You must write the rest. */
/**
 * Class used for determining toll based off relevant information
 *
 * @author Jacob Taloricco
 */
import java.lang.Math;

public class TollRecord implements Comparable<TollRecord>{
    /**
     * Keeps track of tag
     */
    private String tag;
    /**
     * Exit vehicle entered from
     */
    private int onExit;
    /**
     * Time vehicle entered road
     */
    private int onTime;
    /**
     * Exit where vehicle left road
     */
    private int offExit = UNINITIALIZED;
    /**
     * Time when vehicle left road
     */
    private int offTime = UNINITIALIZED;

    /**
     * For printing toll records in reports
     * using {@link String#format(String, Object...)}
     */
    private static final String TOLL_RECORD_FORMAT = "[%11s] on #%2d, time %5d";
    private static final String OFF_FORMAT = "; off #%2d, time %5d";

    /**
     * Value of uninitialized integer fields in this record
     */
    public static final int UNINITIALIZED = -1;

    /**
     * TollRecord Constructor
     */
    public TollRecord(String tag,int onExit,int onTime){
        tag = this.tag;
        this.onExit = onExit;
        this.onTime = onTime;
    }
    /**
     * Sets exit used and exit time of vehicle from the road
     */
    public void setOffExit(int offExit,int offTime){
        this.offExit = offExit;
        this.offTime = offTime;
    }
    /**
     * Getter for tag
     */
    public String getTag(){
        return tag;
    }
    /**
     * Getter for onExit
     */
    public int getOnExit(){
        return onExit;
    }
    /**
     * Getter for onTime
     */
    public int getOnTime(){
        return onTime;
    }
    /**
     * Getter for offExit
     */
    public int getOffExit(){
        return offExit;
    }
    /**
     * Getter for offTime
     */
    public int getOffTime(){
        return offTime;
    }
    /**
     * Computes toll paid by vehicle
     */
    public double getFare(){
        return TollSchedule.getFare(onExit,offExit);
    }
    /**
     * Determines if two TollRecord objects are the same
     */
    public boolean equals(Object o){
        if(o instanceof TollRecord){
            TollRecord a = (TollRecord) o;
            if(this.getOffTime()==(a.getOffTime())&&this.getOffExit()==(a.getOffExit())&&this.getOnExit()==(a.getOnExit())&&this.getOnTime()==(a.getOnTime())&&this.tag.equals(a.tag)){
                return true;
            }
        }
        return false;
    }
    /**
     * Returns a string representation of the object
     */
    public String toString(){
        if(offExit==-1){
            return "["+tag+"]{("+Integer.toString(onExit)+","+Integer.toString(onTime)+")}";
        }
        else{
            return "["+tag+"]{("+Integer.toString(onExit)+","+Integer.toString(onTime)+"),("+Integer.toString(offExit)+","+Integer.toString(offExit)+")}";
        }
    }
    /**
     * Returns a string representation of the record for use in reports
     */
    public String report(){
       return  "["+tag+"] on "+Integer.toString(onExit)+", time "+Integer.toString(onTime)+"; off "+offExit+", time "+offTime;
    }
    /**
     * Returns a hash code value
     */
    public int hashCode(){
        return (int)Math.pow(onExit,onTime);
    }
    /**
     * The natural order comparison for TollRecords
     */
    public int compareTo(TollRecord o){
        return tag.compareTo(o.tag);
    }

}
