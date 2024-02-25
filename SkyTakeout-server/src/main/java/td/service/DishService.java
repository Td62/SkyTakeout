package td.service;

import td.dto.DishDTO;
import td.dto.DishPageQueryDTO;
import td.result.PageResult;

public interface DishService {
    /**
     * 新增对应菜品和口味
     * @param dishDTO
     */
     void saveWithFlavor(DishDTO dishDTO);

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);
}
