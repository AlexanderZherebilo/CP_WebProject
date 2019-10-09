package movies.controllers.command.impl.util;

public enum ParameterEnum {
    LOGIN("login"),
    PASSWORD("password"),
    FIRST_PASSWORD("first_password"),
    REPEAT_PASSWORD("repeat_password"),
    EMAIL("email"),
    NAME("name"),
    SURNAME("surname"),
    COUNTRY("country"),
    COMMAND("command"),
    FILM_NAME("film_name"),
    FILM_GENRE("film_genre"),
    COMPANY("company"),
    DIRECTOR_NAME("director_name"),
    DIRECTOR_SURNAME("director_surname"),
    RATING("rating"),
    BUDGET("budget"),
    BOX_OFFICE("box_office"),
    FILM_YEAR("film_year"),
    ARTICLE("article"),
    IMAGE("film-image"),
    COMPANY_NAME("company_name"),
    FOUNDING_YEAR("founding_year"),
    COMPANY_COUNTRY("company_country"),
    FOUNDER_NAME("founder_name"),
    FOUNDER_SURNAME("founder_surname"),
    HEAD_NAME("head_name"),
    HEAD_SURNAME("head_surname"),
    SITE("site"),
    COMPANY_IMAGE("company-image"),
    ADMIN("admin"),
    COUNT_PAGES("countPages"),
    CORRENT_PAGE("currentPage"),
    CLIENT("client"),
    PAGE("page"),
    RATE("rate"),
    COMMENT("comment"),
    LOGIN_TO_COMMENT("login_to_comment"),
    FILM_ID("film_id"),
    IMG("img");

    private String value;
    ParameterEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
