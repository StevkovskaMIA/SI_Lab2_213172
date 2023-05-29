import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranchTest1() {
        List<User> users = new ArrayList<>();

        //test1
        User user = null;
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }

    @Test
    void everyBranchTest2() {
        List<User> users = new ArrayList<>();

        //test2
        User user = new User(null, "mia23#", "miastevkovska");
        assertFalse(SILab2.function(user, users));
    }

    @Test
    void everyBranchTest3() {
        List<User> users = new ArrayList<>();

        //test3
        User user = new User("mia23", "softv 23", "stevkovskamia@gmail.com");
        User user1 = new User("mia23", "pas12", "stevkovskamia@gmail.com");
        User user2 = new User("si", "passw", "stevkovskamia@gmail.com");
        User user3 = new User("mia23", "passssoft", "stevkovskamia@gmail.com");
        users.add(user1);
        users.add(user2);
        users.add(user3);

        assertFalse(SILab2.function(user, users));
    }

    @Test
    void everyBranchTest4() {
        List<User> users = new ArrayList<>();

        //test4
        User user = new User("mia", "mia", "stevkovskamia");

        assertFalse(SILab2.function(user, users));
    }


    @Test
    void multipleConditionsTest() {
        List<User> users = new ArrayList<>();

        //TXX
        User user1 = null;
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FTX
        User user2 = new User("mia", null, null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FFT
        User user3 = new User("mia", "mia123", null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user3, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FFF
        User user4 = new User("mia", "mia123", "miastevkovska@gmail.com");
        assertFalse(SILab2.function(user4, users));
    }
}