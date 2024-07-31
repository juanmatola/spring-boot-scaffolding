package com.athomic.app.util;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * Utility class for performing operations on {@link Collection} objects.
 * <p>
 * This abstract class provides static methods to safely handle collections and check their state.
 * </p>
 */
public abstract class CollectionsUtils {

    /**
     * Private constructor to prevent instantiation of the utility class.
     * <p>
     * Throws an {@link UnsupportedOperationException} to indicate that this class cannot be instantiated.
     * </p>
     */
    private CollectionsUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * Returns a {@link Stream} of the elements in the collection, or an empty stream if the collection is {@code null}.
     * <p>
     * This method provides a safe way to create a stream from a collection that might be {@code null}, avoiding
     * potential {@link NullPointerException} issues.
     * </p>
     *
     * @param collection the {@link Collection} to create a stream from
     * @param <T>        the type of elements in the collection
     * @return a {@link Stream} of elements from the collection, or an empty {@link Stream} if the collection is {@code null}
     */
    public static <T> Stream<T> safeStream(Collection<T> collection) {
        return collection == null
                ? Stream.empty()
                : collection.stream();
    }

    /**
     * Checks if a collection is not {@code null} and not empty.
     * <p>
     * This method provides a convenient way to check the state of a collection to determine if it contains any elements
     * and is not {@code null}.
     * </p>
     *
     * @param collection the {@link Collection} to check
     * @param <T>        the type of elements in the collection
     * @return {@code true} if the collection is not {@code null} and not empty, {@code false} otherwise
     */
    public static <T> boolean isNotEmpty(Collection<T> collection) {
        return collection != null && !collection.isEmpty();
    }

}
