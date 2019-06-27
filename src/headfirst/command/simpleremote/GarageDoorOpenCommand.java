package headfirst.command.simpleremote;

/**
 * Concrete Command
 */
public class GarageDoorOpenCommand implements Command {
    // an instance of receiver
    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    // one of actions to be invoked
    @Override
    public void execute() {
        this.garageDoor.up();
    }
}
