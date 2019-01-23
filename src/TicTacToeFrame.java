import javax.swing.*;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame implements ActionListener{

    private JButton [][] p = new JButton[3][3];
    private int whichPlayer = 0;
    private JLabel player;

    public static void main(String[] args) {

        new TicTacToeFrame();
    }

    public TicTacToeFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel thePanel = new JPanel();
        JPanel titlePanel = new JPanel();
        player = new JLabel("Player: \"O\"");

        Font font = new Font("Comic Sans", Font.BOLD, 70);

        Dimension d = new Dimension(100, 100);

        for(int i=0; i<p.length; i++) {
            for(int j=0; j<p[i].length; j++) {
                p[i][j] = new JButton();
            }
        }

        for(int i=0; i<p.length; i++) {
            for(int j=0; j<p[i].length; j++) {
                p[i][j].setFont(font);
                p[i][j].setPreferredSize(d);
                p[i][j].addActionListener(this);
                thePanel.add(p[i][j]);
            }
        }

        titlePanel.add(player);
        this.add(BorderLayout.CENTER, thePanel);
        this.add(BorderLayout.NORTH, titlePanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<p.length; i++) {
            for(int j=0; j<p[i].length; j++) {
                if (e.getSource() == p[i][j] && p[i][j].getText().equals("")) {
                    if (whichPlayer == 0) {
                        p[i][j].setText("O");
                        whichPlayer = 1;
                        player.setText("Player: \"X\"");
                        if(engine()) finish();

                    } else {
                        p[i][j].setText("X");
                        whichPlayer = 0;
                        player.setText("Player: \"O\"");
                        if(engine()) finish();
                    }
                }
            }
        }
    }

    public boolean engine() {
        if(checkDiagonal() || checkHorizontal() || checkVertical()) {
            if(whichPlayer==1) player.setText("Player \"O\" won!");
            else player.setText("Player \"X\" won!");
            return true;
        } else return false;
    }

    public boolean checkVertical() {
        for(int i=0; i<p.length; i++) {
            if(!p[0][i].getText().equals("")) {
                if (p[0][i].getText().equals(p[1][i].getText()) && p[1][i].getText().equals(p[2][i].getText())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkHorizontal() {
        for(int i=0; i<p.length; i++) {
            if(!p[i][0].getText().equals("")) {
                if (p[i][0].getText().equals(p[i][1].getText()) && p[i][1].getText().equals(p[i][2].getText())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonal() {
        for(int i=0; i<p.length; i++) {
            if(!p[1][1].getText().equals("")) {
                if(p[0][0].getText().equals(p[1][1].getText()) && p[1][1].getText().equals(p[2][2].getText())) {
                    return true;
                } else if(p[0][2].getText().equals(p[1][1].getText()) && p[1][1].getText().equals(p[2][0].getText())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void finish() {

        GridLayout layout = new GridLayout(4,1);

        JFrame theFrame = new JFrame("LOL");
        theFrame.setSize(400,400);
        theFrame.setLocationRelativeTo(null);
        theFrame.setResizable(false);
        theFrame.setLayout(layout);
        theFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel label = new JLabel("WINNER WINNER CHICKEN DINNER");
        label.setFont(new Font("Calibri", Font.BOLD, 25));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel label2 = new JLabel();
        label2.setFont(new Font("Calibri", Font.BOLD, 22));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        if(whichPlayer==1) label2.setText("Player \"O\" won!");
        else label2.setText("Player \"X\" won!");

        theFrame.add(label2);
        theFrame.add(label);
        theFrame.setVisible(true);
    }
}
