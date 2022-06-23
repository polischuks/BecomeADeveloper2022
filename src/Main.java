import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        Data fileData = new Data();
        fileData.init();
        System.out.println("Running time: " + (System.currentTimeMillis() - startTime) / 1000 + " sec\n" +
                "Min: " + fileData.getFileList().get(0) + "\n" +
                "Max: " + fileData.getFileList().get(fileData.getFileList().size() - 1) + "\n" +
                "Median: " + fileData.getMedian() + "\n" +
                "Arithmetic Mean: " + fileData.getArithmeticMean());
    }
}