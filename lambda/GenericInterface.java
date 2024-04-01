package demo.lambda.java;

@FunctionalInterface
public interface GenericInterface<T> {

	T func(T t);
}
