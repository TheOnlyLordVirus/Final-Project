package start;

import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;


import start.Scene.enumMasterWordList;

/**
 * Runs and holds all the objects and features to operate the game
 *
 */
public class GameManager 
{
	
	private boolean end = false;
	
	// TreeMap
	static Map<String, Scene> Scenes = new TreeMap<>();
	
	// Use to get the current Scene from Scenes;
	static String currentLocation = "Psych Room";

	/**
	 * Runs the logic for the action.
	 */
	public void input(String message)
	{	
		
		// Print the location
		location();		
				
		// Check that message is not empty
		if(!message.isEmpty())
		{
			// Check if game has not ended
			if(end == false) {
				
				// Lower case the message
				message = message.toLowerCase();
				char c = message.charAt(0);
				
				// Check that input does not have slash 
				if(c != '/')
				{
					// Write message to log
					Logger.addLog("User Input: " + message);
					
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
				else if(message.equals("/end"))
				{
					// end game
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
	                for(int i = 0; i < x.length; i += 4)
	                {
	                	
	                    String println = "";
	                    for(int j = 0; j < 4; j++)
	                    {
	                        if(i + j < x.length)
	                        {
	                        	
	                            println += x[i + j].toString() + (i + j + 1 < x.length ? ", " : "");
	                        }
	                        
	                        else
	                        {
	                            break;
	                        }
	                    }

	                    // Print word
	                    Escape_The_Psych_Ward.iPrintLn(println);
	                }
				}
				else {
					// Print invalid command
					Escape_The_Psych_Ward.iPrintLn("Invalid Command");
					Logger.addLog("Invalid Command of " + message);
				}
			}
		}
	}
	
	/**
	 * Use to clear messages
	 */
	public static void location() {
		// Clear UI
		Escape_The_Psych_Ward.clearLn();
		
		// Print Location
		Escape_The_Psych_Ward.iPrintLn(Scenes.get(currentLocation).toString());
		Escape_The_Psych_Ward.iPrintLn(Scenes.get(currentLocation).getDescription() + "\n");
	}
	
	/**
	 * Constructor
	 */
	public GameManager()
	{
		// Create Scenes
		PsychRoom bedroom = new PsychRoom();
		Scenes.put("Psych Room", bedroom);
		OfficeRoom officeroom = new OfficeRoom();
		Scenes.put("Office Room", officeroom);
	    DiningRoom diningroom = new DiningRoom();
		Scenes.put("Dining Room", diningroom);
		
		// Create locale English
		Locale english = new Locale("en", "US");
		
		// Get bundle call intro with the English locale
		ResourceBundle resource = ResourceBundle.getBundle("Intro", english);
				
		// Start Messages using resource bundle
		Escape_The_Psych_Ward.iPrintLn(resource.getString("Intro1"));
		Escape_The_Psych_Ward.iPrintLn(resource.getString("Intro2"));
		Escape_The_Psych_Ward.iPrintLn(resource.getString("Intro3"));
		Escape_The_Psych_Ward.iPrintLn(resource.getString("Intro4"));
		Escape_The_Psych_Ward.iPrintLn(resource.getString("Intro5"));
		
		// Print Commands
		Escape_The_Psych_Ward.iPrintLn("User Commands:");
		Escape_The_Psych_Ward.iPrintLn(" /help - Displays words that can be used in game.");
		Escape_The_Psych_Ward.iPrintLn(" /credits - Displays game credits.");
		Escape_The_Psych_Ward.iPrintLn(" /end - automatically end the game.");
		Escape_The_Psych_Ward.iPrintLn(" /log - Shows user log in console.");
		Escape_The_Psych_Ward.iPrintLn(" /deletelog - Deletes user log file. \n");
		
		// Print location and description
		Escape_The_Psych_Ward.iPrintLn("Location: " + Scenes.get(currentLocation).getName());
		Escape_The_Psych_Ward.iPrintLn(Scenes.get(currentLocation).getDescription() + "\n");
		
		// Print start message
		Escape_The_Psych_Ward.iPrintLn("You have just awoken and crawled out of your bed.");
				
		// Set calendar
		TimeTracker.setCalendarTime();
		
		// Write message to log
		Logger.addLog("User Started The Game");
	}
}
