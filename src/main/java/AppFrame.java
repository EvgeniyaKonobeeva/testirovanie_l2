import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;

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
    private JButton saveBut;
    private JTextField textField;
    private JTextArea textArea;
    private JPanel textPanel;
    private Summary summary;
    private JLabel errorLabel;
    private JScrollPane scrollPane;
    private JTree tree;

    public AppFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);

        summary = new Summary();
//        tree = new TreeFolder()
//        TODO создать дерево, создать filegetter, начать прогулку по дереву, настроить картинки
//        TODO организовать показывание файла в дереве при его создании, открытие по кнопке для просмотра, отображать путь к папке по
// TODO выбранной вершине в текстовом поле, просмотр выбранного листа
        scrollPane = new JScrollPane(tree);

        initButtonPanel();
        initTextPanel();

        initTextPanel();
        add(scrollPane, BorderLayout.LINE_START);
        add(buttonPanel, BorderLayout.PAGE_START);
        add(textPanel, BorderLayout.LINE_END);
        pack();


        chronologyBut.addActionListener(new MyListener("chronologySummary", 0));

        functionalBut.addActionListener(new MyListener("functionalSummary", 1));

        mixedBut.addActionListener(new MyListener("mixedSummary", 2));

        saveBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorLabel.setText("");
                summary.printFile(textArea);
            }
        });
    }


    public boolean readPath(String path){
        if(path.equals("")){
            errorLabel.setText("your path is incorrect");
            return false;
        }else{
            File file = new File(path);
            if(!file.exists() || !file.isDirectory()){
                errorLabel.setText("your path is incorrect");
                return false;
            }else{
                summary.setFilePath(path);
            }
            return true;
        }
    }

    public class MyListener implements ActionListener{
        String name;
        private int countClicks = 0;
        int summarytypecode;
        public MyListener(String name, int summarytypecode) {
            this.name = name;
            this.summarytypecode = summarytypecode;
        }

        public void actionPerformed(ActionEvent e) {
            errorLabel.setText("");
            textArea.setText("");
            summary.setFileName(name + countClicks++);
            if(readPath(textField.getText()))
                switch(summarytypecode){
                    case 0:
                        summary.writeChronologySummary();
                        break;
                    case 1:
                        summary.writeFunctionalSummary();
                        break;
                    case 2:
                        summary.writeMixedSummary();
                        break;
                }

        }
    }

    private void initButtonPanel(){
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));

        chronologyBut = new JButton("хронологическое резюме");
        functionalBut = new JButton("функциональное");
        mixedBut = new JButton("смешанное");
        saveBut = new JButton("показать");
        textField = new JTextField();

        buttonPanel.add(chronologyBut);
        buttonPanel.add(functionalBut);
        buttonPanel.add(mixedBut);
        buttonPanel.add(saveBut);
    }

    private void initTextPanel(){
        errorLabel = new JLabel();
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
        textField = new JTextField();
        textArea = new JTextArea(30, 70);
        textPanel.add(textField);
        textPanel.add(errorLabel);
        textPanel.add(textArea);
    }


}
