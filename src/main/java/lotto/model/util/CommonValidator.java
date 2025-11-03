package lotto.model.util;

public class CommonValidator {
    public static final String NUMBER_REGEX = "^[0-9]+$";

    private CommonValidator() {}

    public static void validateIsNumber(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT);
        }
    }
}
