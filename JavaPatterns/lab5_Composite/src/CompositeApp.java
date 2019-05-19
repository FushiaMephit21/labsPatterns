import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Shape jacobs1 = new Jacobs();
        Shape jacobs2 = new Jacobs();
        Shape nescoffe1 = new Nescoffe();
        Shape jacobs3 = new Jacobs();

        Shape maccoffe1 = new Maccoffe();
        Shape maccoffe2 = new Maccoffe();
        Shape maccoffe3 = new Maccoffe();

        Composite composit = new Composite();
        Composite compositeJacobs = new Composite();
        Composite compositeNescoffe = new Composite();
        Composite compositeMaccoffe = new Composite();

        compositeJacobs.addComponents(jacobs1);
        compositeJacobs.addComponents(jacobs2);
        compositeNescoffe.addComponents(nescoffe1);

        compositeJacobs.addComponents(jacobs3);
        compositeMaccoffe.addComponents(maccoffe1);
        compositeMaccoffe.addComponents(maccoffe2);
        compositeMaccoffe.addComponents(maccoffe3);

        composit.addComponents(compositeJacobs);
        composit.addComponents(compositeNescoffe);
        composit.addComponents(compositeMaccoffe);

        composit.draw();
    }
}

interface Shape {
    void draw();
}

class Jacobs implements Shape {
    public void draw() {
        System.out.println("Jacobs");
    }
}

class Nescoffe implements Shape {
    public void draw() {
        System.out.println("Nescoffe");
    }
}

class Maccoffe implements Shape {
    public void draw() {
        System.out.println("Maccoffe");
    }
}

class Composite implements Shape {
    private List<Shape> components = new ArrayList<>();

    public void addComponents(Shape component) {
        components.add(component);
    }
    public void removeComponents(Shape component) {
        components.remove(component);
    }
    public void draw() {
        for (Shape component : components) {
            component.draw();
        }
    }
}