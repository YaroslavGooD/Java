package tree;

import java.io.File;

public class main {
	public static void main(String[] args) {
		String aPath = "D:\\Setup files";
		String line = DictionaryTree.allFiles(new File(aPath), null, null, "s", "d");
		System.out.println(line);
	}
}
