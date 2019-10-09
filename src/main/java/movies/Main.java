package movies;

import movies.beans.Comment;
import movies.beans.Company;
import movies.beans.Film;
import movies.beans.User;
import movies.dao.CompanyDao;
import movies.dao.impl.*;
import movies.service.UserService;
import movies.service.impl.RatingServiceImpl;
import movies.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*FilmDaoImpl filmDao = new FilmDaoImpl();
        Film film = new Film("Человек-паук", "приключения", 4, "Джон", "Уоттс", "PG-13", 175000000, 880166924, 2017, "Человек паук ва", "asdasdaasd");
        filmDao.save(film);*/

        /*CommentDaoImpl commentDao = new CommentDaoImpl();
        System.out.println(commentDao.findAll().toString());*/

        /*CompanyDaoImpl companyDao = new CompanyDaoImpl();
        Company company = new Company("asd", 1934, "asd", "asd", "asd", "asd", "asd", "asd", "asd","asd");
        companyDao.save(company);*/

        /*RatingDaoImpl ratingDao = new RatingDaoImpl();
        System.out.println(ratingDao.findAll().toString());*/

        /*UserDaoImpl userDao = new UserDaoImpl();
        System.out.println(userDao.findAll().toString());*/

        FilmDaoImpl filmDao = new FilmDaoImpl();
        System.out.println(filmDao.searchByGenre("боевик").toString());
    }
}
