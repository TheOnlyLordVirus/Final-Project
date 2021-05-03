package Items;

/**
 * Not much to say here. Its a abstract class for item data to be stored.
 * 
 * @author Trenton Metzler
 *
 */
public abstract class Item
{
	protected String Name;
	protected String Description;
	
	public String getName()
	{
		return Name;
	}
	
	public String getDescription()
	{
		return Description;
	}
}
