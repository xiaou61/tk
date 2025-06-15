package com.xiaou.tktiku.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaou.tktiku.entity.QuestionBank;
import com.xiaou.tktiku.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question-banks")
public class QuestionBankController {

    @Autowired
    private QuestionBankService questionBankService;

    @GetMapping
    public List<QuestionBank> getAllBanks() {
        return questionBankService.list();
    }

    @PostMapping
    public QuestionBank createBank(@RequestBody QuestionBank questionBank) {
        questionBankService.save(questionBank);
        return questionBank;
    }

    @PutMapping("/{id}")
    public QuestionBank updateBank(@PathVariable Long id, @RequestBody QuestionBank questionBank) {
        questionBank.setId(id);
        questionBankService.updateById(questionBank);
        return questionBank;
    }

    @DeleteMapping("/{id}")
    public void deleteBank(@PathVariable Long id) {
        questionBankService.removeById(id);
    }
}