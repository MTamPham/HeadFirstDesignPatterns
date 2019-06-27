package headfirst.command.simpleremote;

/**
 * Invoker
 */
public class SimpleRemoteControl {
    // we have one slot to hold our command, which will control one device
    Command slot;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed() {
        this.slot.execute();
    }
}
