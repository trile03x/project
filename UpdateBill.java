/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package billmanage;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class UpdateBill extends javax.swing.JFrame {

    /**
     * Creates new form UpdateBill
     */
    public UpdateBill() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    String typeupdate;
    double oldindexupdate;
    double newindexupdate;

    public void getudate() {
        try {
            typeupdate = cbxupdatetype.getSelectedItem().toString();
        } catch (Exception e) {
            typeupdate = null;
        }
        try {
            oldindexupdate = Double.parseDouble(txtupdateoldindex.getText());
        } catch (Exception e) {
            if (txtupdateoldindex.getText().equals("")) {
                oldindexupdate = -1;
            } else {
                JOptionPane.showMessageDialog(this, "Không đúng kiểu dữ liệu!!", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                oldindexupdate = -2;
            }

        }
        try {
            newindexupdate = Double.parseDouble(txtupadtenewindex.getText());
        } catch (Exception e) {
            if (txtupadtenewindex.getText().equals("")) {
                newindexupdate = -1;
            } else {
                JOptionPane.showMessageDialog(this, "Không đúng kiểu dữ liệu!!", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                newindexupdate = -2;
            }
        }

    }
    Bill f = new Bill();//đối tượng trung gian
    ArrayList<Bill> brr;// sao luu bên mm2
    String str1;//sao luu bên mm2

    public void checkupadte(ArrayList<Bill> urr, String str) {
        brr = urr;
        str1 = str;
        for (int i = 0; i < urr.size(); i++) {
            if (urr.get(i).getCode().equals(str)) {
                f = urr.get(i);
            }
        }

    }

    public ArrayList<Bill> Save(ArrayList<Bill> urr, String str) {
        getudate();
        for (int i = 0; i < urr.size(); i++) {
            if (urr.get(i).getCode().equals(str)) {
                if (!typeupdate.equals(null)) {
                    urr.get(i).setType(typeupdate);
                } else {
                    urr.get(i).setType(f.getType());
                }
                if (oldindexupdate != -1) {
                    urr.get(i).setOldindex(oldindexupdate);
                } else if (oldindexupdate != -2) {
                    urr.get(i).setOldindex(f.getOldindex());

                } else {
                    urr.get(i).setOldindex(f.getOldindex());
                }
                if (newindexupdate != -1) {
                    urr.get(i).setNewindex(newindexupdate);
                } else if (newindexupdate != -2) {
                    urr.get(i).setNewindex(f.getNewindex());
                } else {
                    urr.get(i).setNewindex(f.getNewindex());
                }
            }
        }
        if (newindexupdate == -2 || oldindexupdate == -2) {
             JOptionPane.showMessageDialog(this, "Cập nhật hóa đơn "+str+" thất bại", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
             txtupadtenewindex.setText("");
             txtupdateoldindex.setText("");
             txtupdateoldindex.requestFocus();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Mã hóa đơn " + str + " đã cập nhật");
        }
        return urr;
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
        jLabel2 = new javax.swing.JLabel();
        cbxupdatetype = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtupdateoldindex = new javax.swing.JTextField();
        txtupadtenewindex = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHuongDan = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CẬP NHẬT HÓA ĐƠN");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CẬP NHẬT HÓA ĐƠN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 824, 54));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("Loại hóa đơn :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 89, 85, 24));

        cbxupdatetype.setBackground(new java.awt.Color(255, 255, 255));
        cbxupdatetype.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxupdatetype.setForeground(new java.awt.Color(0, 0, 0));
        cbxupdatetype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SX", "NN", "KD", "Khác" }));
        getContentPane().add(cbxupdatetype, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 90, 117, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 51));
        jLabel3.setText("Chỉ số cũ :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 162, 72, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 51));
        jLabel4.setText("Chỉ số mới :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 223, 73, 27));

        txtupdateoldindex.setBackground(new java.awt.Color(255, 255, 255));
        txtupdateoldindex.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtupdateoldindex, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 159, 117, -1));

        txtupadtenewindex.setBackground(new java.awt.Color(255, 255, 255));
        txtupadtenewindex.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtupadtenewindex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtupadtenewindexActionPerformed(evt);
            }
        });
        getContentPane().add(txtupadtenewindex, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 225, 117, -1));

        btnSave.setBackground(new java.awt.Color(204, 204, 204));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(204, 0, 51));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save-icon.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 268, -1, -1));

        txtHuongDan.setEditable(false);
        txtHuongDan.setBackground(new java.awt.Color(153, 255, 153));
        txtHuongDan.setColumns(10);
        txtHuongDan.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtHuongDan.setForeground(new java.awt.Color(0, 0, 0));
        txtHuongDan.setLineWrap(true);
        txtHuongDan.setRows(5);
        jScrollPane1.setViewportView(txtHuongDan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 89, 290, 225));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/User-Chat-icon.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 89, 112, 112));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconexit.png"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 398, 100, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Note");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 207, 68, -1));

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 60, 18, 315));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 381, 818, 11));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 823, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtupadtenewindexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtupadtenewindexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtupadtenewindexActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        Menu2 m = new Menu2();
        m.setBrr(Save(brr, str1));
        BillList p = new BillList();
        p.SaveBill(brr);

    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbxupdatetype;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextArea txtHuongDan;
    private javax.swing.JTextField txtupadtenewindex;
    private javax.swing.JTextField txtupdateoldindex;
    // End of variables declaration//GEN-END:variables
}
