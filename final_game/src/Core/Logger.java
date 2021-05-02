package Core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Logger Class
 */
public interface Logger 
{
	
	/**
	 * Add Message to file log
	 * 
	 * @param message
	 */
	public static void addLog(String message)
	{

		// Create file instance
		File file = new File("Userlog.txt");

		// Try to create file if needed
		try 
		{
			// Check if file exists in storage
			if (!file.getParentFile().exists()) 
			{

				// Create file in storage
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			
		} 
		catch (Exception e) 
		{

		}
		
		// Try to add message to file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) 
		{

			// Write message to file
			writer.write(message);
			writer.newLine();
		} 
		
		catch (Exception e) 
		{

			// Print message
			System.out.println("Error unable to add message to file.");
		}
	}
	
	public static void deleteLog() {
		
		// Create file instance
		File file = new File("Userlog.txt");
		try {
			file.delete();
		}
		catch(Exception e) {
			
			System.out.println("Error when deleting file");
		}
	}

	/**
	 * Read messages from file log
	 * 
	 */
	public static void readLog() 
	{

		// Create file instance
		File file = new File("Userlog.txt");

		// Try to create file if needed
		try 
		{
			// Check if file exists in storage
			if (!file.getParentFile().exists()) 
			{

				// Create file in storage
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			
		} 
		catch (Exception e) 
		{

		}

		// Try to read the file
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
		{

			// Use to get content from file
			String content = reader.readLine();
			
			// Printer Writer class for requirement
			Writer print = new PrintWriter(System.out);

			// Loop for every message
			while (content != null) 
			{

				// Print message and get next line
				print.append(content + System.lineSeparator());
				print.flush();
				content = reader.readLine();
			}
		} 
		
		catch (Exception e) 
		{

			// Print message
			System.out.println("Error unable to read file.");
		}
	}
}