package com.eddy.health.aide.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Eddy Chen
 * @since 2019-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class HUser implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * id
     */
         @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        /**
     * 用户手机号
     */
         private String phone;

        /**
     * 用户名
     */
         private String userName;

        /**
     * 用户密码
     */
         private String password;

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
