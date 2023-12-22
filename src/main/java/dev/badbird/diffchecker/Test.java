package dev.badbird.diffchecker;

import dev.badbird.diffchecker.engine.impl.GitDiffEngine;
import dev.badbird.diffchecker.engine.impl.stringsimilarity.impl.DiceCoefficientStrategyEngine;
import dev.badbird.diffchecker.engine.impl.stringsimilarity.impl.JaroStrategyEngine;
import dev.badbird.diffchecker.engine.impl.stringsimilarity.impl.JaroWinklerStrategyEngine;
import dev.badbird.diffchecker.engine.impl.stringsimilarity.impl.LevDistanceStrategyEngine;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;

public class Test {
    @SneakyThrows
    public static void main(String[] args) {
        String text1 = new String(Files.readAllBytes(new File("1.txt").toPath())), text2 = new String(Files.readAllBytes(new File("2.txt").toPath()));
        DiffChecker checker = new DiffCheckerImpl().init();
        System.out.println("Git: " + checker.getSimilarity(text1, text2, GitDiffEngine.class));
        System.out.println("DiceCoefficentStrategy: " + checker.getSimilarity(text1, text2, DiceCoefficientStrategyEngine.class));
        System.out.println("JaroStrategy: " + checker.getSimilarity(text1, text2, JaroStrategyEngine.class));
        System.out.println("JaroWinklerStrategy: " + checker.getSimilarity(text1, text2, JaroWinklerStrategyEngine.class));
        System.out.println("LevDistanceStrategy: " + checker.getSimilarity(text1, text2, LevDistanceStrategyEngine.class));
    }
}
