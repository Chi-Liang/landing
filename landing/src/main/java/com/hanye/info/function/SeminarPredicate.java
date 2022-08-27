package com.hanye.info.function;

@FunctionalInterface
public interface SeminarPredicate<T, S, R> {
	boolean test(T t, S s, R r);
}
