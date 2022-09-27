package CityQuestApi.command;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    LOCATION(""),
    ON("/on"),
    OFF("/off"),
    NO("nocommand"),
    ADMIN("/admin"),
    AHELP("/ahelp");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
