package dao;

/**
 * 学生家教信息点击次数
 */
public class TutorFlow {

    private int tutorId;//用户id
    private int click;//点击次数

    public TutorFlow() {
    }

    public TutorFlow(int tutorId, int click) {
        this.tutorId = tutorId;
        this.click = click;
    }

    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    @Override
    public String toString() {
        return "TutorFlow{" +
                "tutorId=" + tutorId +
                ", click=" + click +
                '}';
    }
}
