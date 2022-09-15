package sortAlgorithm;

public class InsertionSort {
    
    private int elementToMove;
    private boolean isShift;
    private boolean isInsertionSort;
    private int indexElementToMove;
    private int indexInsertion;


    public InsertionSort(){
        this.isShift = false;
        isInsertionSort = false;
        indexElementToMove = 1;
        indexInsertion = indexElementToMove - 1;
    }

    public void oneComponentInsertionSort(int[] array) {

        if (!isShift && indexElementToMove < 80) {
            elementToMove = array[indexElementToMove];
        }
        if (elementToMove <= array[indexInsertion]) {
            if (indexInsertion < 80) {
                array[indexInsertion + 1] = array[indexInsertion];
                isShift = true;
                array[indexInsertion] = elementToMove;
                indexInsertion--;
            }
        } else {
            indexInsertion--;
        }
        if (indexInsertion == -1) {
            indexInsertion = indexElementToMove;
            indexElementToMove++;
            isShift = false;
        }
        if (elementToMove > array[indexInsertion]) {
            indexInsertion = indexElementToMove;
            indexElementToMove++;
            isShift = false;
        }
    }

    public void setUp(){
        this.isShift = false;
        isInsertionSort = false;
        indexElementToMove = 1;
        indexInsertion = indexElementToMove - 1;
    }

    public int getElementToMove() {
        return elementToMove;
    }

    public boolean isShift() {
        return isShift;
    }

    public boolean isInsertionSort() {
        return isInsertionSort;
    }

    public int getIndexElementToMove() {
        return indexElementToMove;
    }

    public int getIndexInsertion() {
        return indexInsertion;
    }

    
}
