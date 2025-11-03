package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.util.LottoConstants;
import lotto.model.util.RandomNumberGenerator;

public class LottoGenerator implements RandomNumberGenerator {
    private final List<Lotto> lottos = new ArrayList<>();
    private final int count;

    public LottoGenerator(int count) {
        this.count = count;
        createLottos();
    }

    private void createLottos() {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(createNumbers()));
        }
    }

    public List<Lotto> getNumbers() {
        return lottos;
    }

    @Override
    public List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_LOTTO_NUMBER.getNumber(),
                LottoConstants.MAX_LOTTO_NUMBER.getNumber(), LottoConstants.LOTTO_SIZE.getNumber());
    }
}
