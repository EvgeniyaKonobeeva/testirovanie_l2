import javax.swing.*;
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
    private String resourceDirectoryPath = "D:\\IdeaProjects\\testirovanie_l2\\src\\infoFiles";
    private String usersPath;
    private String summaryFileN;

    public void writeChronologySummary(){
        generateHeader();
        writeToSummary("ЦЕЛИ: ");
        readFromFile1Line(resourceDirectoryPath, "goals");
        writeToSummary("ЛИЧНАЯ ИНФОРМАЦИЯ: ");
        readFromFile1Line(resourceDirectoryPath, "personalData");
        writeToSummary("ОПЫТ РАБОТЫ: ");
        readFromFileSeveralLines(resourceDirectoryPath, "workExperience", 2);
        writeToSummary("ОБРАЗОВАНИЕ: ");
        readFromFileSeveralLines(resourceDirectoryPath, "education", 3);
    }

    public void generateHeader(){
        readFromFile1Line(resourceDirectoryPath, "headerInfo\\names");
        readFromFile1Line(resourceDirectoryPath, "headerInfo\\phones");
        readFromFile1Line(resourceDirectoryPath, "headerInfo\\emails");
    }

    public void writeFunctionalSummary(){
        generateHeader();
        writeToSummary("ЦЕЛИ: ");
        readFromFile1Line(resourceDirectoryPath, "goals");
        writeToSummary("ЛИЧНАЯ ИНФОРМАЦИЯ: ");
        readFromFile1Line(resourceDirectoryPath, "personalData");
        writeToSummary("ОБРАЗОВАНИЕ: ");
        readFromFileSeveralLines(resourceDirectoryPath, "education", 3);
        writeToSummary("КАЧЕСТВА: ");
        readFromFileSeveralLines(resourceDirectoryPath,"qualyties", 3);

    }

    public void writeMixedSummary(){
        generateHeader();
        writeToSummary("ЦЕЛИ: ");
        readFromFile1Line(resourceDirectoryPath, "goals");
        writeToSummary("ЛИЧНАЯ ИНФОРМАЦИЯ: ");
        readFromFile1Line(resourceDirectoryPath, "personalData");
        writeToSummary("ОПЫТ РАБОТЫ: ");
        readFromFileSeveralLines(resourceDirectoryPath, "workExperience", 2);
        writeToSummary("ОБРАЗОВАНИЕ: ");
        readFromFileSeveralLines(resourceDirectoryPath,"education", 3);
        writeToSummary("ЛИЧНЫЕ КАЧЕСТВА: ");
        readFromFileSeveralLines(resourceDirectoryPath,"qualyties", 3);
    }

    public void readFromFileSeveralLines(String path11, String file, int numLines){
        int lines = countLinesInFile(path11, file);

        int countLine = -1;

        String lineStr = "";

        String path = concatePathFile(path11, file);
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(path));
            scanner.useDelimiter("\\n");
            while (scanner.hasNext() && countLine != numLines) {
                lineStr = scanner.next();
                writeToSummary(lineStr);
                countLine++;
            }
            scanner.close();

        }catch (FileNotFoundException fileNotFoundException){
            System.out.println(fileNotFoundException.getMessage());
        }

    }

    public String readFromFile1Line(String path11, String file){
        int lines = countLinesInFile(path11,file);

        int lineNum = new Random().nextInt(lines);

        int countLine = -1;

        String lineStr = "";

        String path = concatePathFile(path11, file);
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(path));
            scanner.useDelimiter("\\n");
            while (scanner.hasNext() && lineNum != countLine){
                lineStr = scanner.next();
                countLine++;
            }
            scanner.close();
            writeToSummary(lineStr);


        }catch (FileNotFoundException fileNotFoundException){
            System.out.println(fileNotFoundException.getMessage());
        }
        return lineStr;

    }

    public int countLinesInFile(String path11, String fileName){
        int countLines = 0;
        String path = concatePathFile(path11, fileName);

        try{
            Scanner scanner = new Scanner(new File(path));
            scanner.useDelimiter("\\n");
            while (scanner.hasNext()){
                scanner.next();
                countLines++;
            }
            scanner.close();

        }catch (FileNotFoundException fileNotFoundException){
            System.out.println(fileNotFoundException.getMessage());
        }


        return countLines;
    }

    private void writeToSummary(String line){
        String path = concatePathFile(usersPath, summaryFileN);
        FileWriter fileWriter;
        File summary = new File(path);
        try{
            fileWriter = new FileWriter(summary, true);
            fileWriter.append(line + "\n");
            fileWriter.close();
        }catch (IOException ioex){
            System.out.println(ioex.getMessage());
        }
    }

    private String concatePathFile(String path, String file){
        return  path + "\\" + file;
    }

    public void setFilePath(String path){
        usersPath = path;
    }
    public void setFileName(String fileName){
        summaryFileN = fileName;
    }

    public void printFile(JTextArea textArea){
        String path = concatePathFile(usersPath, summaryFileN);

        try{
            Scanner scanner = new Scanner(new File(path));
            scanner.useDelimiter("\\n");
            while (scanner.hasNext()){
                textArea.append(scanner.next());
            }
            scanner.close();

        }catch (FileNotFoundException fileNotFoundException){
            System.out.println(fileNotFoundException.getMessage());
        }

    }

}
