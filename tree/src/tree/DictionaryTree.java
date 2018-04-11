package tree;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class DictionaryTree {
	public static String line = "";
	
	public static String allFiles(File file, String tab, String sort) {
		tab = tab == null ? "" : tab;
		if(!file.exists())
			System.out.print("File not found");
		File[] list = file.listFiles();
		if(sort != null) {
			if(sort.compareTo("n") == 0) {
				Arrays.sort(list, DictionaryTree.FileNameComparator);
			} else if(sort.compareTo("s") == 0) {
				Arrays.sort(list, DictionaryTree.FileSizeComparator);
			}
		}
		if(list == null)
			return null;
		for(File name : list) {
			if(name.isDirectory()) {
				line +=  tab + ">-" + name.getName() + " : " + FolderSize(name,0) + " byte\n";
//				System.out.print(tab + ">-" + name.getName() + " : " + size + " byte\n");
				allFiles(name, tab + "|  ", sort);
			} else {
				line += tab + "+--" + name.getName() + " : " + name.length() + " byte\n";
//				System.out.print(tab + "+--" + name.getName() + " : " + name.length() + " byte\n");
			}
		}
		return line;
	}
	
	
	
	public static Comparator<File> FileNameComparator = new Comparator<File>() {
		public int compare(File f1, File f2) {
			return f1.getName().toLowerCase().compareTo(f2.getName().toLowerCase());
		}
	};
	
	public static Comparator<File> FileSizeComparator = new Comparator<File>() {
		public int compare(File f1, File f2) {
			long size = 0;
			if(f1.isDirectory() && f2.isDirectory()) {
				return Long.compare(FolderSize(f1,size), FolderSize(f2,size));
			} else {
				return Long.compare(f1.length(), f2.length());
			}
		}
	};
	
	
	public static long FolderSize(File f, long size) {
		long fileSize = 0;
		File[] list = f.listFiles();
		if(list == null) {
			return 0;
		}
		for(File name : list) {
			if(name.isDirectory()) {
				size += FolderSize(name, fileSize);
			} else {
				fileSize += name.length();
			}
		}
		size += fileSize;
		return size;
	}
	
	
}
