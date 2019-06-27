package headfirst.proxy.remoteproxy;

import java.rmi.RemoteException;

public class GumballMonitor {
    GumballMachineRemote gumballMachine;

    public GumballMonitor(GumballMachineRemote gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine: " + gumballMachine.getLocation());
            System.out.println("Current inventory: " + gumballMachine.getCount());
            System.out.println("Current state: " + gumballMachine.getState());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
