package td.mapper;

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
}
