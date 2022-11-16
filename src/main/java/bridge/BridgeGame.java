package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String UP_BRIDGE_CHARACTER = "U";
    private static final String DOWN_BRIDGE_CHARACTER = "D";
    private static final String RETRY_CHARACTER = "R";
    private static final String QUIT_CHARACTER = "Q";
    private static final String WIN = "성공";
    private static final String LOSE = "실패";

    private final List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
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
    public void move() {
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
            throw new IllegalArgumentException();
        }
    }

}
