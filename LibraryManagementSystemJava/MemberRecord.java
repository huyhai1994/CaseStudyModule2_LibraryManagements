
import java.util.*;

/**
 * The member class gives each member a unique ID.
 * It also shows the date of membership, the maximum number of books they might
 * check out,
 * and the members’ names and addresses. It will also show the books currently
 * checked out
 * and the books that have been returned.
 */
public class MemberRecord {

    /**
     * Default constructor
     */
    public MemberRecord() {
    }

    /**
     * 
     */
    private int memberID;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String dateOfMembership;

    /**
     * 
     */
    private int noBookIssued;

    /**
     * 
     */
    private int maxBookIssued;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String address;

    /**
     * @return
     */
    public String retriveMember() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public int increaseBookIssued() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int decreaseBookIssued() {
        // TODO implement here
        return 0;
    }

    /**
     * The member class gives each member a unique ID.
     * It also shows the date of membership, the maximum number of books they might
     * check out,
     * and the members’ names and addresses.
     * It will also show the books currently checked out and the books that have
     * been returned.
     * 
     * @return
     */
    public double payBill() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @return
     */
    public boolean returnBook() {
        // TODO implement here
        return false;
    }

}