package com.food.ordering.zinger.rowMapperLambda;

import com.food.ordering.zinger.model.ItemModel;
import com.food.ordering.zinger.model.ShopModel;
import org.springframework.jdbc.core.RowMapper;

import static com.food.ordering.zinger.column.ItemColumn.*;

public class ItemRowMapperLambda {
    public static final RowMapper<ItemModel> itemRowMapperLambda = (rs, rownum) -> {
        ItemModel item = new ItemModel();
        item.setId(rs.getInt(id));
        item.setName(rs.getString(name));
        item.setPrice(rs.getDouble(price));
        item.setPhotoUrl(rs.getString(photoUrl));
        item.setCategory(rs.getString(category));

        ShopModel shopModel = new ShopModel();
        shopModel.setId(rs.getInt(shopId));
        item.setShopModel(shopModel);

        item.setIsVeg(rs.getInt(isVeg));
        item.setIsAvailable(rs.getInt(isAvailable));
        item.setIsDelete(rs.getInt(isDelete));
        return item;
    };
}
