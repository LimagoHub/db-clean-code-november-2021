package de;

public interface YAC<T> {

    boolean eq(T Other);
    boolean lt(T Other);

    default boolean le (T other) {
        return eq(other) || lt(other);
    }
}
