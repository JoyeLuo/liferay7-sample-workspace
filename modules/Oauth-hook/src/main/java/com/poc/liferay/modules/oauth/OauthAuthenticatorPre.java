package com.poc.liferay.modules.oauth;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.auth.Authenticator;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.lang.reflect.Type;
import java.util.*;

@Component(
    immediate = true, property = {"key=auth.pipeline.pre"},
    service = Authenticator.class
)
public class OauthAuthenticatorPre implements Authenticator {
    
    private static final Log _log = LogFactoryUtil.getLog(OauthAuthenticatorPre.class);

    @Activate
    public void activate() {
        if (_log.isDebugEnabled()) {
            _log.debug("activate");
        }
    }

    @Override
    public int authenticateByEmailAddress(
            long companyId, String emailAddress, String password,
            Map<String, String[]> headerMap, Map<String, String[]> parameterMap)
        throws AuthException {
        
        System.out.println( "email login" );
        
        if (_log.isDebugEnabled()) {
            _log.debug("authenticateByEmailAddress");
        }
        try {
            return SUCCESS;
        }
        catch (Exception ae) {
            _log.error(ae.getMessage(), ae);
            throw new AuthException(ae.getMessage(), ae);
        }
    }

    @Override
    public int authenticateByScreenName(
            long companyId, String screenName, String password,
            Map<String, String[]> headerMap, Map<String, String[]> parameterMap)
        throws AuthException {

        System.out.println( "screen name login" );
        
        if (_log.isDebugEnabled()) {
            _log.debug("authenticateByScreenName  - not implemented ");
        }
        return FAILURE;
    }

    @Override
    public int authenticateByUserId(
            long companyId, long userId, String password,
            Map<String, String[]> headerMap, Map<String, String[]> parameterMap)
        throws AuthException {

        System.out.println( "userid login" );
        
        if (_log.isDebugEnabled()) {
            _log.debug("authenticateByScreenName  - not implemented ");
        }
        return FAILURE;
    }
}