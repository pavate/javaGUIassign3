package pavate;

import java.util.*;

/**
 * @author acer
 */
public class InventoryList  {
    List<Inventory> invList = new ArrayList<Inventory>();
    

   
    
     

    /**
     *
     * @param inventory
     */
    public void add(Inventory inventory) {
        invList.add(inventory);
    }

    /**
     *
     * @param index
     */
    public Inventory get(int index) {
        return invList.get(index);

    }

    public int Length() {
        return invList.size();
        
    }

    public InventoryList() {
        // TODO - implement InventoryList.InventoryList
        throw new UnsupportedOperationException();
    }

}
