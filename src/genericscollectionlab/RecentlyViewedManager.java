package src.genericscollectionlab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecentlyViewedManager {
    private final LinkedList<Item> recentItems;
    private final InventoryManagement<Item> mgmt;

    private static final int MAX_ITEMS = 3;

    public RecentlyViewedManager() {
        recentItems = new LinkedList<>();
        mgmt = new InventoryManagement<>();
    }

    public void add(String itemId) {
        Item item = mgmt.retrieve(itemId);
        recentItems.remove(item);
        recentItems.addFirst(item);
        if (recentItems.size() > MAX_ITEMS) {
            recentItems.removeLast();
        }
    }

    public List<Item> view() {
        return new ArrayList<>(recentItems);
    }
}
