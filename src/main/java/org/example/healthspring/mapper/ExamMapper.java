package org.example.healthspring.mapper;

import org.apache.ibatis.annotations.*;
import org.example.healthspring.entity.ExamEntity;

import java.util.ArrayList;

@Mapper
public interface ExamMapper {

    @Select("SELECT * FROM exam")
    ArrayList<ExamEntity> selectAll();

    @Insert("INSERT INTO exam (question) VALUES (#{question}")
    void insert(ExamEntity examEntity);

    @Update("UPDATE exam SET question = #{question} WHERE id = #{id}")
    void update(ExamEntity examEntity);

    @Delete("DELETE FROM exam WHERE id = #{id}")
    void deleteById(int id);

}
