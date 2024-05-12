package org.example.healthspring.mapper;

import org.apache.ibatis.annotations.*;
import org.example.healthspring.entity.RecordEntity;

import java.util.ArrayList;

@Mapper
public interface RecordMapper {
    @Select("SELECT * FROM exam_record")
    ArrayList<RecordEntity> selectAll();

    @Select("SELECT * FROM exam_record WHERE student_id=#{student_id}")
    ArrayList<RecordEntity> selectByStudent(int student_id);

    @Select("SELECT * FROM exam_record WHERE id = #{id}")
    RecordEntity selectById(int id);

    @Insert("INSERT INTO exam_record (student_id, exam_time, score, teacher_comment, warning_info) VALUES (#{student_id}, #{exam_time}, #{score}, #{teacher_comment}, #{warning_info})")
    void insert(RecordEntity recordEntity);

    @Update("UPDATE exam_record SET student_id=#{student_id}, exam_time=#{exam_time}, score=#{score}, teacher_comment=#{teacher_comment}, warning_info=#{warning_info} WHERE id=#{id}")
    void update(RecordEntity recordEntity);

    @Delete("DELETE FROM exam_record WHERE id = #{id}")
    void deleteById(int id);
}
