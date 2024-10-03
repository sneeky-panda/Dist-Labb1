package se.kth.distribuerad.labb1.BO;

import se.kth.distribuerad.labb1.UI.ItemInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class ItemHandler {
    public static Collection<ItemInfo> getItemWithGroup(String s){
        Collection c = Item.searchItems(s);
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for(Iterator it = c.iterator(); it.hasNext();){
            Item item = (Item) it.next();
            //items.add(new ItemInfo(item.getName()));
        }
        return items;
    }
}
