package org.stng.jbehave.notworkingrunners;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromPath;

/**
 * Created by jk on 03/03/14.
 */
public class JBehaveStoryRunner {


    @Test
    public void runClasspathLoadedStoriesAsJUnit() {
        // Embedder defines the configuration and candidate steps
        Embedder embedder = new JBehaveJUnitStoryEmbedder();
        List<String> storyPaths = storyPaths(); // use StoryFinder to look up paths
        embedder.runStoriesAsPaths(storyPaths);
    }

    protected List<String> storyPaths() {
        //return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
        return new StoryFinder().findPaths(codeLocationFromPath("src/test/java/stories").getFile(),
                asList("**/" + System.getProperty("storyFilter", "*") + ".story"), null);
    }
}
