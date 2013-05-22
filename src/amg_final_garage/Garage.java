
package amg_final_garage;

import java.util.Objects;

/**
 *
 * 
 * Passes in hours, garageId, contains method getGarage where you can get name etc from.
 * 
 * Contains all necessary info for each garage that would be used for this program.
 * Requires id, name, address, city, state, zip, phoneNum and a ParkingFeeCalcultingStrategy.
 * Using the get...() methods will be how you retrieve the details about the garage that will
 * be displayed in the receipt.
 * 
 * Also has toString, HashCode, and equals methods.
 * 
 * @author Andy Gunn
 * 
 */
public class Garage {
    
    private String garageId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNum;
    private ParkingFeeCalculatingStrategy feeCalc;
    private GarageCompanyFile gcf;
    private Garage garage;
    
    
    /**
     *
     */
    public Garage(){
    }
    
    
    /**
     * @param hours
     * @param garageId 
     */
    public Garage(double hours, String garageId){
        this.garageId = garageId;
    }

    /**
     * @param garageId
     * @param name
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param phoneNum
     * @param feeCalc 
     */
    public Garage(String garageId, String name, String address, String city,
                  String state, String zip, String phoneNum, ParkingFeeCalculatingStrategy feeCalc) {
        
        this.garageId = garageId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNum = phoneNum;
        this.feeCalc = feeCalc;
    }

    /**
     * Compares the garageIds to see if they are the same.
     * 
     * @return hash
     */
    @Override
    public final int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.garageId);
        return hash;
    }
    
    /**
     * Compares the garageIds to see if they are the same.
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
        final Garage other = (Garage) obj;
        if (!Objects.equals(this.garageId, other.garageId)) {
            return false;
        }
        return true;
    }
    
    /**
     * ToString that contains all relevant info to a garage object.
     * 
     * @return toString()
     */
    @Override
    public final String toString() {

        return "Garage{" + "garageId=" + garageId + ", name=" + name
                + ", address=" + address + ", city=" + city + ", state="
                + state + ", zip=" + zip + ", phoneNum=" + phoneNum + '}';
    }
    
    
    /**
     * Retrieves the total amount owed for the car that was parked
     * in the garage.
     * 
     * @param hours
     * @return totalParkingFee
     * @throws IllegalHoursException  
     */
    public final double getTotalParkingFee(double hours) throws IllegalHoursException{
        if (Double.isNaN(feeCalc.getTotalParkingFee(hours)) ||
                feeCalc.getTotalParkingFee(hours) < 0){
            throw new IllegalArgumentException();
        }
        
        return feeCalc.getTotalParkingFee(hours);
    }
    
    
    /**
     * retrieves the garageId for the Garage object.
     * 
     * @return the garageId
     */
    public final String getGarageId() {
        return garageId;
    }
    
    /**
     * Sets the garageId for the garage object if the input is valid, otherwise
     * throws customized exception
     * 
     * @param garageId the garageId to set
     * @throws IllegalGarageIdException  
     */
    public final void setGarageId(String garageId) throws IllegalGarageIdException {
        if (garageId.length() <= 4){
            throw new IllegalGarageIdException();
        }
        for (int i=0; i < garageId.length(); i++){
            if (!Character.isLetterOrDigit(i)){
                throw new IllegalGarageIdException();
            }
        }
        this.garageId = garageId;
    }

    
    /**
     * Retrieves business name for Garage company object.
     * 
     * @return the name
     */
    public final String getName() {
        return name;
    }
    
    /**
     * Sets the business name for the garage object if the input is
     * valid, otherwise will throw an exception.
     * 
     * @param name the name to set
     */
    public final void setName(String name) {
        if (name == null || name.length() < 2){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    
    /**
     * Returns the address for the garage object.
     * 
     * @return the address
     */
    public final String getAddress() {
        return address;
    }
    
    /**
     * Sets the address for the garage if the input is valid, otherwise 
     * it will throw an exception.
     * 
     * @param address the address to set
     */
    public final void setAddress(String address) {
        if (address == null || address.length() < 4){
            throw new IllegalArgumentException();
        }
        this.address = address;
    }

    
    /**
     * Returns city stored inside garage object.
     * 
     * @return the city
     */
    public final String getCity() {
        return city;
    }
    
    /**
     * Sets the city for the garage object if the input is valid, otherwise will
     * throw an exception.
     * 
     * @param city the city to set
     */
    public final void setCity(String city) {
        if (city == null || city.length() < 4){
            throw new IllegalArgumentException();
        }
        this.city = city;
    }

    
    /**
     * Retrieves the state that is stored inside the garage object.
     * 
     * @return the state
     */
    public final String getState() {
        return state;
    }
    
    /**
     * Sets the state stored in garage object if the input is valid, otherwise
     * throws exception
     * 
     * @param state the state to set
     */
    public final void setState(String state) {
        if (state == null || state.length() < 2){
            throw new IllegalArgumentException();
        }
        this.state = state;
    }

    
    /**
     * Retrieves the Zip code that is stored in garage object
     * 
     * @return the zip
     */
    public final String getZip() {
        return zip;
    }
    
    /**
     * Sets the Zip code for the garage object if the Zip code isn't invalid and
     * doesn't throw an exception.
     * 
     * @param zip the zip to set
     */
    public final void setZip(String zip) {
        if (zip == null || zip.length() < 5){
            throw new IllegalArgumentException();
        }
        this.zip = zip;
    }

    
    /**
     * @return the phoneNuml
     */
    public final String getPhoneNum() {
        return phoneNum;
    }
    
    /**
     * Sets the phoneNumber for the garage object if the input is valid.
     * Other wise it will thrown an exception.
     * 
     * @param phoneNum 
     */
    public final void setPhoneNum(String phoneNum) {
        if (phoneNum == null || phoneNum.length() < 7){
            throw new IllegalArgumentException();
        }
        this.phoneNum = phoneNum;
    }
    
    
    /**
     * Retrieves the fee calculator object for the garage.
     * 
     * @return the feeCalc
     */
    public final ParkingFeeCalculatingStrategy getFeeCalc() {
        return feeCalc;
    }
    
    /**
     * Sets the feeCalculator if the input is not null. Otherwise throws exception.
     * 
     * @param feeCalc the feeCalc to set
     */
    public final void setFeeCalc(ParkingFeeCalculatingStrategy feeCalc) {
        if (feeCalc == null){
            throw new NullPointerException();
        }
        this.feeCalc = feeCalc;
        
    }

    /**
     * Retrieves the garage from the GCF after it runs the GCF method to search
     * for the passed in id. Returns the garage object it finds.
     * 
     * @return the garage
     * @throws IllegalGarageIdException  
     */
    public final Garage getGarage() throws IllegalGarageIdException {
        gcf = new GarageCompanyFile();
        return gcf.searchForGarageId(garageId);
    }

    /**
     * Sets the garage object if the input is valid, otherwise throws custom
     * garageId exception.
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
}
