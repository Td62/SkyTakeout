package td.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import td.entity.DishFlavor;

import java.util.List;

@Mapper
public interface DishFlavorMapper {
    /**
     * 批量插入口味数据
     * @param dishFlavors
     */
    void insertBatch(List<DishFlavor> dishFlavors);

    /**
     * 根据菜品id集合批量删除对应口味数据
     * @param dishIds
     */

//    @Delete("delete from dish_flavor where dish_id = #{dishId}")
//    void deleteByDishId(Long dishId);

    void deleteByDishIds(List<Long> dishIds);
}
