
public class builder {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new JacobsMonarchBuilder());
        Ad ad = director.BuildAd();
        System.out.println(ad);
    }
}

enum TypeAd {
    Video, PPlacement
}

class Ad {
    String name;
    TypeAd typeAd;
    int longTime;

    public void setName(String name) {this.name = name;}
    public void setTypeAd(TypeAd typeAd) {this.typeAd = typeAd;}
    public void setLongTime(int longTime) {this.longTime = longTime;}
    @Override
    public String toString() {
        return "Ad [name=" + name + ", typeAd=" + typeAd + ", longTime=" + longTime + "s]";
    }
}

abstract class AdBuilder {
    Ad ad;
    void createAd() {ad = new Ad();}

    abstract void buildName();
    abstract void buildTypeAd();
    abstract void buildLongTime();

    Ad getAd() {return ad;}
}

class JacobsMonarchBuilder extends AdBuilder{
    void buildName() {ad.setName("Jacobs Monarch Coffe");}
    void buildTypeAd() {ad.setTypeAd(TypeAd.Video);}
    void buildLongTime() {ad.setLongTime(15);}
}

class LacalutWhiteBuilder extends AdBuilder {
    void buildName() {ad.setName("Lacalut White Toothpaste");}
    void buildTypeAd() {ad.setTypeAd(TypeAd.PPlacement);}
    void buildLongTime() {ad.setLongTime(1800);}
}

class Director {
    AdBuilder builder;
    void setBuilder(AdBuilder b){builder = b;}

    Ad BuildAd(){
        builder.createAd();
        builder.buildName();
        builder.buildTypeAd();
        builder.buildLongTime();
        Ad ad = builder.getAd();
        return ad;
    }
}