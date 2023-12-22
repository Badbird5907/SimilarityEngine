package dev.badbird.diffchecker.engine.impl.stringsimilarity.impl;

import dev.badbird.diffchecker.engine.impl.stringsimilarity.JStringSimilarityEngine;
import net.ricecode.similarity.DiceCoefficientStrategy;
import net.ricecode.similarity.SimilarityStrategy;

public class DiceCoefficientStrategyEngine extends JStringSimilarityEngine {

    @Override
    public SimilarityStrategy getService() {
        return new DiceCoefficientStrategy();
    }
}
