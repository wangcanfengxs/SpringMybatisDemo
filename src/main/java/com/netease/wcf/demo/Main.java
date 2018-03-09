package com.netease.wcf.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.netease.wcf.demo.bean.Order;
import com.netease.wcf.demo.dao.OrderMapper;

public class Main {

    public static void main(String[] args) {
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
        SqlSession session = sqlSessionFactory.openSession();
        // String username = "buyer";
        // String password = "37254660e226ea65ce6f1efd54233424";
        // UserMapper mapper = session.getMapper(UserMapper.class);
        // User user = mapper.selectUser(username, password);
        // System.out.println(user);

        // ContentMapper contentMapper = session.getMapper(ContentMapper.class);

        // Content content = new Content();
        // content.setDetail("detail");
        // content.setDigest("digest");
        // content.setImage("1111.jpg");
        // content.setInventory(1000);
        // content.setPrice(10);
        // content.setTitle("title");
        // contentMapper.insert(content);
        // session.commit();
        // Content content2 = contentMapper.selectDetail(1);
        // System.out.println(content2);
        //
        // List<Content> contentList = contentMapper.selectAll();
        // for(Content element: contentList){
        // System.out.println(element);
        // }

        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
//        Order order = new Order(new Date(), 10, 100);
//        orderMapper.insert(order, 1, 1);
//        session.commit();
        Order order = orderMapper.selectDetail(1);
        System.out.println(order);
    }
}
