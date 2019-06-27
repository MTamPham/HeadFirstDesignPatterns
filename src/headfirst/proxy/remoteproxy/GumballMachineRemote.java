package headfirst.proxy.remoteproxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

// extends Remote to tell us that the interface is going to be used to support remote calls
public interface GumballMachineRemote extends Remote {
    // declare all methods throw a RemoteException
    // arguments and return values of a remote method must be either primitive or Serializable
    public int getCount() throws RemoteException;
    public String getLocation() throws RemoteException;
    public State getState() throws RemoteException;
}
