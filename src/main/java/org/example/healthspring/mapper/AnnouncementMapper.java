package org.example.healthspring.mapper;

import org.apache.ibatis.annotations.*;
import org.example.healthspring.entity.AnnouncementEntity;

import java.util.ArrayList;

@Mapper
public interface AnnouncementMapper {
    @Select("SELECT * FROM announcement")
    ArrayList<AnnouncementEntity> selectAll();

    @Select("SELECT * FROM announcement WHERE id = #{id}")
    AnnouncementEntity selectById(int id);

    @Insert("INSERT INTO announcement (title, content, up_time) VALUES (#{title}, #{content}), #{up_time}")
    void insert(AnnouncementEntity announcementEntity);

    @Update("UPDATE announcement SET title = #{title}, content = #{content}, up_time=#{up_time} WHERE id = #{id}")
    void update(AnnouncementEntity announcementEntity);

    @Delete("DELETE FROM announcement WHERE id = #{id}")
    void deleteById(int id);
}
