import sun.java2d.pipe.SpanShapeRenderer;

import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        User admin = new Admin(chat, "Иван Иваныч");
        User u1 = new SimpleUser(chat, "Ваня");
        User u2 = new SimpleUser(chat, "Вова");
        User u3 = new SimpleUser(chat, "Саша");
        u2.setEnable(false);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);
        chat.addUser(u3);

        admin.sendMessage("Привет");
    }
}

class Ad {
    String name;
    int time;

    public Ad(String name, int time) {
        this.name=name;
        this.time=time;
    }


    @Override
    public String toString() {
        return "Ad [name=" + name + ", time="+time+ "]";
    }
}

abstract class Button {
    Mediator mediator;
    String name;

    public Button(Button button,String name) {};

    String getVerb() {};

}

class AddAd extends Button {
    Mediator mediator;
    public AddAd(Button button, String name) {super(button,name);}

    public String getVerb() {
        return "Рекламу додану";
    }

    @Override
    public void notify() {
        mediator.notify(this.getVerb(), this);
    }
}

class DelAd extends Button {
    public DelAd(Button button, String name){super(button, name);}

    public String getVerb() {
        return "Рекламу видалено";
    }
}

class EditAd extends Button {
    public EditAd(Button button, String name) {super(button,name);}

    public String getVerb() {
        return "Рекламу відредаговано";
    }
}

interface Mediator {
    void notify(String verb, Button button);
}

class ConcreteMediator implements Mediator {
    List<Ad> ads = new ArrayList<>();

    public void reactOnAddAd() {

    }

    public void addUser(User u) {
        if(admin==null) {
            throw new RuntimeException("В чате нет админа!");
        }

        if (u instanceof SimpleUser) {
            users.add(u);
        }
        else {
            throw new RuntimeException("Админ не может вхожить в другой чат");
        }
    }

    public void sendMessage(String message, User user) {
        if (user instanceof Admin) {
            for(User u:users) {
                u.getMessage(user.getName()+": "+message);
            }
        }
        if (user instanceof SimpleUser) {
            for(User u: users) {
                if(u!=user && u.isEnable())
                    u.getMessage(user.getName()+": "+message);
            }
            if (admin.isEnable())
                admin.getMessage(user.getName()+": "+message);
        }
    }
}