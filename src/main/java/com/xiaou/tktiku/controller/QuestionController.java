package com.xiaou.tktiku.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaou.tktiku.entity.Question;
import com.xiaou.tktiku.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<Question> getQuestions(@RequestParam(required = false) Long bankId) {
        LambdaQueryWrapper<Question> wrapper = new LambdaQueryWrapper<>();
        if (bankId != null) {
            wrapper.eq(Question::getBankId, bankId);
        }
        return questionService.list(wrapper);
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Long id) {
        Question question = questionService.getById(id);
        if (question == null) {
            throw new RuntimeException("题目不存在");
        }
        return question;
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        // 验证必填字段
        if (question == null) {
            throw new RuntimeException("请求体不能为空");
        }
        if (question.getBankId() == null) {
            throw new RuntimeException("题库ID不能为空");
        }
        if (question.getTitle() == null || question.getTitle().trim().isEmpty()) {
            throw new RuntimeException("标题不能为空");
        }
        if (question.getContentMd() == null || question.getContentMd().trim().isEmpty()) {
            throw new RuntimeException("内容不能为空");
        }
        // 设置默认难度
        if (question.getDifficulty() == null) {
            question.setDifficulty(1);
        }
        questionService.save(question);
        return question;
    }

    @PostMapping("/batch")
    public Map<String, Object> batchImport(@RequestBody List<Question> questions) {
        if (questions == null || questions.isEmpty()) {
            throw new RuntimeException("题目列表不能为空");
        }

        // 验证所有题目
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            if (question == null) {
                throw new RuntimeException("第 " + (i + 1) + " 个题目数据为空");
            }
            if (question.getBankId() == null) {
                throw new RuntimeException("第 " + (i + 1) + " 个题目缺少题库ID");
            }
            if (question.getTitle() == null || question.getTitle().trim().isEmpty()) {
                throw new RuntimeException("第 " + (i + 1) + " 个题目缺少标题");
            }
            if (question.getContentMd() == null || question.getContentMd().trim().isEmpty()) {
                throw new RuntimeException("第 " + (i + 1) + " 个题目缺少内容");
            }
            // 设置默认难度
            if (question.getDifficulty() == null) {
                question.setDifficulty(1);
            }
        }

        // 批量保存
        boolean success = questionService.saveBatch(questions);
        return Map.of(
                "success", success,
                "count", questions.size());
    }

    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        Question existingQuestion = questionService.getById(id);
        if (existingQuestion == null) {
            throw new RuntimeException("题目不存在");
        }

        // 验证必填字段
        if (updatedQuestion == null) {
            throw new RuntimeException("请求体不能为空");
        }
        if (updatedQuestion.getTitle() == null || updatedQuestion.getTitle().trim().isEmpty()) {
            throw new RuntimeException("标题不能为空");
        }
        if (updatedQuestion.getContentMd() == null || updatedQuestion.getContentMd().trim().isEmpty()) {
            throw new RuntimeException("内容不能为空");
        }

        // 保持原有的 bankId
        updatedQuestion.setId(id);
        updatedQuestion.setBankId(existingQuestion.getBankId());
        // 如果没有设置难度，保持原有难度
        if (updatedQuestion.getDifficulty() == null) {
            updatedQuestion.setDifficulty(existingQuestion.getDifficulty());
        }
        questionService.updateById(updatedQuestion);
        return updatedQuestion;
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        if (!questionService.removeById(id)) {
            throw new RuntimeException("题目不存在");
        }
    }
}