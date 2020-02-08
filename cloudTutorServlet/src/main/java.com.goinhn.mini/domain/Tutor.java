package domain;

import java.io.Serializable;

/**
 * 家教的信息
 */
public class Tutor implements Serializable {
    
    private int userId;//用户id
    private int tutorId;//家教信息的id
    private String name;//真实姓名
    private String sex;//性别
    private String certification;//认证信息
    private String experience;//家教经历
    private String subject;//教授科目
    private String frequency;//教授频率
    private String wage;//期望工资
    private String address;//地址
    private String contact;//联系方式
    private String introduction;//个人介绍
    private String picture;//图片路径
    private String time;//发布时间
    private String click;//点击次数

    public Tutor() {
    }

    public Tutor(int userId, int tutorId, String name, String sex, String certification, String experience, String subject, String frequency, String wage, String address, String contact, String introduction, String time) {
        this.userId = userId;
        this.tutorId = tutorId;
        this.name = name;
        this.sex = sex;
        this.certification = certification;
        this.experience = experience;
        this.subject = subject;
        this.frequency = frequency;
        this.wage = wage;
        this.address = address;
        this.contact = contact;
        this.introduction = introduction;
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "userId=" + userId +
                ", tutorId=" + tutorId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", certification='" + certification + '\'' +
                ", experience='" + experience + '\'' +
                ", subject='" + subject + '\'' +
                ", frequency='" + frequency + '\'' +
                ", wage='" + wage + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", introduction='" + introduction + '\'' +
                ", picture='" + picture + '\'' +
                ", time='" + time + '\'' +
                ", click='" + click + '\'' +
                '}';
    }
}
