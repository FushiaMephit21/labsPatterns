// Цепочка обов'язків. Рівень доступу.

public class ChainOfResponsibilityApp {
    public static void main(String[] args) {
        ClientUser user0 = new ClientUser(Level.ONLY_READ);
        ModeratorUser user1 = new ModeratorUser(Level.EDITING);
        AdminUser user2 = new AdminUser(Level.ALL);
        user0.setNext(user1);
        user1.setNext(user2);

        user0.did("Отримати розклад реклами", Level.ONLY_READ);
        user0.did("Редагувати розклад реклами", Level.EDITING);
        user0.did("Видалення розкладу реклами", Level.ALL);
    }
}

class Level {
    public static final int ONLY_READ= 1;
    public static final int EDITING = 2;
    public static final int ALL = 3;
}

interface User {
    void did(String history, int level);
}

class ClientUser implements User {
    int accessLevel;
    public ClientUser(int accessLevel) {this.accessLevel = accessLevel;}

    User next;
    public void setNext(User next) {this.next = next;}

    public void did(String history, int level) {
        if (level<=accessLevel) {
            System.out.println("Log Клієнта: " + history);
        }
        if (next!=null) {
            next.did(history, level);
        }
    }
}

class ModeratorUser implements User {
    int accessLevel;
    public ModeratorUser(int accessLevel) {this.accessLevel = accessLevel;}

    User next;
    public void setNext(User next) {this.next = next;}

    public void did(String history, int level) {
        if (level<=accessLevel) {
            System.out.println("Log Модератора: " + history);
        }
        if (next!=null) {
            next.did(history, level);
        }
    }
}

class AdminUser implements User {
    int accessLevel;
    public AdminUser(int accessLevel) {this.accessLevel = accessLevel;}

    public void did(String history, int level) {
        if (level<=accessLevel) {
            System.out.println("Log Адміністратора: " + history);
        }
    }
}