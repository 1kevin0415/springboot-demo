package com.neusoft.neu23.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
// 实现表名和类名的映射
@TableName("guest")
/**
 * 客户实体类
 */
public class Guest {
    /** 主键 ，客户编号
     *
     */
    @TableId(type = IdType.AUTO ,value = "gid")
    private Integer gid;
    /**
     * 客户姓名
     */
    @TableField("name")
    private String name;

    /**
     * 客户的手机号码
     */
    private String phone;

    public Guest( ) {    }

    public Guest(Integer gid, String name, String phone) {
        this.gid = gid;
        this.name = name;
        this.phone = phone;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
