package com.food.ordering.zinger.query;

import static com.food.ordering.zinger.column.OrderItemColumn.*;

public class OrderItemQuery {
    public static final String insertOrderItem = "INSERT INTO " + tableName + "(" + orderId + ", " + itemId + ", " + quantity + ", " + price + ") VALUES(:" + orderId + ", :" + itemId + ", :" + quantity + ", :" + price + ")";

    public static final String getItemByOrderId = "SELECT " + orderId + ", " + itemId + ", " + quantity + ", " + price + " FROM " + tableName + " WHERE " + orderId + " = :" + orderId;
}
