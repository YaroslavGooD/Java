import java.util.Comparator;

class FilmNameComparator implements Comparator<Film> {
	public int compare(Film f1, Film f2) {
		return f1.getName().compareTo(f2.getName());
	}
}