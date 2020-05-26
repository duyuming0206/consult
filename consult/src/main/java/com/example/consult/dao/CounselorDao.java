package com.example.consult.dao;


import com.example.consult.entity.Counselor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;


import java.util.List;

@Mapper
@Component
public interface CounselorDao {

    @Insert("insert into counselor(userID,sex,name,phone,mail,qualification,synopsis)" +
            "values(#{userID},#{sex},#{name},#{phone},#{mail},#{qualification},#{synopsis})")
    public void addCounselor(Counselor counselor);

    @Select("select * from counselor")
    public List<Counselor> getAll();

    @Select("select * from counselor where id = #{id}")
    public Counselor getById();

    @Update("update counselor set sex=#{sex}, name=#{name}, phone=#{phone}, mail=#{mail}, " +
            "qualification=#{qualification}, synopsis=#{synopsis} where userID = #{userID}")
    public void updateCounselor(Counselor counselor);


}
