package headfirst.proxy.remoteproxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// to make sure it can act as a service and handle requests coming from over the network,
// implementing the GumballMachineRemote interface
// extending UnicastRemoteObject is the easiest way to make a remote object
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    State noQuarterState;
    State hasQuarterState;
    State soldOutState;
    State soldState;
    State winnerState;

    State state;
    int count;
    String location;

    // the UnicastRemoteObject constructore declares an exception,
    // so we must write
    public GumballMachine() throws RemoteException {}

    public GumballMachine(String location, int numberGumballs) throws RemoteException {
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.state = soldOutState;
        this.location = location;
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            this.state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    public void fill(int count) {
        this.count = count;
        state = noQuarterState;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public int getCount() {
        return count;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }

    public State getWinnerState() {
        return winnerState;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public State getState() {
        return state;
    }
}
