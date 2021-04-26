package start;


/**
 * OfficeRoom Class extends Scene
 */
public class OfficeRoom extends Scene {
	
	// Variables
	boolean haveLogin = false;

	enumCombination currentCombination;

	// Combinations for user input on this scene.
	enum enumCombination {
		opendoor, inspectdoor, jump, crawlvent, movevent, checkdesk, logincomputer, addrecord, checkdatabase, updaterecord, deleterecords
	}

	// The constructor will set the Location Name and Description for each scene.
	OfficeRoom() {
		this.LocationName = "Office Room";
		this.LocationDescription = "You are in a dark room that appears to be an office for pysch staff.\nYou see a desk with active comptuer that you could use.\nYou see the vent that you have use to get here from your room.\nYou see a cloudy glass door that leads to the main lobby.";
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
		
		case crawlvent:
			
		case checkdesk:
			Escape_The_Psych_Ward.iPrintLn("You search the desk and find a sticky note.");
			Escape_The_Psych_Ward.iPrintLn("the sticky note has a Username and Password on it.");
			haveLogin = true;
			break;
		
		// Here we go!
		case logincomputer:
			//Login to computer
			Escape_The_Psych_Ward.iPrintLn(currentCombination.toString());
			Escape_DB.Database(currentCombination);
			break;
			
		// Give me a C!
		case addrecord: 
			//Add a record to the database
			Escape_DB.Database(currentCombination);
			break;
		
		// Give me a R!
		case checkdatabase: 
			//Access all database records
			Escape_DB.Database(currentCombination);
			break;
			
		// Give me a U!
		case updaterecord: 
			//update a record in the database
			Escape_DB.Database(currentCombination);
			break;
			
		// Give me a D
		case deleterecords: 
			//delete all records in the SUBJECTS table.
			Escape_DB.Database(currentCombination);
			break;
		// What does that spell??? CRUD!
			
		case movevent:
			// Move to psych room
			GameManager.currentLocation = "Psych Room";
			GameManager.location();
			Escape_The_Psych_Ward.iPrintLn("You have crawl through the vent back to your psych room.");
			break;

		// Null?
		default:
			Escape_The_Psych_Ward.iPrintLn("You can't do that.");
			break;
		}
	}
}
