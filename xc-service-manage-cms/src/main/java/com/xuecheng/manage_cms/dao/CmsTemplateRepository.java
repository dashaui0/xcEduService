package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Lenovo
 * @Classname CmsTemplateRepository
 * @Description TODO
 * @Date 2021/1/20 16:32
 */
public interface CmsTemplateRepository  extends MongoRepository<CmsTemplate,String>{
}
