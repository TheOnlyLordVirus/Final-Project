package start;

import java.util.Map;
import java.util.TreeMap;


import start.Scene.enumMasterWordList;

/**
 * Runs and holds all the objects and features to operate the game
 *
 */
public class GameManager 
{
	// TreeMap
	static Map<String, Scene> Scenes = new TreeMap<>();
	
	// Use to get the current Scene from Scenes;
	static String currentLocation = "NorthWall";

	/**
	 * Runs the logic for the action.
	 */
	public void input(String message)
	{	
		
		clear();
		
		// Check that message is not empty
		if(!message.isEmpty())
		{
			
			message = message.toLowerCase();
			char c = message.charAt(0);
			
			// Check that input does not have slash 
			if(c != '/')
			{
				// Perform command
				Scenes.get(currentLocation).perform(message);
			}
			// Slash commands
			else if(message.equals("/credits"))
			{
				// Print credits
				Escape_The_Psych_Ward.iPrintLn("Credits:");
				Escape_The_Psych_Ward.iPrintLn(" - Cole Frisch");
				Escape_The_Psych_Ward.iPrintLn(" - Trenton Metzler");
				Escape_The_Psych_Ward.iPrintLn(" - Nick Shuchard");
				Escape_The_Psych_Ward.iPrintLn(" - Jose Tlatempa-Domingu");
			}
			else if(message.equals("/log"))
			{
				// Read log
				Escape_The_Psych_Ward.iPrintLn("Log was printed on console");
				Logger.readLog();
			}
			else if(message.equals("/deletelog"))
			{
				// Delete log
				Escape_The_Psych_Ward.iPrintLn("Log was deleted");
				Logger.deleteLog();
			}
			else if(message.equals("/help"))
			{
				// Print words
				Escape_The_Psych_Ward.iPrintLn("--------------------");
				Escape_The_Psych_Ward.iPrintLn("Master Command List:");
				Escape_The_Psych_Ward.iPrintLn("--------------------");
				
				enumMasterWordList[] x = enumMasterWordList.values();
				
				// Print each word used in the game
				for(int i = 0; i < x.length; i++)
				{
					Escape_The_Psych_Ward.iPrintLn(x[i].toString());
				}
			}
			else {
				// Print invalid command
				Escape_The_Psych_Ward.iPrintLn("Invalid Command");
				Logger.addLog("Invalid Command of " + message);
			}
		}
	}
	
	/**
	 * Use to clear messages
	 */
	public static void clear() {
		// Clear UI
		Escape_The_Psych_Ward.clearLn();
		
		// Print Location
		Escape_The_Psych_Ward.iPrintLn("Location: " + Scenes.get(currentLocation).getName());
		Escape_The_Psych_Ward.iPrintLn(Scenes.get(currentLocation).getDescription() + "\n");
	}
	
	/**
	 * Constructor
	 */
	public GameManager()
	{
		// Create Scenes
		NorthWall north = new NorthWall();
		EastWall east = new EastWall();
		SouthWall south = new SouthWall();
		WestWall west = new WestWall();
		Scenes.put("NorthWall", north);
		Scenes.put("EastWall", east);
		Scenes.put("SouthWall", south);
		Scenes.put("WestWall", west);
		
		// Start Messages
		Escape_The_Psych_Ward.iPrintLn("Instructions:");
		Escape_The_Psych_Ward.iPrintLn(" - Your objective is to escape the mental Hospital.");
		Escape_The_Psych_Ward.iPrintLn(" - You must explore and interact with the objects within the mental hospital to escape.");
		Escape_The_Psych_Ward.iPrintLn(" - You will need to enter in the appropriate word combinations to progress through out the game.");
		Escape_The_Psych_Ward.iPrintLn(" - Word combinations genrally start with a verb and end with a noun within the scene.\n");
		Escape_The_Psych_Ward.iPrintLn("User Commands:");
		Escape_The_Psych_Ward.iPrintLn(" /help - Displays words that can be used in game.");
		Escape_The_Psych_Ward.iPrintLn(" /credits - Displays game credits.");
		Escape_The_Psych_Ward.iPrintLn(" /log - Shows user log in console.");
		Escape_The_Psych_Ward.iPrintLn(" /deletelog - Deletes user log file. \n");
		Escape_The_Psych_Ward.iPrintLn("Location: " + Scenes.get(currentLocation).getName());
		Escape_The_Psych_Ward.iPrintLn(Scenes.get(currentLocation).getDescription() + "\n");
		Escape_The_Psych_Ward.iPrintLn("You have just awoken.");
		
		TimeTracker.setCalendarTime();
	}
}
