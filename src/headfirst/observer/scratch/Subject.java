package headfirst.observer.scratch;

public interface Subject {
    // register an headfirst.observer
    public void registerObserver(Observer o);
    // remove an headfirst.observer
    public void removeObserver(Observer o);
    // notify all observers when the Subject's state has changed
    public void notifyObservers();

}
