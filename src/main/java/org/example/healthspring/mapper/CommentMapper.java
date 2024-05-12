package org.example.healthspring.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.healthspring.entity.CommentEntity;

import java.util.ArrayList;

@Mapper
public interface CommentMapper {
    @Select("select * from comment")
    ArrayList<CommentEntity> selectAll();

    @Select("select * from comment where student_id=#{student_id}")
    ArrayList<CommentEntity> selectByStu(int student_id);

    @Select("select * from comment where teacher_id=#{teacher_id}")
    ArrayList<CommentEntity> selectByTea(int teacher_id);

    @Select("select * from comment where appointment_id=#{appointment_id}")
    CommentEntity selectByAppoint(int appointment_id);

    @Insert("insert into comment (appointment_id, student_id, teacher_id, content, star) values (#{appointment_id}, #{student_id}, #{teacher_id}, #{content}, #{star})")
    void insert(CommentEntity commentEntity);

    @Delete("delete from comment where id=#{id}")
    void delete(int id);
}
