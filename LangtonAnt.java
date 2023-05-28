import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JButton;

public class LangtonAnt {
    private JFrame frame;
    private JButton button;
    private JPanel antPanel;
    private World world;
    private Ant ant;
    private Ant ant2;
    private Ant ant3;
    private Ant ant4;
    private Ant ant5;

    public class AntPanel extends JPanel {
        private final int dotSize;
        private int antNumber;

        public AntPanel(int dotSize) {
            int pixels = dotSize * world.size;
            this.dotSize = dotSize;
            setPreferredSize(new Dimension(pixels, pixels));
            setBackground(Color.BLACK);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int x = 0; x < world.size; x++) {
                for (int y = 0; y < world.size; y++) {
                    if (ant.getAntNumber() == 1) {
                        if (world.getCellColor(x, y) == World.Color.GREEN) {
                            g.setColor(Color.GREEN);
                            g.fillRect(dotSize * x, dotSize * y, dotSize, dotSize);
                        }
                    }
                    if (ant2.getAntNumber() == 2) {
                        if (world.getCellColor(x, y) == World.Color.YELLOW) {
                            g.setColor(Color.YELLOW);
                            g.fillRect(dotSize * x, dotSize * y, dotSize, dotSize);
                        }
                    }
                    if (ant3.getAntNumber() == 3) {
                        if (world.getCellColor(x, y) == World.Color.RED) {
                            g.setColor(Color.RED);
                            g.fillRect(dotSize * x, dotSize * y, dotSize, dotSize);
                        }
                    }
                    if (ant4.getAntNumber() == 4) {
                        if (world.getCellColor(x, y) == World.Color.BLUE) {
                            g.setColor(Color.BLUE);
                            g.fillRect(dotSize * x, dotSize * y, dotSize, dotSize);
                        }
                    }
                    if (ant5.getAntNumber() == 5) {
                        if (world.getCellColor(x, y) == World.Color.WHITE) {
                            g.setColor(Color.WHITE);
                            g.fillRect(dotSize * x, dotSize * y, dotSize, dotSize);
                        }
                    }
                }
            }
        }
    }


    public LangtonAnt() {

        Random random = new Random();
        int rand2X = 180 - random.nextInt(60);
        int rand2y = 180 - random.nextInt(60);

        int rand3X = 20 + random.nextInt(60);
        int rand3y = 180 - random.nextInt(60);

        int rand4X = 180 - random.nextInt(60);
        int rand4y = 20 + random.nextInt(60);

        int rand5X = 20 + random.nextInt(60);
        int rand5y = 20 + random.nextInt(60);

        world = new World(200);
//        world.setCellColor(100, 100, World.Color.GREEN);
        ant = new Ant(100, 100, randomizeDirection(),1);
//        world.setCellColor(75, 75, World.Color.YELLOW);
        ant2 = new Ant(rand2X, rand2y,  randomizeDirection(),2);
//        world.setCellColor(125, 125, World.Color.RED);
        ant3 = new Ant(rand3X, rand3y, randomizeDirection(),3);
//        world.setCellColor(125, 75, World.Color.BLUE);
        ant4 = new Ant(rand4X, rand4y, randomizeDirection(),4);
//        world.setCellColor(75, 125, World.Color.WHITE);
        ant5 = new Ant(rand5X, rand5y, randomizeDirection(),5);

        frame = new JFrame("Langton's Ant");
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        antPanel = new AntPanel(3);

        frame.add(antPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public Ant.Direction randomizeDirection() {
        Random random = new Random();
        int n = random.nextInt(100);
        if (n < 25) {
            return Ant.Direction.WEST;
        } else if (n > 25 && n < 50) {
            return Ant.Direction.EAST;
        } else if (n >= 50 && n < 75) {
            return Ant.Direction.NORTH;
        } else {
            return Ant.Direction.SOUTH;
        }
    }

    public void run(int maxSteps, long delay, long period) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!(ant.steps < maxSteps && ant.isInWorld(world))) {
                    timer.cancel();
                } else {
                    SwingUtilities.invokeLater(() -> {
                        antPanel.repaint();
                    });
                    if (Start.oneAnt) {
                        ant.step(world,1);
                    }
                    if (Start.twoAnt) {
                        ant2.step(world,2);
                    }
                    if (Start.threeAnt) {
                        ant3.step(world,3);
                    }
                    if (Start.fourAnt) {
                        ant4.step(world,4);
                    }
                    if (Start.fiveAnt) {
                        ant5.step(world,5);
                    }
                }
            }
        }, delay, period);
    }
}




