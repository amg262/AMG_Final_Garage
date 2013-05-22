
package amg_final_garage;

import fileaccessservice.ConsoleOutput;
import fileaccessservice.CsvCommaFormat;
import fileaccessservice.CsvQuoteTabFormat;
import fileaccessservice.FileService;
import fileaccessservice.*;
import fileaccessservice.TextFileReader;
import fileaccessservice.TextFileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * 
 * This class does a lot of the work. I creates the Garage object and passes the ID
 * and hours to the garage, contains the method to search the GarageSet, gets the
 * accrued hours, does all of the outputting in two separate methods (one for receipt,
 * one for garage totals.) This class also has a static carNum in which increases with
 * each newTransaction, a Date object, and a DecimalFormatter.
 * 
 * There is also method validation, to make sure all fields are acceptable, and displays
 * error message if they aren't.
 * 
 * @author Andy Gunn
 */
public class Receipt {
    
    private String path;
    private Ticket ticket;
    private Garage garage;
    private double parkingFee;
    private double accruedHours;
    private double accruedMoney;
    private static int carNum = 100;   //counter for carNum -- Output with Receipt
    private static int totalCars = 0;  //counter for total cars -- Output with totals
    private Date date = new Date();
    private NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private DecimalFormat dc = new DecimalFormat("0.00");
    private final String TOT_FEES = "totalFees";
    private final String TOT_HRS = "totalHours";
    private String netHrs = Double.toString(this.accruedHours);
    private String netMoney = Double.toString(this.accruedMoney);
    private final String filePath = "garageTotals.txt";
    /**
     *
     */
    public Receipt(){
    }

    
    FileService service = new FileService(
               new TextFileWriter(new CsvQuoteTabFormat(true), new GuiInput(filePath), TOT_HRS, TOT_FEES, getNetHrs(), getNetMoney()),
               new TextFileReader(new CsvCommaFormat(true), new GuiInput(filePath), new ConsoleOutput()));

    /**
     *
     * @throws IOException
     */
    public final void writeToFile() throws IOException{
        service.writeFile();
    }
    
    /**
     *
     * @throws IOException
     */
    public final void displayFile() throws IOException{
        service.displayFile();
    }

    /**
     * @param garage
     * @param garageId
     * @throws IllegalGarageIdException  
     */
    public Receipt(Garage garage, String garageId) throws IllegalGarageIdException{
        GarageCompanyFile gcf = new GarageCompanyFile();
        this.garage  = getGarage(garageId);
    }
    
    
    /**
     * @param hours
     * @param garageId
     * @throws IllegalGarageIdException  
     */
    public Receipt(double hours, String garageId) throws IllegalGarageIdException{
        GarageCompanyFile gcf = new GarageCompanyFile();
        this.garage = getGarage(garageId);
        hours = hours;
    }
    
    
    /**
     * Creates instance of garage company file and searches through the company 
     * set to see if ID is found. Returns garage object if it is found. No length
     * less than 4 is allowed.
     * 
     * @param garageId
     * @return gcf.searchForGarageId(garageId)
     * @throws IllegalGarageIdException  
     */
    public final Garage getGarage(String garageId) throws IllegalGarageIdException{
        GarageCompanyFile gcf = new GarageCompanyFile();
        if (garageId.length() <= 4){
            throw new IllegalGarageIdException();
        }
        return gcf.searchForGarageId(garageId);
    }
    
     /**
     * @return the netHrs
     */
    public String getNetHrs() {
        return netHrs;
    }

    /**
     * @param netHrs the netHrs to set
     */
    public void setNetHrs(String netHrs) {
        this.netHrs = netHrs;
    }
    

    /**
     * Evaluates the input hours to see if they are valid. If they are, it creates
     * a new Garage object and passes it the hours and Id, and if not, it will throw
     * a customized Hours exception with a custom message.
     * 
     * @param hours
     * @param garageId
     * @throws IllegalHoursException  
     */
    public final void addHoursToGarage(double hours, String garageId) throws IllegalHoursException{
        if (hours >= 1 &&  hours <= 72){
                garage = new Garage(hours, garageId);
                setCarNum(getCarNum() + 1);   
        } else {
            throw new IllegalHoursException();
        }
    }
    
