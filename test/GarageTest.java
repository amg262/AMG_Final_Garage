
import amg_final_garage.Garage;
import amg_final_garage.IllegalGarageIdException;
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
public class GarageTest {
    
    private Garage instance;
    
    /**
     *
     */
    public GarageTest() {
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
        instance = new Garage();
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
    public void setNameShouldNotBeNullorLessThan2(){
        instance.setName("a");
        //one more character would cause FAIL (expects exception)
    }
    
    /**
     *
     */
    @Test (expected = IllegalArgumentException.class)
    public void setAddressShouldNotBeNullorLessThan4(){
        instance.setAddress(null);
    }
    
    /**
     *
     */
    @Test (expected = IllegalArgumentException.class)
    public void setCityShouldNotBeNullorLessThan4(){
        instance.setCity("Del");
        //one more character would cause FAIL (expects exception)
    }
    
    /**
     *
     */
    @Test (expected = IllegalArgumentException.class)
    public void setStateShouldNotBeNullorLessThan2(){
        instance.setState("W");
        //one more character would cause FAIL (expects exception)
    }
    
    /**
     *
     */
    @Test (expected = IllegalArgumentException.class)
    public void setZipShouldNotBeNullorLessThan5(){
        instance.setZip("5318");
        //one more character would cause FAIL (expects exception)
    }
    
    /**
     *
     */
    @Test (expected = IllegalArgumentException.class)
    public void setPhoneNumShouldNotBeNullorLessThan7(){
        instance.setPhoneNum("212989"); 
        //one more character would cause FAIL (expects exception)
    }
    
}