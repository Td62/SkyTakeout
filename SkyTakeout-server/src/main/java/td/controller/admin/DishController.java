package td.controller.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import td.dto.DishDTO;
import td.result.Result;
import td.service.DishService;

@RestController
@RequestMapping("/admin/dish")
@Tag(name = "菜品接口")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * 新增对应菜品和口味
     * @param dishDTO
     * @return
     */
    @PostMapping
    @Operation(summary = "新增菜品")
    public Result save(@RequestBody DishDTO dishDTO){
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }
}
