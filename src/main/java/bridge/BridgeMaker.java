package bridge;

import bridge.domain.Bridge;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int UP_BRIDGE_NUMBER = 1;
    private static final int DOWN_BRIDGE_NUMBER = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        return makeBridgeNumbers(size).stream()
                .map(this::convertNumberToLetter)
                .collect(Collectors.toList());
    }

    private List<Integer> makeBridgeNumbers(int size) {
        List<Integer> bridgeNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            bridgeNumbers.add(bridgeNumber);
        }
        return bridgeNumbers;
    }

    private String convertNumberToLetter(int bridgeNumber) {
        if (bridgeNumber == UP_BRIDGE_NUMBER) {
            return Bridge.upBridgeLetter();
        }
        return Bridge.downBridgeLetter();
    }
}
