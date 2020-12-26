package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author:dashuai
 * @ClassName:PageService
 * @Descirption:
 * @date:2020/12/23 16:06
 */
@Service
public class PageService {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    /**
     * 页面查询方法
     * @param page 当前页码
     * @param size 页面显示个数
     * @param queryPageRequest 查询条件
     * @return 页面列表
     */
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        if (queryPageRequest == null){
            queryPageRequest = new QueryPageRequest();
        }
        if (page <= 0){
            page = 1;
        }
        page = page -1; //为了适应mongdb的接口将页码-1
        if (size <= 0){
            size = 10;
        }
        //分页对象
        Pageable pageable= PageRequest.of(page,size);
        //分页查询
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        QueryResult<CmsPage> cmsPageQueryResult = new QueryResult<>();
        cmsPageQueryResult.setList(all.getContent());
        cmsPageQueryResult.setTotal(all.getTotalElements());
        //返回结果
        return new QueryResponseResult(CommonCode.SUCCESS,cmsPageQueryResult);
    }
}
