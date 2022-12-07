package bridge.constant;

import java.util.stream.Stream;

public enum GameCommand {

    RETRY("R"),
    QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand from(String input) {
        return Stream.of(GameCommand.values())
                .filter(command -> command.command.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_GAME_COMMAND.toString()));
    }

    @Override
    public String toString() {
        return command;
    }

}
