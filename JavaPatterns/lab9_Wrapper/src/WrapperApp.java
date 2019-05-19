public class WrapperApp {
    public static void main(String[] args) {
    ChangeVideo printer = new ChangeSpeedDecorator(new RemoveFrameDecorator(new AddAdDecorator(new Change("==Відтворення реклами Jacobs=="))));
    printer.play();
    }
}

interface ChangeVideo {
    void play();
}

class Change implements ChangeVideo {
    String value;
    public Change(String value) {this.value = value;}
    public void play() {
        System.out.println(value);
    }
}

abstract class Decorator implements ChangeVideo {
    ChangeVideo component;
    public Decorator(ChangeVideo component) {this.component = component;}
}

class ChangeSpeedDecorator extends Decorator {
    public ChangeSpeedDecorator(ChangeVideo component) {super(component);}
    public void play() {
        System.out.println("Відтворити прискорено");
        component.play();
        System.out.println("Відтворити скорочено");
    }
}

class RemoveFrameDecorator extends Decorator {
    public RemoveFrameDecorator(ChangeVideo component) {super(component);}
    public void play() {
        component.play();
        System.out.println("Вирізати кадри");
    }
}

class AddAdDecorator extends Decorator {
    public AddAdDecorator(ChangeVideo component) {super(component);}
    public void play() {
        System.out.println("Накласти поверх відео додаткову рекламу");
        component.play();
    }
}