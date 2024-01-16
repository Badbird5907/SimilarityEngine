package dev.badbird.diffchecker;

import dev.badbird.diffchecker.engine.DiffEngine;
import lombok.SneakyThrows;

import java.util.regex.Pattern;

public class DiffCheckerImpl implements DiffChecker {
    private static final Pattern EMPTY_LINE_PATTERN = Pattern.compile("(?m)^[ \t]*\r?\n");
    @Override
    public DiffChecker init() {
        return this;
    }

    @SneakyThrows
    @Override
    public float getSimilarity(String var1, String var2, Class<? extends DiffEngine> engineClazz) {
        return getSimilarity(var1, var2, engineClazz.getDeclaredConstructor().newInstance());
    }

    @Override
    public float getSimilarity(String var1, String var2, DiffEngine engine) {
        return engine.getSimilarity(preProcess(var1), preProcess(var2));
    }

    @Override
    public String preProcess(String var1) {
        // remove all empty lines
        var1 = EMPTY_LINE_PATTERN.matcher(var1).replaceAll("");
        return var1;
    }


}
