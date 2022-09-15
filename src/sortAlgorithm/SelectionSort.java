package sortAlgorithm;

public class SelectionSort {
    
    private boolean isSelectionSort;
    private int minIndexSelection;
    private int compareIndexSelection;
    private int indexSelection;

    public SelectionSort(){
        this.minIndexSelection = 0;
        this.compareIndexSelection = 1;
        this.indexSelection = 0;
    }

    public void oneComponentSelectioSort(int[] array) {
        // compare_index_sort serve a iterare tutto l'array
        // minIndex serve a salvare l'indice del valore minimo
        if (array[compareIndexSelection] < array[minIndexSelection]) {
            minIndexSelection = compareIndexSelection;
            compareIndexSelection++;
        } else {
            compareIndexSelection++;
        }
        if (compareIndexSelection > array.length - 1) {
            int tmp = array[minIndexSelection];
            array[minIndexSelection] = array[indexSelection];
            array[indexSelection] = tmp;
            minIndexSelection = indexSelection + 1;
            indexSelection = minIndexSelection;
            compareIndexSelection = minIndexSelection + 1;
        }
    }

    public void setUp(){
        this.isSelectionSort = false;
        this.minIndexSelection = 0;
        this.compareIndexSelection = 1;
        this.indexSelection = 0;
    }

    public boolean isSelectionSort() {
        return isSelectionSort;
    }

    public int getMinIndexSelection() {
        return minIndexSelection;
    }

    public int getCompareIndexSelection() {
        return compareIndexSelection;
    }

    public int getIndexSelection() {
        return indexSelection;
    }
}