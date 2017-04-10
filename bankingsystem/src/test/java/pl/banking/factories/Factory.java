package pl.banking.factories;


import java.util.function.Function;

/**
 * Created by dpp on 4/10/17.
 */
@FunctionalInterface
public interface Factory<T> extends Function<Context, T> {


}
