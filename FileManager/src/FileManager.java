import java.awt.BorderLayout;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class FileManager extends JFrame {
	DefaultMutableTreeNode root;
	public FileManager() {
		super("File Manager");
		JPanel basePanel = new JPanel(new BorderLayout());
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel(new BorderLayout());
		JPanel southPanel = new JPanel();

		root = new DefaultMutableTreeNode("(C:)");
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
		JTree tree = new JTree(treeModel);
		centerPanel.add(tree, BorderLayout.WEST);
		
		add(basePanel);
		basePanel.add(northPanel, BorderLayout.NORTH);
		basePanel.add(centerPanel, BorderLayout.CENTER);
		basePanel.add(southPanel, BorderLayout.SOUTH);

		setBounds(100, 100, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileManager();
		FileManager tree = new FileManager();
		File dir = new File("C:\\");
		File[] files = dir.listFiles();
		
		FileFilter filefilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			 		}
			};
			files = dir.listFiles(filefilter);
			if (files.length == 0) {
				System.out.println("Either dir does not exist or is not a directory");
			} else {
				for(int i=0; i<files.length; i++) {
					File filename = files[i];
					if (filename.toString().contains("$") || filename.toString().contains("Recovery") || filename.toString().contains("System") || filename.toString().contains("Temp") || filename.toString().contains("PerfLogs"))
							continue;
					else
						tree.root.add(new DefaultMutableTreeNode(filename.toString()));
				}
			}
			
	}

}
