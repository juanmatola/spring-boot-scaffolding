package com.athomic.app.util;

/**
 * Utility class for String operations.
 */
public final class StringUtils {

    /**
     * Ellipsis to append to truncated strings.
     */
    public static final String ELLIPSIS = "...";

    /**
     * Private constructor to prevent instantiation of the utility class.
     * <p>
     * Throws an {@link UnsupportedOperationException} to indicate that this class cannot be instantiated.
     * </p>
     */
    private StringUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * Limits the given string to a specified maximum length and appends an ellipsis ("...")
     * if the string is truncated.
     *
     * @param input     the input string to be limited
     * @param maxLength the maximum length of the resulting string, including the ellipsis
     * @return the truncated string with an ellipsis appended if it was truncated, or the original string if its length is less than or equal to maxLength
     */
    public static String limit(String input, int maxLength) {
        if (input == null || input.length() <= maxLength) {
            return input;
        }
        return input.substring(0, (maxLength - ELLIPSIS.length())) + ELLIPSIS;
    }
}
