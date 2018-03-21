import java.util.Comparator;

class FilmYearComparator implements Comparator<Film> {
	public int compare(Film f1, Film f2) {
		if(f1.getYear() > f2.getYear())
			return 1;
		else if(f1.getYear() < f2.getYear())
			return -1;
		else
			return 0;
	}
}