package headfirst.adapter.ducks;

import java.util.Random;

/**
 * Adapting Ducks to Turkeys so we implement the Turkey interface
 */
public class DuckAdapter implements Turkey {
    Duck duck;
    Random rand;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
        rand = new Random();
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        // since ducks fly a lot longer than turkeys, we decided to only fly the duck on average one of five times.
        if (rand.nextInt(5) == 0) {
            duck.fly();
        }
    }
}
