package com.vm.admin.controller;

import com.vm.admin.dao.qo.VmAdminsQueryBean;
import com.vm.admin.service.inf.VmAdminsService;
import com.vm.base.util.ServiceController;
import com.vm.dao.util.PageBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Controller
@RequestMapping("/admin/info")
@Scope("prototype")
public class VmAdminsController extends ServiceController<VmAdminsService> {
    /**
     * 获取列表
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getAdmins(PageBean page, VmAdminsQueryBean query) throws Exception {

        return response.putData("list", service.getAdmins(page, query)).putData("total", service.getAdminsTotal(page, query));
    }
}
