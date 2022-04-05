package com.yuqn.dao;

import com.yuqn.entity.Figure;
import org.apache.ibatis.annotations.Param;

public interface FigureDao {
//    添加信息，返回Integer对象
    Integer figAdd(Figure figure);
//    根据查询信息，返回Figure对象
    Figure figSel(@Param("id") Integer id);
}
