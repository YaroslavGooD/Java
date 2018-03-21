import java.util.Comparator;

public class FilmDirectorComparator implements Comparator<Film> {
	public int compare(Film f1, Film f2) {
		return f1.getDirector().compareTo(f2.getDirector());
	}
}
