import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Euclide {
    private JPanel panelMain;
    private JScrollPane scrollPane1;
    private JTextArea Risultato;
    private JTextArea Inserimento_val2;
    private JTextArea Inserimento_val1;
    private JScrollPane scrollPane;
    private JLabel Title_t;
    private JLabel Title_c;
    private JLabel Titolo;
    private JButton Calcola;
    private JButton Reset;
    private JButton Home;
    Integer num1;
    Integer num2;
    public String  OutPut="";
    private JFrame mainFrame;
    String caso;



    public void displayForm() {
        JFrame window = new JFrame("Algortimo di Euclide");
        window.setContentPane(panelMain);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Chiudi solo questa finestra
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }




    public Euclide(JFrame mainFrame) {

        this.mainFrame = mainFrame;

        Calcola.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                num1 = Integer.valueOf(Inserimento_val1.getText());
                num2 = Integer.valueOf(Inserimento_val2.getText());

                if(num1<num2){
                    Integer c=num2;
                    num2=num1;
                    num1=c;
                }

                mcd(num1,num2);
                Risultato.setText(OutPut);

            }

        });
        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Risultato.setText("");
                Inserimento_val1.setText("");
                Inserimento_val2.setText("");
                OutPut = "";
                num1 = null;
                num2 = null;


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


    private int  mcd(int a, int b) {

        if (a % b == 0) {

            OutPut+= "Il MCD è: "+b+"\n";
            return b;

        } else {

            OutPut+= a + " : " + b + " = " +a/b+" resto "+a%b +"\n" ;
            return mcd(b, a % b);

        }

    }

}
