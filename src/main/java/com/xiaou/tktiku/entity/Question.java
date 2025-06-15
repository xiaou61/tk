package com.xiaou.tktiku.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * 
 * @TableName question
 */
@Data
@TableName("question")
public class Question {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    @NotNull(message = "题库ID不能为空")
    private Long bankId;

    /**
     * 
     */
    @NotBlank(message = "标题不能为空")
    private String title;

    /**
     * 
     */
    @NotBlank(message = "内容不能为空")
    private String contentMd;

    /**
     * 
     */
    @NotNull(message = "难度不能为空")
    private Integer difficulty;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Question other = (Question) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getBankId() == null ? other.getBankId() == null : this.getBankId().equals(other.getBankId()))
                && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
                && (this.getContentMd() == null ? other.getContentMd() == null
                        : this.getContentMd().equals(other.getContentMd()))
                && (this.getDifficulty() == null ? other.getDifficulty() == null
                        : this.getDifficulty().equals(other.getDifficulty()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBankId() == null) ? 0 : getBankId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContentMd() == null) ? 0 : getContentMd().hashCode());
        result = prime * result + ((getDifficulty() == null) ? 0 : getDifficulty().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bankId=").append(bankId);
        sb.append(", title=").append(title);
        sb.append(", contentMd=").append(contentMd);
        sb.append(", difficulty=").append(difficulty);
        sb.append("]");
        return sb.toString();
    }
}