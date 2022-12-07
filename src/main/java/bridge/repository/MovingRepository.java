package bridge.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovingRepository {

    private static final List<String> MOVING = new ArrayList<>();

    public static List<String> get() {
        return Collections.unmodifiableList(MOVING);
    }

    public static void add(String moving) {
        MOVING.add(moving);
    }

    public static void retry() {
        MOVING.remove(lastIndex());
    }

    public static int lastIndex() {
        if (MOVING.isEmpty()) {
            return 0;
        }
        return MOVING.size() - 1;
    }

    public static int size() {
        return MOVING.size();
    }

    public static void reset() {
        MOVING.clear();
    }

}
