import java.util.*;
import java.sql.*;

/** 
	Practice how to access a MySQL database through Java
 */

public class DbLabStudent
{
	public static void main(String args[])
	{
		ResultSet rs = null;
		Statement s = null;
		Connection conn = null;
		String query = null;
		ResultSetMetaData rsmd = null;
      int rows = 0;
		
		System.out.println("Connecting to a MySQL database, on this computer.");
		
		 try
       {
         String userName = "root";
         String password = "root";
         String url = "jdbc:mysql://localhost/jobs";	// jobs database
         Class.forName("com.mysql.jdbc.Driver");	// Needs driver in dir
         conn = DriverManager.getConnection (url, userName, password);
         
			System.out.println ("Database connection successful");

			// s is a Statement object that can execute a query
			s = conn.createStatement();

// Beginning of using EMPLOYER table ==================
			System.out.println("Show selected information from Employer table\n");

			// 1) Look at output when run like this, don't make these changes until the lab says to do them.
			// 2) Add the city and state to the following SELECT.
			// 3) Add DISTINCT after select as in: SELECT DISTINCT companyname
			//    See how many rows come out now.  Which ones are missing?
			//    Answer question in lab handout.
			query = "SELECT Distinct companyname, zipcode, city, statecode FROM employer;";
			
			// Execute the query and return resultset
			rs = s.executeQuery( query );
			
			//	Get the meta data so we can see information about data we retrieved
			rsmd = rs.getMetaData();
	
			// STUDENTS: Make sure you set the width to fit the field width you find in MySQL
			System.out.printf("%-33s %-25s %8s %5s  \n\n", 
						"Company Name", "City", "StateCode", "Zip Code");
			
			// Print out the data			
			String coName = null;
			int zipCode = -1;
         String city = null;
         String state = null;
		
			// Loop through the resultset, getting each row of information
			while (rs.next()) 
			{
				coName = rs.getString(1);
				zipCode = rs.getInt(2);
            city = rs.getString(3);
            state = rs.getString(4);
								
				// Need to left fill zip code with zeros  
				System.out.printf("%-33s  %-25s %8s %05d\n", 
							coName, city, state, zipCode );
            rows++;
			}

			System.out.println("\nRows processed: "+rows);

// This is the end of using EMPLOYER table 
//Starting Interview table
         query = " select companyname, division, salaryoffered*minhrsoffered as descr from interview order by descr limit 10;";
			
			// Execute the query and return resultset
			rs = s.executeQuery( query );
			
			//	Get the meta data so we can see information about data we retrieved
			rsmd = rs.getMetaData();
	
			// STUDENTS: Make sure you set the width to fit the field width you find in MySQL
			System.out.printf("\n==>>From Interview table\n\n%-33s %-25s %8s \n\n", 
						"Company Name", "Division", "Weekly Salary");
			
			// Print out the data			
			coName = null;
			int sal = -1;
         String div = null;
         rows = 0;
		
			// Loop through the resultset, getting each row of information
			while (rs.next()) 
			{
				coName = rs.getString(1);
				div = rs.getString(2);
            sal = rs.getInt(3);
								
				// Need to left fill zip code with zeros  
				System.out.printf("%-33s %-25s %8d\n", 
							coName, div, sal );
            rows++;
			}

			System.out.println("\nRows processed: "+rows);
// This is the end of using INTERVIEW table ==================	

		  }
	     catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
				e.printStackTrace();
        }
		  finally
		  {
		  	System.out.println("\nClosing database.");			
			try{
				if( rs != null )	rs.close();
				if(  s != null )	s.close();
				if( conn != null )conn.close();
		 	}
			catch(SQLException se){
				System.out.println("Error closing database connections.");
				//se.printStackTrace();
			}
		  }
		  System.out.println("Demo is exiting...");
	}
}