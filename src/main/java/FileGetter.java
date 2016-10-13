import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Evgenia on 12.10.2016.
 */
public class FileGetter extends SimpleFileVisitor<Path> {
    TreeFolder tree;
    public FileGetter(TreeFolder tree){
        this.tree = tree;
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        tree.createNodes(file);
        return super.visitFile(file, attrs);
    }


    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        tree.createNodes(dir);
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println(exc.toString());
        System.out.println(file.toString());
        return super.visitFileFailed(file, exc);
    }

}
