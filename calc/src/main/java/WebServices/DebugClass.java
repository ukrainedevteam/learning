package WebServices;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by afilippov on 19.05.14 19:05.
 */
public class DebugClass {

    public static void main(String args[]){

        String UserInfo = "not found";

        try {
            SqlConnector conn = new SqlConnector();
            Statement stmt = conn.GetStatement();

            if (stmt!=null){
                ResultSet rs;
                rs = stmt.executeQuery("SELECT Name FROM Users WHERE UserID = 1");
                if (rs.next()) {
                    UserInfo = rs.getString("Name");
                }
                conn.CloseConnection();
            }else {
                UserInfo = "error connection to database!";
            }
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println(UserInfo);
    }
}
