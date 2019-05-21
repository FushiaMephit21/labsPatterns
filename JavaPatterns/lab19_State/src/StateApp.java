public class StateApp {
    public static void main(String[] args) {
        Station dfm = new RadioDFM();
        Radio radio = new Radio();
        radio.setStation(dfm);
        radio.play();
        radio.nextStation();
        radio.play();
    }

    interface Station {
        void play();
    }

    static class Radio7 implements Station {
        public void play() {
            System.out.println("Радио 7...");
        }
    }

    static class RadioDFM implements Station {
        public void play() {
            System.out.println("Радио DFM...");
        }
    }

    static class VestiFM implements Station {
        public void play() {
            System.out.println("Вести FM...");
        }
    }


    //Context
    static class Radio{
        Station station;
        void setStation(Station st) {station = st;}
        void nextStation(){
            if (station instanceof Radio7) {
                setStation(new RadioDFM());
            }
            else if (station instanceof RadioDFM) {
                setStation(new VestiFM());
            }
            else if (station instanceof VestiFM) {
                setStation(new Radio7());
            }
        }
        void play() {
            station.play();
        }
    }
}
