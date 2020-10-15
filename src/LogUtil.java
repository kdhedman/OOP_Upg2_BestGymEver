import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Created by David Hedman <br>
 * Date: 2020-10-13 <br>
 * Time: 16:31 <br>
 * Project: InlUpg2_BestGymEver <br>
 * Copyright: Nackademin <br> <br>
 * Reads and write log entries for Gym. Requiers Customer for contained information.
 */
public class LogUtil {
    static boolean test = false;

    public static void createLogEntry(Customer c){
        writeStringToLogFile(logEntryString(c));
    }

    public static String logEntryString(Customer c){
        LocalDateTime time;
        if(test) {
            time = LocalDateTime.of(2020,10,13,17,00,43);
        } else {
            time = LocalDateTime.now();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")));
        sb.append(c.getID() + " ");
        sb.append(c.getName() + " ");
        sb.append("Entered gym.");
        return sb.toString();
    }

    public static void writeStringToLogFile(String string){
        if(string.isEmpty() || string == null){
            throw new NullPointerException("String empty, nothing to add to file.");
        }
        String filePath = "txt/log.txt";
        if(test) filePath = "txt/logTest.txt";

        try(PrintWriter pw = new PrintWriter(new FileWriter(filePath,true))){
               pw.println(string);
               pw.flush();
        } catch (IOException e){
            e.getStackTrace();
        }
    }

    public static String getCustomerEntriesFromLog(Customer c){
        String filePath = "txt/log.txt";
        if(test) filePath = "txt/logTest.txt";
        String result = c.getID() + " " + c.getName() + "\n";
        String templine;
        try(Scanner sc = new Scanner(new File(filePath))){
            while(sc.hasNextLine()){
                templine = sc.nextLine();
                if(templine.contains(c.getID())){
                    templine = templine.replace(c.getName() + " ", "");
                    templine = templine.replace(c.getID() + " ", "");
                    result += templine;
                    result += "\n";
                }
            }
        } catch (IOException e){
            e.getStackTrace();
        }
        return result;
    }

    public static String getFullLog(){
        String filePath = "txt/log.txt";
        if(test) filePath = "txt/logTest.txt";
        StringBuilder result = new StringBuilder();
        try(Scanner sc = new Scanner(new File(filePath))){
            while(sc.hasNextLine()){
                result.append(sc.nextLine() + "\n");
            }
        } catch (IOException e){
            e.getStackTrace();
        }
        return result.toString();
    }
}
