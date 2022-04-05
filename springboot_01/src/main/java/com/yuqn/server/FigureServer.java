package com.yuqn.server;

import com.yuqn.entity.Figure;

public interface FigureServer {
//    添加记录
    Integer FigAdd(Figure figure);
//    查询记录
    Figure FigSel(Integer id);
}
