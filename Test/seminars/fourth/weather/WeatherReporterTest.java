package seminars.fourth.weather;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class WeatherReporterTest {

    @Test
    void testWeatherReporter() {
        WeatherService service = mock(WeatherService.class);
        WeatherReporter reporter = new WeatherReporter(service);
        reporter.generateReport();
        verify(service).getCurrentTemperature();
    }

}