package td.service;

import td.dto.ShoppingCartDTO;
import td.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    /**
     * 添加购物车
     */
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

    /**
     * 查看购物车
     * @return
     */
    List<ShoppingCart> showShoppingCart();
    /**
     * 清空购物车
     * @return
     */
    void cleanShoppingCart();
    /**
     * 删除购物车中一个商品
     * @param shoppingCartDTO
     * @return
     */
    void subShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
