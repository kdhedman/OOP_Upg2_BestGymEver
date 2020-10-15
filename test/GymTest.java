import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by David Hedman <br>
 * Date: 2020-10-12 <br>
 * Time: 13:30 <br>
 * Project: InlUpg2_BestGymEver <br>
 * Copyright: Nackademin <br>
 */
class GymTest {
    Gym gym = new Gym();
    List<Customer> customers = new LinkedList<>();

    Customer c1 = new Customer("7603021234", "Alhambra Aromes","2019-07-01");
    Customer c2 = new Customer("8104021234", "Bear Belle","2018-12-02");
    Customer c3 = new Customer("8512021234", "Chamade Coriola","2017-03-12");
    Customer c4 = new Customer("7608021234", "Diamanda Djedi","2020-01-30");

    @Test
    public void testIsActive(){
        Gym.test = true;

        assertFalse(gym.isActive(c1));
        assertTrue(gym.isActive(c4));
    }

    @Test
    public void testFindCustomerInList(){
        customers = IOUtilTest.getCustomerTestList();
        String input1 = "Alhambra";
        String input2 = "8104021234";
        String input3 = "bear Belle";
        String input4 = "7608021234";
        String input5 = "alhambra";
        assertTrue(gym.findCustomerInList(input1, customers).getName().equals("Alhambra Aromes"));
        assertTrue(gym.findCustomerInList(input2, customers).getName().equals("Bear Belle"));
        assertTrue(gym.findCustomerInList(input3, customers).getName().equals("Bear Belle"));
        assertTrue(gym.findCustomerInList(input4, customers).getName().equals("Diamanda Djedi"));
        assertTrue(gym.findCustomerInList(input5, customers).getName().equals("Alhambra Aromes"));

    }


}