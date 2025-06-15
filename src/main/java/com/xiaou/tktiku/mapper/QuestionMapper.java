package com.xiaou.tktiku.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaou.tktiku.entity.Question;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Lenovo
 * @description 针对表【question】的数据库操作Mapper
 * @createDate 2025-06-14 19:51:30
 * @Entity com.xiaou.tktiku.entity.Question
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

}
