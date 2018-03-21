
public class Film{
	public String name;
	public int year;
	public String director;
	
	
	public Film(String name, int year, String director) {
		this.name = name;
		this.year = year;
		this.director = director;
	}
	

	
	public String getDirector() {
		return director;
	}



	public void setDirector(String director) {
		this.director = director;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	@Override
	public String toString () {
		return "Name:" + name + ' ' + "Year:" + year + ' '+ "Director: "+ director + "\n";
	}
}
