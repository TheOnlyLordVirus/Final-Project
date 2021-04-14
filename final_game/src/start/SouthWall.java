package start;
/**
 * SouthWall Class extends Scene implements SceneInterface
 */
public class SouthWall extends Scene implements SceneInterface
{
	enumCombination currentCombination;
	
	enum enumCombination 
	{
		inspectwall, inspectfloor, inspectbed, sleepbed, movenorthwall, moveeastwall, movesouthwall, movewestwall
	}
	
	/**
	 * ParseCombination method
	 */
	@Override
	public void ParseCombination(String parseToCombination)
	{
		currentCombination = enumCombination.valueOf(parseToCombination);
	}
	
	// The constructor will set the Location Name and Description for each scene.
	SouthWall()
	{
		this.LocationName = "South Wall";
		this.LocationDescription = "You are facing the South Wall, and you see a bed.";	
	}

	/**
	 * Interaction method performs action based on combination given 
	 */
	@Override
	public void interaction() 
	{
		switch(currentCombination)
		{
			// Change rooms.
			case movenorthwall:
				GameManager.currentLocation = "Northwall";
				GameManager.clear();
				Escape_The_Psych_Ward.iPrintLn("You move to the north wall.");
			break;
			
			case moveeastwall:
				GameManager.currentLocation = "Eastwall";
				GameManager.clear();
				Escape_The_Psych_Ward.iPrintLn("You move to the east wall.");
			break;
			
			case movesouthwall:
				Escape_The_Psych_Ward.iPrintLn("You're allready at the south wall!");
			break;
				
			case movewestwall:
				GameManager.currentLocation = "Westwall";
				GameManager.clear();
				Escape_The_Psych_Ward.iPrintLn("You move to the west wall.");
			break;
				
			// inspect wall
			case inspectwall:
				Escape_The_Psych_Ward.iPrintLn("The wall looks dirty.");
				break;
				
			// Inspect bed
			case inspectbed:
				Escape_The_Psych_Ward.iPrintLn("The bed looks comfortable.");
				break;
				
			// Sleep in bed
			case sleepbed:
				Escape_The_Psych_Ward.iPrintLn("You fall asleep peacefully and wake up 8 hours later. The time is now: (Debug: ADD GAME TIME TO GAME)");
				break;
				
			// Null?
			default:
				Escape_The_Psych_Ward.iPrintLn("You can't do that.");
				break;
		}
	}
}