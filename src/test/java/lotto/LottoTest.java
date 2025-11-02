package lotto;

import lotto.model.Lotto;
import lotto.model.util.ExceptionMessage;
import lotto.model.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
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
        assertThatThrownBy(() ->
                Validator.validateBonusDuplicateWithWinNumbers(bonusNumber,winNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATED_BONUS_NUMBER);

    }
}
