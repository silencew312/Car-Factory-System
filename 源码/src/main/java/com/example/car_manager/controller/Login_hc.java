package com.example.car_manager.controller;


import com.example.car_manager.models.User;
import com.example.car_manager.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


@Controller
@Api(description = "登录")
public class Login_hc{
    @Autowired
    private UserRepository jpa;
    @ApiOperation(value="处理登录")
    @ApiImplicitParams(
            { @ApiImplicitParam(paramType = "form", dataType = "String", name = "Id", value = "账号", required = true) ,
            @ApiImplicitParam(paramType = "form", dataType = "String", name = "Password", value = "密码", required = true) }
    )
    @RequestMapping(value = "/handling-page", method = RequestMethod.POST)
    public String getParmByReq(HttpServletRequest request)
    {
        String  Id = request.getParameter("Id");
        String password = request.getParameter("Password");
        User user=jpa.findUserById(Id);
if(user==null||!password.equals(user.getPassword())){ return "fail";}

        else if(user.getRole()==1)
        { return "sale_input";}
        else if(user.getRole()==2)
        {return "product_query";}
        else
        { return "store_query";}


    }

}

