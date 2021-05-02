package Scenes;

import java.sql.SQLException;

import Core.Escape_DB;
import Core.GameManager;
import Core.Logger;
import Core.Escape_DB.BadConnection;
import start.Escape_The_Psych_Ward;

/**
 * OfficeRoom Class extends Scene
 */
public class OfficeRoom extends Scene {
	
	// Variables
	boolean haveLogin = false;
	boolean computerHasBeenLogin = false;

	enumCombination currentCombination;

	// Combinations for user input on this scene.
	public enum enumCombination {
		opendoor, inspectdoor, checkdoor, jump, crawlvent, movevent, checkdesk, inspectdesk,
		logincomputer, addrecord, checkdatabase, updaterecord, deleterecords, movepsych, movepsychroom,
		movelobby, movemainlobby, movelobbyroom, movemainlobbyroom, checkcomputer, inspectcomputer,
		golobby, golobbyroom, gomainlobby, walklobby, walkmainlobby, walkvent, govent, gopsychroom,
		walkpsychroom, walkpsych, gopsych, walkmainlobbyroom, walklobbyroom, gomainlobbyroom, lookdesk
	}

	// The constructor will set the Location Name and Description for each scene.
	public OfficeRoom() {
		this.LocationName = "Office Room";
		this.LocationDescription = "You are in a dark room that appears to be an office for pysch staff.\n"
				+ "You see a desk with active computer that you could use.\n"
				+ "You see a door that leads to the main lobby.\n"
				+ "You see the vent that you have use to get here from your room.";
	}

	/**
	 * ParseCombination method
	 */
	@Override
	public void ParseCombination(String parseToCombination) {
		currentCombination = enumCombination.valueOf(parseToCombination);
	}

