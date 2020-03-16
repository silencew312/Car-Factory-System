package com.example.car_manager.controller;

import com.example.car_manager.models.Car;
import com.example.car_manager.repository.CarRepository;
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


@Controller
@Api(description = "成车库存管理")
public class Car_hc {

    @Autowired
    private CarRepository jpa;
    @ApiOperation(value="成车入库")
    @ApiImplicitParams(
            { @ApiImplicitParam(paramType = "form", dataType = "String", name = "model", value = "成车型号", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "Integer", name = "sum", value = "入库量", required = true)


            }
    )
    @RequestMapping(value="/car-in-page",method = RequestMethod.POST)
    public String getParmByReq1(HttpServletRequest request) {
        int sum =Integer.parseInt( request.getParameter("sum"));
        String model = request.getParameter("model");
       Car car =jpa.findCarByModel(model);
       if(car==null){car=new Car();
       car.setModel(model);
       car.setSum(sum);
       jpa.save(car);

       }
       else {

     jpa.updateSumByModel(model,car.getSum()+sum);

       }
        return "store_car";
    }
    @ApiOperation(value="成车出库")
    @ApiImplicitParams(
            { @ApiImplicitParam(paramType = "form", dataType = "String", name = "model", value = "成车型号", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "Integer", name = "sum", value = "出库量", required = true)

            }
    )
        @RequestMapping(value="/car-out-page",method = RequestMethod.POST)
        public String getParmByReq2(HttpServletRequest request) {
            int sum =Integer.parseInt( request.getParameter("sum"));
            String model = request.getParameter("model");
            Car car =jpa.findCarByModel(model);
            jpa.updateSumByModel(model,car.getSum()-sum);
            return "store_car";
        }
    @ApiImplicitParams(
            { @ApiImplicitParam(paramType = "form", dataType = "String", name = "model2", value = "成车型号", required = true)
            }
    )
    @ApiOperation(value="查询成车库存")
    @RequestMapping(value="/car-q-page",method = RequestMethod.POST)
       public String getParmByReq3(HttpServletRequest request, Model model) {
        String m = request.getParameter("model2");
        Car car =jpa.findCarByModel(m);
        model.addAttribute("car",car);
        return "store_car";



    }


}

