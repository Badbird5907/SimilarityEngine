package dev.badbird.diffchecker.engine.impl.stringsimilarity.impl;

import dev.badbird.diffchecker.engine.impl.stringsimilarity.JStringSimilarityEngine;
import net.ricecode.similarity.JaroWinklerStrategy;
import net.ricecode.similarity.SimilarityStrategy;

public class JaroWinklerStrategyEngine extends JStringSimilarityEngine {

    @Override
    public SimilarityStrategy getService() {
        return new JaroWinklerStrategy();
    }
}
