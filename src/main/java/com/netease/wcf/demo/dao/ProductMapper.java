package com.netease.wcf.demo.dao;

import java.util.List;

import com.netease.wcf.demo.bean.Content;

public interface ContentMapper {
    Integer insert(Content content);
    
    void delete(Integer id);
    
    Content selectDetail(Integer id);
    
    List<Content> selectAll();
}
