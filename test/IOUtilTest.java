import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by David Hedman <br>
 * Date: 2020-10-13 <br>
 * Time: 09:40 <br>
 * Project: InlUpg2_BestGymEver <br>
 * Copyright: Nackademin <br>
 */
class IOUtilTest {

    @Test
    public void TestGetCustomersFromFile(){
        List<Customer> customerList = new ArrayList<>();
        customerList = IOUtil.getCustomersFromFile("txt/customersTest.txt");
        assertTrue(customerList.get(0).getName().equals("Alhambra Aromes"));
        assertTrue(customerList.get(2).getName().equals("Chamade Coriola"));
        assertTrue(customerList.get(0).getID().equals("7603021234"));
        assertTrue(customerList.get(0).getLastPaymentAsString().equals("2019-07-01"));


//        List<Customer> customerFailList = new ArrayList<>();
//        customerFailList = IOUtil.getCustomersFromFile("txt/thisdoesntexist.txt");
//        assertTrue(customerFailList == null);
    }

    public static List<Customer> getCustomerTestList(){
        return IOUtil.getCustomersFromFile("txt/customersTest.txt");
    }



}