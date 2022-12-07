package bridge.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultRepository {

    private static final List<String> upBridgeResult = new ArrayList<>();
    private static final List<String> downBridgeResult = new ArrayList<>();

    public static List<String> getUpBridgeResult() {
        return Collections.unmodifiableList(upBridgeResult);
    }

    public static List<String> getDownBridgeResult() {
        return Collections.unmodifiableList(downBridgeResult);
    }

    public static void add(String upBridge, String downBridge) {
        upBridgeResult.add(upBridge);
        downBridgeResult.add(downBridge);
    }

    public static void retry() {
        upBridgeResult.remove(upBridgeResult.size() - 1);
        downBridgeResult.remove(downBridgeResult.size() - 1);
    }

    public static void reset() {
        upBridgeResult.clear();
        downBridgeResult.clear();
    }

}
