package tree;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Tree {
	public static String line = "";
	public static String ex = "";
	
	public static String allFiles(File file, String tab, String formatSize, String sort, String whatFirst) {
		//initialize a tab
		tab = tab == null ? "" : tab;
		
		//Check file
		if(!file.exists())
			System.out.print("File not found");
		
		//Make files list 
		File[] list = file.listFiles();
		
		//Check list
		if(list == null)
			return file.getName();
		
		//Sort by name or size or whatFirst
		if(sort != null && whatFirst != null) {
			list = Tree.WhatFirst(list, sort, whatFirst);
		} else if(whatFirst != null && sort == null) { 
			list = Tree.WhatFirst(list, sort, whatFirst);
		} else if(whatFirst == null && sort != null) {
			Tree.Sort(list, sort);
		}
		
		//Format of size and extension
		long div = 1;
		String format = "";
		if(formatSize != null) {
			if(formatSize.compareTo("b") == 0) {
				format = "B";
			} else if(formatSize.compareTo("m") == 0) {
				format = "MB";
				div = 1000000;
			}
		}
		
		//make tree
		for(File name : list) {
			if(name.isDirectory()) {
				line +=  tab + ">-" + name.getName() + " : " + FolderSize(name,0)/div + format +" D\n";
//				System.out.print(tab + ">-" + name.getName() + " : " + size + " byte\n");
				allFiles(name, tab + "|  ", formatSize, sort, whatFirst);
			} else {
				ex = "";
				ex = getExtension(name.getName());
				line += tab + "+--" + getName(name,ex) + " : " + name.length()/div + format +" "+ ex +"\n";
//				System.out.print(tab + "+--" + name.getName() + " : " + name.length() + " byte\n");
			}
		}
		return line;
	}
	
	
	public static String getName(File f, String ex) {
		return f.getName().substring(0, (f.getName().length() - ex.length()));
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
			} else if (f1.isDirectory() && !f2.isDirectory()){
				return Long.compare(FolderSize(f1,size), f2.length());
			} else if(!f1.isDirectory() && f2.isDirectory()) {
				return Long.compare(f1.length(),FolderSize(f2,size));
			} else {
				return Long.compare(f1.length(), f2.length());
			}
		}
	};
	
	//TODO
//	public static Comparator<File> FileExtensionComparator = new Comparator<File>() {}
	
	//TODO
	public static String getExtension(String f) {
		ex = f.substring(f.lastIndexOf('.')) + ex;
		String nf = f.substring(0,f.lastIndexOf('.'));
		if(nf.lastIndexOf('.') != -1) {
			ex = "." + ex;
			return getExtension(nf);
		}		
		return ex;
	}
	
	
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
	
	//TODO make to function for sort 
	public static File[] WhatFirst(File[] list, String sort, String whatFirst) {
		File[] fs = new File[list.length];
		File[] dirs = new File[list.length];
		File[] all = new File[list.length];
		int last = 0;
		int f = 0;
		int d = 0;
		for(File name : list) {
			if(name.isDirectory()) {
				dirs[d] = name;
				d++;
			} else {
				fs[f] = name;
				f++;
			}
		}
		File[] allFs = Arrays.copyOf(fs, f);
		File[] allDirs = Arrays.copyOf(dirs, d);
		
		//Sort
		if(sort != null) {
			Tree.Sort(allDirs, sort); 
			Tree.Sort(allFs, sort);
		} 
		
		if(whatFirst.compareTo("f") == 0) {
			for(int i = 0; i < (f+d); i++) {
				if(i < f) {
					all[i] = allFs[i];
				} else {
					all[i] = allDirs[last];
					last++;
				}
			}
		} else if(whatFirst.compareTo("d") == 0) {
			for(int i = 0; i < (f+d); i++) {
				if(i < d) {
					all[i] = allDirs[i];
				} else {
					all[i] = allFs[last];
					last++;
				}
			}
		}  else {
			Tree.Sort(list, sort);
			return list;
		}
		return all;
	}
	
	public static void Sort(File[] list, String sort) {
		if(sort.compareTo("n") == 0) {
			Arrays.sort(list, Tree.FileNameComparator);
		} else if(sort.compareTo("s") == 0) {
			Arrays.sort(list, Tree.FileSizeComparator);
		}
	}
}
