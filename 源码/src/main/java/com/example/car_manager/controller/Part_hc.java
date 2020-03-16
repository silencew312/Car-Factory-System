package com.example.car_manager.controller;

import com.example.car_manager.models.Car;
import com.example.car_manager.models.Part;
import com.example.car_manager.repository.CarRepository;
import com.example.car_manager.repository.PartRepository;
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
@Api(description = "部件库存管理")
@Controller
public class Part_hc {

    @Autowired
    private PartRepository jpa;
    @ApiOperation(value="部件入库")
    @ApiImplicitParams(
            { @ApiImplicitParam(paramType = "form", dataType = "String", name = "pid", value = "部件型号", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "Integer", name = "sum", value = "入库量", required = true)
                    })
    @RequestMapping(value="/part-in-page",method = RequestMethod.POST)
    public String getParmByReq1(HttpServletRequest request) {
        int sum =Integer.parseInt( request.getParameter("sum"));
        String pid = request.getParameter("pid");
        Part part =jpa.findPartByPid(pid);
        if(part==null){
            return "nopart";

        }
        else {

            jpa.updateSumByPid(pid,part.getSum()+sum);


        return "store_part";}
    }
    @ApiOperation(value="部件出库")
    @ApiImplicitParams(
            { @ApiImplicitParam(paramType = "form", dataType = "String", name = "pid", value = "部件型号", required = true),
                    @ApiImplicitParam(paramType = "form", dataType = "Integer", name = "sum", value = "出库量", required = true)
            })
    @RequestMapping(value="/part-out-page",method = RequestMethod.POST)
    public String getParmByReq2(HttpServletRequest request) {
        int sum =Integer.parseInt( request.getParameter("sum"));
        String pid = request.getParameter("pid");
        Part part =jpa.findPartByPid(pid);
        if(part==null){return "nopart";}
        else{
        jpa.updateSumByPid(pid,part.getSum()-sum);
        return "store_part";}
    }
    @ApiOperation(value="查询部件")
    @ApiImplicitParams(
            { @ApiImplicitParam(paramType = "form", dataType = "String", name = "pid2", value = "部件型号", required = true),

            })
    @RequestMapping(value="/part-q-page",method = RequestMethod.POST)
    public String getParmByReq3(HttpServletRequest request, Model model) {
        String pid = request.getParameter("pid2");
        Part part =jpa.findPartByPid(pid);
        if(part==null)return "nopart";
        else{model.addAttribute("part",part);
        return "store_part";}



    }
    @ApiOperation(value="新部件入库")
    @RequestMapping(value="/new-part-in-page",method = RequestMethod.POST)
    public String getParmByReq3(HttpServletRequest request) {
        int sum =Integer.parseInt( request.getParameter("sum2"));

        String pid = request.getParameter("pid2");
        String pname = request.getParameter("pname2");

          Part  part=new Part();
            part.setPid(pid);
            part.setSum(sum);
            part.setPname(pname);
            jpa.save(part);


        return "store_part";
    }

}
