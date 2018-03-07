package com.netease.wcf.demo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.netease.wcf.demo.Main;
import com.netease.wcf.demo.bean.Content;
import com.netease.wcf.demo.dao.ContentMapper;

public class ContentTest {
    private SqlSession session = null;
    private ContentMapper contentMapper = null;
    
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
    }
    
    @Test
    public void selectDetail(){
        contentMapper = session.getMapper(ContentMapper.class);
        Content content = contentMapper.selectDetail(1);
        System.out.println(content);
    }
}
