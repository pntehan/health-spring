package org.example.healthspring.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.healthspring.entity.AppointmentEntity;

import java.util.ArrayList;

@Mapper
public interface AppointmentMapper {
    @Select("select * from appointment where id=#{id}")
    AppointmentEntity selectById(int id);

    @Select("select * from appointment where student_id=#{student_id}")
    ArrayList<AppointmentEntity> selectByStu(int student_id);

    @Select("select * from appointment where teacher_id=#{teacher_id}")
    ArrayList<AppointmentEntity> selectByTea(int teacher_id);

    @Select("select * from appointment")
    ArrayList<AppointmentEntity> selectAll();

    @Insert("insert into appointment(student_id, teacher_id, up_time, status) values (#{student_id}, #{teacher_id}, #{up_time}, #{status})")
    void insert(AppointmentEntity appointmentEntity);

    @Insert("update appointment set student_id=#{student_id}, teacher_id=#{teacher_id}, up_time=#{up_time}, status=#{status} where id=#{id}")
    void update(AppointmentEntity appointmentEntity);
}
