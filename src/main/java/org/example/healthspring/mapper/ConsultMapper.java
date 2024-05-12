package org.example.healthspring.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.healthspring.entity.ConsultEntity;

import java.util.ArrayList;

@Mapper
public interface ConsultMapper {
    @Select("select * from consultation")
    ArrayList<ConsultEntity> selectAll();

    @Select("select * from consultation where student_id=#{student_id}")
    ArrayList<ConsultEntity> selectByStu(int student_id);

    @Select("select * from consultation where teacher_id=#{teacher_id}")
    ArrayList<ConsultEntity> selectByTea(int teacher_id);

    @Select("select * from consultation where id=#{id}")
    ConsultEntity selectById(int id);

    @Insert("insert into consultation(student_id, teacher_id, up_time, status, question, answer) values(#{student_id}, #{teacher_id}, #{up_time}, #{status}, #{question}, #{answer})")
    void insert(ConsultEntity consultEntity);

    @Update("update consultation set student_id=#{student_id}, teacher_id=#{teacher_id}, up_time=#{up_time}, status=#{status}, question=#{question}, answer=#{answer} where id=#{id}")
    void update(ConsultEntity consultEntity);
}
