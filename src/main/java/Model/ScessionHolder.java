package Model;

import java.util.ArrayList;
import ViewModel.ScoreBoardObserver;

//Teaching Observer Pattern - Subject
public class ScessionHolder implements ScoreBoardSubject{
	
	private ArrayList<ScoreBoardObserver> observers;
	
	public ScessionHolder() {
		observers = new ArrayList<ScoreBoardObserver>();
	}
	
	@Override
	public void registerObserver(ScoreBoardObserver o) {
		
		observers.add(o);
	}

	@Override
	public void removeObserver(ScoreBoardObserver oldObserver) {
		observers.remove(observers.indexOf(oldObserver));
		
	}

	@Override
	public void notifyObservers() {
		
		//Warning ScoreBoardObserver o : observers format breaks code
		for (int i = 0; i < observers.size(); i++) {
			this.observers.get(i).update();
		}
	}
}
