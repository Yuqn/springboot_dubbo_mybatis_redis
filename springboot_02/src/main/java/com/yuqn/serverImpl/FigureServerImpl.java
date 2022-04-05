package com.yuqn.serverImpl;

import com.yuqn.dao.FigureDao;
import com.yuqn.entity.Figure;
import com.yuqn.server.FigureServer;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@DubboService(interfaceClass = FigureServer.class,version = "1.0")
public class FigureServerImpl implements FigureServer {

    @Resource
    private FigureDao figureDao;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public Integer FigAdd(Figure figure) {
        return null;
    }

    @Override
    public Figure FigSel(Integer id) {

//        设置格式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Figure.class));

//        结果
        Figure resour=null;
//        先查询redis数据库
        resour=(Figure) redisTemplate.opsForValue().get(id.toString());
        Figure figure2=(Figure) redisTemplate.opsForValue().get(id.toString());
        System.out.println("redis"+figure2);
        if(resour==null){
//            查询数据库，并且将内容添加到redis中
            resour=figureDao.figSel(id);
            System.out.println("数据库"+resour);
            if(resour!=null){
                redisTemplate.opsForValue().set(id.toString(),resour);
            }else {
                redisTemplate.opsForValue().set(id.toString(),new Figure());
            }
        }
        return resour;
    }
}
