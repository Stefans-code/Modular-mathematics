import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mat extends JFrame {
    private JButton button1;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JSpinner spinner1;
    private JPanel panelMain;
    private JLabel label1;
    private JRadioButton radioButton1;
    private JButton Home;
    private JFrame mainFrame;

    public mat(JFrame mainFrame) {

        this.mainFrame = mainFrame;


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Window[] windows = Window.getWindows();
                for (Window window : windows) {
                    if (window instanceof JFrame && window != mat.this) {
                        window.dispose();
                    }
                }

                int n = ((int) spinner1.getValue());
                n = Math.abs(n);
                int modulo = n;
                n++;
                Integer[][] matrix = new Integer[n][n];
                for (int i = 1; i < n; i++) {
                    matrix[i][0] = i - 1;
                }
                for (int i = 1; i < n; i++) {
                    matrix[0][i] = i - 1;
                }

                // Verifica se almeno una checkbox è selezionata
                if (checkBox1.isSelected() || checkBox2.isSelected()) {
                    Integer[][] results;
                    if (checkBox1.isSelected() && radioButton1.isSelected()) {
                        label1.setText("");
                        results = calcPiu(matrix, n, modulo);
                    } else if (checkBox1.isSelected()) {
                        label1.setText("");
                        results = calcPiu(matrix, n, modulo);
                    } else if (checkBox2.isSelected() && radioButton1.isSelected()) {
                        label1.setText("");
                        results = calcPer(matrix, n, modulo);
                    } else if (checkBox2.isSelected()) {
                        label1.setText("");
                        results = calcPiu(matrix, n, modulo);
                    } else {
                        label1.setText("Selezionare un'operazione");
                        return; // Esci dal metodo se il radio button non è selezionato
                    }

                    JFrame frame = new JFrame();
                    frame.setSize(600, 400);
                    frame.setBackground(Color.white);
                    frame.setTitle("Tabella");

                    DefaultTableModel model1 = new DefaultTableModel(results, matrix);
                    JTable table1 = new JTable(model1);
                    table1.setRowHeight(30);
                    table1.setTableHeader(null);

                    if (checkBox1.isSelected()) {
                        String s = "+";
                        table1.setValueAt(s, 0, 0);
                    } else {
                        String s = "*";
                        table1.setValueAt(s, 0, 0);
                    }

                    frame.add(new JScrollPane(table1));
                    frame.setVisible(true);

                    // Creazione del secondo JFrame solo se la radio button è selezionata
                    if (radioButton1.isSelected()) {
                        JFrame frame2 = new JFrame();
                        frame2.setSize(600, 400);
                        frame2.setBackground(Color.white);
                        frame2.setVisible(true);
                        frame2.setTitle("Inversi");

                        JLabel label = new JLabel();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("<html>Gli opposti:<br/>");
                        stringBuilder.append("a ");
                        for (int j = 1; j < n; j++) {
                            stringBuilder.append(matrix[0][j]).append(" ");
                        }
                        stringBuilder.append("<br/>");
                        stringBuilder.append("-a ");
                        for (int j = 1; j < n; j++) {
                            stringBuilder.append(matrix[1][j]).append(" ");
                        }
                        stringBuilder.append("</html>");
                        label.setText(stringBuilder.toString());
                        frame2.add(label);
                    }

                } else {
                    label1.setText("Selezionare almeno un'operazione");
                }
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


    // Metodo per calcolare e stampare l'opposto della matrice
    private Integer[][] calcPiu(Integer[][] m, int n, int mod) {
        int ind1Row = 0;
        int ind2Col = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                ind2Col++;
                m[i][j] = (m[ind1Row + 1][0] + mod - m[0][ind2Col]) % mod;
            }
            ind1Row++;
            ind2Col = 0;
        }
        return m;
    }

    private Integer[][] calcPer(Integer[][] m, int n, int mod) {
        int ind1Row = 0;
        int ind2Col = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                ind2Col++;
                m[i][j] = (m[ind1Row + 1][0] * mod - m[0][ind2Col]) % mod;
            }
            ind1Row++;
            ind2Col = 0;
        }
        return m;
    }

    public void displayForm() {
        JFrame window = new JFrame("Operazioni modulari");
        window.setContentPane(panelMain);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Chiudi solo questa finestra
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }
}
