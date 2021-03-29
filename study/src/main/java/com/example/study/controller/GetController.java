package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class GetController {
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest(){

        return "Hi getMethod";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam(name="password") String pwd) {
        String password = "bbbb";

        System.out.println("id :" +id);
        System.out.println("pwd :" +pwd);

        return id+pwd;
    }

    //Localhost:8080/api/multiParameter?account=abcd&email=syudy@gmail.com&page=10
    @GetMapping("getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam;
        //{"account" : "","email" : "", "page" : 0}
    }

}
