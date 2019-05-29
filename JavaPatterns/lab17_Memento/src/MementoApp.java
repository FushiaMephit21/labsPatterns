public class MementoApp {
    public static void main(String[] args) {
        TimeTableAd tta = new TimeTableAd();
        tta.set("Lorem100", 150, 20);
        System.out.println(tta);

        File file = new File();
        file.setBackUp(tta.backup());

        tta.set("Lorem200", 300,20);
        System.out.println(tta);

        System.out.println("Завантаження");
        tta.load(file.getBackUp());
        System.out.println(tta);
    }
}

class TimeTableAd {
    private String TableData;
    private int CountRows;
    private int CountColums;
    public void set(String TableData, int CountRows, int CountColums) {
        this.TableData = TableData;
        this.CountColums = CountColums;
        this.CountRows = CountRows;
    }
    public void load(BackUp backup) {
        TableData = backup.getTableData();
        CountRows = backup.getCountRows();
        CountColums = backup.getCountColums();
    }
    public BackUp backup() {
        return new BackUp(TableData, CountRows, CountColums);
    }
    @Override
    public String toString() {
        return "TimeTableAd [TableData="+TableData+", CountRows="+CountRows+", CountColums="+CountColums+"]";
    }
}

class BackUp {
    private final String TableData;
    private final int CountRows;
    private final int CountColums;
    public BackUp(String TableData, int CountRows, int CountColums) {
        this.TableData = TableData;
        this.CountRows = CountRows;
        this.CountColums = CountColums;
    }
    public String getTableData() {return TableData;}
    public int getCountRows() {return CountRows;}
    public int getCountColums() {return CountColums;}
}

class File {
    BackUp backup;
    public BackUp getBackUp() {return backup;}
    public void setBackUp(BackUp backup) {this.backup = backup;}
}