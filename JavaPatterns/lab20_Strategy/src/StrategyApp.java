import java.lang.reflect.Array;
import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient c = new StrategyClient();

        int[] arr0 = {1,3,2,1};
        c.setStrategy(new SelectionSort());
        c.executeStrategy(arr0);

        int[] arr1 = {11,4,2,7,8,54};
        c.setStrategy(new InsertSort());
        c.executeStrategy(arr1);

        int[] arr2 = {3,-8,2,0,33,1,3,2};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr2);
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
    class BubbleSort implements Sorting{
        public void sort(int[] arr) {
            System.out.println("Сортировка пузирьком");
            System.out.println("до:\t"+ Arrays.toString(arr));
            for (int barier=arr.length-1;barier>=0;barier--) {
                for (int i=0;i<barier;i++) {
                    if(arr[i]>arr[i+1]){
                        int tmp = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = tmp;
                    }
                }
            }
            System.out.println("після:\t"+Arrays.toString(arr));
        }
    }
