
/**
 *
 * @authors PARASKEVAS-SOTIRIOS BERTSEKAS, CHRISTOS DIMITRAKOPOULOS, GIANNIS LAOURENTIUS
 */
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class employee extends javax.swing.JFrame {
Connection conn=null;
ResultSet rs =null;
PreparedStatement pst=null;
    /**
     * Creates new form employee
     */
    public employee() {
        initComponents();
        conn=connect.connectDb();
         Update_Table();
    }
private void Update_Table(){
        try {
                  String sql = "SELECT * FROM employee" ;
                  pst=conn.prepareStatement(sql);
                  rs=pst.executeQuery();
                    Table_show.setModel(DbUtils.resultSetToTableModel(rs));
              } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null,ex);
 
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table_show = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_certificates = new javax.swing.JTextField();
        txt_sistatikes = new javax.swing.JTextField();
        txt_bio = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        insert_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        log_out_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DB PROJECT BY P.B, C.D. AND G.L.");

        Table_show.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_showMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_show);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "employee", "applicationshistory", "applies", "dbas", "degree", "etairia", "evaluator", "has_degree", "job", "languages", "Log_Files", "project", "requires", "subject", "user" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Edit Another Table");

        jLabel2.setText("username");

        jLabel3.setText("bio");

        jLabel4.setText("sistatikes");

        jLabel5.setText("certificates");

        txt_sistatikes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sistatikesActionPerformed(evt);
            }
        });

        insert_btn.setText("Insert");
        insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_btnActionPerformed(evt);
            }
        });

        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        log_out_btn.setText("Log Out");
        log_out_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_out_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_username)
                            .addComponent(txt_bio)
                            .addComponent(txt_sistatikes)
                            .addComponent(txt_certificates, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(log_out_btn)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(insert_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(update_btn)))
                        .addGap(28, 28, 28)
                        .addComponent(delete_btn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_bio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_sistatikes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_certificates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert_btn)
                    .addComponent(update_btn)
                    .addComponent(delete_btn))
                .addGap(38, 38, 38)
                .addComponent(log_out_btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void close() { 
    this.setVisible(false);
    this.dispose();
}
    private void txt_sistatikesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sistatikesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sistatikesActionPerformed

    private void Table_showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_showMouseClicked
       try{
            int row = Table_show.getSelectedRow();
            String Table_click=(Table_show.getModel().getValueAt(row,0).toString());
            String sql = "select * from employee where username='"+Table_click+"' ";
            pst= conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String add1 =rs.getString("username");
                txt_username.setText(add1);
                String add2 =rs.getString("bio");
                txt_bio.setText(add2);
                String add3 =rs.getString("sistatikes");
                txt_sistatikes.setText(add3);
                String add4 =rs.getString("certificates");
                txt_certificates.setText(add4);
               
                
               
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_Table_showMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String selectedOption = jComboBox1.getSelectedItem().toString();
      switch (selectedOption) {
            case "employee":
                
                break;
            case "applicationshistory":
              applicationshistory appl_his = new applicationshistory();
              appl_his.setVisible(true);
              appl_his.pack();
              appl_his.setLocationRelativeTo(null);
              appl_his.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              close();
                break;

            case "applies":
              Applies appl = new Applies();
              appl.setVisible(true);
              appl.pack();
              appl.setLocationRelativeTo(null);
              appl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                close();
                break;
            case "dbas":
                dbas dba = new dbas();
              dba.setVisible(true);
              dba.pack();
              dba.setLocationRelativeTo(null);
              dba.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              close();
            break;
            
            case "degree":
                degree deg = new degree();
              deg.setVisible(true);
              deg.pack();
              deg.setLocationRelativeTo(null);
              deg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              close();
            break;
            
            case "etairia":
                etairia et = new etairia();
              et.setVisible(true);
              et.pack();
              et.setLocationRelativeTo(null);
              et.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              close();
            break;
            case "evaluator":
                evaluator ev = new evaluator();
              ev.setVisible(true);
              ev.pack();
              ev.setLocationRelativeTo(null);
              ev.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              close();
            break;
            case "has_degree":
                has_degree hd = new has_degree();
              hd.setVisible(true);
              hd.pack();
              hd.setLocationRelativeTo(null);
              hd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              close();
            break;
            case "job":
                job jb = new job();
              jb.setVisible(true);
              jb.pack();
              jb.setLocationRelativeTo(null);
              jb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              close();
            break;
            case "languages":
                languages lang = new languages();
              lang.setVisible(true);
              lang.pack();
              lang.setLocationRelativeTo(null);
              lang.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              close();
            break;
            case "Log_Files":
                Logfiles lg = new Logfiles();
              lg.setVisible(true);
              lg.pack();
              lg.setLocationRelativeTo(null);
              lg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              close();
            break;
            case "project":
                project pj = new project();
              pj.setVisible(true);
              pj.pack();
              pj.setLocationRelativeTo(null);
              pj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              close();
            break;
            case "requires":
                requires rq = new requires();
              rq.setVisible(true);
              rq.pack();
              rq.setLocationRelativeTo(null);
              rq.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              close();
            break;
            case "subject":
                subject sb = new subject();
              sb.setVisible(true);
              sb.pack();
              sb.setLocationRelativeTo(null);
              sb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              close();
            break;
            case "user":
                user ur = new user();
              ur.setVisible(true);
              ur.pack();
              ur.setLocationRelativeTo(null);
              ur.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              close();
            break;

            default:
                break;
      }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_btnActionPerformed
        try{
            String sql ="INSERT INTO has_degree (username, bio, sistatikes, certificates) VALUES (?, ?, ?, ?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.setString(2, txt_bio.getText());
            pst.setString(3, txt_sistatikes.getText());
            pst.setString(4, txt_certificates.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data inserted succesfully");
        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);}
        Update_Table();
    }//GEN-LAST:event_insert_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
           try{
            String value1= txt_username.getText();
            String value2= txt_bio.getText();
            String value3= txt_sistatikes.getText();
            String value4= txt_sistatikes.getText();
            String value5= txt_certificates.getText();
           
            String sql ="UPDATE  employee set username='"+value1+"', bio='"+value2+"', sistatikes='"+value3+"', certificates='"+value4+"', txt_grade = '"+value5+"'  WHERE username='"+value1+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data updated succesfully");
        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);}
        Update_Table();
    }//GEN-LAST:event_update_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
       try{
            String sql ="DELETE FROM employee WHERE username = ?  ";
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data deleted succesfully");
        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);}
        Update_Table();
    }//GEN-LAST:event_delete_btnActionPerformed

    private void log_out_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_out_btnActionPerformed
      Welcome_DBA wd = new Welcome_DBA();
       wd.setVisible(true);
       wd.pack();
       wd.setLocationRelativeTo(null);
       wd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       close();
    }//GEN-LAST:event_log_out_btnActionPerformed

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
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_show;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton insert_btn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton log_out_btn;
    private javax.swing.JTextField txt_bio;
    private javax.swing.JTextField txt_certificates;
    private javax.swing.JTextField txt_sistatikes;
    private javax.swing.JTextField txt_username;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
