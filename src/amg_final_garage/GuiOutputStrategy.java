
package amg_final_garage;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * 
 * Implements OutputStrategy interface. If this is chose for output,
 * it prints out using a JOptionPane message Box.
 * 
 *
 * @author Andy
 */
public class GuiOutputStrategy implements OutputStrategy {
    
    //String for Title bar in GUI window
    //Image for Icon in Gui
    private final String EZ = "EzGarage v1.1";
    final Icon icon = new ImageIcon("ez.jpeg");
    
    /**
     * Outputs receiptOutput using JOptionPane
     * 
     * @param receiptOutput 
     */
    @Override
    public final void outputTransaction(String receiptOutput) {
        JOptionPane.showMessageDialog(null, receiptOutput, EZ, JOptionPane.PLAIN_MESSAGE, icon);
    }

    @Override
    public String toString() {
        return "GuiOutputStrategy{" + "EZ=" 
                + EZ + ", icon=" + icon + '}';
    }
    
    
}
