package Core;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import Items.*;
import Scenes.*;
import Scenes.Scene.enumMasterWordList;
import start.Escape_The_Psych_Ward;

/**
 * Runs and holds all the objects and features to operate the game
 *
 */
public class GameManager 
{
	// Game Condition boolean.
	static boolean GameOver = false;
	
	// TreeMap
	static Map<String, Scene> Scenes = new TreeMap<>();

	// The users inventory management system is based on a LinkList algorithm.
	//  - Trenton Metzler
	public static InventoryList<Item> UserItems = new InventoryList<Item>();
	
	// Use to get the current Scene from Scenes;
	public static String currentLocation = "Psych Room";
	

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
	    Yard yard = new Yard();
		Scenes.put("Yard", yard);
		
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
		Escape_The_Psych_Ward.iPrintLn(" /inventory - Displays your current inventory.");
		Escape_The_Psych_Ward.iPrintLn(" /credits - Displays game credits.");
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

	/**
	 * Runs the logic for the action.
	 */
	public void input(String message)
	{	
						
		// Check that message is not empty
		if(!message.isEmpty())
		{
			// Check if game has not ended
			if(GameOver == false)
			{
				
				// Print the location
				location();	
				
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
				
				else if(message.equals("/inventory"))
				{
					// Print words
					Escape_The_Psych_Ward.iPrintLn("--------------------");
					Escape_The_Psych_Ward.iPrintLn("Current Inventory:");
					Escape_The_Psych_Ward.iPrintLn("--------------------");
					
					
					if(UserItems.length() > 0)
					{
		                for(int i = 0; i < UserItems.length(); i++)
		                {
		                	Escape_The_Psych_Ward.iPrintLn(UserItems.Get(i).getName() + " - " + UserItems.Get(i).getDescription());
		                }
					}
					
					else
					{
						Escape_The_Psych_Ward.iPrintLn("You currently don't have any items in your inventory.");
					}
				}
				
				else
				{
					// Print invalid command
					Escape_The_Psych_Ward.iPrintLn("Invalid Command");
					Logger.addLog("Invalid Command of " + message);
				}
			}
		}
	}
	
	/**
	 * Use to clear messages and display current location
	 */
	public static void location() 
	{
		// Clear UI
		Escape_The_Psych_Ward.clearLn();
		
		// Print Location
		Escape_The_Psych_Ward.iPrintLn(Scenes.get(currentLocation).toString());
		Escape_The_Psych_Ward.iPrintLn(Scenes.get(currentLocation).getDescription() + "\n");
	}
	
	/**
	 * Use to clear messages and stop the game
	 */
	public static void gameHasEnded() 
	{
		
		// Clear UI
		Escape_The_Psych_Ward.clearLn();
		
		// Set game to true
		GameOver = true;
	}
}
