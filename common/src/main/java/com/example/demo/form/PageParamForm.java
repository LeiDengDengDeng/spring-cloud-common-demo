package com.example.demo.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * 前端向后端传递分页查询的基本参数
 * 如有业务需求扩充，可以自行extend该类
 *
 * @author deng
 * @date 2018/12/26
 */
@Data
public class PageParamForm {
    /**
     * 页数
     */
    @Range(min = 0)
    private Integer pageNumber = 0;

    /**
     * 每页数据量，最大不超过100
     */
    @Range(min = 0, max = 100)
    private Integer pageSize = 10;
}
