
import java.util.*;

/**
 * https://vi.wikipedia.org/wiki/Th%E1%BB%A7_th%C6%B0
 * 
 *  The librarian class gives each librarian an ID number. It also shows the librarian’s name and shows which books they have issued and returned. Librarians may verify members and order books.
 */
public class Librarian {

    /**
     * Default constructor
     */
    public Librarian() {
    }

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String password;

    /**
     * @return
     */
    public String searchBooks() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public boolean verifyMember() {
        // TODO implement here
        return false;
    }

    /**
     * ‘Issue’ has more of the meaning of ‘give’ than ‘take’. The general public ‘borrow’ (take temporarily) a book from the library.
     * The librarian (or the machine) ‘issues’, that is gives the book to the borrower and records the borrower’s name so that they can be chased up if the book isn’t returned on time.
     * @return
     */
    public String issueBook() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public double calculateFIne() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @return
     */
    public String createBill() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public boolean returnBook() {
        // TODO implement here
        return false;
    }

}