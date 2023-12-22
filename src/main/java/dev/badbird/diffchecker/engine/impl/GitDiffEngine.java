package dev.badbird.diffchecker.engine.impl;

import dev.badbird.diffchecker.engine.DiffEngine;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.util.UUID;

public class GitDiffEngine implements DiffEngine {
    @Override
    public void init() {

    }

    @SneakyThrows
    @Override
    public float getSimilarity(String var1, String var2) {
        // write this into two files in temp
        String tmpdir = System.getProperty("java.io.tmpdir");
        File file1 = new File(tmpdir + "/" + UUID.randomUUID() + ".txt");
        File file2 = new File(tmpdir + "/" + UUID.randomUUID() + ".txt");
        file1.deleteOnExit();
        file2.deleteOnExit();
        // write the strings to the files
        Files.write(file1.toPath(), var1.getBytes());
        Files.write(file2.toPath(), var2.getBytes());
        // run git diff
        ProcessBuilder builder = new ProcessBuilder("git", "diff", "--no-index", "--word-diff=porcelain", "--word-diff-regex=.", file1.getAbsolutePath(), file2.getAbsolutePath());
        builder.redirectErrorStream(true);
        Process process = builder.start();
        String output = new String(process.getInputStream().readAllBytes());
        // delete the files
        file1.delete();
        file2.delete();
        // parse the output
        String[] lines = output.split("\n");
        int additions = 0;
        int deletions = 0;
        for (String line : lines) {
            if (line.startsWith("+"))
                additions++;
            else if (line.startsWith("-"))
                deletions++;
        }
        // calculate the similarity
        float similarity = (float) (additions + deletions) / (float) (var1.length() + var2.length());
        return 1 - similarity;
    }
}
