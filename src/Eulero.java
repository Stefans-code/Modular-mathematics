import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eulero {
    private JButton calcolaButton;
    private JButton resetButton;
    private JTextField textField1;
    private JTextArea textArea1;
    private JPanel panelMain;
    private JTextField textField2;
    private JTextField textField3;
    private JButton Home;
    private JFrame mainFrame;

    public Eulero(JFrame mainFrame) {

        this.mainFrame = mainFrame;


        calcolaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int p, q;
                int e_;

                p= Integer.parseInt(textField1.getText());
                q= Integer.parseInt(textField2.getText());
                e_= Integer.parseInt(textField3.getText());

                int d = Algorithm.calcolarePrivateKey(p, q, e_);
                textArea1.setText("La chiave privata (d) è: "+d);

            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textArea1.setText("");
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

    public void displayForm() {
        JFrame window = new JFrame("Funzione indicatrice di eulero");
        window.setContentPane(panelMain);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Chiudi solo questa finestra
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }


}
