package td.service;


import td.vo.OrderReportVO;
import td.vo.SalesTop10ReportVO;
import td.vo.TurnoverReportVO;
import td.vo.UserReportVO;

import java.time.LocalDate;

public interface ReportService {
    /**
     * 统计指定区间内营业额数据
     * @param begin
     * @param end
     * @return
     */
    TurnoverReportVO getTurnoverStatistics(LocalDate begin,LocalDate end);
    /**
     * 统计指定区间内用户数据
     * @param begin
     * @param end
     * @return
     */
    UserReportVO getUserStatistics(LocalDate begin, LocalDate end);

    /**
     * 统计指定区间内订单数据
     * @param begin
     * @param end
     * @return
     */
    OrderReportVO getOrdersStatistics(LocalDate begin, LocalDate end);

    /**
     * 统计指定区间内销量top10
     * @param begin
     * @param end
     * @return
     */
    SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end);
}
