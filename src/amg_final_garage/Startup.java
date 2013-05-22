
package amg_final_garage;

import javax.swing.JOptionPane;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.*;



/**
 * Revamped startup class for the garage Project. Before it had all the hard coded methods
 * and implementations, now the ONLY thing it should do is instantiate a new Login Window,
 * and make it visible.
 * 
 * If nothing is wrong, it will set the Window visible and the program is started. If not, it
 * will throw an exception.
 * 
 * @serial amg1337
 * @version 1.0 
 * @author Andy Gunn
 *
 */

public class Startup {
    /**
     * 
     * @param args
     * @throws Exception  
     * 
     * Main method that kick stars garage program, does NOTHING
     * to any other class, all it does is create a LoginWindow, and set it Visible
     * 
     * XML File "startupConfig" has the Spring logic for the Startup class.
     */
    public static void main(String[] args) throws Exception{

        final String STARTUP_XML = "startupConfig.xml";
        final String LOGIN_BEAN = "loginWindow";
        
        try {
            
        //Dependency injection!
        final AbstractApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {STARTUP_XML});
        
        LoginWindow window = (LoginWindow)context.getBean(LOGIN_BEAN);
        window.setVisible(true); //Setting window to visible
        
        /**
         * Login Information:
         * ------------------
         * user: admin
         * pass: java
         */
        
        } catch (Exception e){
            throw e;
        }
    }
}
