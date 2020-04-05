package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.domain.cms.response.CmsPostPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {

//    @GetMapping("/list/{page}/{size}")
//    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, QueryPageRequest queryPageRequest){
//        QueryResult<CmsPage> queryResult = new QueryResult();
//        List<CmsPage> list = new ArrayList<>();
//        CmsPage cmsPage = new CmsPage();
//        cmsPage.setPageName("测试页面");
//        System.out.println("测试页面");
//        list.add(cmsPage);
//        queryResult.setList(list);
//        queryResult.setTotal(2);
//        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
//        return queryResponseResult;
//    }

    @Autowired
    PageService pageService;

    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, QueryPageRequest queryPageRequest){
        return pageService.findList(page, size, queryPageRequest);
    }

    @PostMapping("/add")
    public CmsPageResult add(@RequestBody CmsPage cmsPage){
        return pageService.add(cmsPage);
    }

    //根据id查询页面
    @GetMapping("/get/{id}")
    public CmsPage findById(@PathVariable("id") String id){
        return pageService.getById(id);
    }

    //保存页面信息
    @PutMapping("/edit/{id}")
    public CmsPageResult edit(@PathVariable("id") String id, @RequestBody CmsPage cmsPage){
        return pageService.update(id, cmsPage);
    }

    //删除页面
    @DeleteMapping("/del/{id}")
    public ResponseResult delete(@PathVariable("id") String id){
        return pageService.delete(id);
    }

    // 发布页面
    @PostMapping("/postPage/{pageId}")
    public ResponseResult post(@PathVariable("pageId") String pageId){
        return pageService.post(pageId);
    }

    @PostMapping("/save")
    public CmsPageResult save(@RequestBody CmsPage cmsPage){
        return pageService.save(cmsPage);
    }

    // 快速发布
    @PostMapping("/postPageQuick")
    public CmsPostPageResult postPageQuick(@RequestBody CmsPage cmsPage){
        return pageService.postPageQuick(cmsPage);
    }
}


