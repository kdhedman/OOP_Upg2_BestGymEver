import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Hedman <br>
 * Date: 2020-10-12 <br>
 * Time: 13:55 <br>
 * Project: InlUpg2_BestGymEver <br>
 * Copyright: Nackademin <br>
 */
public class Gym implements UIUtil{
    public static boolean test = false;

    public static void main(String[] args) {
        Gym gym = new Gym();
        gym.run();
    }

    public void run() {
        List<Customer> customers = new ArrayList<>();
        customers = IOUtil.getCustomersFromFile("txt/customers.txt");
        for(Customer c : customers){
            System.out.printf("%-10s %-17s %s\n", c.getID(), c.getName(), (isActive(c) ? "Active" : "Inactive"));
        }

        //mainloop
        mainloop:
        while (true) {

            //Flervalksnapp 0: Sök person, 1: Full log, 2: Avsluta
            int     choice = mainMenu();
            String  input;
            Customer c;

            if(choice == 0){
                searchloop:
                while(true){
                    input = searchCustomerDialog();
                    if(input == null) break mainloop;
                    if(input.isEmpty()){
                        errorDialog("Error: Input blank.");
                        continue searchloop;
                    }
                    if(input.length() < 3){
                        errorDialog("Error: Search string to short");
                        continue searchloop;
                    }
                    c = findCustomerInList(input, customers);
                    if(c == null){
                        errorDialog("Error: Customer not found.");
                        continue searchloop;
                    }
                    if(!isActive(c)){
                        errorDialog("Error: Customer not active.");
                        continue mainloop;
                    }
                    break searchloop;
                }
                //0 check in, 1 show log, 2 cancel
                choice = showCustomerOptions(c);
                if(choice == 0){
                    LogUtil.createLogEntry(c);
                }
                if(choice == 1){
                    showCustomerInfoDialog(c);
                }if(choice == -1){
                    break mainloop;
                }
                continue mainloop;
            }
            if(choice == 1){
                showFullLogDialog();
                continue mainloop;
            }
            if(choice == -1 || choice == 2){
                break mainloop;
            }
        }
    }

    public Customer findCustomerInList(String input, List<Customer> customers) {
        input = input.trim();
        for(Customer c : customers){
            if(c.getID().equals(input)||
            c.getName().equalsIgnoreCase(input)||
            c.getName().toUpperCase().contains(input.toUpperCase()))
                return c;
        }
        return null;
    }

    public boolean isActive(Customer c) {
        if (test) return (c.getLastPayment().isAfter(LocalDate.parse("2019-10-10")));
        return c.getLastPayment().isAfter(LocalDate.now().minusYears(1));
    }

}
