package word_game;

import javax.swing.*;
import java.awt.*;

public class WordGridUi extends JFrame {

    JFrame frame = new JFrame("Testing");
    JPanel panel = new GamePanel().choice(this);

    WordGridUi() {
        buildFrame();
    }

    public void buildFrame() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void result(String word,WordGridUi fr) {
        JFrame jFrame = new JFrame();
        JButton btn = new JButton("reset");
        JButton btn2 = new JButton("quit");
        JLabel label = new JLabel("your word is : ");
        label.setSize(85,25);
        label.setLocation(10,30);
        JTextField txt = new JTextField(word);
        txt.setSize(75,25);
        txt.setLocation(120,30);
        txt.setBackground(Color.black);
        txt.setEnabled(false);
        jFrame.setPreferredSize(new Dimension(225,300));
        jFrame.setResizable(false);
        jFrame.setLayout(null);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(label);
        jFrame.add(txt);
        btn.setSize(75,25);
        btn.setLocation(20,200);
        btn2.setSize(75,25);
        btn2.setLocation(115,200);
        jFrame.add(btn);
        jFrame.add(btn2);
        jFrame.pack();
        jFrame.setVisible(true);

        btn2.addActionListener(e -> {
            if (e.getActionCommand().equals("quit")) {
                System.exit(0);
            }

        });
        btn.addActionListener(e -> {
            if (e.getActionCommand().equals("reset")) {
                jFrame.dispose();
                frame.remove(panel);
                panel = new GamePanel().choice(fr);

                buildFrame();
                SwingUtilities.updateComponentTreeUI(fr);

            }
        });
    }
}
