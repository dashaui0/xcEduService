package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Lenovo
 * @Classname CmsConfigRepository
 * @Description TODO
 * @Date 2021/1/16 17:08
 */
public interface CmsConfigRepository extends MongoRepository<CmsConfig,String> {
}
