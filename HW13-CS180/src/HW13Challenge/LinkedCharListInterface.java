package HW13Challenge;

import HW13Challenge.LinkedCharList;

public interface LinkedCharListInterface {

    /**
     * HW13Challenge.LinkedCharList has the following private field and no others:
     * private HW13Challenge.CharNode headNode;
     */

    /**
     * HW13Challenge.LinkedCharList has a constructor with the following parameters:
     * modifier - public
     * name HW13Challenge.LinkedCharList
     * parameters - none
     * constructs a new HW13Challenge.LinkedCharList and sets the headNode to null.
     */

    /**
     * public void constructCharList
     * Set the headNode of this HW13Challenge.LinkedCharList to be a new HW13Challenge.CharNode who's char value c is sets to the first character
     * of the char array listChars. Then in order, add each remaining char of the array to the list.
     * Important: the order matters.
     * Note: this method sets the headNode regardless if it already existed or was null.
     * @param listChars an array of characters that needs to be turned into a single linked list in the order provided.
     */

    void constructCharList(char[] listChars);

    /**
     * public void addChar(char c);
     * Inserts a newly constructed HW13Challenge.CharNode at the end of the HW13Challenge.LinkedCharList represented by
     * the private class field headNode.
     * If the list headNode is null, creates a new HW13Challenge.CharNode with the given name and set it as this
     * HW13Challenge.LinkedCharList's headNode.
     * Important: The list must stay connected!
     * Note: the headNode should only change if the headNode was null.
     * @param c The char c for the node to be appended to the HW13Challenge.LinkedCharList
     */

    void addChar(char c);

    /**
     * public void insertCharAt(char c, int position);
     * Insert a new HW13Challenge.CharNode at the given index with the value of char c.
     * If the index extends past the maximum size of the HW13Challenge.LinkedCharList, append it to the end of the list instead.
     * Important: the list must stay connected!
     * Note: The list is zero indexed - the head node is position 0 of the list.
     * @param c the char c for the node to be inserted into the HW13Challenge.LinkedCharList
     * @param index An int indicaating the position the char should be inserted at in the list.
     *                 The list is 0 indexed, meaning that 0 would insert the char as the new headNode.
     */

    void insertCharAt(char c, int index);

    /**
     * public char getCharAt(int index);
     * Traverse the list until you reach the node at the index given and return the char c value of the node.
     * If the index is outside the bounds of the list then throw a new IndexOutOfBoundsException with the message
     * "Index %d out of bounds for length %d" where the first %d is the index parameter for this method and
     * the second %d is the size of this HW13Challenge.LinkedCharList. Example: If this method were called
     * using 5 as a parameter on the HW13Challenge.LinkedCharList containing 'A' 'B' 'C'. The resulting IndexOutOfBoundsException
     * would be: Index 5 out of bounds for length 3
     * Hint: you have seen similar messages for accessing the incorrect index on arrays and Strings.
     * Important: This method does not modify the list.
     * Note: The list is zero indexed - the head node is position 0 of the list.
     * @param index An int indicaating the position the char should be inserted at in the list.
     *              The list is 0 indexed, meaning that 0 would insert the char as the new headNode.
     * @return The char c value of the node at the index
     * @throws IndexOutOfBoundsException If the index is not within the range of the list throw an Exception
     */

    char getCharAt(int index) throws IndexOutOfBoundsException;

    /**
     * public HW13Challenge.LinkedCharList[] splitLinkedCharList(char regex);
     * Traverse the HW13Challenge.LinkedCharList starting at the headNode. When the regex is encountered, set the previous nodes
     * NextNode to be null and create a new HW13Challenge.LinkedCharList starting after the node containing the regex.
     * This function should return an array of LinkedCharLists that have been "split" by the provided regex.
     * The functionality should be identical to that of String.split();
     * Important: the last HW13Challenge.CharNode of each HW13Challenge.LinkedCharList should have its NextNode set to null;
     * Example: The HW13Challenge.LinkedCharList containing: 'A' 'B' 'C' 'B' 'D' with the regex 'B' would result in the following:
     * HW13Challenge.LinkedCharList[0] 'A'
     * HW13Challenge.LinkedCharList[1] 'C'
     * HW13Challenge.LinkedCharList[2] 'D'
     * Example: The HW13Challenge.LinkedCharList containing: 'B' 'B' 'B' 'B' 'B' with the regex 'B' would result in the following:
     * completely null - No HW13Challenge.LinkedCharList should be initialized.
     * Example: The HW13Challenge.LinkedCharList containing: 'B' 'A' 'A' 'A' 'A' with the regex 'B' would result in the following:
     * HW13Challenge.LinkedCharList[0] headNode = null (empty)
     * HW13Challenge.LinkedCharList[1] 'A' 'A' 'A' 'A'
     * Example: The HW13Challenge.LinkedCharList containing: 'A' 'B' 'C' 'C' 'E' with the regex 'C' would result in the following:
     * HW13Challenge.LinkedCharList[0] 'A' 'B'
     * HW13Challenge.LinkedCharList[1] headNode = null (empty)
     * HW13Challenge.LinkedCharList[2] 'E'
     * Try different combinations with String.split() Your methods behavior should be identical, just with lists.
     * @param regex The Char that will be used to split the HW13Challenge.LinkedCharList
     * @return An array of HW13Challenge.LinkedCharList that have been split by the regex.
     */

    LinkedCharList[] splitLinkedCharList(char regex);

}