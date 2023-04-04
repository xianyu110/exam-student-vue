package com.czxy.ssm.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * -- 班级表
 * CREATE TABLE tb_class(
 * `c_id` VARCHAR(32) PRIMARY KEY COMMENT '班级ID',
 * `c_name` VARCHAR(50) COMMENT '班级名称',
 * `desc` VARCHAR(200) COMMENT '班级描述'
 * );
 */
@Table(name = "tb_class")
public class Classes {
    @Id
    @Column(name = "c_id")
    private String cid;
    @Column(name = "c_name")
    private String cname;
    @Column(name = "`desc`")
    private String desc;

    @Override
    public String toString() {
        return "Classes{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Classes(String cid, String cname, String desc) {
        this.cid = cid;
        this.cname = cname;
        this.desc = desc;
    }

    public Classes() {
    }
}
