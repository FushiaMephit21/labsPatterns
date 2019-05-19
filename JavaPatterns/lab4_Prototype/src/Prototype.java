
public class Prototype {
    public static void main(String[] args) {
        Ad original = new Ad("Jacobs", 30);
        System.out.println(original);

        Ad copy = (Ad)original.copy();
        System.out.println(copy);

        AdFactory factory = new AdFactory(copy);
        Ad a1 = factory.makeCopy();
        System.out.println(a1);

        factory.setPrototype(new Ad("Nescafe", 180));
        Ad a2 = factory.makeCopy();
        System.out.println(a2);
    }
}

interface Copyable {
    Object copy();
}



class Ad implements Copyable {
    String name;
    int timeLong;

    public Ad(String name, int timeLong) {
        this.name = name;
        this.timeLong = timeLong;
    }
    @Override
    public String toString() {
        return "Ad [name=" + name + ", timeLong=" + timeLong + "]";
    }

    public Object copy() {
        Ad copy = new Ad(name, timeLong);
        return copy;
    }

}

class AdFactory {
    Ad ad;
    public AdFactory(Ad ad) {
        setPrototype(ad);
    }

    public void setPrototype(Ad ad) {
        this.ad = ad;
    }
    Ad makeCopy() {
        return (Ad)ad.copy();
    }
}