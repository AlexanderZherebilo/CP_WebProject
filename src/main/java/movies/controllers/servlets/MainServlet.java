package movies.controllers.servlets;

import movies.beans.User;
import movies.controllers.CommandProvider;
import movies.controllers.Commands;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ParameterEnum;
import movies.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    private  final CommandProvider commandProvider=new CommandProvider();
    private static String logginedUser;

    private static Logger logger = Logger.getLogger(MainServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter(ParameterEnum.COMMAND.toString());
        ActionCommand mainCommand = commandProvider.takeCommand(commandName);
        if (commandName.equals("sign_in"))
            setSignedUser(req);
        mainCommand.execute(req, resp, logginedUser);
    }

    private static void setSignedUser(HttpServletRequest request) {
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserByEmail(request.getParameter(ParameterEnum.LOGIN.toString()));
        if (user != null) {
            logginedUser = user.getLoginUser();
        }
        else
        logginedUser = request.getParameter(ParameterEnum.LOGIN.toString());
    }

}
