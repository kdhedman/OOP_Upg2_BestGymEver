import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Created by David Hedman <br>
 * Date: 2020-10-12 <br>
 * Time: 13:28 <br>
 * Project: InlUpg2_BestGymEver <br>
 * Copyright: Nackademin <br>
 */
public class Customer {
    public static boolean test = false;

    private String name, id;
    private LocalDate lastPayment;

    public Customer(String id, String name, String lastPayment){
        setId(id);
        setName(name);
        setLastPayment(lastPayment);
    }

    private void setId(String id){
        if(id == null || id.isEmpty()) throw new NullPointerException("Personnummer tomt.");
        for(int i = 0; i < id.length(); i++){
            if(!Character.isDigit(id.charAt(i))) throw new IllegalArgumentException("Ej enbart siffror i personnummer.");
        }
        this.id = id;
    }

    private void setName(String name){
        this.name = name.trim();
    }

    private void setLastPayment(String date){
        //https://kodejava.org/how-do-i-manipulate-the-value-of-localdate-object/
        lastPayment = LocalDate.parse(date);
    }

    public String getID(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public LocalDate getLastPayment(){
        return this.lastPayment;
    }

    public String getLastPaymentAsString(){
        return lastPayment.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
