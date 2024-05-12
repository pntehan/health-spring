package org.example.healthspring.controller;


import org.example.healthspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/login")
    @ResponseBody
    public Map<Object, Object> login(@RequestBody Map<String, Object> params) {
        return studentService.login(params);
    }

    @PostMapping("/updateUser")
    @ResponseBody
    public Map<Object, Object> updateUser(@RequestBody Map<String, Object> params) {
        return studentService.updateUser(params);
    }

    @GetMapping("/initHome")
    @ResponseBody
    public Map<Object, Object> initHome() {
        return studentService.initHome();
    }

    @GetMapping("/getArticles")
    @ResponseBody
    public Map<Object, Object> getArticles() {
        return studentService.getArticles();
    }

    @PostMapping("/getArticle")
    @ResponseBody
    public Map<Object, Object> getArticle(@RequestBody Map<String, Object> params) {
        return studentService.getArticle(params);
    }

    @GetMapping("/initExam")
    @ResponseBody
    public Map<Object, Object> initExam() {
        return studentService.initExam();
    }

    @PostMapping("/getRecords")
    @ResponseBody
    public Map<Object, Object> getRecords(@RequestBody Map<String, Object> params) {
        return studentService.getRecords(params);
    }

    @PostMapping("/addRecord")
    @ResponseBody
    public Map<Object, Object> addRecord(@RequestBody Map<String, Object> params) {
        return studentService.addRecord(params);
    }

    @GetMapping("/initAnnouncement")
    @ResponseBody
    public Map<Object, Object> initAnnouncement() {
        return studentService.initAnnouncement();
    }

    @GetMapping("/initBook")
    @ResponseBody
    public Map<Object, Object> initBook() {
        return studentService.initBook();
    }

    @PostMapping("/getBooks")
    @ResponseBody
    public Map<Object, Object> getBooks(@RequestBody Map<String, Object> params) {
        return studentService.getBooks(params);
    }

    @PostMapping("/addBook")
    @ResponseBody
    public Map<Object, Object> addBook(@RequestBody Map<String, Object> params) {
        return studentService.addBook(params);
    }

    @PostMapping("/cancelBook")
    @ResponseBody
    public Map<Object, Object> cancelBook(@RequestBody Map<String, Object> params) {
        return studentService.cancelBook(params);
    }

    @PostMapping("/initConsult")
    @ResponseBody
    public Map<Object, Object> initConsult(@RequestBody Map<String, Object> params) {
        return studentService.initConsult(params);
    }

    @PostMapping("/initFeedback")
    @ResponseBody
    public Map<Object, Object> initFeedback(@RequestBody Map<String, Object> params) {
        return studentService.initFeedback(params);
    }

    @PostMapping("/addConsult")
    @ResponseBody
    public Map<Object, Object> addConsult(@RequestBody Map<String, Object> params) {
        return studentService.addConsult(params);
    }

    @PostMapping("/addFeedback")
    @ResponseBody
    public Map<Object, Object> addFeedback(@RequestBody Map<String, Object> params) {
        return studentService.addFeedback(params);
    }

    @PostMapping("/initStar")
    @ResponseBody
    public Map<Object, Object> initStar(@RequestBody Map<String, Object> params) {
        return studentService.initStar(params);
    }

    @PostMapping("/addStarTeacher")
    @ResponseBody
    public Map<Object, Object> addStarTeacher(@RequestBody Map<String, Object> params) {
        return studentService.addStarTeacher(params);
    }

    @PostMapping("/addStarArticle")
    @ResponseBody
    public Map<Object, Object> addStarArticle(@RequestBody Map<String, Object> params) {
        return studentService.addStarArticle(params);
    }

    @PostMapping("/checkComment")
    @ResponseBody
    public Map<Object, Object> checkComment(@RequestBody Map<String, Object> params) {
        return studentService.checkComment(params);
    }

    @PostMapping("/addComment")
    @ResponseBody
    public Map<Object, Object> addComment(@RequestBody Map<String, Object> params) {
        return studentService.addComment(params);
    }

    @PostMapping("/showComment")
    @ResponseBody
    public Map<Object, Object> showComment(@RequestBody Map<String, Object> params) {
        return studentService.showComment(params);
    }
}
