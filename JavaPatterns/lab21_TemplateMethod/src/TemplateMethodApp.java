public class TemplateMethodApp {
    public static void main(String[] args) {
        Translation a = new Variant1();
        a.startTwoAd();

        System.out.println("////////////");

        Translation b = new Variant2();
        b.startTwoAd();
    }
}
    abstract class Translation {
        void startTwoAd() {
            System.out.println("Включити заставку");
            templateMethod();
            System.out.println("Включити заставку");
        }
        abstract void templateMethod();
    }

    class Variant1 extends Translation {
        void templateMethod() {
            System.out.println("Реклама товару");
            System.out.println("Реклама телепрограми");
        }
    }

    class Variant2 extends Translation {
        void templateMethod() {
            System.out.println("Реклама телепрограми");
            System.out.println("Реклама товару");
        }
    }
