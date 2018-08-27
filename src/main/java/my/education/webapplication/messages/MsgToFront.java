package my.education.webapplication.messages;

import my.education.webapplication.jdbc.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by bender on 26.08.2018.
 */
@Component
public class MsgToFront extends Message {
    @Autowired
    private FrontService frontService;

    public MsgToFront() {
    }

    public MsgToFront(String from, String to, String payload) {
        super(from, to, payload);
    }

    @Override
    public void exec(String to) {
        frontService.addUser(this.getPayload());
    }
}
