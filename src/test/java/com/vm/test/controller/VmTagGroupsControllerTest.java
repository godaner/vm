package com.vm.test.controller;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.springframework.http.HttpEntity;

/**
 * Created by ZhangKe on 2017/12/1.
 */
public class VmTagGroupsControllerTest extends BaseControllerTest{
    @Test
    public void getTagsGroupsWithTags(){

        String url = getLocalHost()+"/tagGroup/list";

//        String result = rt.postForObject(url, entity, String.class);
        String result = rt.getForObject(url, String.class);
        System.out.println(result);

    }


}