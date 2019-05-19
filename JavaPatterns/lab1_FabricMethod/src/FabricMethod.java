

public class FabricMethod {
    public static void main(String[] args) {
        AddAddvertisment item = new addVideo();
        Addvertisment addver = item.add();
        addver.type();
    }
}

interface Addvertisment {
    void type();
}

class Video implements Addvertisment {
    public void type() {
        System.out.println("Video");
    }
}

class ProductPlacement implements Addvertisment {
    public void type() {
        System.out.println("Product placement");
    }
}

interface AddAddvertisment {
    Addvertisment add();
}

class addVideo implements AddAddvertisment {
    public Addvertisment add() {
        return new Video();
    }
}

class addProduct implements AddAddvertisment {
    public Addvertisment add() {
        return new ProductPlacement();
    }
}