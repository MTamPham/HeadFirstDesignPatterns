package headfirst.compound.observer;

/**
 * Extending the QuackObservable interface to make sure all Quackables can be observed (like the requirement)
 */
public interface Quackable extends QuackObservable {
	public void quack();
}
