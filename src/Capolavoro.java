import javax.swing.*;
import java.awt.event.*;

public class Capolavoro {
    private JFrame mainFrame;
    private JPanel panelMain;
    private JButton button6;
    private JButton button1;
    private JButton button5;
    private JButton button3;
    private JButton button2;
    private JButton button4;
    private JButton button7;

    public Capolavoro() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Euclide euclide = new Euclide(mainFrame);
                euclide.displayForm();

                mainFrame.setVisible(false);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Campionato campionato = new Campionato(mainFrame);
                campionato.displayForm();
                mainFrame.setVisible(false);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mat mate = new mat(mainFrame);
                mate.displayForm();
                mainFrame.setVisible(false);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bezout bezout = new Bezout(mainFrame);
                bezout.displayForm();
                mainFrame.setVisible(false);
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Teorema_cinese_del_resto tcdr = new Teorema_cinese_del_resto(mainFrame);
                tcdr.displayForm();
                mainFrame.setVisible(false);
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eulero eulero = new Eulero(mainFrame);
                eulero.displayForm();
                mainFrame.setVisible(false);
            }
        });



    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Matematica modulare");
        Capolavoro capolavoro = new Capolavoro();
        window.setContentPane(capolavoro.panelMain);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
        capolavoro.mainFrame = window;
    }
}
