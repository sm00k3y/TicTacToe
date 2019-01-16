import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame implements ActionListener{

    JButton przycisk1;

    public static void main(String[] args) {

        new TicTacToeFrame();
    }

    public TicTacToeFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);

        int a = 5;


        JPanel thePanel = new JPanel();

        przycisk1 = new JButton("Click me!");


        thePanel.add(przycisk1);
        this.add(thePanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int a = (int)(Math.random()*300);
        int b = (int)(Math.random()*300);
        if(e.getSource() == przycisk1) {
            przycisk1.setBounds(150, 50, a, b);
        }
    }
}
