package start;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;

/**
 * North Wall Class extends Scene implements SceneInterface
 */
public class NorthWall extends Scene implements SceneInterface
{
	// Variables
	boolean dooropen = false;
	enumCombination currentCombination;
	
	// Combinations for user input on this scene.
	enum enumCombination 
	{
		opendoor, closedoor, inspectdoor, inspectclock, inspectwall, jump, movesouthwall, movenorthwall, moveeastwall, movewestwall
	}
	
	// The constructor will set the Location Name and Description for each scene.
	NorthWall()
	{
		this.LocationName = "North Wall";
		this.LocationDescription = "You are facing the North Wall, and you notice that there is a door.";	
	}
	
	/**
	 * ParseCombination method
	 */
	@Override
	public void ParseCombination(String parseToCombination)
	{
		currentCombination = enumCombination.valueOf(parseToCombination);
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
				Escape_The_Psych_Ward.iPrintLn("You are allready at the North Wall!");
			break;
			
			case moveeastwall:
				GameManager.currentLocation = "EastWall";
				GameManager.clear();
				Escape_The_Psych_Ward.iPrintLn("You move to the East Wall.");
			break;
			
			case movesouthwall:
				GameManager.currentLocation = "SouthWall";
				GameManager.clear();
				Escape_The_Psych_Ward.iPrintLn("You move to the South Wall.");
			break;
				
			case movewestwall:
				GameManager.currentLocation = "WestWall";
				GameManager.clear();
				Escape_The_Psych_Ward.iPrintLn("You move to the West Wall.");
			break;
		
			// open door
			case opendoor:
				Escape_The_Psych_Ward.iPrintLn(dooropen ? "The door is already open!" : "You open the door.");
				
				if(!dooropen)
				{
					dooropen = !dooropen;
				}
			break;
			
			// close door
			case closedoor:
				Escape_The_Psych_Ward.iPrintLn(dooropen ? "You closed the door." : "The door is already closed!");
				
				if(dooropen)
				{
					dooropen = !dooropen;
				}
				break;
				
			// inspect door
			case inspectdoor:
				Escape_The_Psych_Ward.iPrintLn("The door is " + (dooropen ? "open" : "closed and appears to be unlocked."));
			break;
			
			// inspect clock
			case inspectclock:
				ZoneId zone = ZoneId.systemDefault();
				Escape_The_Psych_Ward.iPrintLn("The clock reads:" + LocalDateTime.now(zone) + ". (Will add a game clock mechanic later)");
				break;
			
			// inspect wall
			case inspectwall:
				Escape_The_Psych_Ward.iPrintLn("You inspected the wall.");
				break;
				
			// :)
			case jump:
				Random r = new Random();
				
				switch(r.nextInt(3))
				{
					 case 0:
							Escape_The_Psych_Ward.iPrintLn("Are you happy now?");
						 break;
						 
					 case 1:
						 Escape_The_Psych_Ward.iPrintLn("Are you having fun now?");
						 break;
						 
					 case 2:
						 Escape_The_Psych_Ward.iPrintLn("Yeah! Work it real good!");
						 break;
				}
				break;
				
				
			// Null?
			default:
				Escape_The_Psych_Ward.iPrintLn("You can't do that.");
				break;
		}
	}

}
