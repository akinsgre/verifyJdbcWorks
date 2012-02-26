package com.insomnia;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    Connection conn ;
    public static void main( String[] args )
    {
        System.out.println( "Starting jdbc query..." );
	App app = new App();
	app.execute();
        System.out.println( "Completing jdbc query..." );
    }

    public void execute()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
	    String url="jdbc:oracle:thin:@//10.211.55.14:1521/PCS";
	    System.out.println("Connecting to " + url);
	    conn = DriverManager.getConnection(url, "scott", "tiger");
	    System.out.println("Executing Query");
	    Statement st = conn.createStatement();
	    ResultSet rs = st.executeQuery("select 0 from dual");
	    System.out.println("Got REsults");
	    while (rs.next() ) {
		int key = rs.getInt(1);

		System.out.println("Got a result" + key);
	    }
        }
        catch (Exception ex) {
	    ex.printStackTrace();
        }
	finally {
	    if (conn != null) {
		try {
		    conn.close();
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
		
	    }
	}

    }

}
