package com.example.consult.ctrl;

import com.example.consult.entity.Comment;
import com.example.consult.entity.RestResult;
import com.example.consult.server.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {


    @Autowired
    CommentService commentService;

    //发布评论
    @RequestMapping("addComment")
    public RestResult addComment(Comment comment){
        return commentService.addComment(comment);
    }

    //根据帖子获取帖子的评论
    @RequestMapping("getByArticleID")
    public RestResult getByArticleID(int articleID){
        return commentService.getByArticleID(articleID);
    }

    //根据评论ID隐藏评论
    @RequestMapping("hide")
    public RestResult hide(int[] list){
        return commentService.hide(list);
    }
}
