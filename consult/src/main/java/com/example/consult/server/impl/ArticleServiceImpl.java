package com.example.consult.server.impl;

import com.example.consult.dao.ArticleDao;
import com.example.consult.entity.Article;
import com.example.consult.entity.RestResult;
import com.example.consult.entity.ResultCode;
import com.example.consult.server.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public RestResult addArticle(Article article) {
        try {
            articleDao.addArticle(article);
            List<Article> list = articleDao.getAll();
            return new RestResult(ResultCode.SUCCESS, list);
        }catch (Exception e){
            return new RestResult(ResultCode.ERROR, e.getMessage());
        }
    }

    @Override
    public RestResult getAll() {
        try {
            List<Article> list = articleDao.getAll();
            return new RestResult(ResultCode.SUCCESS, list);
        }catch (Exception e){
            return new RestResult(ResultCode.ERROR, e.getMessage());
        }
    }

    @Override
    public RestResult getByID(int id) {
        try {
            Article article = articleDao.getById(id);
            return new RestResult(ResultCode.SUCCESS, article);
        }catch (Exception e){
            return new RestResult(ResultCode.ERROR, e.getMessage());
        }
    }

    @Override
    public RestResult getByUserID(int userID) {
        try {
            List<Article> list = articleDao.getByUserID(userID);
            return new RestResult(ResultCode.SUCCESS, list);
        }catch (Exception e){
            return new RestResult(ResultCode.ERROR, e.getMessage());
        }
    }

    @Override
    public RestResult deleteByID(int[] list) {
        try {
            for (int i = 0; i < list.length; i++){
                articleDao.deleteByID(list[i]);
            }
            List<Article> list1 = articleDao.getAll();
            return new RestResult(ResultCode.SUCCESS, list1);
        }catch (Exception e){
            return new RestResult(ResultCode.ERROR, e.getMessage());
        }
    }
}
