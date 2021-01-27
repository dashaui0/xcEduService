package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author:dashuai
 * @ClassName:CmsPageRepositoryTest
 * @Descirption:
 * @date:2020/12/23 15:56
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    private CmsPageRepository cmsPageRepository;
    @Autowired
    PageService pageService;

    //查询所有
    @Test
    public void testFinAll(){
        List<CmsPage> all = cmsPageRepository.findAll();
        for (CmsPage cmsPage : all) {
            System.out.println(cmsPage);
        }
    }
    //分页测试
    @Test
    public void testFindPage(){

    }

    //查询所有
    @Test
    public void testGetPageHtml(){
        String pageHtml = pageService.getPageHtml("297e7c7c62b888f00162b8a7dec20000");
        System.out.println(pageHtml);
    }
}
