package bridge;

import bridge.domain.Block;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING_POSITION_MESSAGE = "이동할 칸을 선택해주세요. (위: %s, 아래: %s)%n";
    private static final String INPUT_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)%n";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
        String input = getInput();
        validateInteger(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.printf(
                INPUT_MOVING_POSITION_MESSAGE,
                Block.UP_BRIDGE.getString(),
                Block.DOWN_BRIDGE.getString()
        );
        return getInput();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.printf(INPUT_GAME_COMMAND_MESSAGE, BridgeGame.getRetryCharacter(), BridgeGame.getQuitCharacter());
        return getInput();
    }


    private static String getInput() {
        String input = Console.readLine().trim();
        validateNotEmpty(input);
        return input;
    }

    private static void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY_ERROR.getMessage());
        }
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_INPUT_TYPE_ERROR.getMessage());
        }
    }

}
