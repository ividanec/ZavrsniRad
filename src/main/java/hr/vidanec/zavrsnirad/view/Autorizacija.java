/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.view;

import hr.vidanec.zavrsnirad.controller.ObradaOperater;
import hr.vidanec.zavrsnirad.model.Operater;
import java.awt.event.KeyEvent;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */
public class Autorizacija extends javax.swing.JFrame {

    /**
     * Creates new form Autorizacija
     */
    public Autorizacija() {
        initComponents();
        
        txtEmail.requestFocus();
        txtEmail.setText("ivid@gmail.com");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblLozinka = new javax.swing.JLabel();
        pswLozinka = new javax.swing.JPasswordField();
        btnPrijava = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmail.setText("Email");

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        lblLozinka.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLozinka.setText("Lozinka");

        pswLozinka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pswLozinkaKeyReleased(evt);
            }
        });

        btnPrijava.setText("Prijava");
        btnPrijava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrijavaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail)
                            .addComponent(lblEmail)
                            .addComponent(lblLozinka)
                            .addComponent(pswLozinka, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnPrijava)))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblEmail)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lblLozinka)
                .addGap(41, 41, 41)
                .addComponent(pswLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnPrijava)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !txtEmail.getText().trim().isEmpty()){
            pswLozinka.requestFocus();
        }
    }//GEN-LAST:event_txtEmailKeyReleased

    private void pswLozinkaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswLozinkaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && pswLozinka.getPassword().length>0){
            prijaviSe();
        }
    }//GEN-LAST:event_pswLozinkaKeyReleased

    private void btnPrijavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrijavaActionPerformed
       prijaviSe();
    }//GEN-LAST:event_btnPrijavaActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrijava;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLozinka;
    private javax.swing.JPasswordField pswLozinka;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables

    private void prijaviSe() {
        if(txtEmail.getText().trim().isEmpty()){
            txtEmail.requestFocus();
            JOptionPane.showMessageDialog(rootPane, "Email obavezno");
            return;
        }
        
        
        try {
            InternetAddress emailAddr = new InternetAddress(txtEmail.getText());
            emailAddr.validate();
         } catch (AddressException ex) {
             txtEmail.requestFocus();
                JOptionPane.showMessageDialog(rootPane, "Email nije ispravan");
                  return;
         }
        
        if(pswLozinka.getPassword().length==0){
            pswLozinka.requestFocus();
            JOptionPane.showMessageDialog(rootPane, "Lozinka obavezna");
            return;
        }
        
        ObradaOperater oo = new ObradaOperater();
        Operater operater = oo.autoriziraj(txtEmail.getText(), pswLozinka.getPassword());
        if(operater==null){
           JOptionPane.showMessageDialog(rootPane, "Neispravna kombinacija emaila i lozinke");
            return; 
        }
        
        new Izbornik().setVisible(true);
        dispose();
    }
}
