

import amg_final_garage.IllegalHoursException;
import amg_final_garage.ThriftyFeeCalculator;
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
public class ThriftyFeeCalculatorTest {
    
    private ThriftyFeeCalculator instance;
    
    /**
     *
     */
    public ThriftyFeeCalculatorTest() {
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
        instance = new ThriftyFeeCalculator();
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
    public void setTotalParkingFeeShouldBeMoreThan0AndaNumber(){
        instance.setTotalParkingFee(-22);
        //Number greater than 0 will cause FAIL
    }
    
    /**
     *
     * @throws IllegalHoursException
     */
    @Test (expected = IllegalHoursException.class)
    public void setMinHoursShouldBeMoreThan0AndaNumber() throws IllegalHoursException{
        instance.setMinHours(-44);
        //Number greater than 0 will cause FAIL
    }
    
    /**
     *
     */
    @Test (expected = IllegalArgumentException.class)
    public void setMaxChargeShouldBeMoreThan0AndaNumber(){
        instance.setMaxCharge(-1);
        //Number greater than 0 will cause FAIL
    }
    
    /**
     *
     */
    @Test (expected = IllegalArgumentException.class)
    public void setPerHourShouldBeMoreThan0AndaNumber(){
        instance.setPerHour(-1.5);
        //Number greater than 0 will cause FAIL
    }
    
    /**
     *
     */
    @Test (expected = IllegalArgumentException.class)
    public void setMinChargeShouldBeMoreThan0AndaNumber(){
        instance.setMinCharge(-10.423);
        //Number greater than 0 will cause FAIL
    }
}