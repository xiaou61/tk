package com.xiaou.tktiku.controller;

import com.xiaou.tktiku.entity.QuestionBank;
import com.xiaou.tktiku.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question-banks")
@CrossOrigin(origins = "*")
public class QuestionBankController {

    @Autowired
    private QuestionBankService questionBankService;

    @GetMapping
    public List<QuestionBank> list() {
        return questionBankService.list();
    }

    @GetMapping("/{id}")
    public QuestionBank getById(@PathVariable Long id) {
        return questionBankService.getById(id);
    }

    @PostMapping
    public boolean save(@RequestBody QuestionBank questionBank) {
        return questionBankService.save(questionBank);
    }

    @PutMapping
    public boolean update(@RequestBody QuestionBank questionBank) {
        return questionBankService.updateById(questionBank);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return questionBankService.removeById(id);
    }
}
