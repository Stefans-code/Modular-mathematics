import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teorema_cinese_del_resto {
    private JButton calcolaButton;
    private JButton resetButton;
    private JTextArea textArea1;
    private JTextField textField1;

    private JPanel Jpanel_stampa;
    private JTextField[] N_bFields;
    private JTextField[] N_cFields;
    private JPanel panelMain;
    private JButton Home;
    private JLabel label1;
    private JFrame mainFrame;

    public void displayForm() {
        JFrame window = new JFrame("Teorema cinese del resto");
        window.setContentPane(panelMain);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Chiudi solo questa finestra
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }

    public Teorema_cinese_del_resto(JFrame mainFrame) {

        this.mainFrame = mainFrame;

        calcolaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] a = new int[N_bFields.length];
                int[] nI = new int[N_cFields.length];
                for (int i = 0; i < N_bFields.length; i++) {
                    a[i] = Integer.parseInt(N_bFields[i].getText());
                    nI[i] = Integer.parseInt(N_cFields[i].getText());
                }

                String[] risultati = Tcdr.CalcoloTeoremaCinesedelResto(a, nI);
                StringBuilder resultText = new StringBuilder();
                for (String risultato : risultati) {
                    resultText.append(risultato).append("\n");
                }

                textArea1.setText(resultText.toString());
            }
        });

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numEquazioni = Integer.parseInt(textField1.getText());
                EquazioniGenerate(numEquazioni);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textArea1.setText("");
                Jpanel_stampa.removeAll();
                Jpanel_stampa.revalidate();
                Jpanel_stampa.repaint();
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

    public void EquazioniGenerate(int numEquazioni) {
        Jpanel_stampa.removeAll();
        N_bFields = new JTextField[numEquazioni];
        N_cFields = new JTextField[numEquazioni];

        int width = 5;
        int height = 5;

        GridLayout layout = new GridLayout(numEquazioni, 3);
        Jpanel_stampa.setLayout(layout);

        for (int i = 0; i < numEquazioni; i++) {
            label1 = new JLabel("X ≡  ");

            label1.setPreferredSize(new Dimension(width, height));
            Jpanel_stampa.add(label1);

            JTextField N_b = new JTextField();
            N_bFields[i] = N_b;
            N_b.setPreferredSize(new Dimension(width, height));
            Jpanel_stampa.add(N_b);

            JLabel label2 = new JLabel("mod");
            label2.setPreferredSize(new Dimension(width, height));
            Jpanel_stampa.add(label2);

            JTextField N_c = new JTextField();
            N_cFields[i] = N_c;
            N_c.setPreferredSize(new Dimension(width, height));
            Jpanel_stampa.add(N_c);
        }

        Jpanel_stampa.revalidate();
        Jpanel_stampa.repaint();
    }
}
