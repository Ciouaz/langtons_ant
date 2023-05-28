
public class Ant {
    public static enum Direction {
    NORTH(0,-1),
    EAST(1,0),
    SOUTH(0,1),
    WEST(-1,0);

    public final int deltaX;
    public final int deltaY;

    private Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public Direction left(){
        return Direction.values()[(this.ordinal() + 3) % 4];
    }

        public Direction right(){
            return Direction.values()[(this.ordinal() + 1) % 4];
        }
    }

    public int x, y, steps, antNumber;
    public  Direction direction;

    public int getAntNumber() {
        return antNumber;
    }

    public Ant(int x, int y, Direction direction, int antNumber) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.antNumber = antNumber;
    }

    public boolean isInWorld(World w){
        return 0 <= x && x < w.size && 0 <= y && y < w.size;
    }

    public void step(World w, int antNumber){
        World.Color c = w.getCellColor(x, y);
        direction = (!(World.Color.BLACK == c)) ? direction.right() : direction.left();
        w.setCellColor(x,y, c.inverse(antNumber));
        x += direction.deltaX;
        y += direction.deltaY;
        if (x >= 200 ) {
                x = 1;
            } else if (x <= 0){
                x = 199;
            }
        if (y >= 200) {
               y = 1;
            } else if (y <= 0) {
                y = 199;
            }
        steps++;
    }

    public String toString() {
        return String.format("Ant(%4d, %4d, %s)", x, y, direction);
    }

}
