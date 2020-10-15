import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by David Hedman <br>
 * Date: 2020-10-13 <br>
 * Time: 09:16 <br>
 * Project: InlUpg2_BestGymEver <br>
 * Copyright: Nackademin <br>
 */
public class IOUtil {
    /**
     * Makes a List of Customer-instances from a file, format for file is: <br>
     *     line 1: [ID], [Full Name] <br>
     *     line 2: [LastPaymentDate]
     * @param filepath filepath as String.
     * @return ArrayList of Customer. null if Error.
     */
    public static List<Customer> getCustomersFromFile(String filepath){
        List<Customer> customers = new ArrayList<>();
        Path path = Paths.get(filepath);
        try(Scanner scanner = new Scanner(path)){
            while(scanner.hasNextLine()){
                String input[] = (scanner.nextLine() + ", " + scanner.nextLine()).split(", ");
                String id = input[0].trim();
                String name = input[1].trim();
                String lastPayment = input[2].trim();
                customers.add(new Customer(id,name,lastPayment));
            }
            return customers;
        } catch (Exception e){
            System.out.println("Fel vid konvertering av fil till Kunder.");
            e.printStackTrace();
        }
        return null;
    }
}
