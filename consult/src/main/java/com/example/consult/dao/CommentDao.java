package com.example.consult.dao;


import com.example.consult.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CommentDao {

    @Insert("insert into comment(userID, acticleID, content)values(#{userID}, #{acticleID}, #{content})")
    public void addComment(Comment comment);

    @Select("select * from comment where acticleID = #{acticleID}")
    public List<Comment> getByActicleID(int acticleID);

    @Select("select * from comment")
    public List<Comment> getAll();

    @Delete("delete from comment where id = #{id}")
    public void deleteByID(int id);
}
