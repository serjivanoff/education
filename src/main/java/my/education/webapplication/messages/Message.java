package my.education.webapplication.messages;

/**
 * Created by bender on 26.08.2018.
 */
public abstract class Message {
    private  String from;
    private  String to;
    private  String payload;

    public Message() {
    }

    public Message(String from, String to, String payload) {
        this.from = from;
        this.to = to;
        this.payload = payload;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getPayload() {
        return payload;
    }

    public abstract void exec(String to);
}
