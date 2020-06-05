package com.example.consult.server.impl;

import com.example.consult.dao.CommentDao;
import com.example.consult.entity.Comment;
import com.example.consult.entity.RestResult;
import com.example.consult.entity.ResultCode;
import com.example.consult.server.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;


    @Override
    public RestResult addComment(Comment comment) {
        try {
            commentDao.addComment(comment);
            List<Comment> list = commentDao.getByActicleID(comment.getActicleID());
            return new RestResult(ResultCode.SUCCESS,list);
        }catch (Exception e){
            return new RestResult(ResultCode.ERROR, e.getMessage());
        }
    }

    @Override
    public RestResult getByArticleID(int articleID) {
        try {
            List<Comment> list = commentDao.getByActicleID(articleID);
            return new RestResult(ResultCode.SUCCESS,list);
        }catch (Exception e){
            return new RestResult(ResultCode.ERROR, e.getMessage());
        }
    }

    @Override
    public RestResult hide(int[] list) {
        try {
            Comment comment = new Comment();
            comment.setValid(2);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            comment.setChangeTime(df.format(new Date()));

            for (int i = 0; i < list.length; i++){
                comment.setId(list[i]);
                commentDao.hide(comment);
            }
            return new RestResult(ResultCode.SUCCESS);
        }catch (Exception e){
            return new RestResult(ResultCode.ERROR, e.getMessage());
        }
    }
}
