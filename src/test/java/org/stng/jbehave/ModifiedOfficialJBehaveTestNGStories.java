package org.stng.jbehave;

import org.apache.log4j.Logger;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.stng.jbehave.steps.JBehaveFirstStorySteps;
import org.stng.jbehave.steps.JBehaveSecondStorySteps;

import java.util.List;
import java.util.Properties;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;


/**
 * This class allows to run JBehave stories as JUnit tests
 * I used http://jbehave.org/reference/stable/getting-started.html as a basis.
 * */
public class ModifiedOfficialJBehaveTestNGStories extends testNGStories {

    static Logger log = Logger.getLogger(ModifiedOfficialJBehaveTestNGStories.class);
    
    // Here we specify the configuration, starting from default MostUsefulConfiguration, and changing only what is needed
    @Override
    public Configuration configuration() {
        // partially based upon http://jbehave.org/reference/stable/reporting-stories.html
        log.info("configuration()");
        Class<? extends Embeddable> embeddableClass = this.getClass();
        Properties viewResources = new Properties();
        viewResources.put("decorateNonHtml", "true");
        return new MostUsefulConfiguration()
                // where to find the stories
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                 // CONSOLE and TXT reporting
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                                .withDefaultFormats()
                                .withPathResolver(new FilePrintStreamFactory.ResolveToPackagedName())
                                .withViewResources(viewResources)
                                .withFormats(Format.CONSOLE, Format.HTML, Format.XML, Format.TXT)
                                .withFailureTrace(true)
                                .withFailureTraceCompression(true));
    }

    // Here we specify the steps classes
    @Override
    public InjectableStepsFactory stepsFactory() {
        // varargs, can have more that one steps classes
        log.info("stepsFactory()");
        return new InstanceStepsFactory(configuration(), new JBehaveFirstStorySteps(), new JBehaveSecondStorySteps());
    }

    @Override
    protected List<String> storyPaths() {
        log.info("storyPaths()");
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "**/failing_before*.story");
    }
}