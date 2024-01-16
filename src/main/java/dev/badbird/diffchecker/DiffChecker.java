package dev.badbird.diffchecker;

import dev.badbird.diffchecker.engine.DiffEngine;

public interface DiffChecker {
    DiffChecker init();

    float getSimilarity(String var1, String var2, Class<? extends DiffEngine> engineClazz);
    float getSimilarity(String var1, String var2, DiffEngine engine);
    String preProcess(String var1);
}
