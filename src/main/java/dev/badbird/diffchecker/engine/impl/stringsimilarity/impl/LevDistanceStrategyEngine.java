package dev.badbird.diffchecker.engine.impl.stringsimilarity.impl;

import dev.badbird.diffchecker.engine.impl.stringsimilarity.JStringSimilarityEngine;
import net.ricecode.similarity.LevenshteinDistanceStrategy;
import net.ricecode.similarity.SimilarityStrategy;

public class LevDistanceStrategyEngine extends JStringSimilarityEngine {
    @Override
    public SimilarityStrategy getService() {
        return new LevenshteinDistanceStrategy();
    }
}
