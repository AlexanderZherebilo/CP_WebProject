package movies.controllers.command.impl;

import movies.beans.Company;
import movies.beans.Film;
import movies.beans.Rating;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.controllers.command.impl.util.ParameterEnum;
import movies.service.impl.CompanyServiceImpl;
import movies.service.impl.FilmServiceImpl;
import movies.service.impl.RatingServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddNewCompanyCommand implements ActionCommand {
    public void execute(HttpServletRequest request, HttpServletResponse response, String logginedUser) {
        String companyName = request.getParameter(ParameterEnum.COMPANY_NAME.toString());
        int year = Integer.parseInt(request.getParameter(ParameterEnum.FOUNDING_YEAR.toString()));
        String country = request.getParameter(ParameterEnum.COMPANY_COUNTRY.toString());
        String founderName = request.getParameter(ParameterEnum.FOUNDER_NAME.toString());
        String founderSurname = request.getParameter(ParameterEnum.FOUNDER_SURNAME.toString());
        String headName = request.getParameter(ParameterEnum.HEAD_NAME.toString());
        String headSurname = request.getParameter(ParameterEnum.HEAD_SURNAME.toString());
        String site = request.getParameter(ParameterEnum.SITE.toString());
        String image =request.getParameter(ParameterEnum.COMPANY_IMAGE.toString());
        String article = request.getParameter(ParameterEnum.ARTICLE.toString());

        if (companyName.equals("") || country.equals("") || founderName.equals("") || founderSurname.equals("") || site.equals("")
                || headName.equals("") || headSurname.equals("") || year < 1900 || image.equals("") || article.equals(""))
        {
            request.setAttribute("loggined", logginedUser);

            request.setAttribute("error", "Некорректный ввод данных");
            String path = PageEnum.ADDING_COMPANY_PAGE.toString();
            ForwardRedirectHelper.provideForward(request, response, path);
        }
        else {
            CompanyServiceImpl companyService = new CompanyServiceImpl();
            Company company = companyService.getCompanyByName(companyName);

            if (company != null) {
                request.setAttribute("loggined", logginedUser);
                request.setAttribute("error", "Такая компания уже есть в списке");
                String path = PageEnum.ADDING_COMPANY_PAGE.toString();
                ForwardRedirectHelper.provideForward(request, response, path);
            }
            else {
                Company addingCompany = new Company(companyName, year, country, founderName, founderSurname, headName, headSurname, site, article, image);
                companyService.addCompany(addingCompany);
                request.setAttribute("loggined", logginedUser);

                FilmServiceImpl filmService = new FilmServiceImpl();
                int filmsNum = filmService.getAllFilms().size();
                request.setAttribute("films_number", filmsNum);

                int comaniesNum = companyService.getAllCompanies().size();
                request.setAttribute("companies_number", comaniesNum);

                List<Film> filmList = filmService.getAllFilms();
                request.setAttribute("films_list", filmList);

                List<Company> companyList = companyService.getAllCompanies();
                request.setAttribute("companies_list", companyList);

                String path = PageEnum.SITEMAP_PAGE.toString();
                ForwardRedirectHelper.provideForward(request, response, path);
            }
        }
    }
}
