package com.eddy.health.aide.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表指标记录表
 * </p>
 *
 * @author Eddy Chen
 * @since 2019-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class HUserIndex implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * id
     */
         @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        /**
     * 用户编号
     */
         private Integer userId;

        /**
     * 体温
     */
         private Double animalHeat;

        /**
     * 血氧
     */
         private Double blood;

        /**
     * 胆固醇
     */
         private Double cholesterol;

        /**
     * 血压
     */
         private Double pressure;

        /**
     * 血尿酸
     */
         private Double uric;

        /**
     * 甘油三酯
     */
         private Double triglyceride;

        /**
     * 尿液酸碱度
     */
         private Double urinePh;

        /**
     * 疾病类型编号
     */
         private Integer illnessId;

        /**
     * 结果值
     */
         private Double val;

        /**
     * 创建时间
     */
         private LocalDateTime createTime;

        /**
     * 创建端
     */
         private String createForm;

        /**
     * 创建人
     */
         private String createUser;

        /**
     * 创建Function名
     */
         private String createMethod;

        /**
     * 更新时间
     */
         private LocalDateTime updateTime;

        /**
     * 更新端
     */
         private String updateForm;

        /**
     * 更新人
     */
         private String updateUser;

        /**
     * 更新Function名
     */
         private String updateMethod;

        /**
     * 是否弃用：1.正常，0.失效
     */
         private Integer loseFlag;


}
