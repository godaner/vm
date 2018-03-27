package com.vm.admin.controller;

import com.vm.admin.service.inf.VmMenusService;
import com.vm.base.util.ServiceController;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Controller
@RequestMapping("/admin/menu")
@Scope("prototype")
public class VmMenusController extends ServiceController<VmMenusService> {

    /**
     * 获取列表
     *
     * @return
     */
    @RequestMapping(value = "/info/byAdminId/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getMenusByAdminId(@PathVariable("adminId") Long adminId) throws Exception {

        return response.putData("list", service.getMenusByAdminId(adminId));
    }

}