import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Evgenia on 10.10.2016.
 * пункты резюме :
 * * фио, возраст, телефоны, почта
 * * цели, желаемая должность, уровень зп, другие требования
 * * личные данные: др, сп, машина,права
 * * опыт работы
 * * образование: дата, заведение, специальность
 * * дополнительное образование, достижения
 * * личные качества
 *
 *  // перечисления мест работы начиная с самого последнего
    // профессиональные навыки, личные качества, достижения в сфере
    // комбинирует и хронологическое и функциональное резюме
    // ориентированное на определенную компанию или должность
 */
public class Summary {
    private String resourceDirectoryPath = "D:\\IdeaProjects\\pattern_game-master\\testirovanie_l2\\src\\infoFiles\\Summaries";

    private String fileName;

    public Summary(String fileName){

        this.fileName = fileName;
        resourceDirectoryPath += "\\" + fileName;
        File summaryDir = new File(resourceDirectoryPath);
        if(!summaryDir.exists()){
            try{
                summaryDir.createNewFile();
            }catch (IOException ioe){
                ioe.getMessage();
            }
        }
    }

    public void writeChronologySummary(){
        generateHeader();
        writeToSummary("ЦЕЛИ: ");
        readFromFile1Line("infoFiles\\goals");
        writeToSummary("ЛИЧНАЯ ИНФОРМАЦИЯ: ");
        readFromFile1Line("infoFiles\\personalData");
        writeToSummary("ОПЫТ РАБОТЫ: ");
        readFromFileSeveralLines("infoFiles\\workExperience", 2);
        writeToSummary("ОБРАЗОВАНИЕ: ");
        readFromFileSeveralLines("infoFiles\\education", 3);



    }

    public void generateHeader(){
        readFromFile1Line("headerInfo\\names");
        readFromFile1Line("headerInfo\\phones");
        readFromFile1Line("headerInfo\\emails");
    }

    public void writeFunctionalSummary(){
        generateHeader();
        readFromFile1Line("infoFiles\\goals");
        readFromFile1Line("infoFiles\\personalData");
        readFromFileSeveralLines("infoFiles\\education", 3);
        readFromFileSeveralLines("infoFiles\\qualyties", 3);

    }

    public void writeMixedSummary(){

    }

    public void writeSubjectSummary(){
    }

    public void readFromFileSeveralLines(String file, int numLines){
        int lines = countLinesInFile(file);

        int countLine = -1;

        String lineStr = "";

        String path = resourceDirectoryPath + file;
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(path));
            scanner.useDelimiter(System.getProperty("line.separator"));
            while (scanner.hasNext() || countLine != numLines) {
                lineStr = scanner.next();
                writeToSummary(lineStr);
                countLine++;
            }

        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.getMessage();
        }
        scanner.close();
    }

    public void readFromFile1Line(String file){
        int lines = countLinesInFile(file);

        int lineNum = new Random().nextInt(lines);

        int countLine = -1;

        String lineStr = "";

        String path = resourceDirectoryPath + file;
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(path));
            scanner.useDelimiter(System.getProperty("line.separator"));
            while (scanner.hasNext() || lineNum != countLine){
                lineStr = scanner.next();
                countLine++;
            }
            writeToSummary(lineStr);

        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.getMessage();
        }
        scanner.close();

    }

    public void readFrom(String fileName){
        String path = resourceDirectoryPath + "//" + fileName;
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(path));
            scanner.useDelimiter(System.getProperty("line.separator"));
//          read file

        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.getMessage();
        }
        scanner.close();

    }

    private int countLinesInFile(String fileName){
        int countLines = 0;
        String path = resourceDirectoryPath + "\\" + fileName;

        try{
            Scanner scanner = new Scanner(new File(path));
            scanner.useDelimiter(System.getProperty("line.separator"));
            while (scanner.hasNext()){
                scanner.next();
                countLines++;
            }
            scanner.close();

        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.getMessage();
        }


        return countLines;
    }

    private void writeToSummary(String line){
        FileWriter fileWriter;
        File summary = new File(fileName);
        try{
            fileWriter = new FileWriter(summary);
            fileWriter.append(line + "\n");
        }catch (IOException ioex){
            ioex.getMessage();
        }
    }

//    TODO записывая в файл послежовательно инфу вставлять оформляющие слова полей


}
