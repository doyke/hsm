package pl.mwojcik.domain.model.util;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class RandomStringUtil {

    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    public static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String LOWER = UPPER.toLowerCase(Locale.ROOT);

    public static final String DIGITS = "0123456789";

    public static final String ALPHANUM = UPPER + LOWER + DIGITS;

    private final Random random;

    private final char[] symbols;

    private final char[] buf;

    public RandomStringUtil(int length, Random random, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }


    public RandomStringUtil(int length, Random random) {
        this(length, random, ALPHANUM);
    }


    public RandomStringUtil(int length) {
        this(length, new SecureRandom());
    }

    public RandomStringUtil() {
        this(21);
    }

}
