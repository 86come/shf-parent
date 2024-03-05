package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.base.BaseDao;
import com.atguigu.base.BaseServiceImpl;
import com.atguigu.dao.RoleDao;
import com.atguigu.entity.Role;
import com.atguigu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(interfaceClass = RoleService.class)
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> findAll() {
        return roleDao.findAll();
    }
    @Override
    protected BaseDao<Role> getEntityDao() {
        return roleDao;
    }
//    @Override
//    public Integer insert(Role role) {
//        return roleDao.insert(role);
//    }
//
//    @Override
//    public void delete(Long id) {
//        roleDao.delete(id);
//    }
//
//    @Override
//    public Role getById(Long id) {
//        return roleDao.getById(id);
//    }
//
//    @Override
//    public Integer update(Role role) {
//        return roleDao.update(role);
//    }
//
//    @Override
//    public PageInfo<Role> findPage(Map<String, Object> filters) {
//        //当前页数
//        int pageNum = CastUtil.castInt(filters.get("pageNum"), 1);
//        //每页显示的记录条数
//        int pageSize = CastUtil.castInt(filters.get("pageSize"), 10);
//
//        PageHelper.startPage(pageNum, pageSize);
//        return new PageInfo<Role>(roleDao.findPage(filters), 10);
//    }
}