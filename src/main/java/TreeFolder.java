import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Evgenia on 12.10.2016.
 *
 * сначала создатьдерево TreeFolder tf = new JTree();
 *
 */
public class TreeFolder extends JTree {
    private Map<Path, DefaultMutableTreeNode> nodesMap = new HashMap<Path, DefaultMutableTreeNode>();
    public TreeFolder(DefaultMutableTreeNode top, Path topPath){
        super(top);
        nodesMap.put(topPath, top);
    }
    public void createNodes(Path child){
        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child.getFileName().toString());
        nodesMap.put(child, childNode);
        nodesMap.get(child.getParent()).add(childNode);
    }

}
