package com.atguigu.dao;

import com.atguigu.base.BaseDao;
import com.atguigu.entity.Role;

import java.util.List;

public interface RoleDao extends BaseDao<Role> {


    List<Role> findAll();
//
//    Integer insert(Role role);
//
//    void delete(Long id);
//
//    Role getById(Long id);
//
//    Integer update(Role role);
//
//    List<Role> findPage(Map<String, Object> filters);
}