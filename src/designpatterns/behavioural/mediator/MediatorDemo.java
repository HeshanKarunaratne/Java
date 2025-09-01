package designpatterns.behavioural.mediator;

import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
    void sendMessage(String msg, User user);

    void addUser(User user);
}

class ChatMediatorImpl implements ChatMediator {
    private List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(String msg, User user) {
        for (User u : users) {
            if (u != user) {
                u.receive(msg);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    abstract void send(String msg);

    abstract void receive(String msg);
}

class UserImpl extends User {
    public UserImpl(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    void send(String msg) {
        System.out.println(this.name + " sends: " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    void receive(String msg) {
        System.out.println(this.name + " received: " + msg);
    }
}

public class MediatorDemo {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User u1 = new UserImpl(mediator, "Alice");
        User u2 = new UserImpl(mediator, "Bob");
        User u3 = new UserImpl(mediator, "Charlie");

        mediator.addUser(u1);
        mediator.addUser(u2);
        mediator.addUser(u3);

        u1.send("Hi everyone!");
    }
}