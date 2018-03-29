package com.netease.wcf.demo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.netease.wcf.demo.Main;
import com.netease.wcf.demo.bean.Product;
import com.netease.wcf.demo.dao.ProductMapper;

public class ProductTest {
    private SqlSession session = null;
    private ProductMapper productMapper = null;
    
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
        productMapper = session.getMapper(ProductMapper.class);
        Product content = productMapper.selectDetail(1);
        System.out.println(content);
    }
    
    @Test
    public void insert(){
        Product product = new Product("Test百度","Test","Test",10.0f,"Test");
        productMapper = session.getMapper(ProductMapper.class);
        int result = productMapper.insert(product);
        System.out.println(product.toString());
        System.out.println(result);
        session.commit();
    }
    
    @Test
    public void selectIsBuy(){
        productMapper = session.getMapper(ProductMapper.class);
        List<Product> products = productMapper.selectIsBuy(1);
        System.out.println(products.toString());
    }
    
    @Test
    public void testSetPutOff(){
        productMapper = session.getMapper(ProductMapper.class);
        productMapper.setPutOff(1, 1);
        session.commit();
    }
    
    @Test
    public void testSelectAllProducts(){
        productMapper = session.getMapper(ProductMapper.class);
        List<Product> products = productMapper.selectAllProducts();
        for(Product product : products){
            System.out.println("购买价格："+product.getSellCount());
        }
    }

    @Test
    public void testUpdate(){
        productMapper = session.getMapper(ProductMapper.class);
        Product product = productMapper.selectDetail(4);
        product.setDetail("new detail");
        productMapper.update(product);
                
    }
}
