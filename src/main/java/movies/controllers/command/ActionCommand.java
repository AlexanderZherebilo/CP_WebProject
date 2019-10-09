package movies.controllers.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ActionCommand {
    void  execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) throws ServletException, IOException;
}
