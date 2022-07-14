package headfirst.command.undo;

/**
 * Client
 */
public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        // TEST THE LIVING ROOM LIGHT
        Light livingRoomLight = new Light("Living Room");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        // add the light commands to the remote in slot 0
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);

        // turns the light on, then off and then undo
        remoteControl.onButtonPressed(0);
        remoteControl.offButtonPressed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonPressed();
        // then, turns the light off, back on and undo
        remoteControl.offButtonPressed(0);
        remoteControl.onButtonPressed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonPressed();

        // TEST THE CEILING FAN
        CeilingFan ceilingFan = new CeilingFan("Living Room");

        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        remoteControl.setCommand(1, ceilingFanMedium, ceilingFanOff);
        remoteControl.setCommand(2, ceilingFanHigh, ceilingFanOff);

        // turn the fan on medium, then turn it off and then undo (it should go back to medium)
        remoteControl.onButtonPressed(1);
        remoteControl.offButtonPressed(1);
        System.out.println(remoteControl.toString());
        remoteControl.undoButtonPressed();
        // turn the fan to high, then undo (it should go back to medium)
        remoteControl.onButtonPressed(2);
        System.out.println(remoteControl.toString());
        remoteControl.undoButtonPressed();
    }
}
