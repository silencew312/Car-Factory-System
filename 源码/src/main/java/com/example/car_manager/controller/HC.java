package com.example.car_manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Api(description = "页面跳转")
@Controller
public class HC {
    @ApiOperation(value="输入订单")
    @RequestMapping("/sale_input")
    public String GO1(){
        return "sale_input";
    }
    @ApiOperation(value="订单查询")
    @RequestMapping("/sale_query")
    public String GO2(){
        return "sale_query";
    }
    @ApiOperation(value="生产计划查询")
    @RequestMapping("/product_query")
    public String GO3(){
        return "product_query";
    }
    @ApiOperation(value="输入生产进度")
    @RequestMapping("/product_in")
    public String GO4(){
        return "product_in";
    }
    @ApiOperation(value="成车管理")
    @RequestMapping("/store_car")
    public String GO5(){
        return "store_car";
    }
    @ApiOperation(value="部件管理")
    @RequestMapping("/store_part")
    public String GO6(){
        return "store_part";
    }
    @ApiOperation(value="部件需求管理")
    @RequestMapping("/store_query")
    public String GO7(){
        return "store_query";
    }
    @ApiOperation(value="部件不存在")
    @RequestMapping("/nopart-page")
    public String GO8(){
        return "store_part";
    }
    @ApiOperation(value="订单不存在")
    @RequestMapping("/noorder-page")
    public String GO9(){
        return "sale_query";
    }
    @ApiOperation(value="订单不存在")
    @RequestMapping("/noorder1-page")
    public String GO10(){
        return "product_in";
    }
}
