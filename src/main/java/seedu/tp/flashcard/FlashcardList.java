package seedu.tp.flashcard;

import seedu.tp.exceptions.InvalidFlashcardIndexException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * List of flashcards.
 */
public class FlashcardList {
    private List<Flashcard> flashcards;

    /**
     * Constructor for FlashcardList.
     */
    public FlashcardList() {
        this.flashcards = new ArrayList<Flashcard>();
    }

    public FlashcardList(List<Flashcard> flashcardList) {
        this.flashcards = new ArrayList<>();
        this.flashcards.addAll(flashcardList);
    }

    /**
     * Copy constructor for FlashcardList.
     * Note that this is a shallow copy.
     *
     * @param flashcardList the flashcard list to be copied from
     */
    public FlashcardList(FlashcardList flashcardList) {
        this.flashcards = new ArrayList<>();
        for (int i = 0; i < flashcardList.getTotalFlashcardNum(); i++) {
            this.flashcards.add(flashcardList.getFlashcardAtIdx(i));
        }
    }

    /**
     * Adds a flashcard to the list.
     *
     * @param flashcard the task to be added to the list
     * @return the updated flashcardList with new flashcard just be added in
     */
    public FlashcardList addFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
        return this;
    }

    /**
     * Deletes a flashcard from the list.
     *
     * @param index the index of the flashcard to be deleted
     * @return the deleted flashcard
     */
    public Flashcard deleteFlashcard(int index) throws InvalidFlashcardIndexException {
        try {
            return flashcards.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidFlashcardIndexException();
        }
    }

    /**
     * Gets the flashcard at a specific index.
     *
     * @param idx the index.
     * @return the flashcard at the specified index
     */
    public Flashcard getFlashcardAtIdx(int idx) {
        return flashcards.get(idx);
    }

    /**
     * Checks if the flashcard list is empty.
     *
     * @return boolean value indicating whether or not the flashcard list is empty
     */
    public boolean isEmpty() {
        return flashcards.isEmpty();
    }

    /**
     * Gets the total number of flashcards in the list.
     *
     * @return total number of flashcards in the list
     */
    public int getTotalFlashcardNum() {
        return flashcards.size();
    }

    /**
     * Gets the list of flashcards.
     *
     * @return the list of flashcards
     */
    public List<Flashcard> getFlashcards() {
        return flashcards;
    }

    /**
     * Check if the current instance is equal to the object passed in.
     *
     * @param obj The object to be compared against the current instance
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        FlashcardList otherFlashcards = (FlashcardList) obj;
        if (this.getTotalFlashcardNum() != otherFlashcards.getTotalFlashcardNum()) {
            return false;
        }

        List<Flashcard> flashcardList = new ArrayList<Flashcard>(this.getFlashcards());
        Collections.sort(flashcardList);
        List<Flashcard> otherFlashcardList = new ArrayList<Flashcard>(otherFlashcards.getFlashcards());
        Collections.sort(otherFlashcardList);

        for (int idx = 0; idx < this.getTotalFlashcardNum(); idx++) {
            if (!flashcardList.get(idx).equals(otherFlashcardList.get(idx))) {
                return false;
            }
        }
        return true;
    }
}
