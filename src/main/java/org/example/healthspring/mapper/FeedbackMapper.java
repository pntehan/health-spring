package org.example.healthspring.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.healthspring.entity.FeedbackEntity;

import java.util.ArrayList;

@Mapper
public interface FeedbackMapper {
    @Select("select * from feedback")
    ArrayList<FeedbackEntity> selectAll();

    @Select("select * from feedback where student_id=#{student_id}")
    ArrayList<FeedbackEntity> selectByStu(int student_id);

    @Select("select * from feedback where id=#{id}")
    FeedbackEntity selectById(int id);

    @Insert("insert into feedback(student_id, up_time, status, question, answer) values(#{student_id}, #{up_time}, #{status}, #{question}, #{answer})")
    void insert(FeedbackEntity feedbackEntity);

    @Update("update feedback set student_id=#{student_id}, up_time=#{up_time}, status=#{status}, question=#{question}, answer=#{answer} where id=#{id}")
    void update(FeedbackEntity feedbackEntity);
}
