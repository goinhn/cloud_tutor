package dao;

import java.io.Serializable;

/**
 * 招聘的信息
 */
public class Offer implements Serializable {

    private int userId;//用户id
    private int offerId;//招聘信息id
    private String certification;//需要认证的信息
    private String sex;//性别
    private String claim;//具体要求
    private String fee;//费用
    private String address;//地址
    private String time;//发布时间

    public Offer() {
    }

    public Offer(int userId, int offerId, String certification, String sex, String claim, String fee, String address, String time) {
        this.userId = userId;
        this.offerId = offerId;
        this.certification = certification;
        this.sex = sex;
        this.claim = claim;
        this.fee = fee;
        this.address = address;
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "userId=" + userId +
                ", offerId=" + offerId +
                ", certification='" + certification + '\'' +
                ", sex='" + sex + '\'' +
                ", claim='" + claim + '\'' +
                ", fee='" + fee + '\'' +
                ", address='" + address + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

}
