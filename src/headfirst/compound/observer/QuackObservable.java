package headfirst.compound.observer;

/**
 * An Observable class for registering and notifying Quackable observers
 * Quackables should implement this interface if they want to be observed
 */
public interface QuackObservable {
	public void registerObserver(Observer observer);
	public void notifyObservers();
}
