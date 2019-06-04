import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        User admin = new Admin(chat, "Корольов Максим");
        User u1 = new Moderator(chat, "Петренко Іван");
        User u2 = new Moderator(chat, "Кусик Олександр");
        User u3 = new Client(chat, "Теренко Ольга");
        u2.setEnable(false);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);
        chat.addUser(u3);

        admin.sendMessage("Привет");
    }
}

abstract class User {
    Chat chat;
    String name;
    boolean isEnable = true;
    public boolean isEnable() {return isEnable;}
    public void setEnable(boolean isEnable) {this.isEnable = isEnable;}

    public User(Chat chat, String name) {
        this.chat=chat;
        this.name=name;
    }

    public String getName() {return name;}
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }
    abstract void getMessage(String message);

    @Override
    public String toString() {
        return "User [name=" + name +"]";
    }
}

class Admin extends User {
    public Admin(Chat chat, String name) {super(chat,name);};
    public void getMessage(String message) {
        System.out.println("Адміністратор "+getName()+" отримує повідомлення '"+message+"'");
    }
}

class Moderator extends User {
    public Moderator(Chat chat, String name){super(chat, name);}

    public void getMessage(String message) {
        System.out.println("Модератор "+getName()+" отримує повідомлення '"+message+"'");
    }
}

class Client extends User {
    public Client(Chat chat, String name) {super(chat,name);}

    public void getMessage(String message) {
        System.out.println("Клієнт "+getName()+" отримує повідомлення '"+message+"'");
    }
}

interface Chat{
    void sendMessage(String message, User user);
}

class TextChat implements Chat {
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        if(admin!=null && admin instanceof Admin) {
            this.admin = admin;
        } else {
            throw new RuntimeException("Не хватає прав");
        }
    }

    public void addUser(User u) {
        if(admin==null) {
            throw new RuntimeException("В чаті відсутній адмін!");
        }

        if (u instanceof Moderator || u instanceof Client) {
            users.add(u);
        } else {
            throw new RuntimeException("Админ не може вхоходити в інший чат");
        }
    }

    public void sendMessage(String message, User user) {
        if (user instanceof Admin) {
            for(User u:users) {
                u.getMessage(user.getName()+": "+message);
            }
        }
        if (user instanceof Moderator || user instanceof Client) {
            for(User u: users) {
                if(u!=user && u.isEnable())
                    u.getMessage(user.getName()+": "+message);
            }
            if (admin.isEnable())
                admin.getMessage(user.getName()+": "+message);
        }
    }
}