package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.UiManager;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidDayException;
import seedu.duke.routing.Router;
import seedu.duke.DaySchedulePair;


public class AddDailyRouteCommand extends Command {


    public AddDailyRouteCommand(String userInput) {
        super(userInput);

    }

    @Override
    public void execute(Router router, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute) {
        DaySchedulePair dayAndRoute;
        try {
            dayAndRoute = ui.getDailyRouteInfo();
            assert dayAndRoute != null;
            dailyRoute.addDailyRoute(dayAndRoute.getDay(), dayAndRoute.getSchedule());
        } catch (InvalidDayException e) {
            ui.showToUser(e.getMessage());
        } catch (InvalidBlockException r) {
            ui.showToUser(r.getMessage());
        }
    }
}