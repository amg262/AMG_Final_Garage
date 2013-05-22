
import amg_final_garage.IllegalUserInfoException;
import amg_final_garage.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit Test class for the User class.
 * 
 * @author Andy
 */
public class UserTest {
    
    private User instance;
    
    /**
     *
     */
    public UserTest() {
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
        instance = new User("admin","admin","bob@bob.com","bob");
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
        instance = null;
    }
    
    /**
     * Will cause FAIL if username is greater than 3
     * (Because of expected)
     * @throws IllegalUserInfoException 
     */
    @Test (expected = IllegalUserInfoException.class)
    public void setUserNameShouldBeNotNullAndLessThan4() throws IllegalUserInfoException{
        instance.setUsername("238");
        //instance.setName("andy"); (fail)
    }
    
    /**
     * Will cause FAIL if username is greater than 3
     * (Because of expected)
     * @throws IllegalUserInfoException 
     */
    @Test (expected = IllegalUserInfoException.class)
    public void setPasswordShouldBeNotNullOrLessThan4() throws IllegalUserInfoException{
        instance.setPassword("ac5");
        //instance.setName("andy"); (fail)

    }
    
    /**
     * Will cause FAIL if username is greater than 2
     * (Because of expected)
     * @throws IllegalUserInfoException 
     */
    @Test (expected = IllegalUserInfoException.class)
    public void setNameShouldNotBeNullOrLessThan3() throws IllegalUserInfoException{
        instance.setName("aj");
        //instance.setName("and"); (fail)
    }
    
    /**
     * Will cause FAIL if username is greater than 3
     * (Because of expected)
     * @throws IllegalUserInfoException 
     */
    @Test (expected = IllegalUserInfoException.class)
    public void setEmailShouldNotBeNullOrLessThan4() throws IllegalUserInfoException{
        instance.setEmail("ady");
        //instance.setName("andy"); (fail)
    }
    
    /**
     * Will cause FAIL if User is NOT null
     * (Because of expected)
     * @throws IllegalUserInfoException
     */
    @Test (expected = IllegalUserInfoException.class)
    public void setUserShouldNotBeNull() throws IllegalUserInfoException{
        instance.setUser(null);
        //instance.setUser(instance); (fail)
    }
}