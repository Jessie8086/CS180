package HW13Debugging;

public class UserNode {
    private String name;
    private UserNode nextUserNode;

    public UserNode(String name) {
        this.name = name;
        this.nextUserNode = null;
    }

    public UserNode getNextNode() {
        return this.nextUserNode;
    }

    public void setNextNode(UserNode nextUserNode) {
        this.nextUserNode = nextUserNode;
    }

    public String getName() {
        return this.name;
    }
}