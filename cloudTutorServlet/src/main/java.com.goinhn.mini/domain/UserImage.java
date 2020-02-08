package domain;

/**
 * 家教用户图片
 */
public class UserImage {
    private int userId;
    private int imageId;
    private String picture;

    public UserImage() {
    }

    public UserImage(int userId, int imageId, String picture) {
        this.userId = userId;
        this.imageId = imageId;
        this.picture = picture;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "UserImage{" +
                "userId=" + userId +
                ", imageId=" + imageId +
                ", picture='" + picture + '\'' +
                '}';
    }
}
