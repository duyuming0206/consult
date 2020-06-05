package com.example.consult.server;

import com.example.consult.entity.Article;
import com.example.consult.entity.RestResult;

import java.util.List;

public interface ArticleService {


    //发布帖子
    public RestResult addArticle(Article article);

    //查看所有帖子
    public RestResult getAll();

    //根据帖子ID查看
    public RestResult getByID(int id);

    //根据用户ID查看
    public RestResult getByUserID(int userID);

    //删除
    public RestResult deleteByID(int[] list);
}
