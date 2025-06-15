package com.xiaou.tktiku.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaou.tktiku.entity.QuestionBank;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Lenovo
 * @description 针对表【question_bank】的数据库操作Mapper
 * @createDate 2025-06-14 19:51:30
 * @Entity com.xiaou.tktiku.entity.QuestionBank
 */
@Mapper
public interface QuestionBankMapper extends BaseMapper<QuestionBank> {

}
