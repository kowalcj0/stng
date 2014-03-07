package org.stng.tests.notworkingrunners;

import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.stng.tests.steps.JBehaveFirstStorySteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

/**
 * Created by jk on 03/03/14.
 */
public class SimpleJBehave  extends JUnitStories {

    public SimpleJBehave() {
        super();
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new JBehaveFirstStorySteps());
    }
/*
    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("src/test/java/stories/firstTestStory.story");
    }*/

    @Override
    protected List<String> storyPaths() {
        String filter = System.getProperty("story.filter", "**/*.story");
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), filter, "**/failing_before*.story");
    }
}
