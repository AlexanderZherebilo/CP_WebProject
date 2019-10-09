package movies.controllers.command.impl;

import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.controllers.command.impl.util.ParameterEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignOutCommand implements ActionCommand {

    public void execute(HttpServletRequest request, HttpServletResponse response, String logginedUser) {
        String path = PageEnum.AUTHORIZATION_PAGE.toString();
        ForwardRedirectHelper.provideForward(request, response, path);
    }
}
