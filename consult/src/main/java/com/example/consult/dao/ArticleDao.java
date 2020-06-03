package com.example.consult.dao;

import com.example.consult.entity.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ArticleDao {

    @Insert("insert into article(userID, title, content)values(#{userID},#{title},#{content})")
    public void addArticle(Article article);

    @Select("select * from article where id = #{id}")
    public Article getById(int id);

    @Select("select * from article where userID = #{userID}")
    public List<Article> getByUserID(int userID);

    @Select("select * from article")
    public List<Article> getAll();

    @Delete("delete from article where id = #{id}")
    public void deleteByID(int id);

}
