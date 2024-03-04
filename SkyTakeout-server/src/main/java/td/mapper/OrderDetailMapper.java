package td.mapper;

import org.apache.ibatis.annotations.Mapper;
import td.entity.OrderDetail;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    /**
     * 批量插入订单明细数据
     * @param orderDetailList
     */
    void insertBatch(List<OrderDetail> orderDetailList);
}
