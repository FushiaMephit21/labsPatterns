public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient c = new StrategyClient();
        c.setStrategy(new StrategyA());

        //doSomething...
    }
}

    // Context
    class StrategyClient {
        Sorting strategy;
        public StrategyClient() {}
        public void setStrategy(Sorting strategy) {this.strategy = strategy;}
        public void executeStrategy(int[] arr) {strategy.sort(arr);}
    }

    // Strategy
    interface Sorting {
        void sort(int[] arr);
    }

    //Implement Strategy
    class StrategyA implements Sorting{
        public void sort(int[] arr) {

        }
    }
