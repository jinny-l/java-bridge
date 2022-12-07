package bridge.constant;

import bridge.domain.Bridge;

public enum ErrorMessage {

    EMPTY_INPUT("입력 값이 없습니다."),
    INVALID_INPUT_TYPE("다리 길이는 숫자만 입력 가능합니다."),
    INVALID_BRIDGE_SIZE(
            String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
                    Bridge.minSize(),
                    Bridge.maxSize())
    ),
    INVALID_MOVING_INPUT(
            String.format("이동할 칸은 %s 또는 %s만 입력 가능합니다.",
                    Bridge.upBridgeLetter(),
                    Bridge.downBridgeLetter())
    ),
    INVALID_GAME_COMMAND(
            String.format("게임을 다시 시도하려면 %s, 종료하려면 %s를 입력해주세요.",
                    GameCommand.RETRY,
                    GameCommand.QUIT)
    );

    private static final String ERROR = "[ERROR] ";

    private final String message;

    ErrorMessage(String errorMessage) {
        this.message = errorMessage;
    }

    @Override
    public String toString() {
        return ERROR + message;
    }

}
