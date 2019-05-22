public class FacadeApp {
    public static void main(String[] args) {
        Station station = new Station();
        station.copy();
    }
}

class Station {
    Power power = new Power();
    Video v = new Video();
    PlayVideo pv = new PlayVideo();

    void copy() {
        power.on();
        v.load();
        pv.copyFromVideo(v);
    }
}

class Power {
    void on() {
        System.out.println("Включення живлення");
    }
    void off() {
        System.out.println("Виключення живлення");
    }
}

class Video {
    private boolean data = false;
    public boolean hasData() {
        return data;
    }
    void load() {
        data = true;
    }
    void unload() {
        data = false;
    }
}

class PlayVideo {
    void copyFromVideo(Video v) {
        if (v.hasData()) {
            System.out.println("Відбувається відтворення реклами");
        }
        else {
            System.out.println("Потрібно завантажити рекламу");
        }
    }
}