package Model;

import ViewModel.ScoreBoardObserver;

//Teaching Observer Pattern - Subject Interface
public interface ScoreBoardSubject {
	
	void registerObserver(ScoreBoardObserver o);
	void notifyObservers();
	void removeObserver(ScoreBoardObserver o);
}
