package lotto.model.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> createNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
