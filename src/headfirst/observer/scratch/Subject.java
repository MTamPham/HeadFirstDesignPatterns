package headfirst.observer.scratch;

public interface Subject {
    // register an observer
    public void registerObserver(Observer o);
    // remove an observer
    public void removeObserver(Observer o);
    // notify all observers when the Subject's state has changed
    public void notifyObservers();

}
