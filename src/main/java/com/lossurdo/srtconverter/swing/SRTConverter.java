package com.lossurdo.srtconverter.swing;

import javax.swing.JOptionPane;

public class SRTConverter extends javax.swing.JFrame {

    public SRTConverter() {
        initComponents();
        
        setLocationRelativeTo(null);

        try {
            FileDrop drop = new FileDrop(txtDragDrop, new FileDropListener(this));        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDragDrop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SRT Converter (beta)");
        setMinimumSize(new java.awt.Dimension(440, 320));

        txtDragDrop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDragDrop.setText("Drag and Drop SRT Subtitles here to convert to ISO-8859-1");
        getContentPane().add(txtDragDrop, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel txtDragDrop;
    // End of variables declaration//GEN-END:variables
}
