
import amg_final_garage.IllegalUserInfoException;
import amg_final_garage.User;
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
public class UserLoginDatabaseTest {
    
    private User instance;
    
    /**
     *
     */
    public UserLoginDatabaseTest() {
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
        instance = new User("andy","andy");
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
     * Test for setUser method in UserLogin class, will cause
     * fail if the user is not Null because it expects exception
     * 
     * @throws IllegalUserInfoException
     */
    @Test (expected = IllegalUserInfoException.class)
    public void setUserShouldNotBeNull() throws IllegalUserInfoException{
        instance.setUser(null);
        //instance.setUser(instance); (fail)
    }
}