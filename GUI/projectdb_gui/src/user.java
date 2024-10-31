
/**
 *
 * @authors PARASKEVAS-SOTIRIOS BERTSEKAS, CHRISTOS DIMITRAKOPOULOS, GIANNIS LAOURENTIUS
 */
import java.sql.*; // APARAITITO GIA SINDESI ME MYSQL, XREIAZETAI TO CONNECTOR APO MYSQL
import javax.swing.*; // GIA ELEGXO PARA8IRWN STIN CLOSE
import net.proteanit.sql.DbUtils; // GIA TO EXTRA FEATURE ME TO CLICK STO ROW, XREIAZETAI TO RS2XML JAR
public class user extends javax.swing.JFrame {
Connection conn=null; // KA8ARISMOS CONNECTION
ResultSet rs =null; // OMOIA GIA TO RESULT SET
PreparedStatement pst=null; // OMOIA GIA TO PREPARED STATEMENT

    
    public user() {
        initComponents();
        conn=connect.connectDb(); // SINDESI
        Update_Table();
    }
    private void Update_Table(){
        try {
                  String sql = "SELECT * FROM user" ;
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_show = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_lastname = new javax.swing.JTextField();
        txt_reg_date = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        insert_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        log_out_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DB PROJECT BY P.B, C.D. AND G.L.");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "user", "applicationshistory", "applies", "dbas", "degree", "employee", "etairia", "evaluator", "has_degree", "job", "languages", "Log_Files", "project", "requires", "subject" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

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

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jLabel3.setText("Name");

        jLabel4.setText("Last Name");

        jLabel5.setText("Reg. Date");

        jLabel6.setText("Email");

        jLabel7.setText("Edit another table");

        insert_btn.setText("Insert data");
        insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_btnActionPerformed(evt);
            }
        });

        update_btn.setText("Update Data");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        delete_btn.setText("Delete Data");
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                                .addComponent(txt_lastname, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txt_name, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txt_email, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txt_reg_date, javax.swing.GroupLayout.Alignment.TRAILING))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(insert_btn)
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(log_out_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(update_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(38, 38, 38)
                                        .addComponent(delete_btn)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_reg_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert_btn)
                    .addComponent(update_btn)
                    .addComponent(delete_btn))
                .addGap(44, 44, 44)
                .addComponent(log_out_btn)
                .addGap(0, 47, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Table_showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_showMouseClicked
         try{
            int row = Table_show.getSelectedRow(); // ANAGNWRISI ROW
            String Table_click=(Table_show.getModel().getValueAt(row,0).toString());
            String sql = "select * from user where username='"+Table_click+"'"; //FERNEI ME ENA KLIK TA ANTISTOIXA PEDIA PINAKA APO TO EPILEGMENO ROW, XEKINONTAS ME USERNAME KAI AFXANONTAS KATA 1
            pst= conn.prepareStatement(sql);
            rs=pst.executeQuery(); // FERNEI TA APOTELESMATA STO RESULT SET APO TO PREPARED STATEMENT
            if(rs.next()){
                String add1 =rs.getString("username");
                txt_username.setText(add1);
                String add2 =rs.getString("password");
                txt_password.setText(add2);
                String add3 =rs.getString("name");
                txt_name.setText(add3);
                String add4 =rs.getString("lastname");
                txt_lastname.setText(add4);
                String add5 =rs.getString("reg_date");
                txt_reg_date.setText(add5);
                String add6 =rs.getString("email");
                txt_email.setText(add6);
                
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_Table_showMouseClicked
public void close() { 
    this.setVisible(false); // KLEISIMO PARA8IROU
    this.dispose();
}
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
String selectedOption = jComboBox1.getSelectedItem().toString(); // STRING RECOGNITION GIA TO POION PINAKA DIALEXE O XRISTIS KAI ANALOGO SWITCH
      switch (selectedOption) {
            case "user": // DEN KANEI TIPOTA, EFOSON EINAI EKEI. SWITCH OMOIAS LOGIKIS ME TABLEINFO.
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
            default:
                break;
      }        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_btnActionPerformed
        try{
            String sql ="INSERT INTO User (username,password,name,lastname,reg_date,email) VALUES (?, ?, ?, ?, ?, ?)"; // INSERT QUERY
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.setString(2, txt_password.getText());
            pst.setString(3, txt_name.getText());           // STRING RECOGNITION APO TEXT FIELDS
            pst.setString(4, txt_lastname.getText());
            pst.setString(5, txt_reg_date.getText());
            pst.setString(6, txt_email.getText());
            pst.execute(); // EXECUTE TOU PREPARED STATEMENT
            JOptionPane.showMessageDialog(null, "Data inserted succesfully");
        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);}
        Update_Table();
    }//GEN-LAST:event_insert_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
         try{
            String sql ="DELETE FROM User WHERE username = ?"; // DELETE QUERY
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_username.getText()); // STRING RECOGNITION
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data deleted succesfully");
        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);}
        Update_Table();
    }//GEN-LAST:event_delete_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
       try{
            
            
            String value1= txt_username.getText();
            String value2= txt_password.getText();
            String value3= txt_name.getText();
            String value4= txt_lastname.getText();
            String value5= txt_reg_date.getText();
            String value6= txt_email.getText();
            String sql ="UPDATE  User SET username='"+value1+"', password='"+value2+"', name='"+value3+"', lastname='"+value4+"', reg_date='"+value5+"', email='"+value6+"' WHERE username='"+value1+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data updated succesfully");
        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);}
        Update_Table();
    }//GEN-LAST:event_update_btnActionPerformed

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
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user().setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton log_out_btn;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_lastname;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_reg_date;
    private javax.swing.JTextField txt_username;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
