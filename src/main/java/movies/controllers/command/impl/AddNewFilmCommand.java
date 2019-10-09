package movies.controllers.command.impl;

import movies.beans.Company;
import movies.beans.Film;
import movies.beans.Rating;
import movies.beans.User;
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

public class AddNewFilmCommand implements ActionCommand {

    public void execute(HttpServletRequest request, HttpServletResponse response, String logginedUser) {
        String filmName = request.getParameter(ParameterEnum.FILM_NAME.toString());
        String genre = request.getParameter(ParameterEnum.FILM_GENRE.toString());
        String company = request.getParameter(ParameterEnum.COMPANY.toString());
        String directorName = request.getParameter(ParameterEnum.DIRECTOR_NAME.toString());
        String directorSurname = request.getParameter(ParameterEnum.DIRECTOR_SURNAME.toString());
        String rating = request.getParameter(ParameterEnum.RATING.toString());
        double budget = Double.parseDouble(request.getParameter(ParameterEnum.BUDGET.toString()));
        double box_office = Double.parseDouble(request.getParameter(ParameterEnum.BOX_OFFICE.toString()));
        int year = Integer.parseInt(request.getParameter(ParameterEnum.FILM_YEAR.toString()));
        String image = request.getParameter(ParameterEnum.IMAGE.toString());
        String article = request.getParameter(ParameterEnum.ARTICLE.toString());

        CompanyServiceImpl companyService = new CompanyServiceImpl();
        int companyId = companyService.getCompanyByName(company).getId();

        if (filmName.equals("") || genre.equals("") || directorName.equals("") || directorSurname.equals("")
                || budget <= 0 || box_office <= 0 || year < 1900 || image.equals("") || article.equals(""))
        {
            request.setAttribute("loggined", logginedUser);

            List<Company> companyList = companyService.getAllCompanies();
            request.setAttribute("companies_list", companyList);

            RatingServiceImpl ratingService = new RatingServiceImpl();
            List<Rating> ratingList = ratingService.getAll();
            request.setAttribute("rating_list", ratingList);
            request.setAttribute("error", "Некорректный ввод данных");
            String path = PageEnum.ADDING_FILM_PAGE.toString();
            ForwardRedirectHelper.provideForward(request, response, path);
        }
        else {
            FilmServiceImpl filmService = new FilmServiceImpl();
            Film repeat_film = filmService.getFilmByName(filmName);

            if (repeat_film != null) {
                request.setAttribute("loggined", logginedUser);
                request.setAttribute("error", "Фильм с таким названием уже добавлен");

                int filmsNum = filmService.getAllFilms().size();
                request.setAttribute("films_number", filmsNum);

                int comaniesNum = companyService.getAllCompanies().size();
                request.setAttribute("companies_number", comaniesNum);

                String path = PageEnum.ADDING_FILM_PAGE.toString();
                ForwardRedirectHelper.provideForward(request, response, path);
            }
            else {
                Film film = new Film(filmName, genre, companyId, directorName, directorSurname, rating, budget, box_office, year, article, image);
                filmService.addFilm(film);
                request.setAttribute("loggined", logginedUser);

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
