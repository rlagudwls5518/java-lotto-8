package lotto;

import lotto.controller.InputHandler;
import lotto.controller.LottoController;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        InputHandler inputHandler = new InputHandler();

        LottoController controller = new LottoController(lottoService, inputHandler);
        controller.run();
    }
}
