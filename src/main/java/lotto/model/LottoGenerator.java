package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.util.RandomNumberGenerator;

public class LottoGenerator  {
    private final List<Lotto> lottos = new ArrayList<>();
    private final int count;

    public LottoGenerator(int count) {
        this.count = count;
        createLottos();
    }

    private void createLottos(){
        for(int i=0; i<count; i++){
            lottos.add(new Lotto(RandomNumberGenerator.createNumbers()));
        }
    }

    public List<Lotto> getNumbers(){
        return lottos;
    }
}
