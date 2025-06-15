package com.xiaou.tktiku.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaou.tktiku.entity.Question;
import com.xiaou.tktiku.mapper.QuestionMapper;
import com.xiaou.tktiku.service.QuestionService;
import org.springframework.stereotype.Service;

/**
 * @author Lenovo
 * @description 针对表【question】的数据库操作Service实现
 * @createDate 2025-06-14 19:51:30
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
        implements QuestionService {

}
