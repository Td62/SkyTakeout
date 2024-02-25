package td.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import td.constant.MessageConstant;
import td.constant.StatusConstant;
import td.dto.DishDTO;
import td.dto.DishPageQueryDTO;
import td.entity.Dish;
import td.entity.DishFlavor;
import td.exception.DeletionNotAllowedException;
import td.mapper.DishFlavorMapper;
import td.mapper.DishMapper;
import td.mapper.SetMealDishMapper;
import td.result.PageResult;
import td.service.DishService;
import td.vo.DishVO;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishFlavorMapper dishFlavorMapper;
    @Autowired
    private SetMealDishMapper setMealDishMapper;

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
        if (dishFlavors != null && dishFlavors.size() > 0) {
            dishFlavors.forEach(dishFlavor -> {
                dishFlavor.setDishId(dishId);
            });
            dishFlavorMapper.insertBatch(dishFlavors);
        }
    }

    /**
     * 菜品分页查询
     *
     * @param dishPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO) {
        PageHelper.startPage(dishPageQueryDTO.getPage(), dishPageQueryDTO.getPageSize());
        Page<DishVO> page = dishMapper.pageQuery(dishPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 菜品批量删除
     *
     * @param ids
     */

    @Transactional
    @Override
    public void deleteBatch(List<Long> ids) {
        //菜品是否在售
        List<Dish> dish = dishMapper.getByIds(ids);
        System.out.println(dish);
        dish.forEach(d -> {
            if (d.getStatus() == StatusConstant.ENABLE) {
                throw new DeletionNotAllowedException(MessageConstant.DISH_ON_SALE);
            }
        });

//        ids.forEach(id -> {
//            Dish dish = dishMapper.getById(id);
//            if (dish.getStatus() == StatusConstant.ENABLE) {
//                throw new DeletionNotAllowedException(MessageConstant.DISH_ON_SALE);
//            }
//        });
        //菜品是否被套餐关联
        List<Long> setMealIds = setMealDishMapper.getSetMealIdsByDishIds(ids);
        if (setMealIds != null && setMealIds.size() > 0) {
            throw new DeletionNotAllowedException(MessageConstant.DISH_BE_RELATED_BY_SETMEAL);
        }

        //删除菜品数据
        //删除菜品关联口味数据
//       ids.forEach(id -> {
//           dishMapper.deleteById(id);
//           dishFlavorMapper.deleteByDishId(id);
//       });
        dishMapper.deleteByIds(ids);
        dishFlavorMapper.deleteByDishIds(ids);

    }
}
