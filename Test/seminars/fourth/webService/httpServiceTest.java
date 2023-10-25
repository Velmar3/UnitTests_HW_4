package seminars.fourth.webService;

import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class httpServiceTest {
    @Test
    void httpRequestTest() {

        HttpClient httpClient = mock(HttpClient.class);
        WebService webService = new WebService(httpClient);
        when(httpClient.getHTTPRequest(anyString())).thenReturn("site");

        webService.getHTTP("url");

        verify(httpClient, times(1)).getHTTPRequest(anyString());
    }
}
