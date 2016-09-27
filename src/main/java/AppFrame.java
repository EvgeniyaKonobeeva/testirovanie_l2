import javax.swing.*;
import java.awt.*;

/**
 * Created by Evgenia on 28.09.2016.
 */
public class AppFrame extends JFrame{
    private JPanel buttonPanel;
    private JButton chronologyBut;
    private JButton functionalBut;
    private JButton mixedBut;
    private JButton subjectBut;
    public AppFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);

        buttonPanel = new JPanel();
        chronologyBut = new JButton("хронологическое резюме");
        functionalBut = new JButton("функциональное");
        mixedBut = new JButton("смешанное");
        subjectBut = new JButton("объектное");


        buttonPanel.add(chronologyBut);
        buttonPanel.add(functionalBut);
        buttonPanel.add(mixedBut);
        buttonPanel.add(subjectBut);
        add(buttonPanel, BorderLayout.CENTER);
        pack();
    }

    public void writeChronologySummary(){
        
    }
}
