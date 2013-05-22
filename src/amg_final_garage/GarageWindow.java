
package amg_final_garage;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * GUI window for the Garage Project, that contains all panels, buttons
 * and fields that are required for the functionality of the program. Comes
 * only if user is authenticated and logged into the system. Does ALL outputting
 * for exceptions, because thats the GUIs job, not anything else!
 * 
 * @author Andy
 */
public class GarageWindow extends javax.swing.JFrame {
    
    
    final String EZ_GARAGE = "EzGarage v1.1";
    double totalHours = 0;
    
    
    /**
     * Creates new form GarageWindow
     */
    public GarageWindow() {
        initComponents();
        this.setBounds(600, 300, 320, 290);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtGarageId = new javax.swing.JTextField();
        txtHours = new javax.swing.JTextField();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EzGarage v1.1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 0, 14))); // NOI18N

        btnSubmit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSubmit.setText("Submit Ticket");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Garage ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Hours");

        txtGarageId.setText("0002TYPG");
        txtGarageId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGarageIdActionPerformed(evt);
            }
        });

        txtHours.setText("5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGarageId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHours, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtGarageId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here
        
        try {
        
        String garageId = txtGarageId.getText();
        double hours = Double.valueOf(txtHours.getText());
        //No magic numbers
        final String GARAGE_WIN_XML = "garageWindowConfig.xml";
        final String TVM_BEAN = "ticketVendingMachine";
        
        final AbstractApplicationContext context = 
                new ClassPathXmlApplicationContext(new String[] {GARAGE_WIN_XML});
        
        TicketVendingMachine ticket = (TicketVendingMachine)context.getBean(TVM_BEAN);

        /**
         * Thrifty Id:          0002TYPG
         * BestValue Id:        0001BVPG
         * New Co.(variable):   0003NPGC
         * Sample Id:           0004SPGC
         */
            
        //runs the guts of the program
        ticket.startNewTransaction();
        ticket.addHoursToGarage(hours, garageId);
        totalHours+=hours;
        ticket.addHoursToTotal(totalHours);
        ticket.printReceipt(hours, new GuiOutputStrategy()); //Strategy objects here
        ticket.printTotals(totalHours, new GuiOutputStrategy()); //Strategy objects here

        
        //GUIs job to output exception messages
        } catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(this, nfe.getMessage(), EZ_GARAGE, JOptionPane.ERROR_MESSAGE);
        } catch (IllegalGarageIdException igie) {
            JOptionPane.showMessageDialog(this, igie.getMessage(), EZ_GARAGE, JOptionPane.ERROR_MESSAGE);
        } catch (IllegalHoursException ihe){
            JOptionPane.showMessageDialog(this, ihe.getMessage(), EZ_GARAGE, JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException iae){
            JOptionPane.showMessageDialog(this, iae.getMessage(), EZ_GARAGE, JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException npe){
            JOptionPane.showMessageDialog(this, npe.getMessage(), EZ_GARAGE, JOptionPane.ERROR_MESSAGE);
        } catch (RuntimeException rte){
           JOptionPane.showMessageDialog(this, rte.getMessage(), EZ_GARAGE, JOptionPane.ERROR_MESSAGE);
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), EZ_GARAGE, JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtGarageIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGarageIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGarageIdActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtGarageId;
    private javax.swing.JTextField txtHours;
    // End of variables declaration//GEN-END:variables
}
