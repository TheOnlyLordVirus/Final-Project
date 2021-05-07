package Items;

/**
 * @author Trenton Metzler
 * 
 * A list that only contains the methods we need for our games inventory management.
 *
 * @param <T>
 */
public class InventoryList <T>
{
	/**
	 * Basically just a container to store data and the next set of data, which can contain another set of data in it, which can contain another set of data in it.... 
	 * and so on...
	 * As longs as next != null then there is another piece of data in this 'chain' of nodes.
	 * 
	 * @author Trenton Metzler
	 *
	 */
    private class ItemNode
    {
    	/**
    	 *  The constructor sets the next Node to be null and sets the data to be the passed type.
    	 * @param t
    	 */
        public ItemNode(T t)
        {
            next = null;
            data = t;
        }

        
        
        // Stores the next Node in the Generic list.
        private ItemNode next;
        
        /**
         *  Get the next node.
         * @return
         */
        public ItemNode getNext()
        {
            return next;
        }
        
        /**
         *  Set the next node.
         * @param node
         */
        public void setNext(ItemNode node)
        {
            next = node;
        }
        
        
        
        /**
         *  Stores the Data.
         */
        private T data;
        
        /**
         *  Return Data
         * @return
         */
        public T getData()
        {
            return data;
        }
    }
    
    // How many nodes are there?
    private int size = 0;
    
    // The start of the list (The first object stored)
    private ItemNode head;
    
    /**
     *  Create the object in memory, start the node rabbit hole.
     */
    public InventoryList()
	{
		head = null;
	}
    
	
	/**
	 *  Adds a node
	 * @param t
	 */
    public void Add(T t)
    {
        ItemNode node = new ItemNode(t);
        node.setNext(head);
        head = node;
        
        size += 1;
    }
    
    /**
     *  Gets the data at a indexed node.
     * @param index
     * @return Data stored at the index.
     */
    public T Get(int index)
    {
        ItemNode current = head;

        for (int i = 0; i < index && current != null; i++)
        {
            current = current.getNext();
        }
        
        return current == null ? null : current.getData();
    }
    
    /**
     * Does this object exist in our inventory?
     * @param t
     * @return true if exists.
     */
    public boolean Exists(T t)
    {
    	if(head != null)
    	{
        	ItemNode node = head;
        	
        	// For every one of the nodes...
        	while(node.getNext() != null)
        	{
        		T data = node.getData();
        		
        		// Check if this node is equal to t...
        		if(data == t)
        		{
        			return true;
        		}
        		
        		// Move up a node in the list.
        		node = node.getNext();
        	}
        	
        	
        	T data = node.getData();
        	
    		// Check if this node is equal to t...
    		if(data == t)
    		{
    			return true;
    		}
    		
    		else
    		{
    	    	return false;
    		}
    	}
    	
    	return false;
    }
    
    /**
     *  Removes the element at the specified position in this list.
     * @param t
     */
 	public void Remove(T t)
 	{
 		ItemNode newHead = null;
 		ItemNode oldHead = head;
 		
 		// For every Node in the head.
 		for(int i = 0; i < size; i++)
 		{
 			// Create the new head with the data that isn't equal to 't'.
 	        if(!oldHead.getData().equals(t))
 	        {
 	          ItemNode node = new ItemNode(oldHead.getData());
 	          node.setNext(newHead);
 	          
 	          // Remember preivious.
 	          newHead = node;
 	          
 	        }
 	        
 	        // Set the old heads index node to be the next in the list.
 	        oldHead = oldHead.getNext();
 		}
 		
 		head = newHead;
 		
 		size -= 1;
 	}
    
    /**
     *  Gets the size of your inventory.
     * @return The total size of our inventorys contents.
     */
    public int length()
    {
    	return size;
    }
}