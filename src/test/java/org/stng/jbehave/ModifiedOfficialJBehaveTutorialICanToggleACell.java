package org.stng.jbehave;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.stng.jbehave.steps.JBehaveFirstStorySteps;
import org.stng.jbehave.steps.JBehaveSecondStorySteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;


/**
 * This class allows to run JBehave stories as JUnit tests
 * I used http://jbehave.org/reference/stable/getting-started.html as a basis.
 * */
public class ModifiedOfficialJBehaveTutorialICanToggleACell extends JUnitStories {

    // Here we specify the configuration, starting from default MostUsefulConfiguration, and changing only what is needed
    @Override
    public Configuration configuration() {
        System.out.println("org.stng.jbehave.ModifiedOfficialJBehaveTutorialICanToggleACell.configuration");
        return new MostUsefulConfiguration()
                // where to find the stories
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                        // CONSOLE and TXT reporting
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT));
    }

    // Here we specify the steps classes
    @Override
    public InjectableStepsFactory stepsFactory() {
        // varargs, can have more that one steps classes
        System.out.println("org.stng.jbehave.ModifiedOfficialJBehaveTutorialICanToggleACell.stepsFactory");
        return new InstanceStepsFactory(configuration(), new JBehaveFirstStorySteps(), new JBehaveSecondStorySteps());
    }

    @Override
    protected List<String> storyPaths() {
        System.out.println("org.stng.jbehave.ModifiedOfficialJBehaveTutorialICanToggleACell.storyPaths");
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "**/failing_before*.story");
    }
}