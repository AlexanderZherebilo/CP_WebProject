package movies.controllers;

public enum PageEnum {
    AUTHORIZATION_PAGE("WEB-INF/jsp/main/authorization-page.jsp"),
    REGISTRATION_PAGE("WEB-INF/jsp/main/registration-page.jsp"),
    WELCOME_PAGE("WEB-INF/jsp/welcome-page.jsp"),
    RAITING_PAGE("WEB-INF/jsp/raiting-list.jsp"),
    COMPANIES_PAGE("WEB-INF/jsp/companies-list.jsp"),
    SITEMAP_PAGE("WEB-INF/jsp/sitemap.jsp"),
    FILMS_PAGE("WEB-INF/jsp/films-list.jsp"),
    SINGLE_FILM("WEB-INF/jsp/film.jsp"),
    ADDING_FILM_PAGE("WEB-INF/jsp/adding-film.jsp"),
    ADDING_COMPANY_PAGE("WEB-INF/jsp/adding-company.jsp"),
    EDITING_COMPANY_PAGE("WEB-INF/jsp/editing-company.jsp"),
    EDITING_FILM_PAGE("WEB-INF/jsp/editing-film.jsp");

    private String path;

    PageEnum(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
