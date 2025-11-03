package lotto.service;

import java.util.Map;
import lotto.model.LottoCalculator;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.ProfitCalculator;
import lotto.model.PurchaseInfo;
import lotto.model.ResultRank;
import lotto.model.WinninLotto;


public class LottoService {

    public int calculateLottoCount(int price) {
        PurchaseInfo purchaseInfo = new PurchaseInfo(price);
        return purchaseInfo.perchanceCount();
    }

    public LottoGenerator generateLotto(int count) {
        return new LottoGenerator(count);
    }

    public Map<ResultRank, Integer> lottoCalculater(LottoGenerator lottoGenerator, Lotto winNumbers,int bonusNumber){
        WinninLotto winninLotto = new WinninLotto(bonusNumber, winNumbers);
        LottoCalculator calculator = new LottoCalculator(lottoGenerator.getNumbers(),
                winninLotto.getWinLottos(), winninLotto.getBonusNumber());
        return calculator.calculateWinningResult();
    }

    public double calculateProfitRate(Map<ResultRank, Integer> result, int purchaseAmount){
        ProfitCalculator profitCalculator = new ProfitCalculator(purchaseAmount, result);
        return  profitCalculator.calculateProfitRate();
    }
}
