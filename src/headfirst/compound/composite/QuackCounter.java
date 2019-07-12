package headfirst.compound.composite;

/**
 * This is a decorator to implement the change which is able to count duck quacks without having to change the duck classes
 */
public class QuackCounter implements Quackable {
	Quackable duck;
	static int numberOfQuacks;
  
	public QuackCounter(Quackable duck) {
		this.duck = duck;
	}
  
	public void quack() {
		duck.quack();
		numberOfQuacks++;
	}
 
	public static int getQuacks() {
		return numberOfQuacks;
	}
   
	public String toString() {
		return duck.toString();
	}
}
