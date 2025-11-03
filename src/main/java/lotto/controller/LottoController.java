package lotto.controller;

import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.ResultRank;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputHandler inputHandler;

    public LottoController(LottoService lottoService, InputHandler inputHandler){
        this.lottoService = lottoService;
        this.inputHandler = inputHandler;
    }

    public void run(){

        int price = inputHandler.inputPriceUntilValid();
        int count = lottoService.calculateLottoCount(price);

        LottoGenerator lottoGenerator = printAndGetRandomLottos(count);

        Lotto winNumbers = inputHandler.inputWinningNumbersUntilValid();
        int bonusNumber = inputHandler.inputBonusNumberUntilValid();

        Map<ResultRank, Integer> result = lottoService.lottoCalculater(lottoGenerator, winNumbers, bonusNumber);
        double profitRate = lottoService.calculateProfitRate(result, price);

        printResult(result, profitRate);
    }

    private LottoGenerator printAndGetRandomLottos(int count) {
        OutputView.printPurchaseCount(count);
        LottoGenerator lottoGenerator = lottoService.generateLotto(count);
        OutputView.printRandomLotto(lottoGenerator.getNumbers());
        return lottoGenerator;
    }

    private void printResult(Map<ResultRank, Integer> result, double profitRate) {
        OutputView.printLottoResult(result);
        OutputView.printLottoProfitRate(profitRate);
    }
}
