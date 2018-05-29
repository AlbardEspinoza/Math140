import javax.swing.*;

public class ButtonTest {

    public static void main(String args[]) {

        JFrame window = new JFrame();
        JButton button = new JButton("OK");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.getContentPane().add(button);

        window.setSize(700,1000);

        window.setVisible(true);

    }

}
