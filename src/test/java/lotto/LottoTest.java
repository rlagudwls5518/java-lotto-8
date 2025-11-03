package lotto;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.ResultRank;
import lotto.model.WinninLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("생성 갯수만큼 로또 객체를 생성한다")
    @Test
    void createsLottoObjects_byTheGivenNumber(){
        //given
        int count = 7;
        LottoGenerator lottoGenerator = new LottoGenerator(count);
        List<Lotto> generatedLottos = lottoGenerator.getNumbers();

        // then
        assertEquals(7, generatedLottos.size());
    }
    @DisplayName("로또번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void throwsException_whenLottoNumbersAreMoreThanSix() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void throwsException_whenLottoNumbersAreDuplicated() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45까지가 아니면 예외가 발생한다")
    @Test
    void 로또_번호가_1_45까지가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 46, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호랑 보너스 번호랑 중복될 수 없다.")
    @Test
    void BonusNumberDuplicatesWinningNumber(){

        // given
        Lotto winNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 3;

        // when & then
        assertThatThrownBy(() -> new WinninLotto(bonusNumber, winNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개 일치 시 1등을 반환한다")
    void returnFirstRankWhenMatch6() {
        assertThat(ResultRank.valueOf(6, false))
                .isEqualTo(ResultRank.FIRST);
    }

    @Test
    @DisplayName("5개 + 보너스 일치 시 2등을 반환한다")
    void returnSecondRankWhenMatch5AndBonus() {
        assertThat(ResultRank.valueOf(5, true))
                .isEqualTo(ResultRank.SECOND);
    }

    @Test
    @DisplayName("5개 일치 시 3등을 반환한다")
    void returnThirdRankWhenMatch5() {
        assertThat(ResultRank.valueOf(5, false))
                .isEqualTo(ResultRank.THIRD);
    }

    @Test
    @DisplayName("4개 일치 시 4등을 반환한다")
    void returnFourthRankWhenMatch4() {
        assertThat(ResultRank.valueOf(4, false))
                .isEqualTo(ResultRank.FOURTH);
    }

    @Test
    @DisplayName("3개 일치 시 5등을 반환한다")
    void returnFifthRankWhenMatch3() {
        assertThat(ResultRank.valueOf(3, false))
                .isEqualTo(ResultRank.FIFTH);
    }

    @Test
    @DisplayName("2개 이하 일치 시 당첨되지 않는다(null 반환)")
    void returnNullWhenNoWinningCondition() {
        assertThat(ResultRank.valueOf(2, false)).isEqualTo(null);
        assertThat(ResultRank.valueOf(1, false)).isEqualTo(null);
        assertThat(ResultRank.valueOf(0, false)).isEqualTo(null);
    }
}
