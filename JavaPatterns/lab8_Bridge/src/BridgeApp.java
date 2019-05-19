
public class BridgeApp {
    public static void main(String[] args) {
        Ad c = new ProdPlace(new Twix());
        c.showDetails();
    }
}

abstract class Ad {
    Make make;
    public Ad(Make m){make=m;}
    abstract void showDetails();
}

class Video extends Ad {
    public Video(Make m) {super(m);}
    void showDetails() {
        System.out.println("Video");
        make.setMake();
    }
}

class ProdPlace extends Ad {
    public ProdPlace(Make m) {super(m);}
    void showDetails() {
        System.out.println("Product placement");
        make.setMake();
    }
}

interface Make{
    void setMake();
}

class Jacobs implements Make {
    public void setMake() {
        System.out.println("Jacobs");
    }
}

class Twix implements Make {
    public void setMake() {
        System.out.println("Twix");
    }
}