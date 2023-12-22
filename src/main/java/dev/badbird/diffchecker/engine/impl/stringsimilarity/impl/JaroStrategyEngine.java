package dev.badbird.diffchecker.engine.impl.stringsimilarity.impl;

import dev.badbird.diffchecker.engine.impl.stringsimilarity.JStringSimilarityEngine;
import net.ricecode.similarity.JaroStrategy;
import net.ricecode.similarity.SimilarityStrategy;

public class JaroStrategyEngine extends JStringSimilarityEngine {
    @Override
    public SimilarityStrategy getService() {
        return new JaroStrategy();
    }
}
