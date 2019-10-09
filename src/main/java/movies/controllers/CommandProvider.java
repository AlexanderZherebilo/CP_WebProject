package movies.controllers;

import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<Commands,ActionCommand> commands=new HashMap<Commands, ActionCommand>();

    public CommandProvider() {
        final Commands signUp = Commands.SIGN_UP;
        final Commands signIn = Commands.SIGN_IN;
        final Commands goToSignUp = Commands.GOTO_SIGN_UP;
        final Commands goToRaiting = Commands.GOTO_RAITING_LIST;
        final Commands goToCompanies = Commands.GOTO_COMPANIES_LIST;
        final Commands goToHome = Commands.GOTO_HOME;
        final Commands goToNavigation = Commands.GOTO_NAVIGATION;
        final Commands goToFilms = Commands.GOTO_FILMS_LIST;
        final Commands goToAddingFilm = Commands.GOTO_ADDING_FILM;
        final Commands goToAddingCompany = Commands.GOTO_ADDING_COMPANY;
        final Commands showSingleFilm = Commands.SHOW_FILM_COMMENTS;
        final Commands addNewComment = Commands.ADD_NEW_COMMENT;
        final Commands signOut = Commands.SIGN_OUT;
        final Commands addOneFilm = Commands.ADD_NEW_FILM;
        final Commands addOneCompany = Commands.ADD_NEW_COMPANY;
        final Commands deleteOneFilm = Commands.DELETE_SELECTED_FILM;
        final Commands deleteOneCompany = Commands.DELETE_SELECTED_COMPANY;
        final Commands goToEditingCompany = Commands.EDIT_SELECTED_COMPANY;
        final Commands goToEditingFilm = Commands.EDIT_SELECTED_FILM;
        final Commands confurmEditingCompany = Commands.EDIT_COMPANY;
        final Commands confurmEditingFilm = Commands.EDIT_FILM;
        final Commands deleteComment = Commands.DELETE_MY_COMMENT;
        final Commands searchFilms = Commands.SEARCH_FILM;
        final Commands sortFilms = Commands.SORT;
        final Commands sortReverseFilms = Commands.SORT_DESC;

        commands.put(signUp,new SignUpCommand());
        commands.put(signIn, new SignInCommand());
        commands.put(goToSignUp, new GoToSignUpCommand());
        commands.put(signOut, new SignOutCommand());
        commands.put(goToRaiting, new GoToRaitingList());
        commands.put(goToCompanies, new GoToCompaniesList());
        commands.put(goToHome, new GoToHomePage());
        commands.put(goToNavigation, new GoToNavigation());
        commands.put(goToFilms, new GoToFilmsList());
        commands.put(goToAddingFilm, new GoToAddingFilmCommand());
        commands.put(goToAddingCompany, new GoToAddingCompanyCommand());
        commands.put(showSingleFilm, new ShowSingleFilmCommand());
        commands.put(addNewComment, new AddNewCommentCommand());
        commands.put(addOneFilm, new AddNewFilmCommand());
        commands.put(addOneCompany, new AddNewCompanyCommand());
        commands.put(deleteOneFilm, new DeleteSelectedFilmCommand());
        commands.put(deleteOneCompany, new DeleteSelectedCompanyCommand());
        commands.put(goToEditingCompany, new EditSelectedCompanyCommand());
        commands.put(goToEditingFilm, new EditSelectedFilmCommand());
        commands.put(confurmEditingCompany, new ConfurmEditingCompanyCommand());
        commands.put(confurmEditingFilm, new ConfurmEditingFilmCommand());
        commands.put(deleteComment, new DeleteCommentCommand());
        commands.put(searchFilms, new SearchFilmsCommand());
        commands.put(sortFilms, new SortFilmsCommand());
        commands.put(sortReverseFilms, new SortFilmsReverseCommand());
    }

    public ActionCommand takeCommand(String command){
        final String uppercaseCommand = command.toUpperCase();
        Commands commandName= Commands.valueOf(uppercaseCommand);
        return  commands.get(commandName);
    }
}
