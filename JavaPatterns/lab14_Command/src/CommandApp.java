public class CommandApp {
    public static void main(String[] args) {
        Ad c = new Ad();
        User u = new User(new StartCommand(c), new StopCommand(c), new ResetCommand(c));

        u.startShowAd();
        u.stopShowAd();
        u.resetShowAd();
    }
}

interface Command {
    void execute();
}

class Ad {
    void start() {
        System.out.println("Start");
    }
    void stop() {
        System.out.println("Stop");
    }
    void reset() {
        System.out.println("Reset");
    }
}

class StartCommand implements Command {
    Ad ad;
    public StartCommand(Ad ad) {this.ad = ad;}
    @Override
    public void execute() {
        ad.start();
    }
}

class User {
    Command start;
    Command stop;
    Command reset;
    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }
    void startShowAd() {
        start.execute();
    }
    void stopShowAd() {
        stop.execute();
    }
    void resetShowAd() {
        reset.execute();
    }

}

class ResetCommand implements Command {
    Ad ad;
    public ResetCommand(Ad ad) {this.ad = ad;}
    @Override
    public void execute() {
        ad.reset();
    }
}

class StopCommand implements Command {
    Ad ad;
    public StopCommand(Ad ad) {this.ad = ad;}
    @Override
    public void execute() {
        ad.stop();
    }
}