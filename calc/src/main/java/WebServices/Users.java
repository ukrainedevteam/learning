package WebServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.*;

/**
 * Created by afilippov on 18.05.14 18:43.
 */
@Path("/info")
public class Users {

    @GET
    @Path("/GetUserInfo")
    @Produces("text/plain")
    public String GetUserInfo(){

        String result = "not found";

        try {
            SqlConnector conn = new SqlConnector();
            Statement stmt = conn.GetStatement();

            if (stmt!=null){
                ResultSet rs;
                rs = stmt.executeQuery("SELECT Name FROM Users WHERE UserID = 1");
                if (rs.next()) {
                    result = rs.getString("Name");
                }
                conn.CloseConnection();
            }else {
                result = "error connection to database!";
            }
        }catch (Exception e){
            result = "Connection failed! " + e;
        }

        return result;
    }
}
