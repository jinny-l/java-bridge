package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.repository.MovingRepository;
import bridge.repository.ResultRepository;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String RIGHT_ANSWER = "O";
    private static final String WRONG_ANSWER = "X";
    private static final String NOT_CHOSEN = " ";

    private final Bridge bridge;

    public BridgeGame(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridge = new Bridge(size, bridgeNumberGenerator);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        MovingRepository.add(moving);
        ResultRepository.add(
                convertMovingToAnswer(moving, Bridge.upBridgeLetter()),
                convertMovingToAnswer(moving, Bridge.downBridgeLetter())
        );
    }

    private String convertMovingToAnswer(String moving, String bridgeSide) {
        if (!isLose(moving) && moving.equals(bridgeSide)) {
            return RIGHT_ANSWER;
        }
        if (isLose(moving) && moving.equals(bridgeSide)) {
            return WRONG_ANSWER;
        }
        return NOT_CHOSEN;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        MovingRepository.retry();
        ResultRepository.retry();
    }

    /**
     * 사용자가 게임을 종료할 때 사용하는 메서드
     */
    public void quit() {
        MovingRepository.reset();
        ResultRepository.reset();
    }

    /**
     * 게임 승리 여부를 확인할 때 사용하는 메서드
     */
    public boolean isLose(String moving) {
        return !bridge.equals(MovingRepository.lastIndex(), moving);
    }

    public boolean isWin(String moving) {
        return !isLose(moving) && (bridge.size() == MovingRepository.size());
    }

}
