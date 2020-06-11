package com.coding.common;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;


/**
 * @author chezhu.xin
 */
@Data
public class PageParam {
    @ApiParam(name = "page", required = true, example = "1")
    @ApiModelProperty(value = "page", example = "1")
    private int page = 1;
    @ApiParam(name = "size", required = true, example = "10")
    @ApiModelProperty(value = "size", example = "10")
    private int size = 10;

}
