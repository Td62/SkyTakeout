package td.service;

import td.dto.DishDTO;
import td.dto.DishPageQueryDTO;
import td.entity.Dish;
import td.result.PageResult;
import td.vo.DishVO;

import java.util.List;

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

    /**
     * 菜品批量删除
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据id查询菜品和对应口味
     * @param id
     * @return
     */
    DishVO getByIdWithFlavor(Long id);

    /**
     * 更具id修改菜品基本信息和口味
     * @param dishDTO
     */
    void updateWithFlavor(DishDTO dishDTO);


    /**
     * 菜品起售停售
     *
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    List<Dish> list(Long categoryId);

    /**
     * 条件查询菜品和口味
     * @param dish
     * @return
     */
    List<DishVO>  listWithFlavor(Dish dish);

}
