import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JButton;


public class Start {
    static boolean oneAnt = true;
    static boolean twoAnt;
    static boolean threeAnt;
    static boolean fourAnt;
    static boolean fiveAnt;

    private JFrame frame;
    private JButton startButton;
    private JButton oneAntButton;
    private JButton twoAntButton;
    private JButton threeAntButton;
    private JButton fourAntButton;
    private JButton fiveAntButton;
    private JPanel panel;

    public Start() {
        initialize();
    }

    private void initialize() {

        frame = new JFrame();
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setTitle("Start Langton's Ant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);

        startButton = createStartButton();
        oneAntButton = chooseOneAntButton();
        twoAntButton = chooseTwoAntButton();
        threeAntButton = chooseThreeAntButton();
        fourAntButton = chooseFourAntButton();
        fiveAntButton = chooseFiveAntButton();

        JTextField titleField = new JTextField("LANGTON'S ANT");
        titleField.setBorder(null);
        titleField.setFont(new Font("Arial", Font.BOLD, 24));
        titleField.setEditable(false);
        titleField.setFocusable(false);

        JTextArea descriptionField = new JTextArea("\nLangton's ant is a cellular automaton created by Christopher Langton in 1986. " +
                "Squares on a plane are colored variously. We arbitrarily identify one square as the \"ant\". " +
                "The ant can travel in any of the four cardinal directions at each step it takes, according to the rules:\n" +
                "- at a black square, turn 90° clockwise, flip the color of the square, move forward one unit\n" +
                "- at a color square, turn 90° counter-clockwise, flip the color of the square, move forward one unit\n");
        descriptionField.setLineWrap(true);
        descriptionField.setAlignmentX(Component.CENTER_ALIGNMENT);
        descriptionField.setOpaque(false);
        descriptionField.setBorder(null);
        descriptionField.setSize(550, 200);
        descriptionField.setWrapStyleWord(true);
        descriptionField.setEditable(false);
        descriptionField.setFocusable(false);


        JTextField chooseAnts = new JTextField("CHOOSE NUMBER OF ANTS:");
        chooseAnts.setBorder(null);
        chooseAnts.setFont(new Font("Arial", Font.BOLD, 16));
        chooseAnts.setEditable(false);
        chooseAnts.setFocusable(false);

        JTextField startAnts = new JTextField("START:");
        startAnts.setBorder(null);
        startAnts.setFont(new Font("Arial", Font.BOLD, 16));
        startAnts.setEditable(false);
        startAnts.setFocusable(false);

        frame.add(titleField);
        frame.add(descriptionField);

        frame.add(chooseAnts);

        panel = new JPanel();
        panel.add(oneAntButton);
        panel.add(twoAntButton);
        panel.add(threeAntButton);
        panel.add(fourAntButton);
        panel.add(fiveAntButton);

        frame.add(panel);

        frame.add(startButton);
        startButton.setBounds(0, 500, 220, 30);

    }


    private JButton createStartButton() {
        JButton startButton = new JButton("START");
        startButton.setFont(new Font("Arial", Font.BOLD, 24));
        startButton.setFocusable(false);
        ImageIcon antIcon = new ImageIcon("src/anticon.png");
        startButton.setToolTipText("Start Langton's Ant simulation");

        startButton.setIcon(antIcon);
        startButton.setPreferredSize(new Dimension(200, 80));


        startButton.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    new LangtonAnt().run(1500000, 10, 1);
                });
            }
        });
        return startButton;
    }

    private JButton chooseOneAntButton() {
        JButton oneAntButton = new JButton("1");
        oneAntButton.setFont(new Font("Arial", Font.BOLD, 20));
        oneAntButton.setFocusable(false);
        oneAntButton.setPreferredSize(new Dimension(100, 80));


        oneAntButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent a) {
                oneAnt = true;
                twoAnt = false;
                threeAnt = false;
                fourAnt = false;
                fiveAnt = false;
            }
        });

        return oneAntButton;
    }

    private JButton chooseTwoAntButton() {
        JButton twoAntButton = new JButton("2");
        twoAntButton.setFont(new Font("Arial", Font.BOLD, 20));
        twoAntButton.setFocusable(false);
        twoAntButton.setPreferredSize(new Dimension(100, 80));

        twoAntButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent b) {
                oneAnt = true;
                twoAnt = true;
                threeAnt = false;
                fourAnt = false;
                fiveAnt = false;
            }
        });
        return twoAntButton;
    }

    private JButton chooseThreeAntButton() {
        JButton threeAntButton = new JButton("3");
        threeAntButton.setFont(new Font("Arial", Font.BOLD, 20));
        threeAntButton.setFocusable(false);
        threeAntButton.setPreferredSize(new Dimension(100, 80));

        threeAntButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent c) {
                oneAnt = true;
                twoAnt = true;
                threeAnt = true;
                fourAnt = false;
                fiveAnt = false;
            }
        });
        return threeAntButton;
    }

    private JButton chooseFourAntButton() {
        JButton fourAntButton = new JButton("4");
        fourAntButton.setFont(new Font("Arial", Font.BOLD, 20));
        fourAntButton.setFocusable(false);
        fourAntButton.setPreferredSize(new Dimension(100, 80));

        fourAntButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent d) {
                oneAnt = true;
                twoAnt = true;
                threeAnt = true;
                fourAnt = true;
                fiveAnt = false;
            }
        });
        return fourAntButton;
    }

    private JButton chooseFiveAntButton() {
        JButton fiveAntButton = new JButton("5");
        fiveAntButton.setFont(new Font("Arial", Font.BOLD, 20));
        fiveAntButton.setFocusable(false);
        fiveAntButton.setPreferredSize(new Dimension(100, 80));

        fiveAntButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent f) {
                oneAnt = true;
                twoAnt = true;
                threeAnt = true;
                fourAnt = true;
                fiveAnt = true;
            }
        });
        return fiveAntButton;
    }

    public void show() {
        this.frame.setVisible(true);
    }
}




