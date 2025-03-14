package src.genericscollectionlab;

import java.util.*;
import java.util.stream.Collectors;

public class InventoryManagement<T extends Item> {

    private final HashMap<String, T> itemMap;

    public InventoryManagement() {
        itemMap = new HashMap<>();
    }

    public void printAllItemIDs() {
        itemMap.keySet().forEach(System.out::println);
    }

    public void printAllItemNamesInLowerCase() {
        var list = itemMap.values().stream()
                .map(Item::getName)
                .map(String::toLowerCase)
                .toList();
        list.forEach(System.out::println);
    }

    public void printLengthOfItemNames() {
        itemMap.values().stream()
                .map(Item::getName)
                .map(String::length)
                .forEach(System.out::println);
    }

    public void printItemsAbovePrice1000() {
        itemMap.values().stream()
                .filter(item -> item.getPrice()>1000)
                .map(Item::getName)
                .forEach(System.out::println);
    }

    public boolean checkAnyItemHas0Quantity() {
        return itemMap.values().stream()
                .map(Item::getQuantity)
                .anyMatch(quantity -> quantity==0);
    }
    
    public boolean allItemsHavePriceAbove0() {
        return itemMap.values().stream()
                .map(Item::getPrice)
                .allMatch(price -> price>0);
    }
    
    public boolean noItemHas0Quantity() {
        return itemMap.values().stream()
                .map(Item::getQuantity)
                .noneMatch(quantity -> quantity==0);
    }
    
    public void multipleOperations() {
        var list = itemMap.values().stream()
                .filter(item -> item.getPrice()>1000)
                .filter(item -> item.getQuantity()>0)
                .map(Item::getName)
                .distinct()
                .sorted()
                .limit(5)
                .toList();
        list.forEach(System.out::println);
    }

    public int totalQuantityOfAllItems() {
        return itemMap.values().stream()
                .map(Item::getQuantity)
                .reduce(0, Integer::sum);
//                .reduce((a, b) -> (a+b)).get();
//         when you do not use the initial values, then it returns Optional
    }

    public double getPriceOfMostExpensiveItem() {
        return itemMap.values().stream()
                .map(Item::getPrice)
                .reduce(Double.MIN_VALUE, (a, b) -> a > b ? a : b);
    }

    public String getNameOfMostExpensiveItem() {
        return itemMap.values().stream()
                .reduce((item1, item2) ->
                        (item1.getPrice() > item2.getPrice()) ? item1 : item2)
                .get()
                .getName();
    }

    public String concatenateAllItemNames() {
        return itemMap.values().stream()
                .map(Item::getName)
                .reduce((a, b) -> a + ", " + b).get();
        // if we give initial value as "", then it will start with comma like:
        // , mobile, tv, radio
        // so we are not providing initial value here
    }


//-----------------------------------------------------------------------------------------------
    public void add(T item) throws InvalidQuantityException {
        if (item.getQuantity() < 0) {
            throw new InvalidQuantityException(100, "Negative quantity not allowed");
        }
        // notice that we had to declare throws InvalidQuantityException
        // as it extends Exception which is Checked type
        // but, we did not have to write throws DuplicateItemException
        // as it is unchecked as it extends RuntimeException
        if (itemMap.containsKey(item.getId())) {
            throw new DuplicateItemException(101, "Item with this ID already exists");
        }
        itemMap.put(item.getId(), item);
    }

    public void remove(T item) {
        itemMap.remove(item.getId());
    }

    public T retrieve(String id) {
        if (!itemMap.containsKey(id)) {
            throw new ItemNotFoundException(102, "Item with this id was not found");
        }
        return itemMap.get(id);
    }

    public ArrayList<T> list() {
        return new ArrayList<>(itemMap.values());
    }

}
