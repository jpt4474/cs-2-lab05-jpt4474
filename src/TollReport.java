/**
 * Displays information on vehicles and trips, then gives
 * specific information based on the user's requests
 *
 * @author Jacob Taloricco
 */
public class TollReport {
    public static void main(String[] args){
        if(args.length!=1){
            System.out.println("Usage: java TollReport event-file");
            System.exit(1);
        }

        TollRoadDatabase database = new TollRoadDatabase(args[0]);
    }
}
