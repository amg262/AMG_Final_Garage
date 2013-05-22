
package amg_final_garage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * 
 * Implements OutputStrategy interface. When this is used it will output
 * the information in a JOptionPane message box, and also write the output
 * to a .doc file in project directory.
 * 
 * @author Andy Gunn
 */
public class GuiFileOutputStrategy implements OutputStrategy {

    //String for Title bar in GUI window
    //Image for Icon in Gui
    private final String EZ = "EzGarage v1.1";
    final Icon icon = new ImageIcon("ez.jpeg");
    
    /**
     * Outputs receiptOutput in JOptionPane, and writes it to file.
     * 
     * @param receiptOutput 
     */
    @Override
    public final void outputTransaction(String receiptOutput) {

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("gui_receipt.txt", true));
            

            // Writes receiptOutput to gui_receipt.txt file in the project directory
            // prints out receiptOutput in JOptionPane window
            out.write(receiptOutput);
            JOptionPane.showMessageDialog(null, receiptOutput, EZ, JOptionPane.PLAIN_MESSAGE, icon);
            out.close();

            } catch (IOException e){
        }
    }

    @Override
    public String toString() {
        return "GuiFileOutputStrategy{" + "EZ="
                + EZ + ", icon=" + icon + '}';
    }
    
    
}
