package com.czxy.ssm.vo;

public class studentVo {
    private String cid;
    private String studentName;
    private String startAge;
    private String endAge;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStartAge() {
        return startAge;
    }

    public void setStartAge(String startAge) {
        this.startAge = startAge;
    }

    public String getEndAge() {
        return endAge;
    }

    public void setEndAge(String endAge) {
        this.endAge = endAge;
    }

    @Override
    public String toString() {
        return "studentVo{" +
                "cid='" + cid + '\'' +
                ", studentName='" + studentName + '\'' +
                ", startAge='" + startAge + '\'' +
                ", endAge='" + endAge + '\'' +
                '}';
    }
}
