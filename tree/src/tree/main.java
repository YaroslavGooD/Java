package tree;

import java.io.File;

public class main {
	public static void main(String[] args) {
		String aPath = "D:\\Virtual";
		String line = DictionaryTree.allFiles(new File(aPath), null ,"s");
		System.out.println(line);
	}
}
