package com.food.ordering.zinger.service;

import com.food.ordering.zinger.dao.ItemDao;
import com.food.ordering.zinger.model.ItemModel;
import com.food.ordering.zinger.model.RequestHeaderModel;
import com.food.ordering.zinger.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemDao itemDao;


    public Response<String> insertItem(ItemModel itemModel, String oauthId, String mobile, String role) {
        RequestHeaderModel requestHeaderModel = new RequestHeaderModel(oauthId, mobile, role);
        return itemDao.insertItem(itemModel, requestHeaderModel);
    }

    public Response<List<ItemModel>> getItemsByShopId(Integer shopId, String oauthId, String mobile, String role) {
        RequestHeaderModel requestHeaderModel = new RequestHeaderModel(oauthId, mobile, role);
        return itemDao.getItemsByShopId(shopId, requestHeaderModel);
    }

    public Response<List<ItemModel>> getItemsByName(Integer collegeId, String itemName, String oauthId, String mobile, String role) {
        RequestHeaderModel requestHeaderModel = new RequestHeaderModel(oauthId, mobile, role);
        return itemDao.getItemsByName(collegeId, itemName, requestHeaderModel);
    }

    public Response<String> updateItemById(ItemModel itemModel, String oauthId, String mobile, String role) {
        RequestHeaderModel requestHeaderModel = new RequestHeaderModel(oauthId, mobile, role);
        return itemDao.updateItemById(itemModel, requestHeaderModel);
    }

    public Response<String> deleteItemById(ItemModel itemModel, String oauthId, String mobile, String role) {
        RequestHeaderModel requestHeaderModel = new RequestHeaderModel(oauthId, mobile, role);
        return itemDao.deleteItemById(itemModel, requestHeaderModel);
    }

    public Response<String> unDeleteItemById(ItemModel itemModel, String oauthId, String mobile, String role) {
        RequestHeaderModel requestHeaderModel = new RequestHeaderModel(oauthId, mobile, role);
        return itemDao.unDeleteItemById(itemModel, requestHeaderModel);
    }

}
