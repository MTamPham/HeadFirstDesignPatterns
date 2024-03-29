package headfirst.proxy.remoteproxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachine gumballMachine;
        int count = 0;
        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        try {
            count = Integer.parseInt(args[1]);
            gumballMachine = new GumballMachine(args[0], count);
            StringBuilder sb = new StringBuilder();
            sb.append("//").append(args[0]).append("/gumballmachine");
            System.out.println("Binding " + sb.toString() + " to registry");
            Naming.rebind(sb.toString(), gumballMachine);
            System.out.println("Server is ready");
        } catch (RemoteException remoteExp) {
            remoteExp.printStackTrace();
        } catch (MalformedURLException malformedURLExp) {
            malformedURLExp.printStackTrace();
        }
    }
}
