import javax.swing.*;

/**
 * Created by David Hedman <br>
 * Date: 2020-10-14 <br>
 * Time: 11:01 <br>
 * Project: InlUpg2_BestGymEver <br>
 * Copyright: Nackademin <br>
 */
public interface UIUtil {
    //Flervalksnapp 1: Sök person, 2: Full log, 3: Avsluta
    default int mainMenu(){
        Object[] choices = {"Search Customer", "Full Log", "Exit"};
        Object defaultChoice = choices[2];
        return JOptionPane.showOptionDialog(null,
                "Welcome to Best Gym Ever",
                "Best Gym Ever",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                choices,
                defaultChoice);
    }

    default String searchCustomerDialog(){
        return JOptionPane.showInputDialog(null,
                "Please enter ID or name:",
                "Best Gym Ever",
                JOptionPane.PLAIN_MESSAGE);
    }

    default void showCustomerInfoDialog(Customer c){
        String customerInfo = LogUtil.getCustomerEntriesFromLog(c);
        String message = "<html><body><p style='width: 300px;'>"+customerInfo.replace("\n","<br>")+"</p></body></html>";
        JOptionPane.showMessageDialog(null,
                message,
                "Best Gym Ever",
                JOptionPane.PLAIN_MESSAGE
                );
    }

    default void showFullLogDialog(){
        String log = LogUtil.getFullLog();
        String message = "<html><body><p style='width: 300px;'>"+
                log.replace("\n","<br>")+
                "</p></body></html>";
        JOptionPane.showMessageDialog(null,
                message,
                "Best Gym Ever",
                JOptionPane.PLAIN_MESSAGE);
    }

    //0 check in, 1 show log, 2 cancel
    default int showCustomerOptions(Customer c){
        String customerInfo = c.getID() + " " + c.getName();
        Object[] choices = {"Check in customer", "Show Log", "Cancel"};
        Object defaultChoice = choices[2];
        return JOptionPane.showOptionDialog(null,
                customerInfo,
                "Best Gym Ever",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                choices,
                defaultChoice);
    }

    default void errorDialog(String message){
        JOptionPane.showMessageDialog(null,
                message,
                "Best Gym Ever",
                JOptionPane.PLAIN_MESSAGE);
    }
}
