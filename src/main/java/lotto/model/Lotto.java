package lotto.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.util.ExceptionMessage;

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
        if(numbers.size() != 6){
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
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 45;

        boolean invalid = numbers.stream()
                .anyMatch(n -> n < MIN_NUMBER || n > MAX_NUMBER);

        if (invalid) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE);
        }
    }

}
