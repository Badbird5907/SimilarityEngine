package dev.badbird.diffchecker.engine;

public interface DiffEngine {
    void init();
    float getSimilarity(String var1, String var2);
}
