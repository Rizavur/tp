package seedu.duke.ui;

import seedu.duke.data.Favourite;
import seedu.duke.exception.EmptyFavouriteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.exception.SameBlockException;

public class FavouriteUi extends UiManager {

    /**
     * This method gets the routing information to be saved as favourites by calling the router ui class.
     * @return A pair of starting and destination blocks are returned, where starting block is stored in the first index
     *          of the array and the destination block is stored in the second index of the array.
     * @throws SameBlockException If the same start and destination blocks are entered by the user.
     */
    public String[] getFavouriteInfo() throws SameBlockException {
        return new RouterUi().getRoutingInfo();
    }

    /**
     * This method lists out all the favourite routes that have been stored by the user.
     * @param favourite The instance of the favourites data model.
     * @throws EmptyFavouriteException If there are no favourites stored.
     * @throws InvalidIndexException If the specified index in the favourites list does not exist.
     */
    public void showFavourites(Favourite favourite) throws EmptyFavouriteException, InvalidIndexException {
        if (favourite.isEmpty()) {
            throw new EmptyFavouriteException();
        } else {
            showMessage("Here are your favourite routes:");
            for (int i = 0; i < favourite.getFavouriteSize(); i++) {
                String[] routeInfo = favourite.getSpecificEntry(i);
                showMessage((i + 1) + ". " + routeInfo[0] + " -> " + routeInfo[1]);
            }
            showMessage(CommonMessage.DIVIDER);
        }
    }

    /**
     * This method gets the index of the favourites entry that the user wants to delete.
     * @return The index number of the favourites entry that is to be deleted.
     * @throws InvalidIndexException If the index to be deleted is not an integer that is within the bounds.
     */
    public int getDeleteIndex() throws InvalidIndexException {
        return new NoteUi().getDeleteIndex();
    }

    /**
     * This method gets the index of the favourites entry that the user wants to repeat.
     * @return The index number of the favourites entry that is to be repeated.
     * @throws InvalidIndexException If the index to be deleted is not an integer that is within the bounds.
     */
    public int getRepeatIndex() throws InvalidIndexException {
        return new HistoryUi().getRepeatIndex();
    }
}
