package src.genericscollectionlab;

public class Order implements Comparable<Order> {

    private final String orderId;
    private final boolean isExpress;

    public Order(String orderId, boolean isExpress) {
        this.orderId = orderId;
        this.isExpress = isExpress;
    }

    @Override
    public int compareTo(Order order2) {

        if (this.isExpress && !order2.isExpress) {
            return -1;
        } else if (!this.isExpress && order2.isExpress) {
            return 1;
        } else {
            return this.orderId.compareTo(order2.orderId);
        }
    }
}
