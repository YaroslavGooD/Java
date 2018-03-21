import java.io.*;

public class main {
	public static void main(String args[]) throws IOException {
		Film f1 = new Film("Kevin", 1998, "Ostin");
		Film f2 = new Film("Nelson", 1997, "Harbert");
		Film f3 = new Film("Bada", 1999, "Menski");
		Film f4 = new Film("Konar", 1995, "Kialo");
		
		System.out.println("");
		
		RepositoryList<Film> repList = new RepositoryList<Film>();
		repList.addFilm(f1);
		repList.addFilm(f2);
		repList.addFilm(f3);
		repList.addFilm(f4);
		System.out.println("Unsorted");
//		repList.writeAllFilms();

		// variable
		String dirPath = "D:\\Files\\2Rok\\PK";
		String dirName = "Lesson5";
		String fileNameIN = "input.txt";
		String fileNameOUT = "output.txt";
		
		//making files and folders
		makeDir(dirPath);
		makeDir(dirPath + File.separator + dirName);
		String SubDirName = new File(dirPath + File.separator + dirName).getPath();
		makeFile(SubDirName + File.separator + fileNameIN);
		makeFile(SubDirName + File.separator + fileNameOUT);
		
		//writing to file
		File fout = new File(SubDirName + File.separator + fileNameOUT);
		writeToFile(fout.getPath(), repList, -1);
		readFile(SubDirName + File.separator + fileNameIN, repList);
		repList.sortBy(new FilmNameComparator());
		repList.writeAllFilms();
		writeToFile(fout.getPath(), repList, -1);
	}
	
	// read from file
	private static void readFile(String PN, RepositoryList<Film> repList) throws IOException {
		File fin = new File(PN);
		BufferedReader br = new BufferedReader(new FileReader(fin));
		String line = null;
		try {
			while((line = br.readLine()) != null) {
				String[] arrayLine = line.split("\\s+");
				if(arrayLine.length > 3)
					continue;
				repList.addFilm(new Film(arrayLine[0], Integer.parseInt(arrayLine[1]), arrayLine[2]));
			}
		} finally {
			br.close();
		}
	}

	public static void writeToFile(String PN, RepositoryList<Film> repList, int index) throws IOException {
		FileWriter fw = null;
		
		try {
			if(index == -1) {
				fw = new FileWriter(PN);
				for(Film name : repList.getAll()) {
					fw.write(name.toString());
					fw.write(System.lineSeparator());
				}
			} else {
				fw = new FileWriter(PN,true);
				for(Film name : repList.getToAppend(index)) {
					fw.append(name.toString());
					fw.append(System.lineSeparator());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}	
	
	public static void makeDir(String PN) throws IOException {
        File newDir = new File(PN);
        boolean isCreated = newDir.mkdir();
        if (isCreated) {
            System.out.printf("1. Successfully created directories, path: %s\n",
                    newDir.getCanonicalPath());
        } else if (newDir.exists()) {
            System.out.printf("1. Directory path already exist, path: %s\n",
                    newDir.getCanonicalPath());
        } else {
            System.out.println("1. Unable to create directory");
            return;
        }
	}
	
	public static void makeFile(String PN) throws IOException {
        File newFile = new File(PN);
        boolean isCreated = newFile.createNewFile();
        if (isCreated) {
            System.out.printf("2. Successfully created new file, path: %s\n",
                    newFile.getCanonicalPath());
        } else { //File may already exist
            System.out.printf("2. Unable to create new file\n");
        }
	}
}
