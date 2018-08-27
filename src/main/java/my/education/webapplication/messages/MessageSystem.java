package my.education.webapplication.messages;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by bender on 26.08.2018.
 */
@Component
public class MessageSystem {
    private ConcurrentLinkedQueue<Message> messages;
    private final List<Thread> workers;

    public MessageSystem() {
        this.workers = new ArrayList<>();
        messages = new ConcurrentLinkedQueue<>();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void start() {
        while (!messages.isEmpty()) {
            Thread thread = new Thread(() -> {
                    Message msg = messages.poll();
                    msg.exec(msg.getTo());
            });
            thread.start();
            workers.add(thread);
        }
    }

    public Queue<Message> getMessages() {
        return messages;
    }

    public void dispose() {
        workers.forEach(Thread::interrupt);
    }
}
