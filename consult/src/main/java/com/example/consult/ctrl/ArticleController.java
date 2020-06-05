package com.example.consult.ctrl;


import com.example.consult.entity.Article;
import com.example.consult.entity.RestResult;
import com.example.consult.server.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    //发布帖子
    @RequestMapping("addArticle")
    public RestResult addArticle(Article article){
        return articleService.addArticle(article);
    }

    //查看所有帖子
    @RequestMapping("getAll")
    public RestResult getAll(){
        return articleService.getAll();
    }

    //根据帖子ID查看（查看单篇）
    @RequestMapping("getByID")
    public RestResult getByID(int id){
        return articleService.getByID(id);
    }

    //根据用户ID查看(查看用户发布的所有帖子)
    @RequestMapping("getByUserID")
    public RestResult getByUserID(int userID){
        return articleService.getByUserID(userID);
    }

    //删除
    @RequestMapping("deleteByID")
    public RestResult deleteByID(int[] list){
        return articleService.deleteByID(list);
    }
}
