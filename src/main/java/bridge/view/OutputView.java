package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BRIDGE_START_DELIMITER = "[ ";
    private static final String BRIDGE_END_DELIMITER = " ]";
    private static final String BLOCK_DELIMITER = " | ";

    /**
     * 에러 메시지를 출력할 때 사용하는 기능
     */
    public static void printError(String message) {
        System.out.println(message);
    }

    /**
     * 게임 시작 시 출력하는 메서드
     */
    public static void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> upBridgeResult, List<String> downBridgeResult) {
        System.out.println(printBridge(upBridgeResult));
        System.out.println(printBridge(downBridgeResult));
        System.out.println();
    }

    private static String printBridge(List<String> bridgeResult) {
        return BRIDGE_START_DELIMITER
                + convertDataToBridge(bridgeResult)
                + BRIDGE_END_DELIMITER;
    }

    private static String convertDataToBridge(List<String> bridgeResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bridgeResult.size(); i++) {
            stringBuilder.append(bridgeResult.get(i));
            if (i == bridgeResult.size() - 1) {
                break;
            }
            stringBuilder.append(BLOCK_DELIMITER);
        }
        return stringBuilder.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String gameResult, int attemptsCount) {
        System.out.printf("게임 성공 여부: %s%n", gameResult);
        System.out.printf("총 시도한 횟수: %d%n", attemptsCount);
    }

    public static void printFinalMap() {
        System.out.println("최종 게임 결과: ");
    }

}
