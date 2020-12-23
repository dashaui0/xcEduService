package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author:dashuai
 * @ClassName:PageService
 * @Descirption:
 * @date:2020/12/23 16:06
 */
public class PageService {

    /**
     * 页面查询方法
     *
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        return null;
    }
}
