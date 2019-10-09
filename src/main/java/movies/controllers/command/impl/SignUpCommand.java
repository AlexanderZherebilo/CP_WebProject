package movies.controllers.command.impl;

import movies.beans.User;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.controllers.command.impl.util.ParameterEnum;
import movies.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class SignUpCommand implements ActionCommand {

    public void execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) {
        String name = req.getParameter(ParameterEnum.NAME.toString());
        String surname = req.getParameter(ParameterEnum.SURNAME.toString());
        String email = req.getParameter(ParameterEnum.EMAIL.toString());
        String country = req.getParameter(ParameterEnum.COUNTRY.toString());
        String login = req.getParameter(ParameterEnum.LOGIN.toString());
        String password = req.getParameter(ParameterEnum.FIRST_PASSWORD.toString());
        String repassword = req.getParameter(ParameterEnum.REPEAT_PASSWORD.toString());
        Date date = new Date();

        if (password.equals(repassword)) {
            User user = new User(login, password, email, name, surname, country, date);
            UserServiceImpl userService = new UserServiceImpl();
            boolean flag = userService.signUp(user);
            if (flag == true) {
                String path = PageEnum.AUTHORIZATION_PAGE.toString();
                ForwardRedirectHelper.provideForward(req, resp, path);
            }
            else {
                req.setAttribute("error", "Вы используете занятый логин или/и email");
                String path = PageEnum.REGISTRATION_PAGE.toString();
                ForwardRedirectHelper.provideForward(req, resp, path);
            }
        } else {
            req.setAttribute("error", "Введённые пароли не совпадают");
            String path = PageEnum.REGISTRATION_PAGE.toString();
            ForwardRedirectHelper.provideForward(req, resp, path);
        }
    }
}
