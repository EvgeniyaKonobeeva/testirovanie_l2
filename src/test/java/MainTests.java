import org.junit.Assert;
import org.junit.Test;

/**
 * Created by evgen_001 on 12.10.2016.
 */
public class MainTests {
    @Test
    public void testCountLines(){
        String path = "D:\\IdeaProjects\\testirovanie_l2\\src\\SUMMARIES";
        String name = "chronologySummary0";
        Summary summary = new Summary();
        summary.setFileName("chronologySummary0");
        summary.setFilePath("D:\\IdeaProjects\\testirovanie_l2\\src\\SUMMARIES");
        int res = summary.countLinesInFile(path, name);
        Assert.assertEquals(16, res);
    }

    @Test
    public void testRead1Line(){
        String path = "D:\\IdeaProjects\\testirovanie_l2\\src\\SUMMARIES";
        String name = "oneLine";
        Summary summary = new Summary();
        summary.setFileName("chronologySummary0");
        summary.setFilePath("D:\\IdeaProjects\\testirovanie_l2\\src\\SUMMARIES");
        String res = summary.readFromFile1Line(path, name);
        Assert.assertEquals("2345", res);
    }



    @Test
    public void testReadPath(){
        AppFrame frame = new AppFrame();
        boolean res = frame.readPath("D:\\IdeaProjects\\testirovanie_l2\\src\\main\\java");
        Assert.assertEquals(true, res);
    }

    @Test
    public void testReadPath2(){
        AppFrame frame = new AppFrame();
        boolean res = frame.readPath("D:\\IdeaProjects\\testirovanie_l2\\src\\main\\java22");
        Assert.assertNotEquals(true, res);
    }
}
