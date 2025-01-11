package HW13Debugging;

public interface WalkThroughUserLinkedListInterface {

    /**
     * UserLinkedList has the following private field and no others:
     * private UserNode headNode;
     */

    /**
     * UserLinkedList has a constructor with the following parameters:
     * modifier - public
     * name UserLinkedList
     * parameters - none
     * constructs a new UserLinkedList and sets the headNode to null.
     */

    /**
     * public boolean addUserNode(String name);
     * Inserts a newly constructed UserNode at the end of the UserLinkList represented by
     * the private class field headNode.
     * If the list headNode is null, creates a new userNode with the given name and set it as this
     * UserLinkedList's headNode and return true.
     * If the String name input is equal to the name field of a UserNode already in the UserLinkedList,
     * do not add a new node and return false.
     * Important: The list must stay connected!
     * @param name The String name of the node to be appended to the UserLinkedList
     * @return Returns true if the UserNode is successfully added to the list and false if it already exists.
     */

    boolean addUserNode(String name);

    /**
     * public void printUserList();
     * Starting at the UserNode pointed at by headPointer. Traverse the list and print each nodes name on a new line.
     * You should use println() and getName to do this.
     * If the headNode is null it should print "List is null!"
     */

    void printUserList();
}
