package td.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import td.dto.DishDTO;
import td.entity.Dish;
import td.entity.DishFlavor;
import td.mapper.DishFlavorMapper;
import td.mapper.DishMapper;
import td.service.DishService;

import java.util.List;
@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    /**
     * 新增对应菜品和口味
     *
     * @param dishDTO
     * @Transactional 注解事务管理
     */
    @Override
    @Transactional
    public void saveWithFlavor(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);
        dishMapper.insert(dish);
        //获取insert生成的主键值
        Long dishId = dish.getId();
        List<DishFlavor> dishFlavors = dishDTO.getFlavors();
        if (dishFlavors != null && !dishFlavors.isEmpty()) {
            dishFlavors.forEach(dishFlavor -> {
                dishFlavor.setDishId(dishId);
            });
            dishFlavorMapper.insertBatch(dishFlavors);
        }
    }
}
