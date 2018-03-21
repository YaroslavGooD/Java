import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RepositoryList<T> {
	private ArrayList<T> list;
	
	public RepositoryList() {
		list = new ArrayList<T>();
	}
	
	public void addFilm(T element) {
		list.add(element);
	}
	
	public T getFilm(int index) {
		return list.get(index);
	}
	
	public T allFilms() {
		for(T elem : list) {
			if(elem == null) {
				return null;
			}
			return elem;
		}
		return null;
	}
	
	public void writeAllFilms() {
		for(T elem : list) {
			if(elem == null) {
				return;
			}
			System.out.print(elem);
		}
	}
	
	public ArrayList<T> getToAppend(int index) {
		if(index >= list.size()) {
			return null;
		}
		ArrayList<T> newArray = new ArrayList<T>();
		for(int i = index; i < list.size(); i++) {
			newArray.add(list.get(i));
		}
		return newArray;
	}
	
	public ArrayList<T> getAll() {
		return list;
	}
	
	public void sortBy(Comparator<T> c) {
		Collections.sort(list, c);
	}
	
	public int size() {
		return list.size();
	}
	
}
