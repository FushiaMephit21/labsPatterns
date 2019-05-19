public class ProxyApp {
    public static void main(String[] args) {
        Ad ad = new ProxyAd("D:/adVideo/jacobs.mp4");
        ad.display();
    }
}

interface Ad {
    void display();
}

class RealAd implements Ad {
    String file;
    public RealAd(String file) {
        this.file = file;
        load();
    }

    void load() {
        System.out.println("Загрузка " + file);
    }

    @Override
    public void display() {
        System.out.println("Показ " + file);
    }
}

class ProxyAd implements Ad {
    String file;
    RealAd add;
    public ProxyAd(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if(add == null) {
            add = new RealAd(file);
        }
        add.display();
    }
}