    /**
     * Sets the garage object if it doesn't come back as null. If it does, throws
     * illegal Garage Id exception because that's what would have caused it.
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
     * Retrieves default date object
     * 
     * @return the date
     */
    public final Date getDate() {
        return date;
    }
    

    
    /**
     * Sets the date object. Throws null pointer exception if the date is null;
     * 
     * @param date
     */
    public final void setDate(Date date) {
        if (date == null){
            throw new NullPointerException();
        }
        this.date = date;
    }
    
    /**
     * Retrieves the hours the user has input.
     * 
     * @param hours
     * @return hours
     */
    public final double getInputHours(double hours){
        return hours;
    }
    
    
    /**
     * Sets the input hours it is a positive number, and actually a number. 
     * Otherwise it throws an exception.
     * 
     * @param hours
     * @throws IllegalHoursException  
     */
    public final void setInputHours(double hours) throws IllegalHoursException{
        if (hours < 1 && Double.isNaN(hours)){
            throw new IllegalHoursException();
        }
        hours = hours;
    }

    /**
     * Retrieves the accrued hours that garage has collected.
     * 
     * @param totalHours 
     * @return the accruedHours
     */
    public final double getAccruedHours(double totalHours) {
        accruedHours = totalHours;
        return accruedHours;
    }
    
    /**
     * Sets the accrued hours if the input given is valid. If not, throws custom
     * hours exception
     * 
     * @param accruedHours the accruedHours to set
     * @throws IllegalHoursException  
     */
    public final void setAccruedHours(double accruedHours) throws IllegalHoursException {
        if (accruedHours < 1 && Double.isNaN(accruedHours)){
            throw new IllegalHoursException();
        }
        this.accruedHours = accruedHours;
    }
    
    
    /**
     * Retrieves the totalMoney that the garage has collected thus far.
     * 
     * @param totalHours 
     * @return the accruedMoney
     * @throws IllegalGarageIdException
     * @throws IllegalHoursException  
     */
    public final double getAccruedMoney(double totalHours) throws IllegalGarageIdException, IllegalHoursException {
        accruedMoney += garage.getGarage().getTotalParkingFee(totalHours);
        return accruedMoney;
    }

    /**
     * Sets the accrued money to the amount input if the input is actually valid.
     * if not, it throws an exception.
     * 
     * @param accruedMoney the accruedMoney to set
     */
    public final void setAccruedMoney(double accruedMoney) {
        if (accruedMoney < 1 && Double.isNaN(accruedMoney)){
            throw new IllegalArgumentException();
        }
        this.accruedMoney = accruedMoney;
    }
    

    /**
     * Retrieves the static integer carNum from the class
     * 
     * @return the carNum
     */
    public static int getCarNum() {
        return carNum;
    }
    
    /**
     * Sets the static carNum if the number is above zero.
     * 
     * @param aCarNum the carNum to set
     */
    public static void setCarNum(int aCarNum) {
        if (aCarNum < 0){
            throw new IllegalArgumentException();
        }
        carNum = aCarNum;
    }

    /**
     * Retrieves static totalCars from he class.
     * 
     * @return the totalCars
     */
    public static int getTotalCars() {
        return totalCars;
    }
    
    /**
     * Sets totalCars if the number is above zero.
     * 
     * @param aTotalCars the totalCars to set
     */
    public static void setTotalCars(int aTotalCars) {
        if (aTotalCars < 0){
            throw new IllegalArgumentException();
        }
        totalCars = aTotalCars;
    }

    /**
     * Returns the parkingFee for the car based on amount of hours that car 
     * has been parked, and which garage it was in.
     * 
     * @param hours 
     * @return the parkingFee
     * @throws IllegalGarageIdException
     * @throws IllegalHoursException  
     */
    public final double getParkingFee(double hours) throws IllegalGarageIdException, IllegalHoursException {
        parkingFee = garage.getGarage().getTotalParkingFee(hours);
        ticket = new Ticket(parkingFee);
        
        return parkingFee;
    }
    
    /**
     *
     * @return fee
     */
    public final double getTicketFee(){
        double fee = ticket.getFee();
        return fee;
    }

    
    /**
     * Sets the parking fee if the input is actually valid. Otherwise throw
     * exception.
     * 
     * @param parkingFee the parkingFee to set
     */
    public final void setParkingFee(double parkingFee) {
        if (parkingFee < 0 && Double.isNaN(accruedMoney)){
            throw new IllegalArgumentException();
        }
        this.parkingFee = parkingFee;
    }
    
    
    /**
     * Retrieves the netMoney 
     * 
     * @return the netMoney
     */
    public String getNetMoney() {
        return netMoney;
    }

