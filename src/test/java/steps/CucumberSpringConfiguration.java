package steps;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import refleqt.MonitoringApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = MonitoringApplication.class)
public class CucumberSpringConfiguration {
}
