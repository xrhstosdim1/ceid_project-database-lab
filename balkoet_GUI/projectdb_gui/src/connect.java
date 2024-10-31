/**
 *
 * @authors PARASKEVAS-SOTIRIOS BERTSEKAS, CHRISTOS DIMITRAKOPOULOS, GIANNIS LAOURENTIUS
 */
import java.sql.*; // APARAITITO GIA SINDESI ME MYSQL, TO VRISKOUME STO CONNECTOR TIS MYSQL
import javax.swing.*; // APARAITITO GIA ELEGXO TWN MINIMATWN
public class connect {
    
    Connection conn= null;
    public static Connection connectDb(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root"); // OPOU ROOT ROOT, USERNAME PASSWORD, LOCALHOST= HOST :3306 = PORT
    //JOptionPane.showMessageDialog(null,"Connected to database succesfully"); TROUBLESHOOTING MESSAGE
    return conn;
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        return null;
    }
}
}
