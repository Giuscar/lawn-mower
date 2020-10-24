package giuscar.blablacar.start;

public enum Command {
    LEFT("L"), RIGHT("R"), FORWARD("F");

    private String command;

    Command(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }

    public static Command retrieveCommandByCommand(String val){
        for (Command command : Command.values()) {
            if (command.getCommand().equals(val)) {
                return command;
            }
        }
        throw new IllegalArgumentException("Invalid command");
    }
}
