
public class abstractFabric {
    public static void main(String[] args) {

        TVstudio factory = getTypeAddvertisment("Video");
        Time30s s30 = factory.getShow30s();
        Time5min m5 = factory.getShow5min();
        Time30min m30 = factory.getShow30min();

        s30.type();
        m5.place();
        m30.description();
    }

    private static TVstudio getTypeAddvertisment(String name) {
        switch (name) {
            case "Video":
                return new VideoFactory();
            case "Product Placement":
                return new PPlacementFactory();
            default:
                throw new RuntimeException("Undefined " + name);
        }
    }
}

interface Time30s {
    void type();
}

interface Time5min {
    void place();
}

interface Time30min {
    void description();
}

interface TVstudio {
    Time30s getShow30s();
    Time5min getShow5min();
    Time30min getShow30min();
}

class Video30s implements Time30s {
        public void type() {
            System.out.println("Звичайний рекламний ролик (Відео-1)");
        }
}

class Video5min implements Time5min {
    public void place() {
        System.out.println("Невеликий сюжет у телепрограмі про продукт (Відео-2)");
    }
}

class Video30min implements Time30min {
    public void description() {
        System.out.println("Окреме рекламне шоу (Відео-3)");
    }
}

class PPlacement30s implements Time30s {
    public void type() {
        System.out.println("Фокус камери у телепрограмі (Плейсмент-1)");
    }
}

class PPlacement5min implements Time5min {
    public void place() {
        System.out.println("Під час сюжету у телепрограмі (Плейсмент-2)");
    }
}

class PPlacement30min implements Time30min {
    public void description() {
        System.out.println("На протязі всієї телепрограми (Плейсмент-3)");
    }
}

class VideoFactory implements TVstudio {
    public Time30s getShow30s() {
        return new Video30s();
    }

    public Time5min getShow5min() {
        return new Video5min();
    }

    public Time30min getShow30min() {
        return new Video30min();
    }
}

class PPlacementFactory implements TVstudio {
    public Time30s getShow30s() {
        return new PPlacement30s();
    }

    public Time5min getShow5min() {
        return new PPlacement5min();
    }

    public Time30min getShow30min() {
        return new PPlacement30min();
    }
}