package pl.edu.agh.eaiib.auctions.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.edu.agh.eaiib.auctions.service.AuthService;
import pl.edu.agh.eaiib.auctions.service.AuthServiceImpl;
import pl.edu.agh.eaiib.auctions.utils.Utils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml" })
public class AuthServiceTest {
    @Autowired
    AuthService authService;

    private static final Logger log = Logger.getLogger(AuthServiceTest.class);

    @SuppressWarnings("null")
    @Test
    public void amAccountLoginTest() {
        List<String> error = new ArrayList<String>();

        WebServiceContext context = Mockito.mock(WebServiceContext.class);
        MessageContext msgContext = Mockito.mock(MessageContext.class);
        Map<Object, Object> http_headers = new HashMap<Object, Object>();
        http_headers.put(AuthServiceImpl.USERNAME_PROPERTY, Arrays.asList(new String[] { "AMaccount" }));
        http_headers.put(AuthServiceImpl.PASSWORD_PROPERTY, Arrays.asList(new String[] { "1234567" }));
        Mockito.when(msgContext.get(MessageContext.HTTP_REQUEST_HEADERS)).thenReturn(http_headers);
        Mockito.when(context.getMessageContext()).thenReturn(msgContext);

        ((AuthServiceImpl) authService).setDemo(false);

        // auth success
        Assert.assertTrue(authService.hasManagementPrivileges(context, "AMaccount", error));
        Assert.assertTrue(error.isEmpty());

        // user missmatch
        Assert.assertFalse(authService.hasManagementPrivileges(context, "JohnDoe", error));
        Assert.assertFalse(error.isEmpty());
        Assert.assertTrue(error.get(0).contains("missmatch"));
        log.warn(error);
        error.clear();

        http_headers.put(AuthServiceImpl.USERNAME_PROPERTY, Arrays.asList(new String[] { "Caccount" }));
        // bad role missmatch
        Assert.assertFalse(authService.hasManagementPrivileges(context, "Caccount", error));
        Assert.assertFalse(error.isEmpty());
        Assert.assertTrue(error.get(0).contains("role"));
        log.warn(error);
        error.clear();

        // no account role missmatch
        http_headers.put(AuthServiceImpl.USERNAME_PROPERTY, Arrays.asList(new String[] { "BADaccount" }));
        Assert.assertFalse(authService.hasManagementPrivileges(context, "BADaccount", error));
        Assert.assertFalse(error.isEmpty());
        Assert.assertTrue(error.get(0).contains("return code"));
        log.warn(error);
        error.clear();
    }

    @SuppressWarnings("null")
    @Test
    public void clientAccountLoginTest() {
        List<String> error = new ArrayList<String>();

        WebServiceContext context = Mockito.mock(WebServiceContext.class);
        MessageContext msgContext = Mockito.mock(MessageContext.class);
        Map<Object, Object> http_headers = new HashMap<Object, Object>();
        http_headers.put(AuthServiceImpl.USERNAME_PROPERTY, Arrays.asList(new String[] { "Caccount" }));
        http_headers.put(AuthServiceImpl.PASSWORD_PROPERTY, Arrays.asList(new String[] { "1234567" }));
        Mockito.when(msgContext.get(MessageContext.HTTP_REQUEST_HEADERS)).thenReturn(http_headers);
        Mockito.when(context.getMessageContext()).thenReturn(msgContext);

        ((AuthServiceImpl) authService).setDemo(false);

        // auth success
        Assert.assertTrue(authService.hasClientPrivileges(context, "Caccount", error));
        Assert.assertTrue(error.isEmpty());

        // user missmatch
        Assert.assertFalse(authService.hasClientPrivileges(context, "JohnDoe", error));
        Assert.assertFalse(error.isEmpty());
        Assert.assertTrue(error.get(0).contains("missmatch"));
        log.warn(error);
        error.clear();

        http_headers.put(AuthServiceImpl.USERNAME_PROPERTY, Arrays.asList(new String[] { "AMaccount" }));
        // bad role missmatch
        Assert.assertFalse(authService.hasClientPrivileges(context, "AMaccount", error));
        Assert.assertFalse(error.isEmpty());
        Assert.assertTrue(error.get(0).contains("role"));
        log.warn(error);
        error.clear();

        // no account role missmatch
        http_headers.put(AuthServiceImpl.USERNAME_PROPERTY, Arrays.asList(new String[] { "BADaccount" }));
        Assert.assertFalse(authService.hasClientPrivileges(context, "BADaccount", error));
        Assert.assertFalse(error.isEmpty());
        Assert.assertTrue(error.get(0).contains("return code"));
        log.warn(error);
        error.clear();
    }

    @Test
    public void emailTest() {
        Assert.assertTrue(Utils.isEmail(authService.getEmail("AMaccount")));
        Assert.assertFalse(Utils.isEmail(authService.getEmail("BADaccount")));
        Assert.assertNull(authService.getEmail("BADaccount"));
    }
}
