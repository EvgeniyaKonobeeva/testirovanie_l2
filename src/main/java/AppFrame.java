import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Evgenia on 28.09.2016.
 * Вариант 1: Напишите приложение, генерирующее осмысленные резюме (например, случайно выбирающее значения из файлов),
 * сохраняющее их в заданную папку и предоставляющее возможности по просмотру и поиску.
 * Тип формируемого резюме задается в настройках (придумать не менее 3 типов).
 *
 * пункты резюме :
 * * фио, возраст, телефоны, почта
 * * цели, желаемая должность, уровень зп, другие требования
 * * личные данные: др, сп, машина,права
 * * опыт работы
 * * образование: дата, заведение, специальность
 * * дополнительное образование, достижения
 * * личные качества
 */
public class AppFrame extends JFrame{
    private JPanel buttonPanel;
    private JButton chronologyBut; // перечисления мест работы начиная с самого последнего
    private JButton functionalBut;  // профессиональные навыки, личные качества, достижения в сфере
    private JButton mixedBut; // комбинирует и хронологическое и функциональное резюме
    private JButton subjectBut; // ориентированное на определенную компанию или должность
    private JButton saveBut;

    public AppFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);

        buttonPanel = new JPanel();
        chronologyBut = new JButton("хронологическое резюме");
        functionalBut = new JButton("функциональное");
        mixedBut = new JButton("смешанное");
        subjectBut = new JButton("объектное");
        saveBut = new JButton("сохранить");


        buttonPanel.add(chronologyBut);
        buttonPanel.add(functionalBut);
        buttonPanel.add(mixedBut);
        buttonPanel.add(subjectBut);
        buttonPanel.add(saveBut);

        add(buttonPanel, BorderLayout.CENTER);
        pack();


        chronologyBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Summary summary = new Summary("chronologySummary1");
                summary.writeChronologySummary();
            }
        });
    }



}
