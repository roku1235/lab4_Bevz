package ru.mirea.lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUIFrame extends JFrame {

    protected int cnt1 = 0;
    protected int cnt2 = 0;

    JPanel[] pnl = new JPanel[9];

    Font fnt = new Font("Times new roman",Font.BOLD,20);

    JButton button = new JButton("AC Milan");
    JButton button1 = new JButton("Real Madrid");

    JLabel label = new JLabel("Result: "+ cnt1 +" x "+ cnt2);
    JLabel label1 = new JLabel("Last Scorer: N/A");
    JLabel label2 = new JLabel("Winner: DRAW");

    public GUIFrame() {

        setLayout(new GridLayout(3,3));
        for(int i = 0 ; i < pnl.length ; i++)
        {
            pnl[i] = new JPanel();
            add(pnl[i]);
        }

        pnl[3].setLayout(new BorderLayout());
        pnl[3].add(button);
        button.setFont(fnt);
        button.addMouseListener(new Listener1());

        pnl[5].setLayout(new BorderLayout());
        pnl[5].add(button1);
        button1.setFont(fnt);
        button1.addMouseListener(new Listener2());

        JPanel panel = new JPanel();
        panel.add(label);
        pnl[1].setLayout(new BorderLayout());
        pnl[1].add(panel, BorderLayout.CENTER);
        label.setFont(fnt);

        JPanel panel1 = new JPanel();
        panel1.add(label1);
        pnl[4].setLayout(new BorderLayout());
        pnl[4].add(panel1, BorderLayout.CENTER);
        label1.setFont(fnt);

        JPanel panel2 = new JPanel();
        panel2.add(label2);
        pnl[7].setLayout(new BorderLayout());
        pnl[7].add(panel2, BorderLayout.CENTER);
        label2.setFont(fnt);

        setSize(750,300);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public class Listener1 implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            cnt1++;
            label.setText("Result: "+ cnt1 +" x "+ cnt2);
            label1.setText("Last Scorer: AC Milan");

            if(cnt2 > cnt1)
                label2.setText("Winner: Real Madrid");
            else if(cnt2 < cnt1)
                label2.setText("Winner: AC Milan");
            else
                label2.setText("Winner: DRAW");
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }

    public class Listener2 implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            cnt2++;
            label.setText("Result: " + cnt1 + " x " + cnt2);
            label1.setText("Last Scorer: Real Madrid");

            if(cnt1 > cnt2)
                label2.setText("Winner: AC Milan");
            else if(cnt1 < cnt2)
                label2.setText("Winner: Real Madrid");
            else
                label2.setText("Winner: DRAW");
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }

    public static void main(String[] args) {
        new GUIFrame();
    }
}
