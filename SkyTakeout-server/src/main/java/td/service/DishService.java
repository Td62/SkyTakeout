package td.service;

import td.dto.DishDTO;

public interface DishService {
    /**
     * 新增对应菜品和口味
     * @param dishDTO
     */
     void saveWithFlavor(DishDTO dishDTO);
}
