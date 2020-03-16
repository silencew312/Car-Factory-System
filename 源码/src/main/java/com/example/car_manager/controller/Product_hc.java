package com.example.car_manager.controller;
import com.alibaba.fastjson.JSON;
import com.example.car_manager.compare.Sort;
import com.example.car_manager.models.Order;
import com.example.car_manager.models.Part_need;
import com.example.car_manager.models.Product;
import com.example.car_manager.repository.OrderRepository;
import com.example.car_manager.repository.Part_needRepository;
import com.example.car_manager.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
@Api(description = "生产管理")
@Controller
public class Product_hc {
    @Autowired
    private Part_needRepository jpa;
    @ApiOperation(value="输入部件需求")
    @ApiImplicitParams(
            { @ApiImplicitParam(paramType = "form", dataType = "String", name = "pid", value = "部件型号", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "Date", name = "sum", value = "数量", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "Date", name = "date", value = "日期", required = true)


            })

    @RequestMapping(value="/product1-page",method = RequestMethod.POST)
    public String getParmByReq1(HttpServletRequest request) {
        String pid = request.getParameter("pid");
        int sum =Integer.parseInt( request.getParameter("sum"));
        Date date=Date.valueOf(request.getParameter("date"));
        Part_need p=new Part_need();

        p.setDate(date);
        p.setPid(pid);
        p.setSum(sum);
        jpa.save(p);
        return "product_in";




    }
    @Autowired
    private ProductRepository jpa2;
    @ApiOperation(value="生产计划查询")
    @RequestMapping(value="/P_query-page",method = RequestMethod.POST)

    public String getParmByReq2(HttpServletRequest request,Model model) {
        List<Product>pl=jpa2.findAll();
int n=pl.size();
        for(int i=0;i<n;i++){
            if(pl.get(i).getSum()==pl.get(i).getOversum()){
                jpa2.deleteById(pl.get(i).getId());
                pl.remove(i);
            }
            else{
                pl.get(i).setSum(pl.get(i).getSum()-pl.get(i).getOversum());
            }
        }

       Sort s=new Sort();
        Collections.sort(pl,s);
        System.out.println(pl.get(0).getModel());
        model.addAttribute("pl", pl);
        return"product_query";
    }
    @Autowired
    private OrderRepository jpa3;
    @ApiOperation(value="输入生产进度")
    @ApiImplicitParams(
            { @ApiImplicitParam(paramType = "form", dataType = "Long", name = "oid", value = "订单号", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "Integer", name = "oversum", value = "完成数量", required = true)})
    @RequestMapping(value="/product2-page",method = RequestMethod.POST)
    public String getParmByReq3(HttpServletRequest request){
        Long oid = Long.valueOf(request.getParameter("oid"));
        int oversum =Integer.parseInt( request.getParameter("oversum"));
        Order order=jpa3.findOrderById(oid);
        if(order==null){return "nooder1";}
        else{
        Product product =jpa2.findProductById(oid);
        jpa3.updateOversumById(order.getId(),order.getOversum()+oversum);
        jpa2.updateOversumById(oid,product.getOversum()+oversum);
        return "product_in";
    }
}}
