package lotto.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.util.ExceptionMessage;
import lotto.model.util.LottoConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersDuplication(numbers);
        validateNumbersRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toString() {
        return numbers.toString();
    }

    private void validateNumbersSize(List<Integer> numbers){
        if(numbers.size() != LottoConstants.LOTTO_SIZE.getNumber()){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_SIZE);
        }
    }

    private void validateNumbersDuplication(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_LOTTO_NUMBERS);
        }
    }

    private void validateNumbersRange(List<Integer> numbers){

        boolean invalid = numbers.stream()
                .anyMatch(n -> n < LottoConstants.MIN_LOTTO_NUMBER.getNumber() || n > LottoConstants.MAX_LOTTO_NUMBER.getNumber());

        if (invalid) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE);
        }
    }

}
