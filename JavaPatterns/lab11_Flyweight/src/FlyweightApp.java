import java.text.MessageFormat;
import java.util.*;

public class FlyweightApp {
    public static void main(String[] args) {

        BroadcastingFactory broadcastingFactory = new BroadcastingFactory();

        List<Broadcasting> broadcastings = new ArrayList<>();

        broadcastings.add(broadcastingFactory.getBroadcasting("video"));
        broadcastings.add(broadcastingFactory.getBroadcasting("advrtismnt"));
        broadcastings.add(broadcastingFactory.getBroadcasting("advrtismnt"));
        broadcastings.add(broadcastingFactory.getBroadcasting("pp"));
        broadcastings.add(broadcastingFactory.getBroadcasting("video"));
        broadcastings.add(broadcastingFactory.getBroadcasting("pp"));

        Random rand = new Random();
        for (Broadcasting broadcasting : broadcastings) {
            int y = (rand.nextInt(3));
            switch (y) {
                case 1:
                    broadcasting.play("Jacobs Coffe");
                    break;
                case 2:
                    broadcasting.play("Nescafe Coffe");
                    break;
                default:
                    broadcasting.play("MacCoffe");
                    break;
            }
        }
    }
}

interface Broadcasting {
    void play(String x);
}

class AdVideo implements Broadcasting {
    int t = 30;
    public void play(String x) {
        template.templ("рекламний відео-ролик", x, t);
    }
}

class TVShowWthAdTM implements Broadcasting {
    int t = 1200;
    public void play(String x) {
        template.templ("телешоу з рекламними вставками", x, t);
    }
}

class TVShowWthPP implements Broadcasting {
    int t=1800;
    public void play(String x) {
        template.templ("телешоу з продукт-плейсментом", x, t);
    }
}

class BroadcastingFactory {
    private static final Map<String, Broadcasting> broadcastings = new HashMap<>();
    public Broadcasting getBroadcasting(String broadcastingName) {
        Broadcasting broadcasting = broadcastings.get(broadcastingName);
        if (broadcasting==null) {
            switch(broadcastingName) {
                case "video":
                    broadcasting = new AdVideo();
                    break;
                case "advrtismnt":
                    broadcasting = new TVShowWthAdTM();
                    break;
                case "pp":
                    broadcasting = new TVShowWthPP();
                    break;
            }
            broadcastings.put(broadcastingName, broadcasting);
        }
        return broadcasting;
    }
}


//========================================================
class template {
    public static void templ(String a, String b, int c) {
        System.out.println("Відтворюється: "+a);
        System.out.println("Спонсор: "+b);
        System.out.println("Тривалість: "+c+" секунд");
        System.out.println("------------------------------");
    }
}