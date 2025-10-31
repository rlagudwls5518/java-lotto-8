package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.Calculator;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.ProfitCalculator;
import lotto.model.PurchaseInfo;
import lotto.model.ResultRank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){

        List<Integer> lottoInputNumbers = new ArrayList<>();

        outputView.printInputPrice();
        int price = Integer.parseInt(inputView.input());

        PurchaseInfo purchaseInfo = new PurchaseInfo(price);
        LottoGenerator lottoGenerator = new LottoGenerator(purchaseInfo.perchanceCount());

        outputView.printPurchaseCount(purchaseInfo.perchanceCount());
        outputView.printRandomLotto(lottoGenerator.getNumbers());


        outputView.printInputWinLotto();
        String[] input = inputView.input().split(",");
        for(String a : input){
            lottoInputNumbers.add(Integer.parseInt(a));
        }
        Lotto winNumber = new Lotto(lottoInputNumbers);


        outputView.printInputBonusNumber();
        int bonusNumber = Integer.parseInt(inputView.input());



        Calculator calculator = new Calculator(lottoGenerator.getNumbers(),
                winNumber.getNumbers(), bonusNumber);

        Map<ResultRank, Integer> result = calculator.calculateWinningResult();

        ProfitCalculator profitCalculator = new ProfitCalculator(price, result);

        outputView.printLottoResult(result);

        outputView.printlottoProfitRate(profitCalculator.calculateProfitRate());

    }
}
