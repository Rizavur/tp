package seedu.duke.command;

import seedu.duke.data.*;

public abstract class Command {
    protected NusMap nusMap;
    protected BlockAlias blockAlias;
    protected History history;
    protected Favourite favourite;
    protected DailyRoute dailyRoute;
    protected boolean isExit;

    public Command() {
    }

    public void setData(NusMap nusMap, BlockAlias blockAlias, History history,
                        Favourite favourite, DailyRoute dailyRoute) {
        this.nusMap = nusMap;
        this.blockAlias = blockAlias;
        this.history = history;
        this.favourite = favourite;
        this.dailyRoute = dailyRoute;
    }

    public boolean isExit() {
        return isExit;
    }

    public void execute() {
    }
}
