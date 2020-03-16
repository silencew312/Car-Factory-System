package com.example.car_manager.controller;


import com.example.car_manager.compare.Sort2;
import com.example.car_manager.models.Part_need;
import com.example.car_manager.repository.Part_needRepository;
import io.swagger.annotations.Api;
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
@Api(description = "部件需求")
@Controller
public class Part_need_hc {
    @Autowired
    private Part_needRepository jpa;
    @ApiOperation(value="部件需求")
    @RequestMapping(value="/store-query-page",method = RequestMethod.POST)
    public String getParmByReq1(HttpServletRequest request, Model model) {
        List<Part_need> pnl=jpa.findAll();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        int n=pnl.size();
        for(int i=0;i<n;i++){

            if(pnl.get(i).getDate().before(date)){
                jpa.deleteById(pnl.get(i).getId());
                pnl.remove(i);
            }

        }
        Sort2 s=new Sort2();
        Collections.sort(pnl,s);
        model.addAttribute("pnl",pnl);

        return"store_query";
    }
}
