package dev.badbird.diffchecker.engine.impl.stringsimilarity;

import dev.badbird.diffchecker.engine.DiffEngine;
import net.ricecode.similarity.*;

public abstract class JStringSimilarityEngine implements DiffEngine {
    @Override
    public void init() {

    }

    @Override
    public float getSimilarity(String var1, String var2) {
        StringSimilarityService service = new StringSimilarityServiceImpl(getService());

        return (float) service.score(var1, var2);
    }

    public abstract SimilarityStrategy getService();
}
