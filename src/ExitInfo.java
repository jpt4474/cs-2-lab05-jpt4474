/**
 * Information about a single exit.
 * It is a utility class used by {@link TollSchedule} to store information about
 * the setup of exits on a particular highway
 *
 * @author James Heliotis
 */
public class ExitInfo {

    /** The number of this exit */
    private int exitNum;

    /** The official long-winded name of this exit */
    private String name;

    /** The distance of this exit from the beginning of the toll road */
    private double location;

    /**
     * Create a new exit
     * @param exitNum number of this exit
     * @param name official long-winded name of this exit
     * @param location distance of this exit from the beginning of the toll road
     */
    public ExitInfo( int exitNum, String name, double location ) {
        this.exitNum = exitNum;
        this.name = name;
        this.location = location;
    }

    /**
     * @return this exit's number
     */
    public int getExitNum() {
        return exitNum;
    }

    /**
     * @return this exit's long-winded name
     */
    public String getName() {
        return name;
    }

    /**
     * @return this exit's distance from the beginning of the toll road
     */
    public double getLocation() {
        return location;
    }
}
