package runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

// Below is used when we don't have Junit Platform Properties
//@Suite
//@IncludeEngines("cucumber")
//@SelectClasspathResource("features")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepDefinations")


@Suite
@IncludeEngines("cucumber")
/*SelectClasspathResource ----This always gives all the details inside the package
 * [WARNING] Tests run: 2, Failures: 0, Errors: 0, Skipped: 1 so we need to used @SelectClasspathResource("features")----> @SelectPackages ("features") */
@SelectPackages("features")


public class TestRunner {
}
