package movies.controllers.command.impl;

import movies.beans.Company;
import movies.beans.Film;
import movies.beans.Rating;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.service.impl.CompanyServiceImpl;
import movies.service.impl.FilmServiceImpl;
import movies.service.impl.RatingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EditSelectedCompanyCommand implements ActionCommand {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) throws ServletException, IOException {
        int selectedCompanyId = Integer.parseInt(req.getParameter("company_select_update"));
        CompanyServiceImpl companyService = new CompanyServiceImpl();
        Company myCompany = companyService.getCompanyById(selectedCompanyId);

        preparePage(req, logginedUser, myCompany);
        String path = PageEnum.EDITING_COMPANY_PAGE.toString();
        ForwardRedirectHelper.provideForward(req, resp, path);
    }

    private void preparePage(HttpServletRequest request, String loggined, Company myCompany) {
        request.setAttribute("loggined", loggined);

        myCompany.setImage(myCompany.getImage().substring(29));
        System.out.println(myCompany.toString());
        request.setAttribute("company_edit", myCompany);
    }

}
