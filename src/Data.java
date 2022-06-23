import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Data {
    private static final String FILE_NAME = "./10m.txt";
    private List<Integer> fileList;

    public void init() throws FileNotFoundException {
        readInputFile();
        quickSort(0, fileList.size() - 1);
        getMedian();
    }

    public double getArithmeticMean(){
        AtomicReference<Integer> result = new AtomicReference<>(0);
        fileList.forEach(element -> result.updateAndGet(v -> (v + element)));
        return Math.floor(result.get() / (double) fileList.size());
    }

    public double getMedian() {
        int sizeList = fileList.size();
        if (sizeList % 2 == 0){
            return (fileList.get(sizeList / 2) + fileList.get((sizeList / 2) - 1)) / 2.0;
        } else {
            return fileList.get(sizeList / 2);
        }
    }

    private void readInputFile() throws FileNotFoundException {
        fileList = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(FILE_NAME))){
            while (sc.hasNext()){
                String s = sc.nextLine();
                if (s != null){
                    fileList.add(Integer.valueOf(s));
                }
            }
        }
    }

    public void quickSort(int from, int to) {
        if (from < to) {
            int divideIndex = partition(from, to);
            quickSort(from, divideIndex - 1);
            quickSort(divideIndex, to);
        }
    }

    private int partition(int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = fileList.get(from + (to - from) / 2);
        while (leftIndex <= rightIndex) {

            while (fileList.get(leftIndex) < pivot) {
                leftIndex++;
            }

            while (fileList.get(rightIndex) > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }


    private void swap(int index1, int index2) {
        int tmp  = fileList.get(index1);
        fileList.set(index1, fileList.get(index2));
        fileList.set(index2, tmp);
    }

    public List<Integer> getFileList() {
        return fileList;
    }

    public void setFileList(List<Integer> fileList) {
        this.fileList = fileList;
    }
}
