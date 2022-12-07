package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import java.util.List;

public class Bridge {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String UP_BRIDGE_LETTER = "U";
    private static final String DOWN_BRIDGE_LETTER = "D";

    private final List<String> bridge;

    public Bridge(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        validateSize(size);
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(size);
    }

    public static int minSize() {
        return MIN_SIZE;
    }

    public static int maxSize() {
        return MAX_SIZE;
    }

    public static String upBridgeLetter() {
        return UP_BRIDGE_LETTER;
    }

    public static String downBridgeLetter() {
        return DOWN_BRIDGE_LETTER;
    }

    private void validateSize(int size) {
        if (size < MIN_SIZE || size > MIN_SIZE) {
            throw new IllegalArgumentException();
        }
    }

}
