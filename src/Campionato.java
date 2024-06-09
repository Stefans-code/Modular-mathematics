import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Campionato {
    private JButton calcolaButton;
    private JButton resetButton;
    private JTextField numero;
    private JTextArea textArea1;
    private JPanel panelMain;
    private JButton Home;
    private JFrame mainFrame;

    public Campionato(JFrame mainFrame) {

        this.mainFrame = mainFrame;

        calcolaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int n;
                n = Integer.parseInt(numero.getText());
                Campionato_algorithm prova = new Campionato_algorithm(n);
                textArea1.setText(prova.getOutput()); // Imposta l'output sulla JTextArea

            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numero.setText("");
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
        JFrame window = new JFrame("Campionato di calcio all'italiana");
        window.setContentPane(panelMain);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Chiudi solo questa finestra
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }
}
