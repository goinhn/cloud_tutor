package dao;

import java.io.Serializable;

/**
 * 招聘信息浏览的次数
 */
public class OfferFlow implements Serializable {

    private int offerId;//招聘信息id
    private int click;//点击的次数

    public OfferFlow() {
    }

    public OfferFlow(int offerId, int click) {
        this.offerId = offerId;
        this.click = click;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    @Override
    public String toString() {
        return "OfferFlow{" +
                "offerId=" + offerId +
                ", click=" + click +
                '}';
    }
}
