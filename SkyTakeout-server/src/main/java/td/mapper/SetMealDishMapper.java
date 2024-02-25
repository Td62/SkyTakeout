package td.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetMealDishMapper {

    /**
     * 菜品id查询对应套餐id
     * @param dishIds
     * @return
     */

    List<Long> getSetMealIdsByDishIds(List<Long> dishIds);

}
