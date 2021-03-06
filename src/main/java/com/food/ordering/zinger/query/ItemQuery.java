package com.food.ordering.zinger.query;

import static com.food.ordering.zinger.column.ItemColumn.*;

public class ItemQuery {
    public static final String notDeleted = isDelete + " = 0";

    public static final String insertItem = "INSERT INTO " + tableName + "(" + name + ", " + price + ", " + photoUrl + ", " + category + ", " + shopId + ", " + isVeg + ") VALUES(:" + name + ", :" + price + ", :" + photoUrl + ", :" + category + ", :" + shopId + ", :" + isVeg + ")";

    public static final String getItemById = "SELECT " + id + ", " + name + ", " + price + ", " + photoUrl + ", " + category + ", " + shopId + ", " + isVeg + ", " + isAvailable + ", " + isDelete + " FROM " + tableName + " WHERE " + id + " = :" + id;
    public static final String getItemsByShopId = "SELECT " + id + ", " + name + ", " + price + ", " + photoUrl + ", " + category + ", " + shopId + ", " + isVeg + ", " + isAvailable + ", " + isDelete + " FROM " + tableName + " WHERE " + shopId + " = :" + shopId + " AND " + notDeleted;
    public static final String getItemsByName = "SELECT " + id + ", " + name + ", " + price + ", " + photoUrl + ", " + category + ", " + shopId + ", " + isVeg + ", " + isAvailable + ", " + isDelete + " FROM " + tableName + " WHERE " + name + " LIKE :" + name + " AND " + notDeleted + " AND " + shopId + " IN (" + ShopQuery.getShopIdByCollegeId + ")";


    public static final String updateItem = "UPDATE " + tableName + " SET " + name + " = :" + name + ", " + price + " = :" + price + ", " + photoUrl + " = :" + photoUrl + ", " + category + " = :" + category + ", " + isVeg + " = :" + isVeg + ", " + isAvailable + " = :" + isAvailable + " WHERE " + id + " = :" + id;

    public static final String deleteItem = "UPDATE " + tableName + " SET " + isDelete + " = 1" + " WHERE " + id + " = :" + id;
    public static final String unDeleteItem = "UPDATE " + tableName + " SET " + isDelete + " = 0" + " WHERE " + id + " = :" + id;
}
