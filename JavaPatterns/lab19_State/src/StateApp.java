public class StateApp {
    public static void main(String[] args) {
        Live lv = new NesCoffe();
        TVBroadcast tvb = new TVBroadcast();
        tvb.setLive(lv);
        tvb.play();
        tvb.nextLive();
        tvb.play();
    }
}

    interface Live {
        void play();
    }

    class Jaccobs implements Live {
        public void play() {
            System.out.println("Реклама Jaccobs");
        }
    }

    class NesCoffe implements Live {
        public void play() {
            System.out.println("Реклама NesCoffe");
        }
    }

    class MacCoffe implements Live {
        public void play() {
            System.out.println("Реклама MacCoffe");
        }
    }


    //Context
    class TVBroadcast{
        Live live;
        void setLive(Live st) {live = st;}
        void nextLive(){
            if (live instanceof Jaccobs) {
                setLive(new NesCoffe());
            }
            else if (live instanceof NesCoffe) {
                setLive(new MacCoffe());
            }
            else if (live instanceof MacCoffe) {
                setLive(new Jaccobs());
            }
        }
        void play() {
            live.play();
        }
    }
