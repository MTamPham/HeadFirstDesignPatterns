package headfirst.proxy.remoteproxy;

public class NoQuarterState implements State {

    // use transient keywork to tell the JVM not to serialize the gumball machine reference
    // note that this can be slightly dangerous if you try to access this field once it's been serialized and transferred
    transient GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there's no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }

    public String toString() {
        return "Waiting for quarter";
    }
}
