/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.vidanec.zavrsnirad.view;

/**
 *
 * @author Ivan
 */
public class Izbornik extends javax.swing.JFrame {

    /**
     * Creates new form Izbornik
     */
    public Izbornik() {
        initComponents();
        
        setTitle("Izbornik");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmNaslovGrana = new javax.swing.JMenu();
        jmiOsobe = new javax.swing.JMenuItem();
        jmiSeparator = new javax.swing.JPopupMenu.Separator();
        jmiKnjige = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiPosudbeKnjiga = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiIzlaz = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/13-133083_books-hd-png.png"))); // NOI18N

        jmNaslovGrana.setText("Meni");

        jmiOsobe.setText("Osobe");
        jmiOsobe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOsobeActionPerformed(evt);
            }
        });
        jmNaslovGrana.add(jmiOsobe);
        jmNaslovGrana.add(jmiSeparator);

        jmiKnjige.setText("Knjige");
        jmiKnjige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiKnjigeActionPerformed(evt);
            }
        });
        jmNaslovGrana.add(jmiKnjige);
        jmNaslovGrana.add(jSeparator2);

        jmiPosudbeKnjiga.setText("Posudbe knjiga");
        jmiPosudbeKnjiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPosudbeKnjigaActionPerformed(evt);
            }
        });
        jmNaslovGrana.add(jmiPosudbeKnjiga);
        jmNaslovGrana.add(jSeparator1);

        jmiIzlaz.setText("Izlaz");
        jmiIzlaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiIzlazActionPerformed(evt);
            }
        });
        jmNaslovGrana.add(jmiIzlaz);

        jMenuBar1.add(jmNaslovGrana);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiIzlazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiIzlazActionPerformed
        dispose();
    }//GEN-LAST:event_jmiIzlazActionPerformed

    private void jmiOsobeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOsobeActionPerformed
        new Osobe().setVisible(true);
    }//GEN-LAST:event_jmiOsobeActionPerformed

    private void jmiKnjigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiKnjigeActionPerformed
        new Knjige().setVisible(true);
    }//GEN-LAST:event_jmiKnjigeActionPerformed

    private void jmiPosudbeKnjigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPosudbeKnjigaActionPerformed
        new PosudbeKnjiga().setVisible(true);
    }//GEN-LAST:event_jmiPosudbeKnjigaActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu jmNaslovGrana;
    private javax.swing.JMenuItem jmiIzlaz;
    private javax.swing.JMenuItem jmiKnjige;
    private javax.swing.JMenuItem jmiOsobe;
    private javax.swing.JMenuItem jmiPosudbeKnjiga;
    private javax.swing.JPopupMenu.Separator jmiSeparator;
    // End of variables declaration//GEN-END:variables
}
