public class World {

    public static enum Color {
        WHITE, BLACK, GREEN, YELLOW, RED, BLUE;

        public Color inverse(int antNumber) {
            if (antNumber == 1) {
                return GREEN.equals(this) ? BLACK : GREEN;
            } else if (antNumber == 2) {
                return YELLOW.equals(this) ? BLACK : YELLOW;
            } else if (antNumber == 3) {
                return RED.equals(this) ? BLACK : RED;
            } else if (antNumber == 4) {
                return BLUE.equals(this) ? BLACK : BLUE;
            } else {
                return WHITE.equals(this) ? BLACK : WHITE;
            }
        }
    }


    private Color[][] cells;
    public int size;

    public World(int size) {
        this.size = size;
        cells = new Color[size][size];

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                cells[x][y] = Color.BLACK;
            }
        }
    }

    public Color getCellColor(int x, int y) {
        return cells[x][y];
    }

    public void setCellColor(int x, int y, Color c){

        cells[x][y] = c;
    }


}
