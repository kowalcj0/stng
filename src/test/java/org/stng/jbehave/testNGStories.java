package org.stng.jbehave;

import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.embedder.Embedder;

import java.util.List;

/**
 * Created by jk on 12/03/14.
 * This class is a simple replacement of JUnitStories.
 * It simply annotates run() method as TestNG test!!
 */
public abstract class testNGStories extends ConfigurableEmbedder {

    @org.testng.annotations.Test
    public void run() throws Throwable {
        Embedder embedder = configuredEmbedder();
        try {
            embedder.runStoriesAsPaths(storyPaths());
        } finally {
            embedder.generateCrossReference();
        }
    }

    protected abstract List<String> storyPaths();

}