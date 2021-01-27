package com.xuecheng.manage_cms;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * @author Lenovo
 * @Classname GridFsTest
 * @Description TODO
 * @Date 2021/1/24 16:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GridFsTest {

    @Autowired
    GridFsTemplate gridFsTemplate;

    /**
     * 存文件
     */
    @Test
    public void testRestTemplate(){
        File file = new File("d:/index_banner.ftl");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectId objectId = gridFsTemplate.store(fileInputStream, "index_banner.ftl");
            System.out.println(objectId);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
