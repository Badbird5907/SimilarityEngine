package dev.badbird.diffchecker.engine.impl;

import dev.badbird.diffchecker.engine.DiffEngine;
import dev.badbird.simhash.SimHash;
import dev.badbird.simhash.hash.HashAlgorithm;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SimHashEngine implements DiffEngine {
    private HashAlgorithm hashAlgorithm;
    @Override
    public void init() {

    }

    @Override
    public float getSimilarity(String var1, String var2) {
        long hash1 = SimHash.simHash(var1, hashAlgorithm);
        long hash2 = SimHash.simHash(var2, hashAlgorithm);
        return (float) SimHash.calculateSimilarity(hash1, hash2);
    }
}
