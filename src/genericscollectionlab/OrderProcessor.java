package src.genericscollectionlab;

import java.util.PriorityQueue;

public class OrderProcessor {

    private final PriorityQueue<Order> orderQueue;

    public OrderProcessor() {
        this.orderQueue = new PriorityQueue<>();
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
    }

    public Order processOrder(Order order) {
        return orderQueue.poll();
    }

    public int getSize() {
        return this.orderQueue.size();
    }
}
