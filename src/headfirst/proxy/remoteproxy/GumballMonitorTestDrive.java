package headfirst.proxy.remoteproxy;

import java.rmi.Naming;

public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        // rmi://subdomain.domain.com/gumballmachine
        // where subdomain is the location, domain.com is the domain of Mighty Gumball company
        // and gumballmachine is a generic name
        String[] location = {
            //"rmi://santafe.mightygumball.com/gumballmachine",
            //"rmi://boulder.mightygumball.com/gumballmachine",
            //"rmi://seattle.mightygumball.com/gumballmachine",
            "rmi://127.0.0.1/gumballmachine"};

        if(args.length > 0) {
            location = new String[1];
            location[0] = args[0];
        }

        GumballMonitor[] monitor = new GumballMonitor[location.length];

        for (int i = 0; i < location.length; i++) {
            try {
                // it takes a location and service name, then looks it up in the rmiregistry at that location
                // and returns a proxy to the remote Gumball Machine
                GumballMachineRemote machine =
                        (GumballMachineRemote) Naming.lookup(location[i]);
                monitor[i] = new GumballMonitor(machine);
                System.out.println(monitor[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < monitor.length; i++) {
            if (monitor[i] != null) {
                monitor[i].report();
            }
        }
    }
}
