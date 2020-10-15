import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by David Hedman <br>
 * Date: 2020-10-13 <br>
 * Time: 16:32 <br>
 * Project: InlUpg2_BestGymEver <br>
 * Copyright: Nackademin <br>
 */
class LogUtilTest {
    Customer c1 = new Customer("7603021234", "Alhambra Aromes","2019-07-01");
    Customer c2 = new Customer("8104021234", "Bear Belle","2018-12-02");
    Customer c3 = new Customer("8512021234", "Chamade Coriola","2017-03-12");
    Customer c4 = new Customer("7608021234", "Diamanda Djedi","2020-01-30");

    @Test
    public void TestLogEntryString(){
        LogUtil.test = true;

        String result1 = "2020-10-13 17:00:43 7603021234 Alhambra Aromes Entered gym.";

        assertEquals(LogUtil.logEntryString(c1), result1);
    }

    @Test
    public void TestWriteStringToLogFile(){
        LogUtil.test = true;
        String result1 = "2020-10-13 17:00:43 7603021234 Alhambra Aromes Entered gym.\n" +
                "2020-10-13 17:00:43 8104021234 Bear Belle Entered gym.\n";
        LogUtil.writeStringToLogFile(LogUtil.logEntryString(c1));
        LogUtil.writeStringToLogFile(LogUtil.logEntryString(c2));

        String readResult = "";
        try(Scanner sc = new Scanner(new File("txt/logTest.txt"))){
            while(sc.hasNextLine()){
                readResult += sc.nextLine() + "\n";
            }
        } catch (IOException e){
            e.getStackTrace();
        }
        assertTrue(Files.isReadable(Paths.get("txt/logTest.txt")));
        assertEquals(result1, readResult);
    }
}