    /**
     * 
     * Sets the netMoney collected, and passed to file
     * 
     * @param netMoney the netMoney to set
     */
    public void setNetMoney(String netMoney){
        if (netMoney == null){
            throw new NullPointerException();
        }
        this.netMoney = netMoney;
    }
    
    /**
     * Simple overridden toString method for the class that contains all fields
     * that computations are done for.
     * 
     * @return str
     */
    @Override
    public String toString() {
        String str = "Receipt{" + "garage=" + garage + ", accruedHours=" + accruedHours
                + ", accruedMoney=" + accruedMoney + ", date=" + date + '}';
        return str;
    }
    

    /**
     * Uses StringBuilder to append all information needed for the receipt output
     * given to each car. This is the receipt being printed.
     * 
     * @param hours
     * @return str.toString()
     * @throws IllegalGarageIdException
     * @throws IllegalHoursException  
     */
    public final String getReceipt(double hours) throws IllegalGarageIdException, IllegalHoursException {
        
        if (hours < 0){
            throw new IllegalHoursException();
        }
        
        StringBuilder str = new StringBuilder();
        
        //No magic numbers
        final String LINE = "\n";
        final String TAB = "\t";
        final String CO = "Company";
        final String PHONE = "Phone";
        final String DASHS = "---------------------------";
        final String SOLID_LINE = "___________________________";
        final String CAR = "Car #: ";
        final String HOURS = "Hours: ";
        final String FEE = "Fee: ";
        final String SP = " ";
        final String COM = ", ";
        final String PER = ". ";
        
        
        getParkingFee(hours);
        
        str.append(LINE).append(SOLID_LINE + LINE);
        str.append(LINE + LINE + CO + TAB + TAB + TAB + TAB + PHONE);
        str.append(LINE).append(DASHS);
        str.append(LINE).append(garage.getGarage().getName()).append(TAB + TAB).append(garage.getGarage().getPhoneNum());
        str.append(LINE).append(garage.getGarage().getAddress()).append(SP + LINE)
                                                .append(garage.getGarage().getCity())
                                                .append(COM).append(garage.getGarage().getState())
                                                .append(PER).append(garage.getGarage().getZip());
        str.append(LINE).append(DASHS);
        str.append(LINE).append(getDate());
        str.append(LINE).append(DASHS);
        str.append(LINE + CAR + TAB + TAB + TAB + TAB).append(Receipt.getCarNum());
        str.append(LINE+ HOURS + TAB + TAB + TAB + TAB).append(getInputHours(hours));   
        str.append(LINE + FEE + TAB + TAB + TAB + TAB).append(formatter.format(getTicketFee()));
        str.append(LINE).append(SOLID_LINE + LINE + LINE);

        Receipt.totalCars++;
        
        return str.toString();
    }
    
    /**
     * The output for the garage totals. Similar to receipt output method, except this
     * one can be output aside from receipt, and it will of course have different
     * information in it.
     * 
     * @param totalHours
     * @return str.toString()
     * @throws IllegalGarageIdException
     * @throws IllegalHoursException
     * @throws IOException  
     */
    public final String getGarageTotals(double totalHours) throws IllegalGarageIdException, IllegalHoursException, IOException{
        
        if (totalHours < 0){
            throw new IllegalHoursException();
        }
        StringBuilder str = new StringBuilder();
        
        //No magic numbers
        final String LINE = "\n";
        final String TAB = "\t";
        final String SOLID_LINE = "___________________________";
        final String NO_CARS = "No. of Cars: ";
        final String TOT_CASH = "Total Cash: ";
        final String TOT_HOURS = "Total Hours: ";
        
        
        str.append(NO_CARS + TAB + TAB + TAB).append(Receipt.getTotalCars()).append(LINE);
        str.append(TOT_CASH + TAB + TAB + TAB).append(formatter.format(getAccruedMoney(totalHours))).append(LINE);
        setNetMoney(getNetMoney() + getAccruedMoney(totalHours));
        str.append(TOT_HOURS + TAB + TAB + TAB).append(getAccruedHours(totalHours));
        setNetHrs(getNetHrs() + getAccruedHours(totalHours));
        
        writeToFile();
        str.append(LINE + SOLID_LINE + LINE);

        return str.toString();
    }
}
