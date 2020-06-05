package com.example.consult.dao;


import com.example.consult.entity.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface CommentDao {

    @Insert("insert into comment(userID, acticleID, content)values(#{userID}, #{acticleID}, #{content})")
    public void addComment(Comment comment);

    @Select("select * from comment where acticleID = #{acticleID} and ")
    public List<Comment> getByActicleID(int acticleID);

    @Select("select * from comment")
    public List<Comment> getAll();

    @Delete("delete from comment where id = #{id}")
    public void deleteByID(int id);

    @Update("update comment set valid = #{valid}, changeTime = #{changeTime} where id = #{id}")
    public void hide(Comment comment);
}
