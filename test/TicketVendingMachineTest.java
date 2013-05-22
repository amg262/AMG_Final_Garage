

import amg_final_garage.IllegalGarageIdException;
import amg_final_garage.IllegalHoursException;
import amg_final_garage.TicketVendingMachine;
import java.io.IOException;
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
public class TicketVendingMachineTest {
    
    private TicketVendingMachine instance;
    
    /**
     *
     */
    public TicketVendingMachineTest() {
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
        instance = new TicketVendingMachine();
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
     * @throws IllegalHoursException
     */
    @Test (expected = IllegalHoursException.class)
    public void addHoursToTotalShouldBeThanZero() throws IllegalHoursException{
        instance.addHoursToTotal(-1);
    }
    
    /**
     *
     * @throws IllegalHoursException
     * @throws IllegalGarageIdException
     */
    @Test (expected = IllegalHoursException.class)
    public void printReceiptHoursShouldBeThanZero()
            throws IllegalHoursException, IllegalGarageIdException{
        
        instance.printReceipt(-1, null);
    }
    
    /**
     *
     * @throws IllegalHoursException
     * @throws IllegalGarageIdException
     * @throws IOException
     */
    @Test (expected = IllegalHoursException.class)
    public void printtotalsTotalHoursShouldBeThanZero()
            throws IllegalHoursException, IllegalGarageIdException, IOException{
        
        instance.printTotals(-42, null);
    }
    
    

}