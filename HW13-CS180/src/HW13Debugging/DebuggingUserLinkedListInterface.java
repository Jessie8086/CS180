package HW13Debugging;

public interface DebuggingUserLinkedListInterface extends WalkThroughUserLinkedListInterface {

    /**
     * See the comments in WalkThroughUserLinkedListInterface for additional information
     */

    /**
     * public boolean insertUserNode(String name);
     * Inserts a newly constructed UserNode alphabetically by name into the UserLinkList represented by
     * the private class field headNode.
     * If the list headNode is null, creates a new userNode with the given name and set it as this
     * UserLinkedList's headNode and return true.
     * If the String name input is equal to the name field of a UserNode already in the UserLinkedList,
     * do not insert a node and return false.
     * Important: The list must stay connected!
     * Helpful hint: Be careful in situations where the newly made node should become the headNode.
     * @param name The String name to be added alphabetically to the UserLinkedList
     * @return Returns true if the UserNode is successfully added to the list and false if it already exists.
     */

    boolean insertUserNode(String name);

    /**
     * public boolean deleteUserNode(String name);
     * Traverse the linked list and locate the node with the given String name.
     * Remove that node from the linked list if it exists and return true.
     * Important: The list must stay connected!
     * If a UserNode does not have the given name in the UserLinkedList return false.
     * @param name The String name to be found in the UserLinkedList and deleted
     * @return Returns true if the UserNode with the given name was removed from the list
     * Returns false if the UserNode does not exist in the list. (be careful about empty/null lists)
     */

    boolean deleteUserNode(String name);
}
