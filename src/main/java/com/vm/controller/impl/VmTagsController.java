package com.vm.controller.impl;

import com.vm.controller.base.ServiceController;
import com.vm.dao.po.CustomVmTagsGroups;
import com.vm.dao.po.VmTags;
import com.vm.service.inf.VmTagsService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by ZhangKe on 2017/12/20.
 */
@Controller
@RequestMapping("/tag")
@Scope("prototype")
public class VmTagsController extends ServiceController<VmTagsService> {
    /*********************************前端*********************************/
    /**
     * 获取所有的tags
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    Object getTags()  throws Exception {
        List<VmTags> list = service.getTags();
        response.putData("list", list);
        return response;
    }

    /**
     * 获取某个电影的的tags
     *
     * @return
     */
    @RequestMapping(value = "/tag/movie/{movieId}", method = RequestMethod.GET)
    public @ResponseBody
    Object getTagsOfMovie(@PathVariable("movieId") Long movieId)  throws Exception {
        List<VmTags> list = service.getTagsOfMovie(movieId);
        response.putData("list", list);
        return response;
    }

    /*********************************后端*********************************/

}