	/**
	 * Interaction method performs action based on combination given
	 * @throws Exception 
	 */
	@Override
	public void interaction() {
		switch (currentCombination) {
		
		// Inspect door commands
		case inspectdoor:
		case checkdoor:	
		
			// Print messages
			Escape_The_Psych_Ward.iPrintLn("You have inspected the office door that leads to the main lobby.");
			Escape_The_Psych_Ward.iPrintLn("The office door appears to be unlock.");
			Escape_The_Psych_Ward.iPrintLn("But you could hear loud snoring noises coming from the other side of the door.");
			Escape_The_Psych_Ward.iPrintLn("Proably not a good idea to open this door since you might wake someone up.");
			
			break;
		
		// Open door commands
		case opendoor:
		case movelobby:
		case movelobbyroom:
		case movemainlobby:
		case movemainlobbyroom:
		case golobby:
		case gomainlobby:
		case gomainlobbyroom:
		case golobbyroom:
		case walklobby:
		case walkmainlobby:
		case walklobbyroom:
		case walkmainlobbyroom:
			
			// End game
			GameManager.gameHasEnded();
			
			// Print bad ending messages
			Escape_The_Psych_Ward.iPrintLn("Bad Ending:");
			Escape_The_Psych_Ward.iPrintLn("You decided to open the office door to the main lobby.");
			Escape_The_Psych_Ward.iPrintLn("You startled the guard that was taking a nap on the chair.");
			Escape_The_Psych_Ward.iPrintLn("Before you can flee the guard pulls out his tazer and tazes you.");
			Escape_The_Psych_Ward.iPrintLn("You have been given a lobotomy as punishment for your actions.");
			Escape_The_Psych_Ward.iPrintLn("You now have the intelligence of a potato and incapable of thinking.");
			Escape_The_Psych_Ward.iPrintLn("The End.");
			Escape_The_Psych_Ward.iPrintLn("");
			Escape_The_Psych_Ward.iPrintLn("Tip: Some areas should not be travel at all.");
			Escape_The_Psych_Ward.iPrintLn("Restart the application to try again!");
			
			// Print in log
			Logger.addLog("Bad Ending: Office Door");
			
			break;
		
		// Inspect desk commands
		case inspectdesk:
		case checkdesk:
		case lookdesk:
			
			// Check if login is false
			if(haveLogin == false) {
				
				// Print messages
				Escape_The_Psych_Ward.iPrintLn("You search the desk and found a sticky note.");
				Escape_The_Psych_Ward.iPrintLn("The sticky note has an username and password on it.");
				Escape_The_Psych_Ward.iPrintLn("Maybe you can use it on the computer.");
				Escape_The_Psych_Ward.iPrintLn("");
				Escape_The_Psych_Ward.iPrintLn("You continue search through the desk and found a pack of cigarettes.");
				Escape_The_Psych_Ward.iPrintLn("This could be useful for trading.");
				
				// Add sticky note into inventory
				GameManager.UserItems.Add(passwordNote);
				
				// Add cigarettes into inventory
				GameManager.UserItems.Add(smokersCiggarette);
				
				// Set login to true
				haveLogin = true;
			}
			else {
				
				// Print messages
				Escape_The_Psych_Ward.iPrintLn("You already search through the desk.");
				Escape_The_Psych_Ward.iPrintLn("You found a sticky note with some account information and cigarettes the last time you search through it.");
			}
			
			break;
		
		// Inspect computer commands
		case inspectcomputer:
		case checkcomputer:
			
			// Print messages
			Escape_The_Psych_Ward.iPrintLn("You inspect the active computer.");
			Escape_The_Psych_Ward.iPrintLn("You notice that the computer requires an username and password if you want to use it.");
			Escape_The_Psych_Ward.iPrintLn("Maybe you can find somthing that has an username and password writen on it.");
			Escape_The_Psych_Ward.iPrintLn("You should try looking around the office room.");
			
			break;
		
		// Login computer commands
		case logincomputer:
			
			// Check player have a login
			if(haveLogin == true) {
				
				// Check if computer has been login
				if (computerHasBeenLogin == false) {
					
					// Print message
					Escape_The_Psych_Ward.iPrintLn("You have decided to login into the computer using the information provided by the sticky note");
					Escape_The_Psych_Ward.iPrintLn("The following information has been displayed on the computer moniter:");
					Escape_The_Psych_Ward.iPrintLn("");
					
					// Perform database actions
					try {
						
						Escape_DB.Database(currentCombination);
						
					} catch (SQLException | BadConnection e) {
						e.printStackTrace();
					}
				}
				else {
					
					// Print message
					Escape_The_Psych_Ward.iPrintLn("You already login into the computer");
				}
			}
			else {
				
				// Print message
				Escape_The_Psych_Ward.iPrintLn("You need to find a username and password to login into the computer.");
			}
			
			break;
			
		// Give me a C!
		case addrecord:
			
			// Print messages
            Escape_The_Psych_Ward.iPrintLn("You feel mischeivous and decide to add a fake staff member.");
			Escape_The_Psych_Ward.iPrintLn("The following information has been displayed on the computer moniter:");
			Escape_The_Psych_Ward.iPrintLn("");
			
			//Add a record to the database
			try {
				Escape_DB.Database(currentCombination);
			} catch (SQLException | BadConnection e) {

				e.printStackTrace();
			}
			break;
		
		// Give me a R!
		case checkdatabase:
			
			// Print messages
			Escape_The_Psych_Ward.iPrintLn("You decided to check the database on the computer.");
			Escape_The_Psych_Ward.iPrintLn("The following information has been displayed on the computer moniter:");
			Escape_The_Psych_Ward.iPrintLn("");
			
			//Access all database records
			try {
				
				// Perform database
				Escape_DB.Database(currentCombination);
				
			} catch (SQLException | BadConnection e) {

				e.printStackTrace();
			}
			break;
			
		// Give me a U!
		case updaterecord: 
			
			// Print messages
            Escape_The_Psych_Ward.iPrintLn("You notice that your nick's age is incorrect.");
			Escape_The_Psych_Ward.iPrintLn("The following information has been displayed on the computer moniter:");
			Escape_The_Psych_Ward.iPrintLn("");
			
			//update a record in the database
			try {
				
				// Perform database
				Escape_DB.Database(currentCombination);
				
			} catch (SQLException | BadConnection e) {

				e.printStackTrace();
			}
			break;
			
		// Give me a D
		// What does that spell??? CRUD!
		case deleterecords: 
			
			// Print messages
            Escape_The_Psych_Ward.iPrintLn("You take this opportunity to delete all of the prisoner records.");
			Escape_The_Psych_Ward.iPrintLn("The following information has been displayed on the computer moniter:");
			Escape_The_Psych_Ward.iPrintLn("");
			
			// Delete all records in the SUBJECTS table.
			try {
				
				Escape_DB.Database(currentCombination);
				
			} catch (SQLException | BadConnection e) {
				
				e.printStackTrace();
			}
			break;
			
		// Move to psych room commands
		case crawlvent:
		case movevent:
		case govent:
		case walkvent:
		case movepsych:
		case movepsychroom:
		case gopsych:
		case gopsychroom:
		case walkpsychroom:
		case walkpsych:
			
			// Move to psych room
			GameManager.currentLocation = "Psych Room";
			GameManager.location();
			Escape_The_Psych_Ward.iPrintLn("You have crawl through the vent back to your psych room.");
			break;
			
		default:
			break;
	}
	}
}
