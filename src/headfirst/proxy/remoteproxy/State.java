package headfirst.proxy.remoteproxy;

import java.io.Serializable;

// extends Serializable to make it transferable over the network
public interface State extends Serializable {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
