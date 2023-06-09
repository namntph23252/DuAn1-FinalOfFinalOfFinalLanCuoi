/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import service.NguoiDungService;
import serviceimpl.NguoiDungServiceImpl;

/**
 *
 * @author User
 */
public class UIDangKi extends javax.swing.JFrame {

    /**
     * Creates new form UIDangKi
     */
    public UIDangKi() {
        super("UIDangKi");

        initComponents();
    }
    NguoiDungService nguoiDungService = new NguoiDungServiceImpl();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_oldPass = new javax.swing.JPasswordField();
        ttx_rePass = new javax.swing.JPasswordField();
        txt_newPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("User name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 60, -1, -1));
        jPanel2.add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 57, 264, -1));

        jLabel3.setText("Mật Khẩu Cũ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 106, 84, -1));

        jButton2.setText("Xác Nhân");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Đổi Mật Khẩu");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 6, 130, -1));

        jLabel4.setText("Mật Khẩu Mới");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 146, -1, -1));

        jLabel5.setText("Xác nhân mật khẩu");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 186, -1, -1));
        jPanel2.add(txt_oldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 103, 264, -1));
        jPanel2.add(ttx_rePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 183, 264, -1));
        jPanel2.add(txt_newPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 143, 264, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 440, 270));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1325, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void clear() {
        txt_newPass.setText("");
        txt_user.setText("");
        txt_oldPass.setText("");
        ttx_rePass.setText("");
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String username = txt_user.getText().trim();
        if (username.isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui long nhap tai khoan1");
            return;
        }
        String oldPass = txt_oldPass.getText().trim();
        if (oldPass.isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui long nhap mat khau cu!");
            return;
        }
        String newPass = txt_newPass.getText().trim();
        if (newPass.isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui long nhap mat khau moi!");
            return;
        }
        String rePass = ttx_rePass.getText().trim();
        if (rePass.isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui long xac nahn mat khau!");
            return;
        }
        if (rePass.equals(newPass) == false) {
            JOptionPane.showMessageDialog(this, "Xac nhan mat khau khong turng khop!");
            return;
        }
        int choice = JOptionPane.showConfirmDialog(null, "Xác nhân đổi mật khẩu?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            if (nguoiDungService.rePassword(username, oldPass, newPass)) {
                JOptionPane.showMessageDialog(this, "doi mat khau thanh conng!");
            } else {
                JOptionPane.showMessageDialog(this, "doi mat khau that bai!");
            }
        }
        clear();


    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIDangKi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField ttx_rePass;
    private javax.swing.JPasswordField txt_newPass;
    private javax.swing.JPasswordField txt_oldPass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
