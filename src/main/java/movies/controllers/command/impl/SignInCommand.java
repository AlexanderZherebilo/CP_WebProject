package movies.controllers.command.impl;

import movies.beans.User;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.controllers.command.impl.util.ParameterEnum;
import movies.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.hibernate.internal.util.xml.ErrorLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

public class SignInCommand implements ActionCommand {

    public void execute(HttpServletRequest request, HttpServletResponse response, String logginedUser) {
        String login = request.getParameter(ParameterEnum.LOGIN.toString());
        String password = request.getParameter(ParameterEnum.PASSWORD.toString());

            UserServiceImpl userService = new UserServiceImpl();
            boolean isValidParameters = userService.signIn(login, password);
            if (isValidParameters) {
                preparePage(request, logginedUser);
                String path = PageEnum.WELCOME_PAGE.toString();
                ForwardRedirectHelper.provideForward(request, response, path);
            }
            else {
                request.setAttribute("error", "Указан неверный логин и/или пароль");
                String path = PageEnum.AUTHORIZATION_PAGE.toString();
                ForwardRedirectHelper.provideForward(request, response, path);
            }
    }

    private void preparePage(HttpServletRequest request, String loggined) {
        request.setAttribute("loggined", loggined);
    }

}
