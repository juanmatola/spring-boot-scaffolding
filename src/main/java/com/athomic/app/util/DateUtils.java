package com.athomic.app.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Utility class for validating time intervals.
 * <p>
 * This class provides a method to validate whether a given time interval between two {@link LocalDateTime} instances
 * is within a specified maximum duration.
 * </p>
 */
public class DateUtils {

    /**
     * Private constructor to prevent instantiation of the utility class.
     * <p>
     * Throws an {@link UnsupportedOperationException} to indicate that this class cannot be instantiated.
     * </p>
     */
    private DateUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * Validates that the time interval between the specified start and end times does not exceed the maximum allowed duration.
     * <p>
     * This method checks if the duration between {@code startTime} and {@code endTime} is less than or equal to the
     * specified {@code maxDuration}. The duration is measured using the specified {@link ChronoUnit}.
     * </p>
     *
     * @param startTime   the start time of the interval (cannot be {@code null})
     * @param endTime     the end time of the interval (cannot be {@code null})
     * @param maxDuration the maximum allowed duration for the interval, in units of {@code unit} (must be greater than 0)
     * @param unit        the {@link ChronoUnit} used to measure the duration (cannot be {@code null})
     * @throws IllegalArgumentException if {@code startTime}, {@code endTime}, or {@code unit} is {@code null}, or if
     *                                  {@code maxDuration} is less than or equal to 0, or if the duration between {@code startTime} and {@code endTime}
     *                                  exceeds {@code maxDuration}
     */
    public static void validateTimeInterval(LocalDateTime startTime, LocalDateTime endTime, long maxDuration, ChronoUnit unit) {
        Assert.notNull(startTime, "startTime cannot be null.");
        Assert.notNull(endTime, "endTime cannot be null.");
        Assert.notNull(unit, "unit cannot be null.");
        Assert.isTrue(maxDuration > 0, "maxDuration must be greater than 0.");

        long duration = unit.between(startTime, endTime);

        if (duration > maxDuration) {
            throw new IllegalArgumentException("The time interval cannot be greater than " + maxDuration + " " + unit.toString().toLowerCase() + "(s).");
        }
    }

}