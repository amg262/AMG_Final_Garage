

import amg_final_garage.Ticket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andy
 */
public class TicketTest {
    
    private Ticket instance;
    
    /**
     *
     */
    public TicketTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
        instance = new Ticket(6.00);
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     *
     */
    @Test (expected = IllegalArgumentException.class)
    public void setSeeShouldBeNumberAndGreaterThan0(){
        instance.setFee(-.0000001);
        //If number was 0 it would Fail
    }
}