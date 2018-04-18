package tree;

import java.io.File;

public class main {
	public static void main(String[] args) {
		String aPath = "D:\\css";
		String line = DictionaryTree.allFiles(new File(aPath), null, null, null, null);
		System.out.println(line);
//		String f = "File.zip";
//		String nf = f.substring(f.lastIndexOf('.') + 1);
//		System.out.println(f.substring(0,(f.length() - nf.length()) - 1));
	}
}
