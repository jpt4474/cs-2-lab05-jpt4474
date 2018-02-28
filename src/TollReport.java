/**
 * Displays information on vehicles and trips, then gives
 * specific information based on the user's requests
 *
 * @author Jacob Taloricco
 */
import java.util.Scanner;

public class TollReport {
    public static void main(String[] args)throws Exception{
        if(args.length!=1){
            System.out.println("Usage: java TollReport event-file");
            System.exit(1);
        }

        boolean quit = false;

        TollRoadDatabase database = new TollRoadDatabase(args[0]);
        database.summaryReport();
        database.onRoadReport();
        database.speederReport();
        database.printBills();

        while(quit==false){
            System.out.println("'b <String>' to see bill for license tag");
            System.out.println("'e <number>' to see activity at exit");
            System.out.println("'q' to quit");
            Scanner scan = new Scanner(System.in);
            String choice = scan.nextLine();
            if(choice.charAt(0)==('b')){
                String arr[] = choice.split(" ");
                database.printCustSummary(arr[1]);
            }
            else if(choice.charAt(0)==('e')){
                String arr[] = choice.split(" ");
                database.printExitActivity(Integer.parseInt(arr[1]));
            }
            else if(choice.equals("q")){
                break;
            }
        }
    }
}
