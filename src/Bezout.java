import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Bezout {

    private JPanel panelMain;
    private JButton resetButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton calcolaButton;
    private JTextArea Risultato;

    private JTextField B_n;

    private JTextField A_n;

    private JTextField C_n;
    private JButton Home;
    private JFrame mainFrame;

    public Bezout(JFrame mainFrame) {

        this.mainFrame = mainFrame;








        calcolaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int a;
                int b;
                int c;




                    a = Integer.parseInt(A_n.getText());
                    b = Integer.parseInt(B_n.getText());
                    c = Integer.parseInt(C_n.getText());
                    int i;

                    if (a != 0 && b != 0 && c != 0) {
                        Integer[] soluzioni ;
                        TeoremaDiBezout prova = new TeoremaDiBezout(a, b, c);
                        soluzioni = prova.algoritmoDiBezout();

                        if (soluzioni  == null) {
                            Risultato.setText("L'equazione è impossibile");
                        } else {
                            Risultato.setText("La soluzione finale è:\n"
                                    + "x=" + soluzioni[0] +"\n"
                                    + "y=" + soluzioni[1] );
                        }
                    } else {
                        Risultato.setText("I valori di a, b e c non possono essere zero.");
                    }

                }

        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();

            }
        });
        Home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chiudi il form di Euclide e mostra il form principale
                mainFrame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(panelMain)).dispose();
            }
        });
    }
    public void reset() {
        A_n.setText("");
        C_n.setText("");
        B_n.setText("");
        Risultato.setText("");
    }
    public void displayForm() {
        JFrame window = new JFrame("Bezout");
        window.setContentPane(panelMain);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Chiudi solo questa finestra
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }



}
