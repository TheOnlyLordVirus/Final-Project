package start;
import java.sql.*;
import start.OfficeRoom.enumCombination;

public class Escape_DB {
        /**
		* Create Database Method that can throw Exceptions
		*/
        static void Database(enumCombination enumCombination) 
        {
			/**
			* Sets up the URL for the JDBC to derby:zoo;create=true
			*/
            String url = "jdbc:derby:ESCAPE;create=true";
			/**
			* Sets up Derby DB Connection.
			*/
            try (Connection conn = DriverManager.getConnection(url); 
                Statement stmt = conn.createStatement()) {

                /**
                * Run Database setup code
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
				    * Get Staff Directory
                    */
                    switch(enumCombination) {
                    /**
                    * Switch statemnt if currentCombination = login computer
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
                    * Switch statemnt if currentCombination = check database
                    */
                    case checkdatabase:
                        /**
                        * Creates query called STAFF for all records in STAFF
                        */
		    			ResultSet STAFF = stmt.executeQuery("SELECT * FROM STAFF");
                        Escape_The_Psych_Ward.iPrintLn("\n" + "Department: Science Division");
                        /**
                        * Loop and print out while STAFF has a next row
                        */
                        while(STAFF.next()) {
                            Escape_The_Psych_Ward.iPrintLn("Name: " + STAFF.getString("EMPLOYEE_NAME") + "\n" + "Position: " + STAFF.getString("ROLE"));
                        }
                        Escape_The_Psych_Ward.iPrintLn("\n" + "Prisoners:");
                        /**
                        * Creates query called SUBJECTS for all records in STAFF
                        */
		    			ResultSet SUBJECTS = stmt.executeQuery("SELECT * FROM SUBJECTS");
                        /**
                        * Loop and print out while SUBJECTS has a next row
                        */
                        while(SUBJECTS.next()) {
                            Escape_The_Psych_Ward.iPrintLn("Name: " + SUBJECTS.getString("SUBJECT_NAME") + "\n" + "Age: " + SUBJECTS.getString("SUBJECT_AGE") + "\n" + "Total Memory Wipes: " + SUBJECTS.getString("MEMORY_WIPES"));
                        }
                        break;
                    /**
                    * Switch statemnt if currentCombination = add record
                    */
                    case addrecord:
                        Escape_The_Psych_Ward.iPrintLn("You feel mischeivous and decide to add a fake staff member");
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
		    			ResultSet ADD = stmt.executeQuery("SELECT * FROM STAFF WHERE STAFF_ID = 4");
                        Escape_The_Psych_Ward.iPrintLn("\n" + "Department: Science Division");
                        /**
                        * Loop and print out while the ADD query has a next row
                        */
                        while(ADD.next()) {
                            Escape_The_Psych_Ward.iPrintLn("Name: " + ADD.getString("EMPLOYEE_NAME") + "\n" + "Position: " + ADD.getString("ROLE"));
                        }
                        break;
                    /**
                    * Switch statemnt if currentCombination = updaterecord 
                    */
                    case updaterecord:

                        Escape_The_Psych_Ward.iPrintLn("You notice that your nick's age is incorrect");
                        /**
                        * Updates SUBJECT_AGE in SUBJECTS for the SUBJECT_ID that = 3
                        */
                        stmt.executeUpdate("UPDATE SUBJECTS SET SUBJECT_AGE = 35 WHERE SUBJECT_ID = 3");
		    			ResultSet AGE = stmt.executeQuery("SELECT * FROM SUBJECTS WHERE SUBJECT_ID = 3");
                        /**
                        * Loop and print out while the ADD query has a next row
                        */
                        while(AGE.next()) {
                            Escape_The_Psych_Ward.iPrintLn("Name: " + AGE.getString("SUBJECT_NAME") + "\n" + "Age: " + AGE.getString("SUBJECT_AGE") + "\n" + "Total Memory Wipes: " + AGE.getString("MEMORY_WIPES"));
                        }
                        break;
                    /**
                    * Switch statemnt if currentCombination = deleterecords
                    */
                    case deleterecords: 
                        Escape_The_Psych_Ward.iPrintLn("You take this opertunity to delete all prisoner records.");
                        /**
                        * Deletes all records in SUBJECTS
                        */
                        stmt.executeUpdate("DELETE FROM SUBJECTS WHERE SUBJECT_ID > 0");
                        /**
                        * Creates a query of all rows in SUBJECTS
                        */
		    			ResultSet DELETE = stmt.executeQuery("SELECT * FROM SUBJECTS");
                        /**
                        * Loop and print out while the DELETE query has a next row
                        */
                        if(DELETE.next()) {
                            Escape_The_Psych_Ward.iPrintLn("Name: " + DELETE.getString("SUBJECT_NAME") + "\n" + "Age: " + DELETE.getString("SUBJECT_AGE") + "\n" + "Total Memory Wipes: " + DELETE.getString("MEMORY_WIPES"));
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
            } catch (SQLException e) {
            	Escape_The_Psych_Ward.iPrintLn("Something went wrong, please try again.");
			}
		}
	}

