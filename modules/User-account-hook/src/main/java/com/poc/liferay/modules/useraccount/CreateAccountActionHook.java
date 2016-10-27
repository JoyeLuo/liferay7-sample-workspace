package com.poc.liferay.modules.useraccount;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

@Component(
        property =
                {
                    "javax.portlet.name=com_liferay_login_web_portlet_LoginPortlet",
                    "mvc.command.name=/login/create_account",
                    "service.ranking:Integer=100"
                }, service = MVCActionCommand.class)
public class CreateAccountActionHook extends BaseMVCActionCommand {
    Log _log = LogFactoryUtil.getLog(CreateAccountActionHook.class);

    @Reference(
        target = 
        "(&(mvc.command.name=/login/create_account)" +
        "(javax.portlet.name=com_liferay_login_web_portlet_LoginPortlet)" +
        "(component.name=com.liferay.login.web.internal.portlet.action.CreateAnonymousAccountMVCActionCommand))"
        )
    public void setMvcActionCommand(MVCActionCommand mvcActionCommand) {
        this.mvcActionCommand = mvcActionCommand;
    }

    public MVCActionCommand getMvcActionCommand() {
        return this.mvcActionCommand;
    }

    protected MVCActionCommand mvcActionCommand;

    @Activate
    public void activate() {
        
        System.out.println( "create account active" );
        if (_log.isDebugEnabled()) {
            _log.debug("activate");
        }
    }

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        
        System.out.println( "create account doProcessAction" );
        
        _log.debug("Inside doProcessAction of CreateAccountActionHook");
        mvcActionCommand.processAction(actionRequest, actionResponse);
        if (SessionErrors.isEmpty(actionRequest)) {
            _log.debug("No errors found!!!!");
        }
    }

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        System.out.println( "create account processAction" );
        
        _log.debug("Inside processAction of CreateAccountActionHook");
        return super.processAction(actionRequest, actionResponse);
    }

}