package sortAlgorithm;
public class BubbleSort {

    private int compareIndexBubble;
    private int indexBubble;

    private boolean isBubbleSort;

    public BubbleSort() {
        this.compareIndexBubble = 0;
        this.indexBubble = 0;
        this.isBubbleSort = false;
    }

    public void oneComponenetBubbleSort(int[]array) {
        if (array[compareIndexBubble] > array[compareIndexBubble + 1]) {
            // swap
            int tmp = array[compareIndexBubble];
            array[compareIndexBubble] = array[compareIndexBubble + 1];
            array[compareIndexBubble + 1] = tmp;
        }
        if ((compareIndexBubble + 1) >= (array.length - indexBubble - 1)) {
            indexBubble++;
            compareIndexBubble = 0;
        } else {
            compareIndexBubble++;
        }
    }

    public void setUp(int[] array){
        isBubbleSort = false;
        compareIndexBubble = 0;
        indexBubble = 0;
    }

    public int getCompareIndexBubble() {
        return compareIndexBubble;
    }

    public int getIndexBubble() {
        return indexBubble;
    }

    public boolean isBubbleSort() {
        return isBubbleSort;
    }
}