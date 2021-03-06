package Core;
import java.sql.*;
import java.util.ArrayList;

import Scenes.OfficeRoom.enumCombination;
import start.Escape_The_Psych_Ward;

/**
 * Escape_DB Class
 */
public class Escape_DB {
		/**
		* Creates a custom exception nested 
		*/
		public static class BadConnection extends Exception { 
			private static final long serialVersionUID = 1L;
			public BadConnection(String errorMessage) {
				super(errorMessage);
			}
		}
		
        /**
		* Create Database Method that can throw Exceptions
         * @throws SQLException 
         * @throws BadConnection 
		*/
        public static void Database(enumCombination enumCombination) throws SQLException, BadConnection 
        {
        	
			/**
			* Sets up the URL for the JDBC to derby:ESCAPE;create=true
			*/
	        String url = "jdbc:derby:ESCAPE;create=true";
			/**
			* Check if the custom connection is null
			* using assertions we check if the connection is null
			* if the connection is null we throw our customer "Bad Connection" exception
			* from our nested BadConnection class
			*/
	        Connection conn = DriverManager.getConnection(url); 
	        if (conn == null) {
	        	throw new BadConnection("Connection is null");
	        }
            /**
            * if the connection is not null continue to run the DB setup code
            */
	        else {
	        /**
	        * Create a customer create statement
	        */
	        Statement stmt = conn.createStatement();
	        /**
	        * DB setup code try to run
	        */
            try {
                /**
                * Drop all tables if they exist
                */
                stmt.executeUpdate("DROP TABLE SUBJECTS");
                stmt.executeUpdate("DROP TABLE STAFF");
                /**
                * CREATES STAFF TABLE
                */
                stmt.executeUpdate("CREATE TABLE STAFF ("
                    + "STAFF_ID INT PRIMARY KEY NOT NULL,"
                    + "EMPLOYEE_NAME VARCHAR(50) NOT NULL,"
                    + "DEPARTMENT VARCHAR(50),"
                    + "ROLE VARCHAR(50)"
                    + ")");
                /**
                * UPDATES STAFF TABLE WITH VALUES
                */
                stmt.executeUpdate("INSERT INTO STAFF  VALUES ("
                    + "1,"
                    + "'Timothy Cain',"
                    + "'Science Division',"
                    + "'Head Researcher'"
                    + ")");
                stmt.executeUpdate("INSERT INTO STAFF VALUES ("
                    + "2,"
                    + "'Charles Ashford',"
                    + "'Science Division',"
                    + "'Sr. Researcher'"
                    + ")");
                stmt.executeUpdate("INSERT INTO STAFF VALUES ("
                    + "3,"
                    + "'Anna Bolt',"
                    + "'Science Division',"
                    + "'Researcher'"
                    + ")");
                /**
                * CREATES SUBJECTS TABLE
                */
                stmt.executeUpdate("CREATE TABLE SUBJECTS ("
                    + "SUBJECT_ID INT PRIMARY KEY NOT NULL,"
                    + "STAFF_ID INT REFERENCES STAFF(STAFF_ID),"
                    + "SUBJECT_NAME VARCHAR(255) NOT NULL,"
                    + "SUBJECT_AGE INT,"
                    + "MEMORY_WIPES INT"
                    + ")");
                /**
                * UPDATES STAFF TABLE WITH VALUES
                */
                stmt.executeUpdate("INSERT INTO SUBJECTS (SUBJECT_ID,STAFF_ID,SUBJECT_NAME,SUBJECT_AGE,MEMORY_WIPES) VALUES ("
                    + "1,"
                    + "3,"
                    + "'Cole Frisch',"
                    + "20,"
                    + "3"
                    + ")");
                stmt.executeUpdate("INSERT INTO SUBJECTS (SUBJECT_ID,STAFF_ID,SUBJECT_NAME,SUBJECT_AGE,MEMORY_WIPES) VALUES ("
                    + "2,"
                    + "1,"
                    + "'Trenton Metzler',"
                    + "23,"
                    + "1"
                    + ")");
                stmt.executeUpdate("INSERT INTO SUBJECTS (SUBJECT_ID,STAFF_ID,SUBJECT_NAME,SUBJECT_AGE,MEMORY_WIPES) VALUES ("
                    + "3,"
                    + "2,"
                    + "'Nick Schuchard',"
                    + "37,"
                    + "5"
                    + ")");
                stmt.executeUpdate("INSERT INTO SUBJECTS (SUBJECT_ID,STAFF_ID,SUBJECT_NAME,SUBJECT_AGE,MEMORY_WIPES) VALUES ("
                    + "4,"
                    + "3,"
                    + "'Jose Tlatempa-Domingu',"
                    + "25,"
                    + "0"
                    + ")");
                } catch( SQLException i ) {
                	Escape_The_Psych_Ward.iPrintLn("*****************************");
                	Escape_The_Psych_Ward.iPrintLn("********** WARNING **********");
                	Escape_The_Psych_Ward.iPrintLn("*****************************");
                	Escape_The_Psych_Ward.iPrintLn("FILES NOT FOUND...");
                	Escape_The_Psych_Ward.iPrintLn("RESTOREING FROM BACKUP...");
                    /**
                    * CREATES STAFF TABLE
                    */
                    stmt.executeUpdate("CREATE TABLE STAFF ("
                        + "STAFF_ID INT PRIMARY KEY NOT NULL,"
                        + "EMPLOYEE_NAME VARCHAR(50) NOT NULL,"
                        + "DEPARTMENT VARCHAR(50),"
                        + "ROLE VARCHAR(50)"
                        + ")");
                    /**
                    * UPDATES STAFF TABLE WITH VALUES
                    */
                    stmt.executeUpdate("INSERT INTO STAFF  VALUES ("
                        + "1,"
                        + "'Timothy Cain',"
                        + "'Science Division',"
                        + "'Head Researcher'"
                        + ")");
                    stmt.executeUpdate("INSERT INTO STAFF VALUES ("
                        + "2,"
                        + "'Charles Ashford',"
                        + "'Science Division',"
                        + "'Sr. Researcher'"
                        + ")");
                    stmt.executeUpdate("INSERT INTO STAFF VALUES ("
                        + "3,"
                        + "'Anna Bolt',"
                        + "'Science Division',"
                        + "'Researcher'"
                        + ")");
                    /**
                    * CREATES SUBJECTS TABLE
                    */
                    stmt.executeUpdate("CREATE TABLE SUBJECTS ("
                        + "SUBJECT_ID INT PRIMARY KEY NOT NULL,"
                        + "STAFF_ID INT REFERENCES STAFF(STAFF_ID),"
                        + "SUBJECT_NAME VARCHAR(255) NOT NULL,"
                        + "SUBJECT_AGE INT,"
                        + "MEMORY_WIPES INT"
                        + ")");
                    /**
                    * UPDATES STAFF TABLE WITH VALUES
                    */
                    stmt.executeUpdate("INSERT INTO SUBJECTS (SUBJECT_ID,STAFF_ID,SUBJECT_NAME,SUBJECT_AGE,MEMORY_WIPES) VALUES ("
                        + "1,"
                        + "3,"
                        + "'Cole Frisch',"
                        + "20,"
                        + "3"
                        + ")");
                    stmt.executeUpdate("INSERT INTO SUBJECTS (SUBJECT_ID,STAFF_ID,SUBJECT_NAME,SUBJECT_AGE,MEMORY_WIPES) VALUES ("
                        + "2,"
                        + "1,"
                        + "'Trenton Metzler',"
                        + "23,"
                        + "1"
                        + ")");
                    stmt.executeUpdate("INSERT INTO SUBJECTS (SUBJECT_ID,STAFF_ID,SUBJECT_NAME,SUBJECT_AGE,MEMORY_WIPES) VALUES ("
                        + "3,"
                        + "2,"
                        + "'Nick Schuchard',"
                        + "37,"
                        + "5"
                        + ")");
                    stmt.executeUpdate("INSERT INTO SUBJECTS (SUBJECT_ID,STAFF_ID,SUBJECT_NAME,SUBJECT_AGE,MEMORY_WIPES) VALUES ("
                        + "4,"
                        + "3,"
                        + "'Jose Tlatempa-Domingu',"
                        + "25,"
                        + "0"
                        + ")");
                    }
			        /**
			        * After the DB has been setup run the switch statement code to access the DB queries
			        */
            		finally {
                        /**
     				    * Get Staff Directory
                         */
                         switch(enumCombination) {
                         /**
                         * Switch statement if currentCombination = login computer
                         */
                         case logincomputer:
                            /**
                            * Simulate Login
                            */
                         	Escape_The_Psych_Ward.iPrintLn("Welcome to Server 56-D");
                            Escape_The_Psych_Ward.iPrintLn("Login: TC1");
              		    	Escape_The_Psych_Ward.iPrintLn("Password: ***********");
                            Escape_The_Psych_Ward.iPrintLn("Login Sucessful");
                            Escape_The_Psych_Ward.iPrintLn("Accessing System Files...");
                         	break;

                         /**
                         * Switch statement if currentCombination = check database
                         */
                         case checkdatabase:
                        	 ArrayList<String> STAFFLIST = new ArrayList<String>();
                        	 ArrayList<String> SUBJECTLIST = new ArrayList<String>();
                             /**
                             * TV Show Reference /https://www.youtube.com/watch?v=vBuZoFjEFAY
                             */
                        	 String Text = "Stewie the cool!";

                             /**
                              * 
                             * Creates query called STAFF for all records in STAFF
                             */
     		    			 ResultSet STAFF = stmt.executeQuery("SELECT * FROM STAFF");
                             Escape_The_Psych_Ward.iPrintLn("Department: Science Division");
                             /**
                             * Loop and print out while STAFF has a next row
                             */
                             while(STAFF.next()) {
                            	 STAFFLIST.add("Name: " + STAFF.getString("EMPLOYEE_NAME") + "\n" + "Position: " + STAFF.getString("ROLE"));
                             }
                             /**
                             * Lamda foreach print expression 1
                             */
                             STAFFLIST.forEach((String v) -> Escape_The_Psych_Ward.iPrintLn(v));
                             Escape_The_Psych_Ward.iPrintLn("Prisoners:");
                             /**
                             * Creates query called SUBJECTS for all records in STAFF
                             */
     		    			 ResultSet SUBJECTS = stmt.executeQuery("SELECT * FROM SUBJECTS");
                             /**
                             * Loop and print out while SUBJECTS has a next row
                             */
                             while(SUBJECTS.next()) {
                            	 SUBJECTLIST.add("Name: " + SUBJECTS.getString("SUBJECT_NAME") + "\n" + "Age: " + SUBJECTS.getString("SUBJECT_AGE") + "\n" + "Total Memory Wipes: " + SUBJECTS.getString("MEMORY_WIPES"));
                             }
                             /**
                             * Lambda foreach print expression 2 + Lambda with variable.
                             * 
                             */
                             SUBJECTLIST.forEach((String v) -> Escape_The_Psych_Ward.iPrintLn(v + Text));
                             Escape_The_Psych_Ward.iPrintLn("It would appear there is some sort of \"Stewie Is Cool\" glitch...");
                             break;
                             
                         /**
                         * Switch statement if currentCombination = add record
                         */
                         case addrecord:
                        	 ArrayList<String> ADDLIST = new ArrayList<String>();
                             /**
                             * Inserts a row into STAFF
                             */
                             stmt.executeUpdate("INSERT INTO STAFF  VALUES ("
                                 + "4,"
                                 + "'Bob Ross',"
                                 + "'Painting Division',"
                                 + "'Head Painter'"
                                 + ")");
                             /**
                             * Creates query called ADD for all records in STAFF WHERE THE STAFF ID = 4
                             */
     		    			 ResultSet ADD = stmt.executeQuery("SELECT * FROM STAFF WHERE STAFF_ID > 4");
                             Escape_The_Psych_Ward.iPrintLn("\n" + "Department: Science Division");
                             /**
                             * Loop and print out while the ADD query has a next row
                             */
                             while(ADD.next()) {
          		    			ADDLIST.add("Name: " + ADD.getString("EMPLOYEE_NAME") + "\n" + "Position: " + ADD.getString("ROLE"));
                             }
                             /**
                             * Lamda foreach print expression 3
                             */
                             ADDLIST.forEach((String v) -> Escape_The_Psych_Ward.iPrintLn(v));
                             break;
                             
                         /**
                         * Switch statement if currentCombination = updaterecord 
                         */
                         case updaterecord:
                        	 ArrayList<String> AGELIST = new ArrayList<String>();
                             /**
                             * Updates SUBJECT_AGE in SUBJECTS for the SUBJECT_ID that = 3
                             */
                             stmt.executeUpdate("UPDATE SUBJECTS SET SUBJECT_AGE = 35 WHERE SUBJECT_ID = 3");
     		    			ResultSet AGE = stmt.executeQuery("SELECT * FROM SUBJECTS WHERE SUBJECT_ID = 3");
                             /**
                             * Loop and print out while the ADD query has a next row
                             */
                             while(AGE.next()) {
                            	 AGELIST.add("Name: " + AGE.getString("SUBJECT_NAME") + "\n" + "Age: " + AGE.getString("SUBJECT_AGE") + "\n" + "Total Memory Wipes: " + AGE.getString("MEMORY_WIPES"));
                             }
                             /**
                             * Lamda foreach print expression 4
                             */
                             AGELIST.forEach((String v) -> Escape_The_Psych_Ward.iPrintLn(v));
                             break;
                             
                         /**
                         * Switch statement if currentCombination = deleterecords
                         */
                         case deleterecords:
                        	 ArrayList<String> DELETELIST = new ArrayList<String>();
                             /**
                             * Deletes all records in SUBJECTS
                             */
                             stmt.executeUpdate("DELETE FROM SUBJECTS WHERE SUBJECT_ID > 0");
                             stmt.executeUpdate("DELETE FROM STAFF WHERE STAFF_ID > 0");
                             /**
                             * Creates a query of all rows in SUBJECTS
                             */
     		    			ResultSet DELETE = stmt.executeQuery("SELECT * FROM SUBJECTS, STAFF");
     		    			DELETELIST.add("Name: " + DELETE.getString("SUBJECT_NAME") + "\n" + "Age: " + DELETE.getString("SUBJECT_AGE") + "\n" + "Total Memory Wipes: " + DELETE.getString("MEMORY_WIPES"));
     		    			
                             /**
                             * Loop and print out while the DELETE query has a next row
                             */
                             if(DELETE.next()) {
                                 /**
                                  * Lamda foreach print expression 5
                                  */
                            	 DELETELIST.forEach((String v) -> Escape_The_Psych_Ward.iPrintLn(v));
                             }
                             /**
                             * If there are no records in SUBJECTS then print out message.
                             */
                             else {
                                 Escape_The_Psych_Ward.iPrintLn("No Prisoner Records Found.");
                             }
                             break;
                            
                        	 
                         /**
                         * If the selection variable is not part of the switch statment then give error message.
                         */
                         default :
                         Escape_The_Psych_Ward.iPrintLn("Command not found, please try again.");
                    }
            	}
            }
		}
	}

