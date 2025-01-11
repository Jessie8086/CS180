package HW13Challenge;

import java.util.LinkedList;

/**
 * Class HW13Challenge.LinkedCharList
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p >
 *
 * @author Jiauxn Li
 * @version April 16, 2024
 */
public class LinkedCharList implements LinkedCharListInterface {
    private CharNode headNode;

    public LinkedCharList() {
        this.headNode = null;
    }

    public void constructCharList(char[] listChars) {
        for (char c : listChars) {
            this.addChar(c);
        }
    }

    public void addChar(char c) {
        if (headNode == null) {
            headNode = new CharNode(c);
        } else {
            CharNode cn = headNode;
            while (cn.getNextNode() != null) {
                cn = cn.getNextNode();
            }
            cn.setNextNode(new CharNode(c));
        }
    }

    public void insertCharAt(char c, int index) {
        CharNode cn = new CharNode(c);
        if (headNode == null) {
            headNode = cn;
            return;
        }
        if (index == 0) {
            cn.setNextNode(headNode);
            headNode = cn;
            return;
        }
        CharNode cn1 = null;
        CharNode cn2 = headNode;
        int count = 0;
        while (count != index) {
            cn1 = cn2;
            cn2 = cn2.getNextNode();
            count++;
            if (count == index) {
                cn1.setNextNode(cn);
                cn.setNextNode(cn2);
            }
            if (cn2 == null) {
                cn1.setNextNode(cn);
                break;
            }

        }
    }

    public char getCharAt(int index) throws IndexOutOfBoundsException {
        CharNode node = headNode;
        if (headNode == null) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d",
                    index, 0));
        }
        if (index == 0) {
            return node.getC();
        }
        int count = 0;
        while (count != index) {
            node = node.getNextNode();
            count++;
            if (node == null) {
                throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d",
                        index, count));
            }
        }
        return node.getC();
    }

    public LinkedCharList[] splitLinkedCharList(char regex) {
        LinkedList<Character> list = new LinkedList<>();
        LinkedList<LinkedCharList> result = new LinkedList<>();
        CharNode node = headNode;
        if (headNode == null) {
            return result.toArray(new LinkedCharList[0]);
        }
        while (node != null) {
            list.add(node.getC());
            node = node.getNextNode();
        }
        String input = "";
        for (Character c : list) {
            input += c;
        }
        int startIndex = 0;
        LinkedList<String> temp = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == regex) {
                temp.add(input.substring(startIndex, i));
                startIndex = i + 1;
            }
            if (i == input.length() - 1 && startIndex < input.length()) {
                temp.add(input.substring(startIndex));
                break;
            }
        }
        for (String str : temp) {
            char[] chars = str.toCharArray();
            LinkedCharList newList = new LinkedCharList();
            for (char c : chars) {
                newList.addChar(c);
            }
            result.add(newList);
        }
        return result.toArray(new LinkedCharList[0]);
    }
}
