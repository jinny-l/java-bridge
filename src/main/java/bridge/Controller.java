package bridge;

import bridge.constant.GameCommand;
import bridge.domain.BridgeGame;
import bridge.repository.ResultRepository;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {

    private static final String WIN_GAME = "성공";
    private static final String LOSE_GAME = "실패";

    private int attemptsCount = 1;

    public void run() {
        BridgeGame bridgeGame = initialize();
        boolean retry = true;
        do {
            String moving = moving(bridgeGame);
            if (bridgeGame.isLose(moving)) {
                retry = retryOrQuit(bridgeGame);
            }
            if (bridgeGame.isWin(moving)) {
                printResult(WIN_GAME);
                break;
            }
        } while (retry);
    }

    private BridgeGame initialize() {
        OutputView.printStart();
        return makeBridgeGame();
    }

    private BridgeGame makeBridgeGame() {
        try {
            return new BridgeGame(InputView.readBridgeSize(), new BridgeRandomNumberGenerator());
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            return makeBridgeGame();
        }
    }

    private String moving(BridgeGame bridgeGame) {
        String moving = readMoving();
        bridgeGame.move(moving);
        OutputView.printMap(ResultRepository.getUpBridgeResult(), ResultRepository.getDownBridgeResult());
        return moving;
    }

    private String readMoving() {
        try {
            return InputView.readMoving();
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            return readMoving();
        }
    }

    private boolean retryOrQuit(BridgeGame bridgeGame) {
        GameCommand gameCommand = readGameCommand();
        if (gameCommand.equals(GameCommand.RETRY)) {
            return retry(bridgeGame);
        }
        return quit(bridgeGame);
    }

    private GameCommand readGameCommand() {
        try {
            return InputView.readGameCommand();
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            return readGameCommand();
        }
    }

    private boolean retry(BridgeGame bridgeGame) {
        bridgeGame.retry();
        attemptsCount++;
        return true;
    }

    private boolean quit(BridgeGame bridgeGame) {
        printResult(LOSE_GAME);
        bridgeGame.quit();
        return false;
    }

    private void printResult(String gameResult) {
        OutputView.printFinalMap();
        OutputView.printMap(ResultRepository.getUpBridgeResult(), ResultRepository.getDownBridgeResult());
        OutputView.printResult(gameResult, attemptsCount);
    }

}
