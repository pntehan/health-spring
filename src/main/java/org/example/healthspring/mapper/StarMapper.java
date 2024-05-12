package org.example.healthspring.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.healthspring.entity.StarEntity;

import java.util.ArrayList;

@Mapper
public interface StarMapper {
    @Select("select * from favorite")
    ArrayList<StarEntity> selectAll();

    @Select("select * from favorite where student_id=#{student_id}")
    ArrayList<StarEntity> selectByStu(int student_id);

    @Select("select * from favorite where student_id=#{student_id} and teacher_id=#{teacher_id}")
    StarEntity selectByStuAndTea(int student_id, int teacher_id);

    @Select("select * from favorite where student_id=#{student_id} and article_id=#{article_id}")
    StarEntity selectByStuAndArt(int student_id, int article_id);

    @Insert("insert into favorite (student_id, article_id, up_time) values (#{student_id}, #{article_id}, #{up_time})")
    void insertArticle(StarEntity starEntity);

    @Insert("insert into favorite (student_id, teacher_id, up_time) values (#{student_id}, #{teacher_id}, #{up_time})")
    void insertTeacher(StarEntity starEntity);

    @Delete("delete from favorite where id=#{id}")
    void delete(int id);
}
