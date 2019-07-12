package headfirst.compound.observer;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * A helper class to encapsulate the registration and notification code and composite it with a QuackObservable.
 * Observable implements all the functionality a Quackable needs to be an observable.
 */
public class Observable implements QuackObservable {
	ArrayList observers = new ArrayList();
	QuackObservable duck;
 
	public Observable(QuackObservable duck) {
		this.duck = duck;
	}
  
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
  
	public void notifyObservers() {
		Iterator iterator = observers.iterator();
		while (iterator.hasNext()) {
			Observer observer = (Observer)iterator.next();
			observer.update(duck);
		}
	}
 
	public Iterator getObservers() {
		return observers.iterator();
	}
}
