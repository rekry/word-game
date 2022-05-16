package word_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {

    int i = 0;
    int count = 1;

    WordComparison wordComparison = new WordComparison();
    int wordSize = wordComparison.word.length();
    char[] listOfChars = new char[wordSize];

    public GamePanel() {
    }
    protected JPanel choice(WordGridUi frame ) {
        JPanel panel = new JPanel(new GridLayout(6,wordSize,1,2));
        panel.setPreferredSize(new Dimension(960   ,720));
        panel.setSize(new Dimension(960   ,720));

        for (int horz = 0; horz < wordSize; horz++) {
            for (int vert = 0; vert < 6; vert++) {
                panel.add(createJTextField(frame));
            }
        }
        return panel;
    }

    public JTextField createJTextField(WordGridUi frame) {

        JTextField txtField = new JTextField(1);
        txtField.setFont(new Font("Times New Roman", Font.PLAIN, 75));
        txtField.setHorizontalAlignment(0);
        txtField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                count++;
                if (e.getKeyChar() != ' ') {
                    char input = e.getKeyChar();
                    if (i<wordSize) {
                        listOfChars[i] = input;
                        int status = wordComparison.checkWord(input,i);
                        if (status==1) {txtField.setBackground(Color.green);}
                        if (status==2) {txtField.setBackground(Color.yellow);}
                        if (status==3) {txtField.setBackground(Color.darkGray);}
                    } else {
                        i = 0;
                        listOfChars = new char[wordSize];
                        listOfChars[i] = input;
                        int status = wordComparison.checkWord(input,i);
                        if (status==1) {txtField.setBackground(Color.green);}
                        if (status==2) {txtField.setBackground(Color.yellow);}
                        if (status==3) {txtField.setBackground(Color.darkGray);}
                    }
                    txtField.setEnabled(false);
                    txtField.setForeground(Color.black);
                    txtField.setText(String.valueOf(input));
                    if (wordComparison.checkWin(listOfChars)) {
                        frame.result(wordComparison.results(),frame);
                    }
                    if (count == wordSize*6 + 1) {
                        //needs to show after 31
                        frame.result(wordComparison.results(),frame);
                    }
                }
                i = i+1;
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        return txtField;
    }

}
