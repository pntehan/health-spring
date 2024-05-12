package org.example.healthspring.mapper;

import org.apache.ibatis.annotations.*;
import org.example.healthspring.entity.ArticleEntity;

import java.util.ArrayList;

@Mapper
public interface ArticleMapper {
    @Select("SELECT * FROM article")
    ArrayList<ArticleEntity> selectAll();

    @Select("SELECT * FROM article WHERE id = #{id}")
    ArticleEntity selectById(int id);

    @Insert("INSERT INTO article (title, content, cover, up_time) VALUES (#{title}, #{content}), #{cover}, #{up_time}")
    void insert(ArticleEntity articleEntity);

    @Update("UPDATE article SET title = #{title}, content = #{content}, cover=#{cover}, up_time=#{up_time} WHERE id = #{id}")
    void update(ArticleEntity articleEntity);

    @Delete("DELETE FROM article WHERE id = #{id}")
    void deleteById(int id);
}
