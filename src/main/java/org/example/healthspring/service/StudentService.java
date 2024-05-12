package org.example.healthspring.service;

import org.example.healthspring.entity.*;
import org.example.healthspring.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ExamMapper examMapper;

    @Autowired
    RecordMapper recordMapper;

    @Autowired
    AnnouncementMapper announcementMapper;

    @Autowired
    AppointmentMapper appointmentMapper;

    @Autowired
    ConsultMapper consultMapper;

    @Autowired
    FeedbackMapper feedbackMapper;

    @Autowired
    StarMapper starMapper;

    @Autowired
    CommentMapper commentMapper;

    public Map<Object, Object> login(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        // get data
        int id = Integer.parseInt(params.get("id").toString());
        String password = params.get("password").toString();
        UserEntity userEntity = userMapper.selectById(id);
        if (userEntity.getPassword().equals(password)) {
            response.put("status", 200);
            response.put("data", userEntity);
        }
        else {
            response.put("status", 400);
            response.put("msg", "账号或者密码不正确！");
        }
        return response;
    }

    public Map<Object, Object> updateUser(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        // get data
        int id = Integer.parseInt(params.get("id").toString());
        String name = params.get("name").toString();
        String gender = params.get("gender").toString();
        String intro = params.get("intro").toString();
        String password = params.get("password").toString();
        int classroom = Integer.parseInt(params.get("classroom").toString());
        // 获取旧数据
        UserEntity userEntity = userMapper.selectById(id);
        if (userEntity.getPassword().equals(password)) {
            // 修改信息
            userEntity.setName(name);
            userEntity.setGender(gender);
            userEntity.setIntro(intro);
            userEntity.setClassroom(classroom);
            response.put("status", 200);
            response.put("data", userEntity);
        }
        else {
            response.put("status", 400);
            response.put("msg", "账号或者密码不正确！");
        }
        return response;
    }

    public Map<Object, Object> initHome() {
        Map<Object, Object> response = new HashMap<>();
        // 取值打乱
        ArrayList<ArticleEntity> articleEnities = articleMapper.selectAll();
        Collections.shuffle(articleEnities);
        // 取前4个
        ArrayList<ArticleEntity> data = new ArrayList<>();
        for (int i=0; i<4; i++) {
            data.add(articleEnities.get(i));
        }
        response.put("status", 200);
        response.put("data", data);
        return response;
    }

    public Map<Object, Object> getArticles() {
        Map<Object, Object> response = new HashMap<>();
        ArrayList<ArticleEntity> articleEnities = articleMapper.selectAll();
        response.put("status", 200);
        response.put("data", articleEnities);
        return response;
    }

    public Map<Object, Object> getArticle(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        // get data
        int id = Integer.parseInt(params.get("id").toString());
        ArticleEntity articleEntity = articleMapper.selectById(id);
        response.put("status", 200);
        response.put("data", articleEntity);
        return response;
    }

    public Map<Object, Object> initExam() {
        Map<Object, Object> response = new HashMap<>();
        // 取题目
        ArrayList<ExamEntity> examEntities = examMapper.selectAll();
        response.put("status", 200);
        response.put("data", examEntities);
        return response;
    }

    public Map<Object, Object> getRecords(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int student_id = Integer.parseInt(params.get("student_id").toString());
        // 取题目
        ArrayList<RecordEntity> recordEntities = recordMapper.selectByStudent(student_id);
        response.put("status", 200);
        response.put("data", recordEntities);
        return response;
    }

    public Map<Object, Object> addRecord(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int student_id = Integer.parseInt(params.get("student_id").toString());
        float score = Float.parseFloat(params.get("score").toString());
        RecordEntity recordEntity = new RecordEntity(student_id, new Date(), score, "", "");
        recordMapper.insert(recordEntity);
        // 取题目
        ArrayList<RecordEntity> recordEntities = recordMapper.selectByStudent(student_id);
        response.put("status", 200);
        response.put("data", recordEntities);
        return response;
    }

    public Map<Object, Object> initAnnouncement() {
        Map<Object, Object> response = new HashMap<>();
        // 取题目
        ArrayList<AnnouncementEntity> announcementEntities = announcementMapper.selectAll();
        response.put("status", 200);
        response.put("data", announcementEntities);
        return response;
    }

    public Map<Object, Object> initBook() {
        Map<Object, Object> response = new HashMap<>();
        // 取题目
        ArrayList<UserEntity> userEntities = userMapper.selectByRole("老师");
        response.put("status", 200);
        response.put("data", userEntities);
        return response;
    }

    public Map<Object, Object> getBooks(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int student_id = Integer.parseInt(params.get("student_id").toString());
        // 取题目
        ArrayList<AppointmentEntity> appointmentEntities = appointmentMapper.selectByStu(student_id);
        for (int i=0; i<appointmentEntities.size(); i++) {
            AppointmentEntity appointmentEntity = appointmentEntities.get(i);
            appointmentEntity.setStudent_name(userMapper.selectById(appointmentEntity.getStudent_id()).getName());
            appointmentEntity.setTeacher_name(userMapper.selectById(appointmentEntity.getTeacher_id()).getName());
            appointmentEntities.set(i, appointmentEntity);
        }
        response.put("status", 200);
        response.put("data", appointmentEntities);
        return response;
    }

    public Map<Object, Object> addBook(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int student_id = Integer.parseInt(params.get("student_id").toString());
        int teacher_id = Integer.parseInt(params.get("teacher_id").toString());
        String status = params.get("status").toString();
        // 存值
        AppointmentEntity appointmentEntity = new AppointmentEntity(student_id, teacher_id, new Date(), status);
        appointmentMapper.insert(appointmentEntity);
        // 取值
        ArrayList<AppointmentEntity> appointmentEntities = appointmentMapper.selectByStu(student_id);
        for (int i=0; i<appointmentEntities.size(); i++) {
            AppointmentEntity t = appointmentEntities.get(i);
            t.setStudent_name(userMapper.selectById(t.getStudent_id()).getName());
            t.setTeacher_name(userMapper.selectById(t.getTeacher_id()).getName());
            appointmentEntities.set(i, t);
        }
        response.put("status", 200);
        response.put("data", appointmentEntities);
        return response;
    }

    public Map<Object, Object> cancelBook(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int id = Integer.parseInt(params.get("id").toString());
        int student_id = Integer.parseInt(params.get("student_id").toString());
        String status = params.get("status").toString();
        // 取值
        AppointmentEntity appointmentEntity = appointmentMapper.selectById(id);
        appointmentEntity.setStatus("已取消");
        appointmentMapper.update(appointmentEntity);
        // 取值
        ArrayList<AppointmentEntity> appointmentEntities = appointmentMapper.selectByStu(student_id);
        for (int i=0; i<appointmentEntities.size(); i++) {
            AppointmentEntity t = appointmentEntities.get(i);
            t.setStudent_name(userMapper.selectById(t.getStudent_id()).getName());
            t.setTeacher_name(userMapper.selectById(t.getTeacher_id()).getName());
            appointmentEntities.set(i, t);
        }
        response.put("status", 200);
        response.put("data", appointmentEntities);
        return response;
    }

    public Map<Object, Object> initConsult(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int student_id = Integer.parseInt(params.get("student_id").toString());
        // 取题目
        ArrayList<ConsultEntity> consultEntities = consultMapper.selectByStu(student_id);
        response.put("status", 200);
        response.put("data", consultEntities);
        return response;
    }

    public Map<Object, Object> initFeedback(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int student_id = Integer.parseInt(params.get("student_id").toString());
        // 取题目
        ArrayList<FeedbackEntity> feedbackEntities = feedbackMapper.selectByStu(student_id);
        response.put("status", 200);
        response.put("data", feedbackEntities);
        return response;
    }

    public Map<Object, Object> addConsult(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int student_id = Integer.parseInt(params.get("student_id").toString());
        String question = params.get("question").toString();
        // 存值
        ConsultEntity consultEntity = new ConsultEntity(student_id, new Date(), "未回复", question, "");
        consultMapper.insert(consultEntity);
        ArrayList<ConsultEntity> consultEntities = consultMapper.selectByStu(student_id);
        response.put("status", 200);
        response.put("data", consultEntities);
        return response;
    }

    public Map<Object, Object> addFeedback(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int student_id = Integer.parseInt(params.get("student_id").toString());
        String question = params.get("question").toString();
        // 存值
        FeedbackEntity feedbackEntity = new FeedbackEntity(student_id, new Date(), "未回复", question, "");
        feedbackMapper.insert(feedbackEntity);
        ArrayList<FeedbackEntity> feedbackEntities = feedbackMapper.selectByStu(student_id);
        response.put("status", 200);
        response.put("data", feedbackEntities);
        return response;
    }

    public Map<Object, Object> initStar(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int student_id = Integer.parseInt(params.get("student_id").toString());
        // 取值
        ArrayList<StarEntity> starEntities = starMapper.selectByStu(student_id);
        // 处理
        ArrayList<Map<Object, Object>> articles = new ArrayList<>();
        ArrayList<Map<Object, Object>> teachers = new ArrayList<>();
        for (StarEntity starEntity: starEntities) {
            Map<Object, Object> item = new HashMap<>();
            if (starEntity.getArticle_id() != 0) {
                ArticleEntity articleEntity = articleMapper.selectById(starEntity.getArticle_id());
                item.put("id", starEntity.getId());
                item.put("article_id", articleEntity.getId());
                item.put("title", articleEntity.getTitle());
                item.put("content", articleEntity.getContent());
                item.put("up_time", starEntity.getUp_time());
                articles.add(item);
            }
            else {
                UserEntity userEntity = userMapper.selectById(starEntity.getTeacher_id());
                item.put("id", starEntity.getId());
                item.put("teacher_id", userEntity.getId());
                item.put("name", userEntity.getName());
                item.put("intro", userEntity.getIntro());
                item.put("up_time", starEntity.getUp_time());
                teachers.add(item);
            }
        }
        response.put("status", 200);
        response.put("articles", articles);
        response.put("teachers", teachers);
        return response;
    }

    public Map<Object, Object> addStarTeacher(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int student_id = Integer.parseInt(params.get("student_id").toString());
        int teacher_id = Integer.parseInt(params.get("teacher_id").toString());
        // 校验
        StarEntity starEntity = starMapper.selectByStuAndTea(student_id, teacher_id);
        if (starEntity == null) {
            // 存值
            starEntity = new StarEntity(student_id, 0, teacher_id, new Date());
            starMapper.insertTeacher(starEntity);
            response.put("status", 200);
        }
        else {
            response.put("status", 400);
        }
        return response;
    }

    public Map<Object, Object> addStarArticle(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int student_id = Integer.parseInt(params.get("student_id").toString());
        int article_id = Integer.parseInt(params.get("article_id").toString());
        // 校验
        StarEntity starEntity = starMapper.selectByStuAndArt(student_id, article_id);
        if (starEntity == null) {
            // 存值
            starEntity = new StarEntity(student_id, article_id, 0, new Date());
            starMapper.insertArticle(starEntity);
            response.put("status", 200);
        }
        else {
            response.put("status", 400);
        }
        return response;
    }

    public Map<Object, Object> checkComment(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int appointment_id = Integer.parseInt(params.get("appointment_id").toString());
        // 校验
        CommentEntity commentEntity = commentMapper.selectByAppoint(appointment_id);
        if (commentEntity == null) {
            response.put("status", 200);
        }
        else {
            response.put("status", 400);
        }
        return response;
    }

    public Map<Object, Object> addComment(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int appointment_id = Integer.parseInt(params.get("appointment_id").toString());
        int student_id = Integer.parseInt(params.get("student_id").toString());
        int teacher_id = Integer.parseInt(params.get("teacher_id").toString());
        String content = params.get("content").toString();
        int star = Integer.parseInt(params.get("star").toString());
        // 存值
        CommentEntity commentEntity = new CommentEntity(appointment_id, student_id, teacher_id, content, star);
        commentMapper.insert(commentEntity);
        response.put("status", 200);
        return response;
    }

    public Map<Object, Object> showComment(Map<String, Object> params) {
        Map<Object, Object> response = new HashMap<>();
        int appointment_id = Integer.parseInt(params.get("appointment_id").toString());
        // 取值
        CommentEntity commentEntity = commentMapper.selectByAppoint(appointment_id);
        if (commentEntity == null) {
            response.put("status", 400);
        }
        else {
            response.put("status", 200);
            response.put("data", commentEntity);
        }
        return response;
    }
}
