import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by David Hedman <br>
 * Date: 2020-10-13 <br>
 * Time: 16:41 <br>
 * Project: InlUpg2_BestGymEver <br>
 * Copyright: Nackademin <br>
 */
class CustomerTest {
    Customer c1 = new Customer("7603021234", "Alhambra Aromes","2019-07-01");
    Customer c2 = new Customer("8104021234", "Bear Belle","2018-12-02");
    Customer c3 = new Customer("8512021234", "Chamade Coriola","2017-03-12");
    Customer c4 = new Customer("7608021234", "Diamanda Djedi","2020-01-30");

    @Test
    public void createCustomer(){
        Customer c1 = new Customer("7603021234", "Alhambra Aromes","2019-07-01");
        assertEquals("7603021234", c1.getID());
        assertEquals("Alhambra Aromes", c1.getName());
        assertEquals("2019-07-01", c1.getLastPaymentAsString());
    }


}