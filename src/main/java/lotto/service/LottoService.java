package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.Calculator;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.ProfitCalculator;
import lotto.model.PurchaseInfo;
import lotto.model.ResultRank;


public class LottoService {

    public int calculateLottoCount(int price) {
        PurchaseInfo purchaseInfo = new PurchaseInfo(price);
        return purchaseInfo.perchanceCount();
    }

    public LottoGenerator generateLotto(int count) {
        return new LottoGenerator(count);
    }

    public Lotto winLotto(String[] input){
        List<Integer> lottoInputNumbers = new ArrayList<>();
        for(String a : input){
            lottoInputNumbers.add(Integer.parseInt(a));
        }
        return new Lotto(lottoInputNumbers);

    }
    public Map<ResultRank, Integer> lottoCalculater(LottoGenerator lottoGenerator, Lotto winNumbers,int bonusNumber){
        //계산로직
        Calculator calculator = new Calculator(lottoGenerator.getNumbers(),
                winNumbers.getNumbers(), bonusNumber);
        return calculator.calculateWinningResult();
    }

    public double calculateProfitRate(Map<ResultRank, Integer> result, int purchaseAmount){
        //수익률계산로직
        ProfitCalculator profitCalculator = new ProfitCalculator(purchaseAmount, result);
        return  profitCalculator.calculateProfitRate();
    }
}
