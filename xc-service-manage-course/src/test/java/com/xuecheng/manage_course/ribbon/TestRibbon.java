package com.xuecheng.manage_course.ribbon;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_course.dao.CourseBaseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRibbon {
    @Autowired
    CourseBaseRepository courseBaseRepository;

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testRibbon() {
        // 服务id
        String serviceId = "XC-SERVICE-MANAGE-CMS";
        for(int i = 0; i<10; i++){
            //通过服务id调用
            ResponseEntity<CmsPage> forEntity = restTemplate.getForEntity("http://" + serviceId + "/cms/page/get/5a754adf6abb500ad05688d9", CmsPage.class);
            CmsPage cmsPage = forEntity.getBody();
            System.out.println(cmsPage);
        }
    }

}
