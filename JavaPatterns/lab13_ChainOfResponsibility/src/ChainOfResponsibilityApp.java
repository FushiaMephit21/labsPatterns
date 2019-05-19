public class ChainOfResponsibilityApp {
    public static void main(String[] args) {
        SMSLogger logger0 = new SMSLogger(Level.ERROR);
    }
}

class Level {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

interface Logger {
    void writeMessage(String message, int level);
}

class SMSLogger implements Logger {
    int priority;
    public SMSLogger(int priority) {this.priority = priority;}

    Logger next;
    public void setNext(Logger next) {this.next = next;}

    public void writeMessage(String message, int level) {
        if (level<=priority) {
            System.out.println("СМС: " + message);
        }
        if (next==null) {
            next.writeMessage(message, level);
        }
    }
}