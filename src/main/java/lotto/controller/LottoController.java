package lotto.controller;

import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.ResultRank;
import lotto.model.util.LottoValidator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService){
        this.lottoService = lottoService;
    }

    public void run(){

        int price = inputPriceUntilValid();
        int count = printAndGetLottoCount(price);
        LottoGenerator lottoGenerator = printAndGetRandomLottos(count);
        Lotto winNumbers = inputWinningNumbersUntilValid();
        int bonusNumber = inputBonusNumber(winNumbers);

        Map<ResultRank, Integer> result = lottoService.lottoCalculater(lottoGenerator, winNumbers, bonusNumber);
        double profitRate = lottoService.calculateProfitRate(result, price);

        printResult(result, profitRate);
    }

    private int printAndGetLottoCount(int price) {
        int count = lottoService.calculateLottoCount(price);
        OutputView.printPurchaseCount(count);
        return count;
    }

    private LottoGenerator printAndGetRandomLottos(int count) {
        LottoGenerator lottoGenerator = lottoService.generateLotto(count);
        OutputView.printRandomLotto(lottoGenerator.getNumbers());
        return lottoGenerator;
    }

    private int inputBonusNumber(Lotto winNumbers) {
        OutputView.printInputBonusNumber();
        String inputBonusNumber = InputView.input();
        LottoValidator.validBonusNumber(inputBonusNumber, winNumbers);
        return Integer.parseInt(inputBonusNumber);
    }

    private void printResult(Map<ResultRank, Integer> result, double profitRate) {
        OutputView.printLottoResult(result);
        OutputView.printLottoProfitRate(profitRate);
    }

    private int inputPriceUntilValid() {
        while (true) {
            try {
                return BuyLotto();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private int BuyLotto(){
        OutputView.printInputPrice();
        String inputPrice = InputView.input();
        LottoValidator.validInputPriceIsNumber(inputPrice);
        return Integer.parseInt(inputPrice);
    }

    private Lotto inputWinningNumbersUntilValid() {
        while (true) {
            try {
                OutputView.printInputWinLotto();
                String[] input = InputView.input().split(",");
                return lottoService.winLotto(input);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
