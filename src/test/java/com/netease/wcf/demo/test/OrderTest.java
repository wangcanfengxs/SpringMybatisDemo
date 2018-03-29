package com.netease.wcf.demo.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.netease.wcf.demo.Main;
import com.netease.wcf.demo.bean.Order;
import com.netease.wcf.demo.dao.OrderMapper;
import com.netease.wcf.demo.dao.ProductMapper;

public class OrderTest {
    
    private SqlSession session = null;
    private OrderMapper orderMapper = null;
    
    @Before
    public void init(){
        String resource = "/mybatis-config.xml";
        InputStream inputStream = Main.class.getResourceAsStream(resource);
        String props = "/config.properties";
        Properties properties = new Properties();
        try {
            properties.load(Main.class.getResourceAsStream(props));
            System.out.println(properties);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
        session = sqlSessionFactory.openSession();
        orderMapper = session.getMapper(OrderMapper.class);
    }
    
    @Test
    public void testSelectDetail(){
        Order order = orderMapper.selectDetail(1);
        System.out.println(order);
    }
    
    @Test
    public void testSelectAll(){
        List<Order> orderList = orderMapper.selectAllByUserId(1);
        System.out.println(orderList);
        System.out.println(orderList.size());
    }
    
    @Test
    public void testInsert(){
        Date date = new Date();    
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
        String dateStr = sdf.format(date);  
        Timestamp ts = Timestamp.valueOf(dateStr); //2017-05-06 15:54:21.0  
        System.out.println(ts);
        Order order = new Order(ts, 10, 100);
        System.out.println(order.toString());
        orderMapper.insert(order, 1, 1);
        session.commit();
    }
    
    @Test
    public void testSelectByUserIdAndProductId(){
        orderMapper = session.getMapper(OrderMapper.class);
        Order order = orderMapper.selectByUserIdAndProductId(1, 1);
        System.out.println(order);
    }
}
