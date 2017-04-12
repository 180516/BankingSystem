package pl.banking.factories;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Random;

/**
 * Created by dpp on 4/10/17.
 */
public class Context {
    private final Random random;
    private final Clock clock;

    public Context(Random random, Clock clock) {
        this.random = random;
        this.clock = clock;
    }

    public static Context createDefaultContext() {
        return new Context(new Random(), Clock.fixed(Instant.now(), ZoneId.systemDefault()));
    }

    public Random getRandom() {
        return random;
    }

    public Clock getClock() {
        return clock;
    }

    @Override
    public String toString() {
        return "Context{" +
                "random=" + random +
                ", clock=" + clock +
                '}';
    }
}
