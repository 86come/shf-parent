package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.base.BaseController;
import com.atguigu.entity.Role;
import com.atguigu.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping(value="/role")
@SuppressWarnings({"unchecked", "rawtypes"})
public class RoleController extends BaseController {

    @Reference
    private RoleService roleService;


    private final static String PAGE_INDEX = "role/index";
    private final static String PAGE_CREATE = "role/create";
    private final static String LIST_ACTION = "redirect:/role";
    private final static String PAGE_EDIT = "role/edit";
    private final static String PAGE_SUCCESS ="common/successPage";

    /**
     * 列表
     * @param
     * @return
     */
//    @RequestMapping
//    public String index(ModelMap model) {
//        List<Role> list = roleService.findAll();
//
//        model.addAttribute("list", list);
//        return PAGE_INDEX;
//    }



    @RequestMapping("/create")
    public String create() {
        return PAGE_CREATE;
    }
    //新增角色
    @RequestMapping("/save")
    public String save(Role role){
        roleService.insert(role);
        //重定向到查询所有角色的方法
        return PAGE_SUCCESS;
    }
    //删除角色
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        roleService.delete(id);
        return LIST_ACTION;
    }

    //修改角色
    @GetMapping("/edit/{id}")
    public String edit(ModelMap model,@PathVariable Long id){
        Role role = roleService.getById(id);
        model.addAttribute("role",role);
        return PAGE_EDIT;
    }
    @PostMapping(value="/update")
    public String update(Role role){
        roleService.update(role);
        return PAGE_SUCCESS;
    }

    //分页
    @RequestMapping
    public String index(ModelMap model, HttpServletRequest request) {
        Map<String,Object> filters = getFilters(request);
        PageInfo<Role> page = roleService.findPage(filters);

        model.addAttribute("page", page);
        model.addAttribute("filters", filters);
        return PAGE_INDEX;
    }

    /**
     * 封装页面提交的分页参数及搜索条件
     * @param request
     * @return
     */
//    private Map<String, Object> getFilters(HttpServletRequest request) {
//        Enumeration<String> paramNames = request.getParameterNames();
//        Map<String, Object> filters = new TreeMap();
//        while(paramNames != null && paramNames.hasMoreElements()) {
//            String paramName = (String)paramNames.nextElement();
//            String[] values = request.getParameterValues(paramName);
//            if (values != null && values.length != 0) {
//                if (values.length > 1) {
//                    filters.put(paramName, values);
//                } else {
//                    filters.put(paramName, values[0]);
//                }
//            }
//        }
//        if(!filters.containsKey("pageNum")) {
//            filters.put("pageNum", 1);
//        }
//        if(!filters.containsKey("pageSize")) {
//            filters.put("pageSize", 5);
//        }
//
//        return filters;
//    }
}