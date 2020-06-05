package com.example.consult.server;

import com.example.consult.entity.Comment;
import com.example.consult.entity.RestResult;

public interface CommentService {

    //发布评论
    public RestResult addComment(Comment comment);

    //根据帖子获取帖子的评论
    public RestResult getByArticleID(int articleID);

    //根据评论ID隐藏评论
    public RestResult hide(int[] list);

}
