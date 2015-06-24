package controllers;

import play.mvc.*;
import singletones.ModelSingleton;
import ua.intor.api.IntorModelBasicAPI;
import ua.intor.api.helpers.UserCategory;
import ua.intor.api.helpers.UserEcoMissionState;
import ua.intor.api.helpers.UserJob;
import ua.intor.api.helpers.UserProblem;
import ua.intor.exceptions.UserWithSuchLoginNotFoundException;

@With(Secure.class)
public class Application extends Controller {

    private static IntorModelBasicAPI api = ModelSingleton.getInstance().getApi();

    public static void index() {
        render();
    }

    public static void submit(String login) {
        Application.userDignity(login);
    }

    public static void userDignity(String login) {
        try {
            boolean ecoMission = getEcoMissionStatus(api.getUserEcoMissionState(login));
            boolean category = getCategoryStatus(api.getUserCategory(login));
            boolean problem = getProblemStatus(api.getUserProblem(login));
            boolean job = getJobStatus(api.getUserJob(login));
            render(login, ecoMission, category, problem, job);
        } catch (UserWithSuchLoginNotFoundException e) {
            Application.index();
        }
    }

    public static void setEcoMission(String login, boolean toConfirm) {
        try {
            UserEcoMissionState state = toConfirm ? UserEcoMissionState.CONFIRMED : UserEcoMissionState.NOT_CONFIRMED;
            api.setUserEcoMissionState(login, state);
            Application.userDignity(login);
        } catch (UserWithSuchLoginNotFoundException e) {
            Application.index();
        }
    }

    public static void setCategory(String login, boolean toConfirm) {
        try {
            UserCategory state = toConfirm ? UserCategory.DOCTOR : UserCategory.NONE;
            api.setUserCategory(login, state);
            Application.userDignity(login);
        } catch (UserWithSuchLoginNotFoundException e) {
            Application.index();
        }
    }

    public static void setProblem(String login, boolean toConfirm) {
        try {
            UserProblem state = toConfirm ? UserProblem.BANKRUPT : UserProblem.NONE;
            api.setUserProblem(login, state);
            Application.userDignity(login);
        } catch (UserWithSuchLoginNotFoundException e) {
            Application.index();
        }
    }

    public static void setJob(String login, boolean toConfirm) {
        try {
            UserJob state = toConfirm ? UserJob.CLEANER : UserJob.NONE;
            api.setUserJob(login, state);
            Application.userDignity(login);

        } catch (UserWithSuchLoginNotFoundException e) {
            Application.index();
        }
    }

    private static boolean getEcoMissionStatus(UserEcoMissionState state) {
        return state == UserEcoMissionState.CONFIRMED;
    }

    private static boolean getCategoryStatus(UserCategory state) {
        return state != UserCategory.NONE;
    }

    private static boolean getProblemStatus(UserProblem state) {
        return state != UserProblem.NONE;
    }

    private static boolean getJobStatus(UserJob state) {
        return state != UserJob.NONE;
    }
}