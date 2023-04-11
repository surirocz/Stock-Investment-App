import java.util.Date;

public class Notification {
    private String message;
    private Date date;

    private User user;

    public Notification(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public Notification(User user, String message, Date date) {
        this.message = message;
        this.date = date;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void send() {
        //send notification to the mobile notification
    }
}
