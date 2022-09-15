import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import sortAlgorithm.BubbleSort;
import sortAlgorithm.InsertionSort;
import sortAlgorithm.MergeSort;
import sortAlgorithm.QuickSort;
import sortAlgorithm.SelectionSort;

public class SortingPanel extends JPanel {

    Random random = new Random();
    private int[] array = new int[80];

    private BubbleSort bubbleSort = new BubbleSort();
    private InsertionSort insertionSort = new InsertionSort();
    private SelectionSort selectionSort = new SelectionSort();
    private QuickSort quickSort = new QuickSort(array);
    private MergeSort mergeSort = new MergeSort();

    private boolean isSelectionSort;
    private boolean isInsertionSort;
    private boolean isQuickSort;
    private boolean isBubbleSort;
    private boolean isMergeSort;

    public SortingPanel() {

        this.setBackground(Color.BLACK);
        JButton bubbleSort = new JButton("Bubble sort");
        JButton reset = new JButton("Reset");
        JButton selectionSort = new JButton("Selection sort");
        JButton insertionSort = new JButton("Insertion sort");
        JButton quickSort = new JButton("Quick sort");
        JButton mergeSort = new JButton("Merge sort");

        bubbleSort.setBackground(Color.WHITE);
        reset.setBackground(Color.WHITE);
        selectionSort.setBackground(Color.WHITE);
        insertionSort.setBackground(Color.WHITE);
        quickSort.setBackground(Color.WHITE);
        mergeSort.setBackground(Color.WHITE);

        setArray();

        bubbleSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bubbleSort.setBackground(Color.lightGray);
                    if (isBubbleSort == false) {
                        isBubbleSort = true;
                        bubbleSortAnimate(); // Chiama metodo per fare il bubble sort animato
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        selectionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    selectionSort.setBackground(Color.lightGray);
                    if (isSelectionSort == false) {
                        isSelectionSort = true;
                        selectionSortAnimate();
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        insertionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    insertionSort.setBackground(Color.lightGray);
                    if (isInsertionSort == false) {
                        isInsertionSort = true;
                        insertionSortAnimate();
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        quickSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    quickSort.setBackground(Color.lightGray);
                    if (isQuickSort == false) {
                        isQuickSort = true;
                        quickSortAnimate();
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        mergeSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mergeSort.setBackground(Color.lightGray);
                    if (isMergeSort == false) {
                        isMergeSort = true;
                        mergeSortAnimate();
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setArray();
                if (isBubbleSort) {
                    bubbleSort.setBackground(Color.WHITE);
                    isBubbleSort = false;
                    SortingPanel.this.bubbleSort.setUp(array);
                } else if (isSelectionSort) {
                    selectionSort.setBackground(Color.WHITE);
                    isSelectionSort = false;
                    SortingPanel.this.selectionSort.setUp();
                } else if (isInsertionSort) {
                    insertionSort.setBackground(Color.WHITE);
                    isInsertionSort = false;
                    SortingPanel.this.insertionSort.setUp();
                } else if (isQuickSort) {
                    isQuickSort = false;
                    quickSort.setBackground(Color.WHITE);
                    SortingPanel.this.quickSort.setUp();
                } else if (isMergeSort) {
                    isMergeSort = false;
                    mergeSort.setBackground(Color.WHITE);
                    SortingPanel.this.mergeSort.setUp();
                }
                repaint();
            }
        });

        add(bubbleSort);
        add(selectionSort);
        add(insertionSort);
        add(quickSort);
        add(mergeSort);
        add(reset);
    }

    public void setArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(500) + 50;
        }
    }

    public boolean isSorted() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

    public void selectionSortAnimate() {

        Timer timer = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isSorted()) {
                    // compare_index = Integer.MAX_VALUE;
                    ((Timer) e.getSource()).stop();
                } else {
                    if (isSelectionSort == true) {
                        selectionSort.oneComponentSelectioSort(array);
                    }
                }
                repaint();
            }
        });
        timer.start();
    }

    public void bubbleSortAnimate() {

        Timer timer = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isSorted()) {
                    ((Timer) e.getSource()).stop();
                } else {
                    if (isBubbleSort == true) {
                        bubbleSort.oneComponenetBubbleSort(array);
                    }
                }
                repaint();
            }
        });
        timer.start();
    }

    public void insertionSortAnimate() {
        Timer timer = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isSorted()) {
                    ((Timer) e.getSource()).stop();
                } else {
                    if (isInsertionSort == true) {
                        insertionSort.oneComponentInsertionSort(array);
                    }
                }
                repaint();
            }
        });
        timer.start();
    }

    public void quickSortAnimate() {
        Timer timer = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isSorted()) {
                    // compare_index = Integer.MAX_VALUE;
                    ((Timer) e.getSource()).stop();
                } else {
                    if (isQuickSort == true) {
                        array = quickSort.sortOnlyOneItem();
                    }
                }
                repaint();
            }
        });
        timer.start();
    }

    public void mergeSortAnimate() {
        Timer timer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isSorted()) {
                    ((Timer) e.getSource()).stop();
                } else {
                    if (isMergeSort == true) {
                        mergeSort.mergeSort(array);
                    }
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);

        for (int i = 0; i < array.length; i++) {
            g.setColor(Color.CYAN);

            if (isBubbleSort) {
                if (i == bubbleSort.getCompareIndexBubble() || i == bubbleSort.getCompareIndexBubble() + 1) {
                    g.setColor(Color.RED);
                }
            } else if (isSelectionSort) {
                if (i == selectionSort.getCompareIndexSelection()) {
                    g.setColor(Color.RED);
                }
                if (i == selectionSort.getMinIndexSelection()) {
                    g.setColor(Color.ORANGE);
                }
                if (i == selectionSort.getIndexSelection()) {
                    g.setColor(Color.GREEN);
                }
            } else if (isInsertionSort) {
                if (i == insertionSort.getIndexElementToMove()) {
                    g.setColor(Color.GREEN);
                }
                if (i == insertionSort.getIndexInsertion()) {
                    g.setColor(Color.RED);
                }
                if (i == insertionSort.getIndexInsertion() + 1) {
                    g.setColor(Color.ORANGE);
                }
            } else if (isQuickSort) {
                if (i == quickSort.getArrayIndex()) {
                    g.setColor(Color.MAGENTA);
                }
                if (i == quickSort.getCompareIndex()) {
                    g.setColor(Color.BLUE);
                }
                if (i == quickSort.getPartition())
                    g.setColor(Color.GREEN);
            } else if (isMergeSort) {
                if(i == mergeSort.getM()) {
                    g.setColor(Color.RED);
                }
            }
            if (isSorted()) {
                g.setColor(Color.green);
            }

            g.drawRect(i * 15, 600 - array[i], 13, array[i]);// I bordi sinistro e destro del rettangolo sono a x e x +
            // width
            g.fillRect(i * 15, 600 - array[i], 13, array[i]);// I bordi superiore e inferiore sono in corrispondenza ye
            // y + height
        }
    }
}