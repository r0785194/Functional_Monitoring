package Setup;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import refleqt.MonitoringApplication;

@RunWith(Cucumber.class)
@SpringBootTest(classes = { MonitoringApplication.class,
                    RunnerTest.class})
@CucumberOptions(plugin = {"pretty", "json:target/cucumber-reports/json/report.json"},glue = ("steps"), features = "src/test/resources/features")
public class RunnerTest {
}
