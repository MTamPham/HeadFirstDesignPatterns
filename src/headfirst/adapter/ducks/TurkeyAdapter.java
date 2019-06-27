package headfirst.adapter.ducks;

/**
 * Adapting Turkeys to Ducks so we implement the Duck interface
 */
public class TurkeyAdapter implements Duck {
    Turkey turkey;

    // get a reference to the object that we are adapting
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        // let's say Turkeys fly in short spurts - they can't do long-distance flying like ducks
        // to map between a Duck's fly() method and a Turkey's, we need to call the Turkey's fly() method five times to make up for it
        for(int i=0; i < 5; i++) {
            turkey.fly();
        }
    }
}
