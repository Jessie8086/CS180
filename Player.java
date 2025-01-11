public class Player {
    private int x;	//x position of the player
    private int y;	//y position of the player
    private int hp;		//health point of the player
    public static Object obj;
    public Player(int x, int y, int hp){
        this.x = x;
        this.y = y;
        this.hp = hp;
    }

    public void printPlayer(){
        System.out.printf("x position:\t%d\ny position:\t%d\nhealth point:\t%d\n", x, y, hp);
    }

    public synchronized void moveLeft(){
        x --;
    }
    public synchronized void moveRight(){
        x ++;
    }

    public void moveUp(){
        synchronized (obj){
            y --;
        }

    }
    public void moveDown(){
        synchronized (obj) {
            y++;
        }
    }

    public void loseHealth(){
        synchronized (obj) {
            hp--;
        }
    }
    public void gainHealth(){
        synchronized (obj) {
            hp++;
        }
    }

}

