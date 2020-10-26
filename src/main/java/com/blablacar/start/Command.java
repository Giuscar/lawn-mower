package com.blablacar.start;
/**
 * This enum class has the scope to represent the list of commands in order to move
 * the mower.
 */
public enum Command {
    LEFT("L"), RIGHT("R"), FORWARD("F");

    private String command;

    /**
     * @param command
     */
    Command(String command){
        this.command = command;
    }

    /**
     * @return String
     */
    public String getCommand(){
        return command;
    }

    /**
     * Method that returns the Command corresponding to the input val. In
     * case val is not contained in the list of the Command constants,
     * an IllegalArgumentException is thrown.
     * @param val
     * @return Command
     */
    public static Command retrieveCommandByVal(String val){
        for (Command command : Command.values()) {
            if (command.getCommand().equals(val)) {
                return command;
            }
        }
        throw new IllegalArgumentException("Invalid command");
    }
}
