package com.xiaou.tktiku.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaou.tktiku.entity.QuestionBank;
import com.xiaou.tktiku.service.QuestionBankService;
import com.xiaou.tktiku.mapper.QuestionBankMapper;
import org.springframework.stereotype.Service;

/**
 * @author Lenovo
 * @description 针对表【question_bank】的数据库操作Service实现
 * @createDate 2025-06-14 19:51:30
 */
@Service
public class QuestionBankServiceImpl extends ServiceImpl<QuestionBankMapper, QuestionBank>
        implements QuestionBankService {

}
