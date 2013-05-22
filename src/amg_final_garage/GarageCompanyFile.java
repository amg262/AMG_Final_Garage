
package amg_final_garage;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * Because of dependency injection, this class no longer depends on concrete FeeStrategy
 * objects.
 * All information that is attached to the Garage objects, including address, phone-no, etc.
 * are stored in a Spring XML file, so should a client need to change their Fee Calculator,
 * name, city, address, phone, etc. it would be done EASILY without ever touching the 
 * source code! A big step up from before.
 * 
 * Also has hashCode, equals and toString()
 * 
 * 
 * @author Andy Gunn
 */
public class GarageCompanyFile {
    
    private Garage garage;

    //Dependency Injection!! No concrete dependencies!
    final AbstractApplicationContext context =
            new ClassPathXmlApplicationContext(new String[] {"garageCompanyFileConfig.xml"});
    
    Garage bestValueGarage = (Garage)context.getBean("bestValueGarage");
    Garage thriftyGarage = (Garage)context.getBean("thriftyGarage");
    Garage newGarageClient = (Garage)context.getBean("newGarageClient");
    Garage sampleGarageOne = (Garage)context.getBean("sampleGarageOne");
    
    /**
     * Searches through the set of Garages to see if the passed in garageId
     * matches any inside the set of Garage objects. If it does, it returns the
     * garage object, and if not, it will return null;
     * 
     * @param garageId
     * @return garage
     * @throws IllegalGarageIdException  
     */
    public final Garage searchForGarageId(String garageId) throws IllegalGarageIdException{
        Set<Garage> garageSet = new HashSet<Garage>();
        garageSet.add(bestValueGarage);
        garageSet.add(thriftyGarage);
        garageSet.add(newGarageClient);
        garageSet.add(sampleGarageOne);

        garage = null;
        
        for (Garage g: garageSet){
            if (garageId.equals(g.getGarageId())){
                setGarage(g);
                break;
            }
        }
        return garage;
    }

    /**
     * Retrieves the garage object
     * 
     * @return the garage
     */
    public final Garage getGarage() {
        return garage;
    }  

    /**
     * Sets the garage object if the input is not null, otherwise throws Illegal
     * garage Id exception.
     * 
     * @param garage the garage to set
     * @throws IllegalGarageIdException  
     */
    public final void setGarage(Garage garage) throws IllegalGarageIdException {
        if (garage == null){
            throw new IllegalGarageIdException();
        }
        this.garage = garage;
    }

    /**
     * Simple overridden hashcode method that compares sees if two garage objects are
     * equal.
     * 
     * @return hash
     */
    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.garage);
        return hash;
    }

    /**
     * Simple overridden equals method that compares sees if two garage objects are
     * equal.
     * 
     * @param obj
     * @return boolean
     */
    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GarageCompanyFile other = (GarageCompanyFile) obj;
        if (!Objects.equals(this.garage, other.garage)) {
            return false;
        }
        return true;
    }

    /**
     * Overridden toString() method that displays all info in the file class.
     *
     * @return str
     */
    @Override
    public final String toString() {
        String str = "GarageCompanyFile{" + "garage=" + garage + ", bestValueGarage="
                + bestValueGarage + ", thriftyGarage=" + thriftyGarage + ", newGarageClient="
                + newGarageClient + ", sampleGarageOne=" + sampleGarageOne + '}';
        
        return str;
    }
}
