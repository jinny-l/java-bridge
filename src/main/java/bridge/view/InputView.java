package bridge.view;

import bridge.constant.GameCommand;
import bridge.domain.Bridge;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리 길이를 입력해주세요.");
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.printf("%n이동할 칸을 입력해주세요. (위: %s, 아래: %s)%n", Bridge.upBridgeLetter(), Bridge.downBridgeLetter());
        String input = readLine();
        Bridge.validateMoving(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static GameCommand readGameCommand() {
        return GameCommand.from(readLine());
    }

    /**
     * 입력 시 사용하는 기능
     * @return 입력 값의 공배 여부를 검증한 값 반환
     */
    private static String readLine() {
        String input = Console.readLine().trim();
        validateHasInput(input);
        return input;
    }

    private static void validateHasInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
