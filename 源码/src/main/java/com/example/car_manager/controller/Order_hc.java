package com.example.car_manager.controller;

import com.example.car_manager.models.Order;
import com.example.car_manager.models.Product;
import com.example.car_manager.repository.OrderRepository;
import com.example.car_manager.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@Api(description = "订单管理")
@Controller
 class Order_hc {


    public Long now_id;
    @Autowired
    private OrderRepository jpa;
    @Autowired
    private ProductRepository jpa2;
    @ApiOperation(value="输入订单")
    @ApiImplicitParams(
            { @ApiImplicitParam(paramType = "form", dataType = "Long", name = "id", value = "订单号", required = true) ,
                    @ApiImplicitParam(paramType = "form", dataType = "String", name = "c_name", value = "姓名", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "String", name = "c_phone", value = "电话", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "String", name = "c_adr", value = "地址", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "String", name = "car_model", value = "汽车型号", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "String", name = "c_sum", value = "数量", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "Date", name = "date", value = "日期", required = true)
            }
    )
    @RequestMapping(value="/S_input-page",method = RequestMethod.POST)
    public String getParmByReq1(HttpServletRequest request) {
       Long id = Long.valueOf(request.getParameter("id"));
        String c_name = request.getParameter("c_name");
        String c_phone = request.getParameter("c_phone");
        String c_adr = request.getParameter("c_adr");
        String car_model = request.getParameter("car_model");
        int car_sum =Integer.parseInt( request.getParameter("car_sum"));
        Date date=Date.valueOf(request.getParameter("date"));
        Order order =new Order();
        Product p=new Product();
        order.setId(id);
        order.setC_name(c_name);
        order.setC_phone(c_phone);
        order.setC_adr(c_adr);
        order.setCar_model(car_model);
        order.setCar_sum(car_sum);
        order.setDate(date);
        order.setOversum(0);
        jpa.save(order);
        p.setId(id);
        p.setModel(car_model);
        p.setOversum(0);
        p.setSum(car_sum);
        p.setDate(date);
        jpa2.save(p);
        return "sale_input";
}
    @ApiOperation(value="订单查询")
    @ApiImplicitParams(
            {@ApiImplicitParam(paramType = "form", dataType = "Long", name = "query_id", value = "订单号", required = true)
            })
    @RequestMapping(value="/S_query-page",method = RequestMethod.POST)
    public String getParmByReq2(HttpServletRequest request,Model model){
        Long id = Long.valueOf(request.getParameter("query_id"));

        Order order=jpa.findOrderById(id);

        if(order==null){
            return"noorder";
        }else{
            now_id=id;
        model.addAttribute("o",order);
     return "sale_query";}
    }
    @ApiOperation(value="订单修改")
    @ApiImplicitParams(
            {@ApiImplicitParam(paramType = "form", dataType = "Long", name = "query_id", value = "订单号", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "String", name = "name", value = "姓名", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "String", name = "phone", value = "电话", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "String", name = "adr", value = "地址", required = true)

            })

    @RequestMapping(value="/S_query-revise-page",method = RequestMethod.POST)
    public String getParmByReq3(HttpServletRequest request) {
        String rid=request.getParameter("query_id");
        if(!rid.equals(""))now_id=Long.valueOf(rid);
        Order order=jpa.findOrderById(now_id);
        if(order==null){ return"noorder";}
        else{
        String c_name = request.getParameter("name");
        String c_phone = request.getParameter("phone");
        String c_adr = request.getParameter("adr");
        if(!c_adr.equals(""))
                jpa.updateAdrById(now_id,c_adr);
        if(!c_name.equals(""))
                jpa.updateNameById(now_id,c_name);
        if(!c_phone.equals(""))
                jpa.updatePhoneById(now_id,c_phone);

            return "sale_query";
    }}

    }
