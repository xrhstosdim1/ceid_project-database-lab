
/**
 *
 * @authors PARASKEVAS-SOTIRIOS BERTSEKAS, CHRISTOS DIMITRAKOPOULOS, GIANNIS LAOURENTIUS
 */
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class dbas extends javax.swing.JFrame {
Connection conn=null;
ResultSet rs =null;
PreparedStatement pst=null;
    /**
    
     */
    public dbas() {
        initComponents();
        conn=connect.connectDb();
        Update_Table();
    }
private void Update_Table(){
        try {
                  String sql = "SELECT * FROM dbas" ;
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
        txt_username = new javax.swing.JTextField();
        txt_start_date = new javax.swing.JTextField();
        txt_end_date = new javax.swing.JTextField();
        insert_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        Delete_btn = new javax.swing.JButton();
        Log_out_btn = new javax.swing.JButton();

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dbas", "applicationshistory", "applies", "degree", "employee", "etairia", "evaluator", "has_degree", "job", "languages", "Log_Files", "project", "requires", "subject", "user" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Edit Another Table");

        jLabel2.setText("username");

        jLabel3.setText("start date");

        jLabel4.setText("end_date");

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

        Delete_btn.setText("Delete");
        Delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_btnActionPerformed(evt);
            }
        });

        Log_out_btn.setText("Log Out");
        Log_out_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Log_out_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(insert_btn))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Log_out_btn)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(update_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addGap(44, 44, 44)
                                    .addComponent(Delete_btn))
                                .addComponent(txt_username)
                                .addComponent(txt_start_date)
                                .addComponent(txt_end_date)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2))
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_start_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_end_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert_btn)
                    .addComponent(update_btn)
                    .addComponent(Delete_btn))
                .addGap(48, 48, 48)
                .addComponent(Log_out_btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void close() { 
    this.setVisible(false);
    this.dispose();
}
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String selectedOption = jComboBox1.getSelectedItem().toString();
      switch (selectedOption) {
            case "dbas":
                
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
            
            
            case "degree":
                degree deg = new degree();
              deg.setVisible(true);
              deg.pack();
              deg.setLocationRelativeTo(null);
              deg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              close();
            break;
            case "employee":
                employee emp = new employee();
              emp.setVisible(true);
              emp.pack();
              emp.setLocationRelativeTo(null);
              emp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

    private void Table_showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_showMouseClicked
       try{
            int row = Table_show.getSelectedRow();
            String Table_click=(Table_show.getModel().getValueAt(row,0).toString());
            String sql = "select * from dbas ";
            pst= conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String add1 =rs.getString("username");
                txt_username.setText(add1);
                String add2 =rs.getString("start_date");
                txt_start_date.setText(add2);
                String add3 =rs.getString("end_date");
                txt_end_date.setText(add3);
                          
             
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_Table_showMouseClicked

    private void insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_btnActionPerformed
        try{
            String sql ="INSERT INTO dbas (DBAusername, Edited, Table_, Date) VALUES (?, ?, ?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.setString(2, txt_start_date.getText());
            pst.setString(3, txt_end_date.getText());          
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
            String value2= txt_start_date.getText();
            String value3= txt_end_date.getText();
         
            String sql ="UPDATE  dbas set username='"+value1+"', Edited='"+value2+"', Table_='"+value3+"' WHERE username = ? ";
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data updated succesfully");
        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);}
        Update_Table();
    }//GEN-LAST:event_update_btnActionPerformed

    private void Delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_btnActionPerformed
      try{
            String sql ="DELETE FROM dbas; WHERE username = ?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data deleted succesfully");
        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);}
        Update_Table();
    }//GEN-LAST:event_Delete_btnActionPerformed

    private void Log_out_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Log_out_btnActionPerformed
          Welcome_DBA wd = new Welcome_DBA();
       wd.setVisible(true);
       wd.pack();
       wd.setLocationRelativeTo(null);
       wd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       close();
    }//GEN-LAST:event_Log_out_btnActionPerformed

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
            java.util.logging.Logger.getLogger(dbas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dbas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dbas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dbas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dbas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete_btn;
    private javax.swing.JButton Log_out_btn;
    private javax.swing.JTable Table_show;
    private javax.swing.JButton insert_btn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_end_date;
    private javax.swing.JTextField txt_start_date;
    private javax.swing.JTextField txt_username;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
