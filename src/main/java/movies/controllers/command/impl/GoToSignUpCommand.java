package movies.controllers.command.impl;

import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.controllers.command.impl.util.ParameterEnum;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToSignUpCommand implements ActionCommand {
    private static Logger logger = Logger.getLogger(GoToSignUpCommand.class);

    public void execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) {
        String path = PageEnum.REGISTRATION_PAGE.toString();
        ForwardRedirectHelper.provideForward(req, resp, path);
    }
}
