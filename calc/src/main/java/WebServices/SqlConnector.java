package WebServices;

import java.sql.*;

/**
 * Created by afilippov on 18.05.14 17:14.
 */

public class SqlConnector {

    // TODO: где и как хранить информацию о подключении?
    static final String DB_URL      = "jdbc:sqlserver://localhost:1433;databaseName=testDB";
    static final String USER        = "sa";
    static final String PASS        = "12345";
    static final String driver      = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private Connection conn = null;
    private Statement stmt  = null;

    public Connection getConnection() throws Exception {

        // Open a connection
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        return conn;
    }

    public Statement GetStatement() throws Exception {

        if(conn==null)
            getConnection();

        if(stmt==null && conn!=null)
            stmt = conn.createStatement();

        return stmt;
    }

    public void CloseConnection() throws Exception{
        if(conn!=null)
            conn.close();
    }
}

