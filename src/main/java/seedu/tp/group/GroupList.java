package seedu.tp.group;

import java.util.ArrayList;
import java.util.List;

import seedu.tp.exceptions.HistoryFlashcardException;
import seedu.tp.exceptions.InvalidFlashcardIndexException;
import seedu.tp.exceptions.UnrecognizedFlashcardGroupException;
import seedu.tp.flashcard.Flashcard;
import seedu.tp.flashcard.FlashcardList;
import seedu.tp.ui.Ui;
import static seedu.tp.utils.Constants.INDEXES_FIELD;
import static seedu.tp.utils.Constants.NAME_FIELD;

/**
 * Lists of flashcard groups.
 */
public class GroupList {
    private List<FlashcardGroup> groupList;

    /**
     * Constructs a list of groups.
     */
    public GroupList(){
        this.groupList = new ArrayList<FlashcardGroup>();
    }

    /**
     * Adds a new group to the group list.
     *
     * @param group the new group to be added to the list
     */
    public void addFlashcardGroup(FlashcardGroup group){
        groupList.add(group);
    }

    /**
     *  Adds a flashcard to an existing group.
     *
     * @param ui used to prompt the user
     * @throws InvalidFlashcardIndexException if the user gives an index not an integer of out of bound
     */
    public void addFlashcardToOneGroup(Ui ui,FlashcardList flashcardList) throws HistoryFlashcardException {
        try{
            int flashcardIndex = Integer.parseInt(ui.promptUserForRequiredField(INDEXES_FIELD))-1;
            String groupName = ui.promptUserForRequiredField(NAME_FIELD);
            Flashcard flashcard = null;
            FlashcardGroup group = null;
            for(FlashcardGroup g : groupList){
                if(g.getName().equals(groupName)){
                    flashcard = flashcardList.getFlashcardAtIdx(flashcardIndex);
                    g.addFlashcardToTheGroup(flashcard);
                    group = g;
                    break;
                }
            }
            if (group != null){
                ui.confirmFlashcardAdditionToGroup(group,flashcard);
            }else{
                throw new UnrecognizedFlashcardGroupException("There is no such group.");
            }
        }catch(NumberFormatException e){
            throw new InvalidFlashcardIndexException();
        }catch(IndexOutOfBoundsException e){
            throw new InvalidFlashcardIndexException();
        }
    }
}