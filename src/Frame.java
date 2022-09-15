import javax.swing.JFrame;

public class Frame extends JFrame {

    private SortingPanel sortingPanel = new SortingPanel();

    public Frame(){
        setTitle("Sorting Visualization");
        setSize(1213, 600);
        this.getContentPane().add(sortingPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
