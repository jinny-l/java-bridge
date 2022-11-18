package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String RIGHT_ANSWER = "O";
    private static final String WRONG_ANSWER = "X";
    private static final String NOT_CHOSEN = " ";
    private static final String UP_BRIDGE_CHARACTER = "U";
    private static final String DOWN_BRIDGE_CHARACTER = "D";
    private static final String RETRY_CHARACTER = "R";
    private static final String QUIT_CHARACTER = "Q";

    public static String getUpBridgeCharacter() {
        return UP_BRIDGE_CHARACTER;
    }

    public static String getDownBridgeCharacter() {
        return DOWN_BRIDGE_CHARACTER;
    }

    public static String getRetryCharacter() {
        return RETRY_CHARACTER;
    }

    public static String getQuitCharacter() {
        return QUIT_CHARACTER;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String moving) {
        validateMovingInput(moving);
        return moving;
    }

    private void validateMovingInput(String input) {
        if (!input.equals(UP_BRIDGE_CHARACTER) && !input.equals(DOWN_BRIDGE_CHARACTER)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_MOVING_INPUT_ERROR.getMessage());
        }
    }

    /**
     * 사용자가 이동한 칸의 정답을 확인할 때 사용하는 메서드
     */
    public String getUpBridgeResult(List<String> bridge, int index, String input) {
        if (isMovingCorrect(bridge, index, input) && input.equals(UP_BRIDGE_CHARACTER)) {
            return RIGHT_ANSWER;
        }
        if (!isMovingCorrect(bridge, index, input) && input.equals(UP_BRIDGE_CHARACTER)) {
            return WRONG_ANSWER;
        }
        return NOT_CHOSEN;
    }

    public String getDownBridgeResult(List<String> bridge, int index, String input) {
        if (isMovingCorrect(bridge, index, input) && input.equals(DOWN_BRIDGE_CHARACTER)) {
            return RIGHT_ANSWER;
        }
        if (!isMovingCorrect(bridge, index, input) && input.equals(DOWN_BRIDGE_CHARACTER)) {
            return WRONG_ANSWER;
        }
        return NOT_CHOSEN;
    }

    public boolean isMovingCorrect(List<String> bridge, int index, String input) {
        return bridge.get(index).equals(input);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        validateRetryOrQuit(input);
        return input.equals(RETRY_CHARACTER);
    }

    private void validateRetryOrQuit(String input) {
        if (!input.equals(RETRY_CHARACTER) && !input.equals(QUIT_CHARACTER)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_RETRY_OR_QUIT_INPUT_ERROR.getMessage());
        }
    }

}
