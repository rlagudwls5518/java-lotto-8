package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.PurchaseInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseInfoTest {

    @DisplayName("구매 금액 입력이 1000원 단위가 아닌경우")
    @Test
    void 구매_금액_입력이_1000원_단위가_아닌경우() {

        //given
        PurchaseInfo purchaseInfo1 = new PurchaseInfo(3400);
        PurchaseInfo purchaseInfo2 = new PurchaseInfo(5780);
        PurchaseInfo purchaseInfo3 = new PurchaseInfo(5555);

        //when
        int count1 = purchaseInfo1.perchanceCount();
        int count2 = purchaseInfo2.perchanceCount();
        int count3 = purchaseInfo3.perchanceCount();

        //then
        assertThat(count1).isEqualTo(3);
        assertThat(count2).isEqualTo(5);
        assertThat(count3).isEqualTo(5);;
    }

    @DisplayName("구매 금액 입력이 1000원 단위가 아닌경우")
    @Test
    void 구매_금액_입력이_1000원_단위일_경우() {

        //given
        PurchaseInfo purchaseInfo1 = new PurchaseInfo(123000);
        PurchaseInfo purchaseInfo2 = new PurchaseInfo(8000);
        PurchaseInfo purchaseInfo3 = new PurchaseInfo(5544000);

        //when
        int count1 = purchaseInfo1.perchanceCount();
        int count2 = purchaseInfo2.perchanceCount();
        int count3 = purchaseInfo3.perchanceCount();

        //then
        assertThat(count1).isEqualTo(123);
        assertThat(count2).isEqualTo(8);
        assertThat(count3).isEqualTo(5544);;
    }
}
