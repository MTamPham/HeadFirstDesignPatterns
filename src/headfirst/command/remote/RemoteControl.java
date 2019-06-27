package headfirst.command.remote;

@SuppressWarnings("Duplicates")
public class RemoteControl {
    // the remote control obtained from Home Automation or Bust, Inc. has 7 slots
    private static final int MAX_SLOTS = 7;
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        // instantiate the on and off arrays
        onCommands = new Command[MAX_SLOTS];
        offCommands = new Command[MAX_SLOTS];

        // initialize the on and off arrays
        Command noCommand = new NoCommand();
        for (int i = 0; i < MAX_SLOTS; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    // take a slot position and store an On and Off command in that slot
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    // when the On button is pressed, the hardware takes care of calling the corresponding methods
    public void onButtonPressed(int slot) {
        onCommands[slot].execute();
    }

    // when the Off button is pressed, the hardware takes care of calling the corresponding methods
    public void offButtonPressed(int slot) {
        offCommands[slot].execute();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                    + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuff.toString();
    }
}
