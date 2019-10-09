package movies.controllers.command.impl;

import movies.beans.Company;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.service.impl.CompanyServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToCompaniesList implements ActionCommand {
    public void execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) {
        preparePage(req, logginedUser);
        String path = PageEnum.COMPANIES_PAGE.toString();
        ForwardRedirectHelper.provideForward(req, resp, path);
    }

    private void preparePage(HttpServletRequest request, String loggined) {
        request.setAttribute("loggined", loggined);
        CompanyServiceImpl companyService = new CompanyServiceImpl();
        List<Company> companies = companyService.getAllCompanies();
        request.setAttribute("companies_list", companies);
    }
}
