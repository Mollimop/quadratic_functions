package quadratischeFunktionen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sebastian on 10.01.2016.
 */
public class SwingGUI extends JFrame implements ActionListener {
    JLabel labelA;
    JLabel labelB;
    JLabel labelC;
    JLabel labelAb;
    JLabel labelBc;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel label9;
    JLabel label10;
    JLabel label11;
    JLabel labelVertex;
    JLabel labelDisplayVertex;
    JLabel labelZero;
    JLabel labelDisplayZero;

    JTextField textA;
    JTextField textB;
    JTextField textC;
    JTextField text1;
    JTextField text2;
    JTextField text3;
    JTextField text4;
    JTextField text5;
    JTextField text6;
    JTextField text7;
    JTextField text8;
    JTextField text9;
    JTextField text10;
    JTextField text11;

    JButton generate;
    public JPanel panel;


    public SwingGUI(){
        super("Quadratic Functions");
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        generate.addActionListener(this);

    }




    public void actionPerformed(ActionEvent e){
        try {
            double a = Double.parseDouble(textA.getText());
            double b = Double.parseDouble(textB.getText());
            double c = Double.parseDouble(textC.getText());
            QuadraticFunction function = new QuadraticFunction(a, b, c);
            labelDisplayVertex.setText("(" + function.getVertex().getX() + "|" + function.getVertex().getY() + ")");
            labelDisplayZero.setText("" + function.toZeroString());
            label1.setText("" + function.generateY(Double.parseDouble(text1.getText())));
            label2.setText("" + function.generateY(Double.parseDouble(text2.getText())));
            label3.setText("" + function.generateY(Double.parseDouble(text3.getText())));
            label4.setText("" + function.generateY(Double.parseDouble(text4.getText())));
            label5.setText("" + function.generateY(Double.parseDouble(text5.getText())));
            label6.setText("" + function.generateY(Double.parseDouble(text6.getText())));
            label7.setText("" + function.generateY(Double.parseDouble(text7.getText())));
            label8.setText("" + function.generateY(Double.parseDouble(text8.getText())));
            label9.setText("" + function.generateY(Double.parseDouble(text9.getText())));
            label10.setText("" + function.generateY(Double.parseDouble(text10.getText())));
            label11.setText("" + function.generateY(Double.parseDouble(text11.getText())));


        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Illegal Arguments");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An unknown error occured");
        }


    }
}
