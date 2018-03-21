
public class Files {
	public String name;
	public String format;
	public char whatToDo;
	
	public Files(String name, String format) {
		if(name == null) {
			this.name = "NewFile";
		}
		if(format == null) {
			this.format = ".txt";
		}
		
		this.name = name;
		this.format = format;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public char getWhatToDo() {
		return whatToDo;
	}

	public void setWhatToDo(char whatToDo) {
		this.whatToDo = whatToDo;
	}
	
}
