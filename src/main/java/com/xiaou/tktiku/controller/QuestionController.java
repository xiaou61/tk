package com.xiaou.tktiku.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaou.tktiku.entity.Question;
import com.xiaou.tktiku.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<Question> list() {
        return questionService.list();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable Long id) {
        return questionService.getById(id);
    }

    @PostMapping
    public boolean save(@RequestBody Question question) {
        return questionService.save(question);
    }
    // ✅ 批量新增
    @PostMapping("/batch")
    public boolean saveBatch(@RequestBody List<Question> questions) {
        return questionService.saveBatch(questions);
    }

    @PutMapping
    public boolean update(@RequestBody Question question) {
        return questionService.updateById(question);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return questionService.removeById(id);
    }
}
