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
    private String resourceDirectoryPath;

    private String summaryFilePath;

    public Summary(String summaryFilePath){
        this.summaryFilePath = summaryFilePath;
    }

    public void writeChronologySummary(){
        readFromFile1Line();
        writeGoals();
        writePersonalInfo();
        writeWorkExperience();
        writeEducation();

    }

    public void writeFunctionalSummary(){
        readFromFile1Line();
        writeGoals();
        writePersonalInfo();
        writeQualities();
        writeAdditionalInfo();
    }

    public void writeMixedSummary(){
        readFromFile1Line();
        writeGoals();
        writePersonalInfo();

    }

    public void writeSubjectSummary(){
        readFromFile1Line();
        writeGoals();
        writePersonalInfo();
        writeWorkExperience();
        writeEducation();
        writeQualities();
    }

    public void writePersonalInfo(){

    }

    public void writeWorkExperience(){

    }

    public void writeEducation(){

    }

    public void writeAdditionalInfo(){

    }

    public void writeQualities(){

    }

    public void writeGoals(){

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
            while (scanner.hasNext() && lineNum != countLine){
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
        String path = resourceDirectoryPath + "//" + fileName;
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(path));
            scanner.useDelimiter(System.getProperty("line.separator"));
            while (scanner.hasNext()){
                scanner.next();
                countLines++;
            }

        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.getMessage();
        }
        scanner.close();

        return countLines;
    }

    private void writeToSummary(String line){
        FileWriter fileWriter;
        File summary = new File(summaryFilePath);
        try{
            fileWriter = new FileWriter(summary);
            fileWriter.append(line + "\n");
        }catch (IOException ioex){
            ioex.getMessage();
        }
    }

//    TODO записывая в файл послежовательно инфу вставлять оформляющие слова полей


}
