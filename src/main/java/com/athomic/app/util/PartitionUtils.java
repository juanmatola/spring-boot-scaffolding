package com.athomic.app.util;

import java.util.*;

/**
 * Utility class for partitioning collections into multiple partitions.
 * <p>
 * This class provides static methods for partitioning a collection into sublists using different strategies:
 * <ul>
 *     <li>Chunk Partitioning: Splits the collection into a specified number of partitions with approximately equal size.</li>
 *     <li>Round-Robin Partitioning: Distributes elements of the collection evenly across the specified number of partitions.</li>
 * </ul>
 * This class is final and cannot be instantiated.
 * </p>
 */
public final class PartitionUtils {

    /**
     * Private constructor to prevent instantiation of the utility class.
     * <p>
     * Throws an {@link UnsupportedOperationException} to indicate that this class cannot be instantiated.
     * </p>
     */
    private PartitionUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * Partitions a collection into a specified number of chunks.
     * <p>
     * This method divides the collection into a number of partitions such that each partition contains a contiguous subset
     * of the collection. The size of each partition is approximately equal.
     * </p>
     *
     * @param collection    the {@link Collection} to be partitioned
     * @param numPartitions the number of partitions to create
     * @param <T>           the type of elements in the collection
     * @return a {@link List} of {@link List}s, where each inner {@link List} represents a partition
     * @throws IllegalArgumentException if {@code numPartitions} is less than or equal to 0, or if {@code collection} is null
     */
    public static <T> List<List<T>> chunkPartition(Collection<T> collection, int numPartitions) {

        validateInputs(collection, numPartitions);

        List<List<T>> partitions = new ArrayList<>();
        int partitionSize = (int) Math.ceil((double) collection.size() / numPartitions);
        Iterator<T> iterator = collection.iterator();

        for (int i = 0; i < numPartitions; i++) {
            List<T> partition = new ArrayList<>();
            for (int j = 0; j < partitionSize && iterator.hasNext(); j++) {
                partition.add(iterator.next());
            }
            partitions.add(partition);
        }

        return Collections.unmodifiableList(partitions);
    }

    /**
     * Partitions a collection into a specified number of partitions using round-robin distribution.
     * <p>
     * This method distributes the elements of the collection across the specified number of partitions such that
     * elements are distributed evenly, with each partition receiving elements in a round-robin fashion.
     * </p>
     *
     * @param collection    the {@link Collection} to be partitioned
     * @param numPartitions the number of partitions to create
     * @param <T>           the type of elements in the collection
     * @return a {@link List} of {@link List}s, where each inner {@link List} represents a partition
     * @throws IllegalArgumentException if {@code numPartitions} is less than or equal to 0, or if {@code collection} is null
     */
    public static <T> List<List<T>> roundRobinPartition(Collection<T> collection, int numPartitions) {

        validateInputs(collection, numPartitions);

        List<List<T>> partitions = new ArrayList<>(numPartitions);
        for (int i = 0; i < numPartitions; i++) {
            partitions.add(new ArrayList<>());
        }

        int index = 0;
        for (T item : collection) {
            partitions.get(index % numPartitions).add(item);
            index++;
        }

        return Collections.unmodifiableList(partitions);
    }

    /**
     * Validates the inputs for partitioning methods.
     * <p>
     * This method checks that the number of partitions is greater than 0 and that the collection is not null.
     * </p>
     *
     * @param collection    the {@link Collection} to be validated
     * @param numPartitions the number of partitions to be validated
     * @param <T>           the type of elements in the collection
     * @throws IllegalArgumentException if {@code numPartitions} is less than or equal to 0, or if {@code collection} is null
     */
    private static <T> void validateInputs(Collection<T> collection, int numPartitions) {
        if (numPartitions <= 0) {
            throw new IllegalArgumentException("The number of partitions must be greater than 0.");
        }
        if (collection == null) {
            throw new IllegalArgumentException("The collection cannot be null.");
        }
    }

}
