package com.yuqn.controller;

import com.yuqn.entity.Figure;
import com.yuqn.server.FigureServer;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FigureController {


    @DubboReference(interfaceClass = FigureServer.class,version = "1.0")
    private FigureServer figureServer;

//查询用户
    @GetMapping(value = "/figSel/{id}")
    public String figSel(@PathVariable String id){
        System.out.println(id);
        Figure figure=figureServer.FigSel(Integer.parseInt(id));
        System.out.println(figure.toString());
        return figure.toString();
    }

//    添加redis数据
//    public
}
